package com.ainews.app

import com.ainews.app.util.AISummaryService
import com.ainews.app.data.MockNewsDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Unit tests for the AI Summary Service.
 */
class AISummaryServiceTest {

    @Test
    fun `generateSummary returns article with tldr`() = runBlocking {
        val articles = MockNewsDataSource.getMockArticles()
        val article = articles.first()
        
        val summarized = AISummaryService.generateSummary(article)
        
        assertNotNull("TL;DR should not be null", summarized.tldr)
        assertTrue("TL;DR should not be empty", summarized.tldr.isNotBlank())
    }

    @Test
    fun `generateSummary returns article with key takeaways`() = runBlocking {
        val articles = MockNewsDataSource.getMockArticles()
        val article = articles.first()
        
        val summarized = AISummaryService.generateSummary(article)
        
        assertNotNull("Key takeaways should not be null", summarized.keyTakeaways)
        assertEquals("Should have 3 key takeaways", 3, summarized.keyTakeaways.size)
        
        summarized.keyTakeaways.forEach { takeaway ->
            assertTrue("Takeaway should not be empty", takeaway.isNotBlank())
        }
    }

    @Test
    fun `generateSimplifiedContent returns article with simplified content`() = runBlocking {
        val articles = MockNewsDataSource.getMockArticles()
        val article = articles.first()
        
        val withSummary = AISummaryService.generateSummary(article)
        val simplified = AISummaryService.generateSimplifiedContent(withSummary)
        
        assertNotNull("Simplified content should not be null", simplified.simplifiedContent)
        assertTrue("Simplified content should not be empty", simplified.simplifiedContent.isNotBlank())
    }

    @Test
    fun `regenerateSummary returns new summary`() = runBlocking {
        val articles = MockNewsDataSource.getMockArticles()
        val article = articles.first()
        
        val regenerated = AISummaryService.regenerateSummary(article)
        
        assertNotNull("Regenerated TL;DR should not be null", regenerated.tldr)
        assertTrue("Regenerated TL;DR should not be empty", regenerated.tldr.isNotBlank())
        assertEquals("Should still have 3 key takeaways", 3, regenerated.keyTakeaways.size)
    }

    @Test
    fun `all mock articles can be summarized`() = runBlocking {
        val articles = MockNewsDataSource.getMockArticles()
        
        articles.forEach { article ->
            val summarized = AISummaryService.generateSummary(article)
            
            assertTrue("Article ${article.id} should have TL;DR", summarized.tldr.isNotBlank())
            assertEquals("Article ${article.id} should have 3 takeaways", 3, summarized.keyTakeaways.size)
        }
    }

    @Test
    fun `all mock articles can be simplified`() = runBlocking {
        val articles = MockNewsDataSource.getMockArticles()
        
        articles.forEach { article ->
            val withSummary = AISummaryService.generateSummary(article)
            val simplified = AISummaryService.generateSimplifiedContent(withSummary)
            
            assertTrue(
                "Article ${article.id} should have simplified content", 
                simplified.simplifiedContent.isNotBlank()
            )
        }
    }
}
