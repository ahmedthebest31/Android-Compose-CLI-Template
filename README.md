# Android Jetpack Compose CLI Template

A lightweight, clean, and CLI-first Android Jetpack Compose template. Designed for developers who prefer VS Code, Neovim, or terminal workflows over heavy IDEs.

This template is "Open Source First," optimized for F-Droid standards, offline development, and maximum build transparency.

## Core Philosophy
- **Terminal Centric:** No dependency on Android Studio. Built to be run with `./gradlew` and `adb`.
- **Privacy & Transparency:** No proprietary Google binaries, no obfuscated encryption blocks, and fully compatible with IzzyOnDroid and F-Droid audit standards.
- **Minimalist:** Only essential dependencies included.

## Features
- **Modern UI Stack:** Jetpack Compose with Material3 Design System.
- **Broad Compatibility:** Supports **Android 8.0 (API 26)** up to the latest **Android 16 (Preview/API 35+)**.
- **Production Ready:** Pre-configured R8 (ProGuard) rules for minification and optimization in release builds.
- **Clean Architecture:** Zero boilerplate business logic. Ready for your code immediately.
- **Offline Capable:** Gradle wrapper and dependency versions are locked for consistent offline builds.
- **F-Droid Ready:** Pre-configured Fastlane file structure and settings, designed to meet F-Droid distribution requirements easily.

## Requirements
- JDK 17 or higher.
- Android SDK Command-line Tools.
- Git.

## Getting Started (Terminal Workflow)

### 1. Initialize Project
Create a new repository from this template or clone it:
```bash
git clone https://github.com/ahmedthebest31/Android-Compose-CLI-Template.git my-app
cd my-app
```

## 2. Build the App
You don't need to open an IDE to build. Use the wrapper directly:
For Debug Build:
Bash
Copy code
./gradlew assembleDebug
For Release Build (Minified):
Bash
Copy code
./gradlew assembleRelease
## 3. Install & Run
Install the APK directly to your connected device using ADB:
```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

## 4. Clean Project
If you want to start fresh or remove cached build artifacts:
Bash
Copy code
./gradlew clean
## Project Structure
- app/src/main/java/com/ahmedsamy/app: Main Kotlin source code (Hello World).
- app/src/main/java/com/ahmedsamy/app/ui/theme: Material3 Theme definitions.
- gradle/libs.versions.toml: Centralized dependency management.


## ⚙️ Configuration
You can configure the essential project details without touching Kotlin code. Open `gradle.properties` and edit:

```properties
APP_ID=com.yourcompany.project
VERSION_CODE=1
VERSION_NAME=1.0.0
```


## 🔐 Secure Signing (Release)

To sign your APK for release securely:

1. Copy the example file:
   `cp keystore.properties.example keystore.properties`
2. Open `keystore.properties` and add your real keystore details (passwords, alias, path).
3. The build script will automatically detect this file and sign the release APK.

*Note: `keystore.properties` is strictly ignored by Git to protect your secrets.*


Built with ❤️ for the Open Source Community.
