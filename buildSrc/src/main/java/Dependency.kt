object Kotlin {
    private const val SDK_VERSION = "1.5.21"

    const val SDK = "org.jetbrains.java:java-stdlib-jdk8:$SDK_VERSION"
}

object AndroidX {
    private const val MATERIAL_VERSION = "1.0.0-rc02"
    private const val CONSTRAINTLAYOUT_VERSION = "2.1.3"
    private const val COMPAT_VERSION = "1.4.1"
    private const val LEGACY_VERSION = "1.0.0"
    private const val LIFECYCLE_VERSION = "2.3.1"
    private const val ACTIVITY_VERSION = "1.3.1"
    private const val FRAGMENT_VERSION = "1.3.6"
    private const val DATASTORE_VERSION = "1.0.0"

    const val MATERIAL = "androidx.compose.material:material:$MATERIAL_VERSION"
    const val CONSTRAINTLAYOUT = "androidx.constraintlayout:constraintlayout:$CONSTRAINTLAYOUT_VERSION"
    const val APP_COMPAT = "androidx.appcompat:appcompat:$COMPAT_VERSION"
    const val LEGACY = "androidx.legacy:legacy-support-v4:$LEGACY_VERSION"
    const val LIFECYCLE_VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:$LIFECYCLE_VERSION"
    const val LIFECYCLE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:$LIFECYCLE_VERSION"
    const val ACTIVITY = "androidx.activity:activity-ktx:$ACTIVITY_VERSION"
    const val FRAGMENT = "androidx.fragment:fragment-ktx:$FRAGMENT_VERSION"
    const val DATASTORE = "androidx.datastore:datastore-preferences:$DATASTORE_VERSION"
}

object KTX {
    private const val KTX_VERSION = "1.7.0"

    const val CORE = "androidx.core:core-ktx:$KTX_VERSION"
}

object Google {
    private const val GOOGLE_VERSION = "1.6.0"

    const val MATERIAL = "com.google.android.material:material:$GOOGLE_VERSION"
}

object Test {
    const val JUNIT = "junit:junit:4.+"
    const val ANDROID_JUNIT_RUNNER = "AndroidJUnitRunner"
}

object AndroidTest {
    private const val JUNIT_VERSION = "1.1.3"
    private const val RUNNER_VERSION = "1.4.0"
    private const val ESPRESSO_CORE_VERSION = "3.4.0"

    const val EXT_JUNIT = "androidx.test.ext:junit:$JUNIT_VERSION"
    const val TEST_RUNNER = "androidx.test:runner:$RUNNER_VERSION"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:$ESPRESSO_CORE_VERSION"
}

object DaggerHilt {
    private const val HILT_VERSION = "2.40.1"
    private const val VIEWMODEL_VERSION = "1.0.0-alpha03"
    private const val COMPILER_VERSION = "1.0.0"

    const val DAGGER_HILT = "com.google.dagger:hilt-android:$HILT_VERSION"
    const val DAGGER_HILT_COMPILER = "com.google.dagger:hilt-android-compiler:$HILT_VERSION"
    const val DAGGER_HILT_VIEW_MODEL = "androidx.hilt:hilt-lifecycle-viewmodel:$VIEWMODEL_VERSION"
    const val DAGGER_HILT_ANDROIDX_COMPILER = "androidx.hilt:hilt-compiler:$COMPILER_VERSION"
}

object Retrofit {
    private const val RETROFIT_VERSION = "2.9.0"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION"
    const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:$RETROFIT_VERSION"
    const val CONVERTER_JAXB = "com.squareup.retrofit2:converter-jaxb:$RETROFIT_VERSION"
}

object OkHttp {
    private const val OKHTTP_VERSION = "4.9.1"

    const val OKHTTP = "com.squareup.okhttp3:okhttp:$OKHTTP_VERSION"
    const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:$OKHTTP_VERSION"
}

object Coroutines {
    private const val COROUTINES_VERSION = "1.5.2"

    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$COROUTINES_VERSION"
}

object CameraX {
    private const val CAMERA_VERSION = "1.0.2"
    private const val VIEW_VERSION = "1.0.0-alpha29"
    private const val EXTENSIONS_VERSION = "1.0.0-alpha29"

    const val CAMERA_CORE = "androidx.camera:camera-core:$CAMERA_VERSION"
    const val CAMERA_CAMERA2 = "androidx.camera:camera-camera2:$CAMERA_VERSION"
    const val CAMERA_LIFECYCLE = "androidx.camera:camera-lifecycle:$CAMERA_VERSION"
    const val CAMERA_VIEW = "androidx.camera:camera-view:$VIEW_VERSION"
    const val CAMERA_EXTENSIONS = "androidx.camera:camera-extensions:$EXTENSIONS_VERSION"
}

