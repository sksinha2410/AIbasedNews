package com.ainews.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ainews.app.data.FeedState
import com.ainews.app.data.NewsArticle
import com.ainews.app.data.NewsRepository
import com.ainews.app.data.RefreshState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for the news feed screen.
 * Manages loading, pagination, and refresh states.
 */
class NewsFeedViewModel : ViewModel() {
    
    private val repository = NewsRepository()
    
    private val _feedState = MutableStateFlow<FeedState>(FeedState.Loading)
    val feedState: StateFlow<FeedState> = _feedState.asStateFlow()
    
    private val _refreshState = MutableStateFlow(RefreshState())
    val refreshState: StateFlow<RefreshState> = _refreshState.asStateFlow()
    
    private val _articles = MutableStateFlow<List<NewsArticle>>(emptyList())
    val articles: StateFlow<List<NewsArticle>> = _articles.asStateFlow()
    
    private val _isLoadingMore = MutableStateFlow(false)
    val isLoadingMore: StateFlow<Boolean> = _isLoadingMore.asStateFlow()
    
    private val _hasMorePages = MutableStateFlow(true)
    val hasMorePages: StateFlow<Boolean> = _hasMorePages.asStateFlow()
    
    private val _regeneratingArticleId = MutableStateFlow<String?>(null)
    val regeneratingArticleId: StateFlow<String?> = _regeneratingArticleId.asStateFlow()
    
    private var currentPage = 1
    private val pageSize = 5
    
    init {
        loadInitialArticles()
    }
    
    /**
     * Loads the initial set of articles.
     */
    private fun loadInitialArticles() {
        viewModelScope.launch {
            _feedState.value = FeedState.Loading
            try {
                repository.loadArticles(page = 1, pageSize = pageSize).collect { newArticles ->
                    _articles.value = newArticles
                    _feedState.value = FeedState.Success(newArticles)
                    _hasMorePages.value = newArticles.size >= pageSize && 
                                          currentPage * pageSize < repository.getTotalArticleCount()
                }
            } catch (e: Exception) {
                _feedState.value = FeedState.Error(e.message ?: "Unknown error")
            }
        }
    }
    
    /**
     * Loads the next page of articles (pagination).
     */
    fun loadMoreArticles() {
        if (_isLoadingMore.value || !_hasMorePages.value) return
        
        viewModelScope.launch {
            _isLoadingMore.value = true
            try {
                val nextPage = currentPage + 1
                repository.loadArticles(page = nextPage, pageSize = pageSize).collect { newArticles ->
                    if (newArticles.isNotEmpty()) {
                        val currentList = _articles.value.toMutableList()
                        currentList.addAll(newArticles)
                        _articles.value = currentList
                        _feedState.value = FeedState.Success(currentList)
                        currentPage = nextPage
                        _hasMorePages.value = newArticles.size >= pageSize && 
                                              currentPage * pageSize < repository.getTotalArticleCount()
                    } else {
                        _hasMorePages.value = false
                    }
                }
            } catch (e: Exception) {
                // Don't change main feed state on pagination error
            } finally {
                _isLoadingMore.value = false
            }
        }
    }
    
    /**
     * Refreshes the article feed (pull-to-refresh).
     */
    fun refreshFeed() {
        viewModelScope.launch {
            _refreshState.value = _refreshState.value.copy(isRefreshing = true)
            try {
                val refreshedArticles = repository.refreshArticles()
                _articles.value = refreshedArticles
                _feedState.value = FeedState.Success(refreshedArticles)
                currentPage = 1
                _hasMorePages.value = refreshedArticles.size >= pageSize && 
                                      pageSize < repository.getTotalArticleCount()
                _refreshState.value = RefreshState(
                    isRefreshing = false,
                    lastRefreshTime = System.currentTimeMillis()
                )
            } catch (e: Exception) {
                _feedState.value = FeedState.Error(e.message ?: "Refresh failed")
                _refreshState.value = _refreshState.value.copy(isRefreshing = false)
            }
        }
    }
    
    /**
     * Regenerates summary for a specific article.
     */
    fun regenerateSummary(articleId: String) {
        if (_regeneratingArticleId.value != null) return
        
        viewModelScope.launch {
            _regeneratingArticleId.value = articleId
            try {
                val updatedArticle = repository.regenerateSummary(articleId)
                if (updatedArticle != null) {
                    val currentList = _articles.value.toMutableList()
                    val index = currentList.indexOfFirst { it.id == articleId }
                    if (index != -1) {
                        currentList[index] = updatedArticle
                        _articles.value = currentList
                        _feedState.value = FeedState.Success(currentList)
                    }
                }
            } catch (e: Exception) {
                // Log error - in production, would emit error state or show snackbar
            } finally {
                _regeneratingArticleId.value = null
            }
        }
    }
    
    /**
     * Retry loading articles after an error.
     */
    fun retry() {
        currentPage = 1
        loadInitialArticles()
    }
}
