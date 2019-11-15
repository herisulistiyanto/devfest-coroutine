package com.google.devfest.mvvmcoroutine

import android.app.Application
import com.google.devfest.mvvmcoroutine.di.DepsModuleProvider
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(DepsModuleProvider.modules)
        }
    }

}