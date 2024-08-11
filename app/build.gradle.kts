plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.jokerapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jokerapp"
        minSdk = 25
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    val roomVersion = "2.6.1"

    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")

    val lifecycleVersion = "2.8.4"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")

    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.3.1")
    implementation("androidx.lifecycle:lifecycle-livedata:2.3.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    implementation("com.squareup.picasso:picasso:2.71828")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5'")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5'")
    implementation("com.google.android.material:material:1.6.1")

}