plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("kotlin-kapt")
  id("com.google.dagger.hilt.android")
}

android {
  namespace = "com.example.notie"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.example.notie"
    minSdk = 27
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
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_18
    targetCompatibility = JavaVersion.VERSION_18
  }
  kotlinOptions {
    jvmTarget = "18"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.3"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {
  implementation ("androidx.core:core-ktx:1.9.0")
  implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
  implementation ("androidx.activity:activity-compose:1.7.2")
  implementation (platform("androidx.compose:compose-bom:2023.03.00"))
  implementation ("androidx.compose.ui:ui")
  implementation ("androidx.compose.ui:ui-graphics")
  implementation ("androidx.compose.ui:ui-tooling-preview")
  implementation ("androidx.compose.material3:material3")
  implementation("androidx.compose.material:material-icons-extended")
  testImplementation ("junit:junit:4.13.2")
  androidTestImplementation ("androidx.test.ext:junit:1.1.5")
  androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation (platform("androidx.compose:compose-bom:2023.03.00"))
  androidTestImplementation ("androidx.compose.ui:ui-test-junit4")
  debugImplementation ("androidx.compose.ui:ui-tooling")
  debugImplementation ("androidx.compose.ui:ui-test-manifest")
  implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

  implementation ("androidx.compose.material:material:1.4.3")

//    Compose Navigation -
  implementation ("androidx.navigation:navigation-compose:2.7.0-rc01")

//    Room DB -
  implementation ("androidx.room:room-runtime:2.5.2")
  kapt ("androidx.room:room-compiler:2.5.2")
  implementation ("androidx.room:room-ktx:2.5.2")

//    DataStore Preferences -
  implementation ("androidx.datastore:datastore-preferences:1.0.0")

//    Dagger - Hilt
  implementation("com.google.dagger:hilt-android:2.44")
  kapt ("com.google.dagger:hilt-android-compiler:2.44")
  kapt("androidx.hilt:hilt-compiler:1.0.0")

  //firebase
  implementation(platform("com.google.firebase:firebase-bom:32.3.1"))
  implementation("com.google.firebase:firebase-auth-ktx")
  implementation("com.google.android.gms:play-services-auth:20.7.0")
}