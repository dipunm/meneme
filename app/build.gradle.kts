plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "app.nostr.meneme"
    compileSdk = 35

    defaultConfig {
        applicationId = "app.nostr.meneme"
        minSdk = 26
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
//
//    packaging {
//        jniLibs.pickFirsts.add("lib/arm64-v8a/libjnidispatch.so")
//        jniLibs.pickFirsts.add("lib/arm64-v8a/libsodium.so")
//        jniLibs.pickFirsts.add("lib/armeabi-v7a/libjnidispatch.so")
//        jniLibs.pickFirsts.add("lib/armeabi-v7a/libsodium.so")
//        jniLibs.pickFirsts.add("lib/x86/libjnidispatch.so")
//        jniLibs.pickFirsts.add("lib/x86/libsodium.so")
//        jniLibs.pickFirsts.add("lib/x86_64/libjnidispatch.so")
//        jniLibs.pickFirsts.add("lib/x86_64/libsodium.so")
//    }
}

dependencies {
    implementation("com.goterl:lazysodium-android:5.2.0@arr")
    implementation("net.java.dev.jna:jna:5.17.0@arr")
    implementation(libs.amethyst.quartz)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}