package com.ainews.app.data

/**
 * Represents a health news article with AI-generated summaries.
 */
data class NewsArticle(
    val id: String,
    val title: String,
    val content: String,
    val source: String,
    val publishedDate: String,
    val imageUrl: String?,
    val category: String,
    val tldr: String = "",
    val keyTakeaways: List<String> = emptyList(),
    val simplifiedContent: String = ""
)

/**
 * Represents the state of AI summary generation.
 */
sealed class AISummaryState {
    data object Idle : AISummaryState()
    data object Loading : AISummaryState()
    data class Success(val article: NewsArticle) : AISummaryState()
    data class Error(val message: String) : AISummaryState()
}

/**
 * Represents the state of the news feed.
 */
sealed class FeedState {
    data object Loading : FeedState()
    data class Success(val articles: List<NewsArticle>) : FeedState()
    data class Error(val message: String) : FeedState()
}

/**
 * Represents refresh state for UI feedback.
 */
data class RefreshState(
    val isRefreshing: Boolean = false,
    val lastRefreshTime: Long = System.currentTimeMillis()
)
