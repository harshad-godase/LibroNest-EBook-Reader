
# 📚 LibroNest – EBook Reader App

**LibroNest** is a cleanly-structured Jetpack Compose-based Android application that allows users to explore and read categorized eBooks from Firebase Realtime Database. PDFs are rendered directly within the app using Bouquet PDF reader.

---

## ✨ Features

- 🔖 Browse categorized books (8 categories, 32 books)
- 📄 Open and read PDF books within the app
- 🔥 Firebase Realtime Database integration
- 🎨 Jetpack Compose + Material 3 UI
- ⚙️ MVVM architecture with clean modular structure
- 🌗 Light & dark mode support

---
## 📸 Screenshots


  ![WhatsApp Image 2025-06-12 at 11 49 34_7f5f348d](https://github.com/user-attachments/assets/731f206e-a20a-4fc7-bba6-7e5e7536da92)
  <img src="![WhatsApp Image 2025-06-12 at 11 49 40_216d68ad](https://github.com/user-attachments/assets/3e48b63c-6dfd-485d-8ddb-d756ff98eab3)
" width="200"/>
  <img src="s![WhatsApp Image 2025-06-12 at 11 49 40_e02f8cfa](https://github.com/user-attachments/assets/8768ae90-e7e7-4037-8b36-cbd5f3f97ce2)
" width="200"/>
  <img src="![WhatsApp Image 2025-06-12 at 11 49 40_3eadae2f](https://github.com/user-attachments/assets/a2022e34-4095-4ee8-8b80-7fb16faee157)
" width="200"/>

## 🧱 Tech Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose + Material 3
- **Architecture**: MVVM + Repository Pattern
- **Dependency Injection**: Hilt
- **Backend**: Firebase Realtime Database
- **PDF Viewer**: Bouquet PDF Viewer

---

## 📂 Folder Structure

```
com.example.ebooklibrary/
├── common/
│   ├── BookCategoryModel.kt
│   ├── BookModel.kt
│   └── ResultState.kt
│
├── data/
│   ├── di/
│   │   └── HiltModule.kt
│   └── repoImpl/
│       └── AllBookRepoImpl.kt
│
├── domain/
│   └── repo/ (Interface definitions if any)
│
├── presentation/
│   ├── Effects/
│   │   └── ShimmerEffects.kt
│   ├── Navigation/
│   │   ├── NavGraph.kt
│   │   └── Routes.kt
│   ├── Screens/
│   │   ├── AllBooksScreen.kt
│   │   ├── BooksByCategoryScreen.kt
│   │   ├── CategoryScreen.kt
│   │   ├── HomeScreen.kt
│   │   ├── PdfViewScreen.kt
│   │   ├── TabScreen.kt
│   │   └── ViewModel.kt
│   └── UIcomponent/
│       ├── Bookcart.kt
│       └── BookCategoryCard.kt
│
├── ui.theme/ (Jetpack Compose theme files)
│
├── MainActivity.kt
└── BaseApplication.kt
```

---

## 🛠️ How to Setup

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/LibroNest.git
cd LibroNest
```

### 2. Firebase Setup
- Download `google-services.json` from Firebase Console and place it under `app/`
- Enable Realtime Database and paste the provided JSON data

### 3. Database Rules (Demo)
```json
{
  "rules": {
    ".read": "true",
    ".write": "false"
  }
}
```

### 4. Run the App
- Open in Android Studio Arctic Fox or higher
- Connect Firebase and sync Gradle
- Run on emulator/device (minSdk 28+)

---

## 📌 Project Highlights

- Structured clean architecture following MVVM
- State handled with Compose and Hilt-injected ViewModel
- PDFs open from real working remote links
- No login needed — users instantly access all books

---

## 🧑‍💻 Author

**Your Name**  
📧 your.email@example.com  
🌐 [Portfolio](https://yourportfolio.com) | [LinkedIn](https://linkedin.com/in/yourprofile)

---

## 📄 License

This project is for educational and résumé purposes. The books are open-license PDFs hosted externally.

---

