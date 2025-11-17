# To-Do List Android App

A modern Android to-do list application built with Jetpack Compose and Room Database. This app allows users to manage their daily tasks with an intuitive swipe-to-edit/delete interface.

## Features

- **Add Tasks**: Create new tasks with a simple dialog interface
- **Edit Tasks**: Swipe right on any task to edit its name
- **Delete Tasks**: Swipe left on any task to delete it
- **Check/Uncheck**: Mark tasks as completed with checkboxes
- **Persistent Storage**: All tasks are stored locally using Room Database
- **Modern UI**: Built with Jetpack Compose and Material Design 3

## Tech Stack

### Architecture & Components
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture Pattern**: MVVM (Model-View-ViewModel)
- **Database**: Room Persistence Library
- **Reactive Programming**: LiveData & Coroutines

### Key Libraries
- **Jetpack Compose** - Modern declarative UI toolkit
- **Material Design 3** - Latest Material Design components
- **Room** (v2.6.1) - Local database with compile-time verification
- **ViewModel & LiveData** (v2.6.2) - Lifecycle-aware data handling
- **Kotlin Coroutines** - Asynchronous programming

## Project Structure

```
app/src/main/java/com/example/to_do_list/
├── MainActivity.kt           # Main entry point and UI
├── TaskViewModel.kt          # ViewModel for task management
├── TaskRepository.kt         # Repository pattern implementation
├── data/
│   ├── Task.kt              # Task entity model
│   ├── TaskDao.kt           # Room DAO interface
│   └── TaskDatabase.kt      # Room database configuration
└── ui/theme/
    ├── Color.kt             # App color definitions
    ├── Theme.kt             # Material theme configuration
    └── Type.kt              # Typography definitions
```

## Requirements

- **Minimum SDK**: Android 7.0 (API 24)
- **Target SDK**: Android 14 (API 36)
- **Compile SDK**: Android 14 (API 36)
- **Kotlin Version**: Compatible with Kotlin 1.9+
- **Gradle**: 8.0+

## Installation

### Prerequisites
- Android Studio Hedgehog (2023.1.1) or later
- JDK 11 or higher
- Android SDK with API 24-36

### Setup Steps

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Todolist
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an Existing Project"
   - Navigate to the project directory

3. **Sync Gradle**
   - Android Studio should automatically sync Gradle dependencies
   - If not, click "Sync Project with Gradle Files"

4. **Run the app**
   - Connect an Android device or start an emulator
   - Click the "Run" button or press `Shift + F10`

## Usage

### Adding a Task
1. Tap the floating action button (+ icon) at the bottom right
2. Enter the task name in the dialog
3. Tap "Add" to save the task

### Editing a Task
1. Swipe **right** on a task card
2. Modify the task name in the dialog
3. Tap "Save" to update

### Deleting a Task
1. Swipe **left** on a task card
2. The task will be removed from the list

### Checking/Unchecking a Task
- Tap the checkbox next to any task to toggle its completion status

## Architecture Overview

### MVVM Pattern
The app follows the Model-View-ViewModel architecture:

- **Model** (`Task`, `TaskDao`, `TaskDatabase`): Data layer handling persistence
- **View** (`MainActivity`, Composables): UI layer built with Jetpack Compose
- **ViewModel** (`TaskViewModel`): Business logic and UI state management
- **Repository** (`TaskRepository`): Abstraction layer between ViewModel and data sources

### Room Database
Tasks are stored persistently using Room with the following schema:

| Column   | Type    | Description                    |
|----------|---------|--------------------------------|
| id       | Int     | Primary key (auto-generated)   |
| name     | String  | Task description               |
| checked  | Boolean | Completion status (default: false) |

## Key Features Implementation

### Swipe to Edit/Delete
- Uses `SwipeToDismiss` from Material components
- Left swipe: Delete action (red background)
- Right swipe: Edit action (secondary color background)

### Material Design 3
- Custom purple theme with `PurpleColor`, `PurpleCheck`, and `PurpleUnchecked`
- Elevated cards with rounded corners
- Modern Material 3 components (TopAppBar, FloatingActionButton, etc.)

### LiveData & Coroutines
- Real-time UI updates through LiveData observation
- Database operations run on background threads using coroutines

## Building for Release

1. **Generate signed APK**
   - Build → Generate Signed Bundle/APK
   - Follow the wizard to create or use existing keystore
   - Select release build variant

2. **Configure ProGuard** (optional)
   - Edit `proguard-rules.pro` for code obfuscation
   - Enable minification in `build.gradle.kts`

## License

This project is licensed under the MIT License.