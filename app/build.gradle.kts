import com.android.build.gradle.internal.api.BaseVariantOutputImpl
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.ahmedsamy.app"
    compileSdk = 36

    dependenciesInfo {
        // Privacy: Disable dependency metadata for IzzyOnDroid compliance
        includeInApk = false
        includeInBundle = false
    }

    defaultConfig {
        applicationId = "com.ahmedsamy.app"
        
        minSdk = 26
        targetSdk = 36
        
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    // signingConfigs {
    //     // TODO: Add your signing configuration here for release builds.
    //     // Example:
    //     // create("release") {
    //     //     storeFile = file("your.keystore")
    //     //     storePassword = "your_password"
    //     //     keyAlias = "your_key_alias"
    //     //     keyPassword = "your_key_password"
    //     // }
    // }

    buildTypes {
        getByName("debug") {
            // Keep debug builds fast and open
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = true
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
        }

        getByName("release") {
            // Optimize APK size (~2MB) using R8
            isMinifyEnabled = true
            isShrinkResources = true
            
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isDebuggable = false
            // signingConfig = signingConfigs.getByName("release")
        }
    }



    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_21)
        targetCompatibility(JavaVersion.VERSION_21)
    }

    kotlin { jvmToolchain(21) }
    buildFeatures { compose = true }
}

dependencies {
    implementation("androidx.core:core-ktx:1.17.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.3.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")

    // Jetpack Compose
    val composeBom = platform("androidx.compose:compose-bom:2024.12.01")
    implementation(composeBom)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose:1.12.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.10.0")
    
    debugImplementation("androidx.compose.ui:ui-tooling")
}