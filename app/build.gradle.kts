plugins {
    alias(libs.plugins.android.application) // Плагин для сборки Android-приложения
    alias(libs.plugins.kotlin.android) // Поддержка Kotlin в Android
    id("kotlin-kapt") // KAPT (Kotlin Annotation Processing) для обработки аннотаций (например, Hilt, Room)
    id("androidx.navigation.safeargs.kotlin") // Безопасная передача аргументов в Navigation Component
    id("kotlin-parcelize") // Аннотация @Parcelize для упрощенной работы с Parcelable
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0" // Плагин для поддержки Jetpack Compose
    id("dagger.hilt.android.plugin") // Плагин для внедрения зависимостей с Dagger Hilt
}

android {
    namespace = "com.boardgames.rick_and_morty"
    compileSdk = 35 // Версия SDK, с которой компилируется приложение

    defaultConfig {
        applicationId = "com.boardgames.rick_and_morty"
        minSdk = 26 // Минимальная поддерживаемая версия Android
        targetSdk = 35 // Версия Android, на которую нацелено приложение
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner" // Тестовый раннер для Android
        vectorDrawables.useSupportLibrary = true // Поддержка векторных ресурсов в старых версиях Android
    }

    buildTypes {
        release {
            isMinifyEnabled = false // Отключение минификации кода в релизной сборке
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), // Базовые правила ProGuard
                "proguard-rules.pro" // Дополнительные правила ProGuard
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8 // Совместимость с Java 1.8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8" // Установка версии JVM для Kotlin
    }

    buildFeatures {
        dataBinding = true // Включение DataBinding
        viewBinding = true // Включение ViewBinding
        compose = true // Поддержка Jetpack Compose
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1" // Версия компилятора Jetpack Compose
    }

    packaging.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}" // Исключение ненужных лицензий
}

dependencies {
    // Базовые библиотеки Android
    implementation(libs.androidx.core.ktx) // Расширения Kotlin для Android
    implementation(libs.androidx.appcompat) // Поддержка старых версий Android
    implementation(libs.material) // Компоненты Material Design
    implementation(libs.androidx.constraintlayout) // ConstraintLayout для адаптивного UI

    // Архитектурные компоненты Android Jetpack
    implementation(libs.androidx.lifecycle.viewmodel.ktx) // ViewModel для хранения UI-данных
    implementation(libs.androidx.lifecycle.livedata.ktx) // LiveData для реактивного программирования
    implementation(libs.androidx.recyclerview) // RecyclerView для списков

    // Navigation Component
    implementation(libs.androidx.navigation.fragment.ktx) // Навигация между фрагментами
    implementation(libs.androidx.navigation.ui.ktx) // Навигация через UI-компоненты
    implementation(libs.androidx.navigation.compose) // Навигация в Jetpack Compose

    // Библиотека Coil для загрузки изображений
    implementation(libs.coil.compose)

    // Retrofit для работы с API
    implementation(libs.retrofit) // Основная библиотека Retrofit
    implementation(libs.converter.gson) // Конвертер JSON через Gson

    // OkHttp для логирования HTTP-запросов
    implementation(libs.logging.interceptor)

    // Пагинация с Jetpack Paging 3
    implementation(libs.androidx.paging.runtime.ktx)
    implementation(libs.androidx.paging.compose)

    // ViewPager 2 для перелистываемых экранов
    implementation(libs.androidx.viewpager2)

    // Dagger Hilt для внедрения зависимостей
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Коррутины Kotlin
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Jetpack Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose) // ViewModel в Compose
    implementation(libs.androidx.material.icons.extended) // Расширенные иконки Material
    implementation(libs.androidx.activity.compose) // Поддержка Activity в Compose
    implementation(platform(libs.androidx.compose.bom)) // BOM (Bill of Materials) для Compose
    implementation(libs.androidx.ui) // Основная UI-библиотека Compose
    implementation(libs.androidx.ui.graphics) // Работа с графикой в Compose
    implementation(libs.androidx.ui.tooling.preview) // Поддержка предпросмотра UI в Compose
    implementation(libs.androidx.material3) // Компоненты Material Design 3 для Compose

    // Библиотеки для тестирования
    testImplementation(libs.junit) // Библиотека JUnit для модульных тестов
    androidTestImplementation(libs.androidx.junit) // Android-тесты с JUnit
    androidTestImplementation(libs.androidx.espresso.core) // UI-тесты с Espresso
    androidTestImplementation(platform(libs.androidx.compose.bom)) // BOM для тестирования Compose
    androidTestImplementation(libs.androidx.ui.test.junit4) // UI-тесты Compose с JUnit
    debugImplementation(libs.androidx.ui.tooling) // Инструменты отладки UI
    debugImplementation(libs.androidx.ui.test.manifest) // Поддержка тестирования манифеста
}
