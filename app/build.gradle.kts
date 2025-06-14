import com.google.protobuf.gradle.*

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.protobuf)
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
}

protobuf {
    // Point to the protoc compiler version from your version catalog
    protoc {
        artifact = libs.protobuf.protoc.get().toString()
    }
    // Configure all generateProto tasks to emit Java code
    generateProtoTasks {
        all().forEach {
            it.builtins {
                id("java") {
                    option("lite")
                }
            }
        }
    }
}

dependencies {
    // Quartz library provides helpful Nostr functionality.
    implementation(libs.amethyst.quartz) {
        // Exclude transitive JNA dependency to avoid pulling the JAR-only version without native libs.
        exclude("net.java.dev.jna")
    }
    // Add JNA explicitly as an AAR dependency to ensure native libraries for all Android architectures are included.
    implementation("net.java.dev.jna:jna:5.17.0") {
        // Use AAR artifact to get native .so libraries bundled with JNA.
        artifact { type = "aar" }
    }

    // Jetpack DataStore (Preferences)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.datastore.core)
    implementation(libs.androidx.datastore)
    implementation(libs.protobuf.javalite)

    // Used to encrypt data with Android KeyStore
    implementation(libs.androidx.security.crypto.ktx)

    // Navigation library for routing between screens.
    implementation(libs.androidx.navigation.compose)

    // Default dependencies installed by default.
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
