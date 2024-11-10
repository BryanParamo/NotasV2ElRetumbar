plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.notasv2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.notasv2"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildToolsVersion = "35.0.0"
}

dependencies {
    implementation("androidx.compose.material3:material3:1.1.0")
    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.material3:material3:1.0.1")



    // Tu BOM para Compose gestiona las versiones automáticamente.
    implementation(platform(libs.androidx.compose.bom))

    // Dependencias de Jetpack Compose
    implementation(libs.androidx.ui) // androidx.compose.ui:ui
    implementation(libs.androidx.material3) // androidx.compose.material3
    implementation(libs.androidx.ui.graphics) // androidx.compose.ui.graphics
    implementation(libs.androidx.ui.tooling.preview) // androidx.compose.ui.tooling.preview

    // Ciclo de vida y compatibilidad con ViewModel
    implementation(libs.androidx.lifecycle.runtime.ktx) // androidx.lifecycle:lifecycle-runtime-ktx

    // Core y compatibilidad con actividades
    implementation(libs.androidx.core.ktx) // androidx.core:core-ktx
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.room.common)
    implementation(libs.androidx.room.ktx) // androidx.activity:activity-compose

    // Dependencias de testing
    testImplementation(libs.junit) // junit:junit
    androidTestImplementation(libs.androidx.junit) // androidx.test.ext:junit
    androidTestImplementation(libs.androidx.espresso.core) // androidx.test.espresso:espresso-core
    androidTestImplementation(libs.androidx.ui.test.junit4) // androidx.compose.ui:ui-test-junit4

    // Debugging tools
    debugImplementation(libs.androidx.ui.tooling) // androidx.compose.ui:ui-tooling
    debugImplementation(libs.androidx.ui.test.manifest) // androidx.compose.ui:ui-test-manifest
}