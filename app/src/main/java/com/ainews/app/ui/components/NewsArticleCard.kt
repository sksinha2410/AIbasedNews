package com.ainews.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ainews.app.data.NewsArticle
import com.ainews.app.ui.theme.AppTypography
import com.ainews.app.ui.theme.CategoryFitness
import com.ainews.app.ui.theme.CategoryImmuneHealth
import com.ainews.app.ui.theme.CategoryMentalHealth
import com.ainews.app.ui.theme.CategoryNutrition
import com.ainews.app.ui.theme.CategoryResearch
import com.ainews.app.ui.theme.CategorySleep
import com.ainews.app.ui.theme.HealthGreen

/**
 * Card component for displaying a news article summary in the feed.
 */
@Composable
fun NewsArticleCard(
    article: NewsArticle,
    onArticleClick: (NewsArticle) -> Unit,
    onRegenerateSummary: (String) -> Unit,
    isRegenerating: Boolean = false,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onArticleClick(article) },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Header with image and category
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                // Article image
                AsyncImage(
                    model = article.imageUrl,
                    contentDescription = article.title,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
                
                Spacer(modifier = Modifier.width(12.dp))
                
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    // Category chip
                    CategoryChip(category = article.category)
                    
                    Spacer(modifier = Modifier.height(4.dp))
                    
                    // Title
                    Text(
                        text = article.title,
                        style = AppTypography.headlineSmall,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // TL;DR Section
            TldrSection(
                tldr = article.tldr,
                isRegenerating = isRegenerating,
                onRegenerate = {
                    onRegenerateSummary(article.id)
                }
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Key Takeaways
            KeyTakeawaysSection(takeaways = article.keyTakeaways)
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Footer with source and date
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = article.source,
                    style = AppTypography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = article.publishedDate,
                    style = AppTypography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

/**
 * Category chip displaying the article category with color coding.
 */
@Composable
fun CategoryChip(
    category: String,
    modifier: Modifier = Modifier
) {
    val categoryColor = when (category.lowercase()) {
        "nutrition" -> CategoryNutrition
        "fitness" -> CategoryFitness
        "mental health" -> CategoryMentalHealth
        "research" -> CategoryResearch
        "sleep" -> CategorySleep
        "immune health" -> CategoryImmuneHealth
        else -> HealthGreen
    }
    
    Box(
        modifier = modifier
            .background(
                color = categoryColor.copy(alpha = 0.15f),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = category,
            style = AppTypography.labelSmall,
            color = categoryColor,
            fontWeight = FontWeight.SemiBold
        )
    }
}

/**
 * TL;DR section with regenerate button.
 */
@Composable
fun TldrSection(
    tldr: String,
    isRegenerating: Boolean,
    onRegenerate: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(HealthGreen, CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "TL;DR",
                    style = AppTypography.labelLarge,
                    color = HealthGreen,
                    fontWeight = FontWeight.Bold
                )
            }
            
            IconButton(
                onClick = onRegenerate,
                modifier = Modifier.size(32.dp)
            ) {
                if (isRegenerating) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(16.dp),
                        strokeWidth = 2.dp,
                        color = HealthGreen
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Regenerate summary",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = tldr,
            style = AppTypography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            lineHeight = AppTypography.bodyMedium.lineHeight
        )
    }
}

/**
 * Key takeaways section with bullet points.
 */
@Composable
fun KeyTakeawaysSection(
    takeaways: List<String>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "Key Takeaways",
            style = AppTypography.labelLarge,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.SemiBold
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        takeaways.forEachIndexed { index, takeaway ->
            Row(
                modifier = Modifier.padding(vertical = 2.dp),
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = "${index + 1}.",
                    style = AppTypography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(20.dp)
                )
                Text(
                    text = takeaway,
                    style = AppTypography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

/**
 * Loading placeholder for articles.
 */
@Composable
fun ArticleLoadingPlaceholder(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    color = HealthGreen,
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "AI is generating summary...",
                    style = AppTypography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