object NavComponent {
    private const val NAV_VERSION = "2.4.0-alpha10"

    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:$NAV_VERSION"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:$NAV_VERSION"
    const val NAVIGATION_DYNAMIC_FEATURES_FRAGMENT = "androidx.navigation:navigation-dynamic-features-fragment:$NAV_VERSION"
    const val NAVIGATION_TESTING = "androidx.navigation:navigation-testing:$NAV_VERSION"
    const val NAVIGATION_COMPOSE = "androidx.navigation:navigation-compose:$NAV_VERSION"
}

object Room {
    private const val ROOM_VERSION = "2.2.6"

    const val ROOM_RUNTIME = "androidx.room:room-runtime:$ROOM_VERSION"
    const val ROOM_RXJAVA2 = "androidx.room:room-rxjava2:$ROOM_VERSION"
    const val ROOM_TESTING = "androidx.room:room-testing:$ROOM_VERSION"
    const val ROOM_COMPILER = "androidx.room:room-compiler:$ROOM_VERSION"
    const val ROOM_KTX = "androidx.room:room-ktx:$ROOM_VERSION"
}

object MOSHI {
    private const val MOSHI_VERSION = "1.13.0"
    const val MOSHI = "com.squareup.moshi:moshi-kotlin:$MOSHI_VERSION"
}

object AWS {
    private const val AWS_VERSION = "2.20.1"

    const val AWS_COGNITO = "com.amazonaws:aws-android-sdk-cognito:$AWS_VERSION"
    const val AWS_S3 = "com.amazonaws:aws-android-sdk-s3:$AWS_VERSION"
    const val AWS_MOBILE_CLIENT = "com.amazonaws:aws-android-sdk-mobile-client:$AWS_VERSION"
}

object Glide {
    private const val GLIDE_VERSION = "4.12.0"

    const val GLIDE = "com.github.bumptech.glide:glide:$GLIDE_VERSION"
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:$GLIDE_VERSION"
}

object ProductFlavor{
    const val DEMENSION = "server"

    const val LIVE_APP_LABEL = "live"
    const val LIVE_APP_NAME = "젤리핀"

    const val DEV_APP_LABEL = "dev"
    const val DEV_APP_NAME = "(D)젤리핀"

    const val APPLICATION_ID_SUFFIX = ""

    /**
     * buildConfigField 정의
     */
    //https://jellypins.org/jellypins/api/v1/jelly/jelly2.do?indexNo=1
    //API 서버 주소
    const val FIELD_HOSTNAME = "HOSTNAME"
    const val LIVE_HOSTNAME_VALUE = "\"https://jellypins.org/\""
    const val DEV_HOSTNAME_VALUE = "\"https://reqres.in/\""

    //API 컨트롤러
    const val FIELD_CONTROLLER = "CONTROLLER"
    const val LIVE_CONTROLLER_VALUE = "\"/jellypins\""
    const val DEV_CONTROLLER_VALUE = "\"/api\""

    //AWS 정보
    const val FIELD_AWS_ACCESS_KEY = "AWS_ACCESS_KEY"
    const val LIVE_AWS_ACCESS_KEY_VALUE = "\"AKIAS6767LQJS3JKXJL3\""
    const val DEV_AWS_ACCESS_KEY_VALUE = "\"AKIAS6767LQJS3JKXJL3\""

    const val FIELD_AWS_SECRET_KEY = "AWS_SECRET_KEY"
    const val LIVE_AWS_SECRET_KEY_VALUE = "\"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\""
    const val DEV_AWS_SECRET_KEY_VALUE = "\"gtkxXrq1QVmCWXvrbqMsotkrScg41btdCqtBLarX\""

    const val FIELD_AWS_BUCKET = "AWS_BUCKET"
    const val LIVE_AWS_BUCKET_VALUE = "\"jellypins\""
    const val DEV_AWS_BUCKET_VALUE = "\"jellypins\""

    const val FIELD_AWS_CLOUD_FRONT = "AWS_CLOUD_FRONT"
    const val LIVE_AWS_CLOUD_FRONT_VALUE = "\"https://jellypins.s3.us-east-2.amazonaws.com\""
    const val DEV_AWS_CLOUD_FRONT_VALUE = "\"https://jellypins.s3.us-east-2.amazonaws.com\""

}