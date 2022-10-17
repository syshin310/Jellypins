package jellypins.org.data.di

import jellypins.org.data.service.api.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * packageName    : jellypins.org.data.di
 * fileName       : NetworkModule
 * author         : syshinpins
 * date           : 2022/06/06
 * description    : API 의존성 주입
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-06       syshinpins         최초 생성
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class ReqresServer

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class GitServer

    /**
     * HttpClient 의존성 주입
     * @return
     */
    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(getLoggingInterceptor())
            .build()
    }

    /**
     * GsonConverterFactory 의존성 주입
     * @return
     */
    @Provides
    @Singleton
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

//    /**
//     * Retrofit 의존성 주입
//     * @param okHttpClient
//     * @param gsonConverterFactory
//     * @return
//     */
//    @Singleton
//    @Provides
//    fun provideRetrofitInstance(
//        okHttpClient: OkHttpClient,
//        gsonConverterFactory: GsonConverterFactory
//    ): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(BuildConfig.HOSTNAME)
//            .client(okHttpClient)
//            .client(provideHttpClient())
//            .addConverterFactory(gsonConverterFactory)
//            .build()
//    }

    /**
     * Reqres서버 Retrofit 의존성 주입
     * @param okHttpClient
     * @param gsonConverterFactory
     * @return
     */
    @Singleton
    @Provides
    @ReqresServer
    fun provideReqresServerInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
//            .baseUrl(BuildConfig.HOSTNAME)
            .baseUrl("https://github.com/")
            .client(okHttpClient)
            .client(provideHttpClient())
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    /**
     * Reqres서버 ApiInterface 의존성 주입
     * @param retrofit
     * @return
     */
    @Provides
    @Singleton
    @ReqresServer
    fun provideReqresServerApiService(@ReqresServer retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    /**
     * API서버 Retrofit 의존성 주입
     * @param okHttpClient
     * @param gsonConverterFactory
     * @return
     */
    @Singleton
    @Provides
    @GitServer
    fun provideServerInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(jellypins.org.data.BuildConfig.HOSTNAME)
            .client(okHttpClient)
            .client(provideHttpClient())
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    /**
     * API서버 ApiInterface 의존성 주입
     * @param retrofit
     * @return
     */
    @Provides
    @Singleton
    @GitServer
    fun provideServerApiService(@GitServer retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
}