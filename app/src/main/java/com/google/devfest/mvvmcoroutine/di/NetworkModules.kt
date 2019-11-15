package com.google.devfest.mvvmcoroutine.di

import com.google.devfest.mvvmcoroutine.api.UserServices
import com.google.mvvmcoroutine.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */
 
object NetworkModules: BaseModule {

    override val modules: List<Module>
        get() = listOf(
                retrofitModule,
                webServiceModule
        )

    private val webServiceModule = module {
        single { get<Retrofit>().create(UserServices::class.java) }
    }

    private val retrofitModule = module {
        single { provideOkHttpClient() }
        single { provideRetrofit(get()) }
    }

    private fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else
                HttpLoggingInterceptor.Level.NONE
        }

        return OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(30L, TimeUnit.SECONDS)
                .writeTimeout(30L, TimeUnit.SECONDS)
                .readTimeout(30L, TimeUnit.SECONDS)
                .build()
    }

    private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }
}