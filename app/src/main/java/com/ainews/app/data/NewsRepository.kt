package com.ainews.app.data

import com.ainews.app.util.AISummaryService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Repository for managing news article data and AI summaries.
 */
class NewsRepository {
    
    private var cachedArticles: List<NewsArticle> = emptyList()
    
    /**
     * Loads mock news articles with pagination support.
     */
    fun loadArticles(page: Int, pageSize: Int = 5): Flow<List<NewsArticle>> = flow {
        // Load from mock data source if cache is empty
        if (cachedArticles.isEmpty()) {
            cachedArticles = MockNewsDataSource.getMockArticles()
        }
        
        val startIndex = (page - 1) * pageSize
        val endIndex = minOf(startIndex + pageSize, cachedArticles.size)
        
        if (startIndex >= cachedArticles.size) {
            emit(emptyList())
            return@flow
        }
        
        val pageArticles = cachedArticles.subList(startIndex, endIndex)
        
        // Generate summaries for articles
        val articlesWithSummaries = pageArticles.map { article ->
            AISummaryService.generateSummary(article)
        }
        
        emit(articlesWithSummaries)
    }
    
    /**
     * Refreshes articles - clears cache and reloads.
     */
    suspend fun refreshArticles(): List<NewsArticle> {
        cachedArticles = MockNewsDataSource.getMockArticles()
        return cachedArticles.take(5).map { article ->
            AISummaryService.generateSummary(article)
        }
    }
    
    /**
     * Gets a specific article by ID with simplified content.
     */
    suspend fun getArticleDetail(articleId: String): NewsArticle? {
        val article = cachedArticles.find { it.id == articleId }
            ?: MockNewsDataSource.getMockArticles().find { it.id == articleId }
        
        return article?.let {
            val withSummary = AISummaryService.generateSummary(it)
            AISummaryService.generateSimplifiedContent(withSummary)
        }
    }
    
    /**
     * Regenerates summary for a specific article.
     */
    suspend fun regenerateSummary(articleId: String): NewsArticle? {
        val article = cachedArticles.find { it.id == articleId }
            ?: return null
        
        return AISummaryService.regenerateSummary(article)
    }
    
    /**
     * Regenerates simplified content for a specific article.
     */
    suspend fun regenerateSimplifiedContent(articleId: String): NewsArticle? {
        val article = cachedArticles.find { it.id == articleId }
            ?: return null
        
        val withSummary = AISummaryService.generateSummary(article)
        return AISummaryService.generateSimplifiedContent(withSummary)
    }
    
    /**
     * Gets total number of articles available.
     */
    fun getTotalArticleCount(): Int {
        if (cachedArticles.isEmpty()) {
            cachedArticles = MockNewsDataSource.getMockArticles()
        }
        return cachedArticles.size
    }
}
