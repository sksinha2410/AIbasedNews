package com.ainews.app

import com.ainews.app.data.MockNewsDataSource
import com.ainews.app.data.NewsArticle
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Unit tests for the AI Health News app.
 */
class NewsArticleTest {

    @Test
    fun `mock data source returns articles`() {
        val articles = MockNewsDataSource.getMockArticles()
        
        assertTrue("Should have articles", articles.isNotEmpty())
        assertEquals("Should have 12 articles", 12, articles.size)
    }

    @Test
    fun `each article has required fields`() {
        val articles = MockNewsDataSource.getMockArticles()
        
        articles.forEach { article ->
            assertNotNull("Article should have id", article.id)
            assertNotNull("Article should have title", article.title)
            assertNotNull("Article should have content", article.content)
            assertNotNull("Article should have source", article.source)
            assertNotNull("Article should have publishedDate", article.publishedDate)
            assertNotNull("Article should have category", article.category)
            
            assertTrue("Title should not be empty", article.title.isNotBlank())
            assertTrue("Content should not be empty", article.content.isNotBlank())
        }
    }

    @Test
    fun `articles have unique ids`() {
        val articles = MockNewsDataSource.getMockArticles()
        val ids = articles.map { it.id }
        val uniqueIds = ids.toSet()
        
        assertEquals("All article IDs should be unique", ids.size, uniqueIds.size)
    }

    @Test
    fun `articles cover different health categories`() {
        val articles = MockNewsDataSource.getMockArticles()
        val categories = articles.map { it.category }.toSet()
        
        assertTrue("Should have multiple categories", categories.size > 1)
        assertTrue("Should have Nutrition category", categories.contains("Nutrition"))
        assertTrue("Should have Mental Health category", categories.contains("Mental Health"))
    }

    @Test
    fun `news article data class works correctly`() {
        val article = NewsArticle(
            id = "test-1",
            title = "Test Article",
            content = "Test content",
            source = "Test Source",
            publishedDate = "2024-01-01",
            imageUrl = "https://example.com/image.jpg",
            category = "Test",
            tldr = "Test TL;DR",
            keyTakeaways = listOf("Takeaway 1", "Takeaway 2", "Takeaway 3"),
            simplifiedContent = "Simplified content"
        )
        
        assertEquals("test-1", article.id)
        assertEquals("Test Article", article.title)
        assertEquals("Test TL;DR", article.tldr)
        assertEquals(3, article.keyTakeaways.size)
        assertEquals("Simplified content", article.simplifiedContent)
    }

    @Test
    fun `news article has default empty values for AI fields`() {
        val article = NewsArticle(
            id = "test-2",
            title = "Test",
            content = "Content",
            source = "Source",
            publishedDate = "2024-01-01",
            imageUrl = null,
            category = "Test"
        )
        
        assertEquals("", article.tldr)
        assertTrue(article.keyTakeaways.isEmpty())
        assertEquals("", article.simplifiedContent)
    }
}
