package com.ainews.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ainews.app.data.AISummaryState
import com.ainews.app.data.NewsArticle
import com.ainews.app.data.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for the article detail screen.
 * Manages loading and regenerating simplified content.
 */
class ArticleDetailViewModel : ViewModel() {
    
    private val repository = NewsRepository()
    
    private val _articleState = MutableStateFlow<AISummaryState>(AISummaryState.Idle)
    val articleState: StateFlow<AISummaryState> = _articleState.asStateFlow()
    
    private val _article = MutableStateFlow<NewsArticle?>(null)
    val article: StateFlow<NewsArticle?> = _article.asStateFlow()
    
    private val _isRegenerating = MutableStateFlow(false)
    val isRegenerating: StateFlow<Boolean> = _isRegenerating.asStateFlow()
    
    private val _showOriginal = MutableStateFlow(false)
    val showOriginal: StateFlow<Boolean> = _showOriginal.asStateFlow()
    
    private val _regenerationError = MutableStateFlow<String?>(null)
    val regenerationError: StateFlow<String?> = _regenerationError.asStateFlow()
    
    /**
     * Loads article details with simplified content.
     */
    fun loadArticleDetail(articleId: String) {
        viewModelScope.launch {
            _articleState.value = AISummaryState.Loading
            try {
                val articleDetail = repository.getArticleDetail(articleId)
                if (articleDetail != null) {
                    _article.value = articleDetail
                    _articleState.value = AISummaryState.Success(articleDetail)
                } else {
                    _articleState.value = AISummaryState.Error("Article not found")
                }
            } catch (e: Exception) {
                _articleState.value = AISummaryState.Error(e.message ?: "Failed to load article")
            }
        }
    }
    
    /**
     * Regenerates the simplified content for the current article.
     */
    fun regenerateSimplifiedContent() {
        val currentArticle = _article.value ?: return
        
        viewModelScope.launch {
            _isRegenerating.value = true
            _regenerationError.value = null
            try {
                val regenerated = repository.regenerateSimplifiedContent(currentArticle.id)
                if (regenerated != null) {
                    _article.value = regenerated
                    _articleState.value = AISummaryState.Success(regenerated)
                } else {
                    _regenerationError.value = "Failed to regenerate content"
                }
            } catch (e: Exception) {
                _regenerationError.value = e.message ?: "An error occurred while regenerating"
            } finally {
                _isRegenerating.value = false
            }
        }
    }
    
    /**
     * Clears the regeneration error.
     */
    fun clearRegenerationError() {
        _regenerationError.value = null
    }
    
    /**
     * Toggles between showing original and simplified content.
     */
    fun toggleContentView() {
        _showOriginal.value = !_showOriginal.value
    }
    
    /**
     * Resets state when leaving the screen.
     */
    fun resetState() {
        _articleState.value = AISummaryState.Idle
        _article.value = null
        _showOriginal.value = false
        _isRegenerating.value = false
    }
}
