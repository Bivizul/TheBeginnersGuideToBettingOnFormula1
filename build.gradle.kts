buildscript {
    extra.apply {
        set("compose_compile_version", "1.3.0")
        set("compose_ui_version", "1.2.1")
        set("accompanist_version", "0.25.1")
        set("agp_version", "7.2.2")
        set("kotlin_version", "1.7.10")
        set("lifecycle_version", "2.5.1")
        set("nav_version", "2.5.1")
        set("hilt_version", "2.43.2")
        set("retrofit_version", "2.9.0")
        set("landscapist_version", "1.6.1")
    }
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.1")
        classpath ("gradle.plugin.com.onesignal:onesignal-gradle-plugin:0.14.0")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.43.2")
    }
}
plugins {
    id("com.android.application") version "7.2.2" apply false
    id("com.android.library") version "7.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.7.10" apply false
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}