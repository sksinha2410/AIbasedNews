# AI Health News

An Android app (Kotlin + Jetpack Compose) that summarizes and simplifies health news articles into a daily feed with AI-powered features.

## Features

### Screen 1 & 3: News Feed
- Load mock health news articles (RSS-style data)
- Paginated list with infinite scroll
- Pull-to-refresh functionality
- Category-based color coding

### Screen 2: AI Summary Cards
- **TL;DR**: 2-line summary of each article
- **3 Key Takeaways**: Bullet-pointed main insights
- Regenerate button for each summary
- Clean, consistent formatting

### Screen 4: Article Detail
- Full article with AI-simplified content
- Toggle between original and simplified versions
- Regenerate simplified content
- Friendly, easy-to-understand tone

## Architecture

```
app/
├── data/
│   ├── NewsArticle.kt         # Data models
│   ├── MockNewsDataSource.kt  # Mock health news articles
│   └── NewsRepository.kt      # Data repository
├── ui/
│   ├── theme/                 # Material 3 theming
│   ├── components/            # Reusable UI components
│   ├── screens/               # Main screens
│   └── Navigation.kt          # Navigation setup
├── viewmodel/
│   ├── NewsFeedViewModel.kt   # Feed screen logic
│   └── ArticleDetailViewModel.kt # Detail screen logic
└── util/
    └── AISummaryService.kt    # AI summary generation
```

## Tech Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose with Material 3
- **Architecture**: MVVM with StateFlow
- **Navigation**: Navigation Compose
- **Image Loading**: Coil
- **Async**: Kotlin Coroutines

## Building the App

```bash
# Build debug APK
./gradlew assembleDebug

# Run unit tests
./gradlew test

# Build release APK
./gradlew assembleRelease
```

## AI Features

The app demonstrates AI-powered content summarization:

1. **Summary Generation**: Creates concise TL;DR summaries
2. **Key Takeaways**: Extracts 3 main points from each article
3. **Content Simplification**: Rewrites articles in friendly, easy-to-understand language
4. **Regeneration**: Users can request new AI-generated content

In a production environment, the `AISummaryService` would integrate with an actual AI API (e.g., OpenAI, Claude) for real-time content processing.

## Screenshots

The app features:
- Green health-themed color scheme
- Card-based article layout
- Smooth animations and transitions
- Dark mode support
- Material 3 design language

## Requirements

- Android SDK 24+ (Android 7.0+)
- Kotlin 1.9.0
- Gradle 8.2