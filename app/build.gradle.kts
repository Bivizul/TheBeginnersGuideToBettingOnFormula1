plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("com.onesignal.androidsdk.onesignal-gradle-plugin")
}

val composeCompileVersion = rootProject.extra.get("compose_compile_version") as String

android {
    namespace = "com.bivizul.thebeginnersguidetobettingonformula1"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.bivizul.thebeginnersguidetobettingonformula1"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled  = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled  = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeCompileVersion
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

val lifecycleVersion = rootProject.extra.get("lifecycle_version") as String
val composeUiVersion = rootProject.extra.get("compose_ui_version") as String
val navVersion = rootProject.extra.get("nav_version") as String
val accompanistVersion = rootProject.extra.get("accompanist_version") as String
val retrofitVersion = rootProject.extra.get("retrofit_version") as String
val hiltVersion = rootProject.extra.get("hilt_version") as String
val landscapistVersion = rootProject.extra.get("landscapist_version") as String

dependencies {

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation("androidx.compose.ui:ui:$composeUiVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeUiVersion")
    implementation("androidx.compose.material:material:$composeUiVersion")
    implementation("androidx.compose.ui:ui:$composeUiVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeUiVersion")
    implementation("androidx.compose.material:material:$composeUiVersion")
    implementation("androidx.compose.animation:animation:$composeUiVersion")
    implementation("androidx.compose.foundation:foundation:$composeUiVersion")
    implementation("androidx.compose.material:material:$composeUiVersion")
    implementation("androidx.compose.runtime:runtime:$composeUiVersion")
    implementation("androidx.compose.runtime:runtime-livedata:$composeUiVersion")
    implementation("androidx.appcompat:appcompat:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.6.1")

    // Appyx
    // Core
    implementation ("com.bumble.appyx:core:1.0-alpha05")
    // Additional routing sources (such as Tiles, Promoter carousel and Modal)
    implementation ("com.bumble.appyx:navmodel-addons:1.0-alpha05")


    // Navigation
    implementation("androidx.navigation:navigation-compose:$navVersion")

    // Accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-pager:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-pager-indicators:$accompanistVersion")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    // Hilt
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    implementation("androidx.hilt:hilt-work:1.0.0")
    kapt ("com.google.dagger:hilt-compiler:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // Landscapist
    implementation("com.github.skydoves:landscapist-coil:$landscapistVersion")

    // OneSignal
    implementation("com.onesignal:OneSignal:[4.0.0, 4.99.99]")

    // Appsflyer
    implementation("com.appsflyer:af-android-sdk:6.8.0")
    implementation("com.android.installreferrer:installreferrer:2.2")

    // Test
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:$composeUiVersion")
    debugImplementation ("androidx.compose.ui:ui-tooling:$composeUiVersion")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:$composeUiVersion")
}