// 引用插件
plugins {
    id("com.android.application")
    id("kotlin-android")
}

// Android 属性
android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 21
        targetSdk = 30
        // 可以在 Android 系统的设置-应用设置-该应用信息中展示
        versionCode = 1
        // 只能在应用内部显示调用展示
        versionName = "1.0"

        externalNativeBuild {
            cmake {
                cppFlags += "-std=c++17"
                // 设置支持的 so 库构架 "armeabi-v7a" , "arm64-v8a", "x86", "x86_64"
                abiFilters += mutableListOf("armeabi-v7a", "arm64-v8a")
                //abiFilters += "armeabi-v7a"
                //abiFilters += "arm64-v8a"
            }
        }

    }

    // 编译类型
    buildTypes {
        release {
            // 是否代码混淆
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // 编译选项操作
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.10.2"
        }
    }

    // 开启视图绑定
    buildFeatures {
        viewBinding = true
    }

}

// 依赖
dependencies {
    implementation("androidx.core:core-ktx:1.5.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")

    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("de.hdodenhof:circleimageview:3.1.0")
}