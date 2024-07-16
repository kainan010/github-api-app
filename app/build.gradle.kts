plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.naniak.githubapi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.naniak.githubapi"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Retrofit + Coroutines
    implementation (libs.gson)
    implementation (libs.converter.gson)
    implementation (libs.kotlinx.coroutines.android)
    implementation (libs.retrofit)
    implementation (libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.androidx.versionedparcelable)

    //Glide
    implementation (libs.glide)

    //koin
// Koin for Android
    implementation (libs.koin.android)
// Koin Android Scope features
    implementation (libs.koin.android.scope)
// Koin Android ViewModel features
    implementation (libs.koin.android.viewmodel)
// Koin Android Experimental features
    implementation (libs.koin.android.ext)

    //Paging 3
    implementation(libs.androidx.paging.runtime)
}