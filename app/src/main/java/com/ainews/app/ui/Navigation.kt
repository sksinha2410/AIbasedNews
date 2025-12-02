package com.ainews.app.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ainews.app.ui.screens.ArticleDetailScreen
import com.ainews.app.ui.screens.NewsFeedScreen

/**
 * Navigation routes for the app.
 */
object Routes {
    const val FEED = "feed"
    const val ARTICLE_DETAIL = "article/{articleId}"
    
    fun articleDetail(articleId: String) = "article/$articleId"
}

/**
 * Main navigation host for the AI Health News app.
 */
@Composable
fun AIHealthNewsNavHost() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = Routes.FEED
    ) {
        // Screen 1 & 3: News Feed with mock articles, pagination, and pull-to-refresh
        composable(Routes.FEED) {
            NewsFeedScreen(
                onArticleClick = { article ->
                    navController.navigate(Routes.articleDetail(article.id))
                }
            )
        }
        
        // Screen 2 & 4: Article Detail with TL;DR, key takeaways, and simplified content
        composable(
            route = Routes.ARTICLE_DETAIL,
            arguments = listOf(
                navArgument("articleId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val articleId = backStackEntry.arguments?.getString("articleId") ?: ""
            ArticleDetailScreen(
                articleId = articleId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
