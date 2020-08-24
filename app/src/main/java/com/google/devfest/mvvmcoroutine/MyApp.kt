package com.google.devfest.mvvmcoroutine

import android.app.Application
import com.google.devfest.mvvmcoroutine.di.DepsModuleProvider
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

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
//            modules(DepsModuleProvider.modules)

            // TODO: Await fix for Koin and replace the explicit invocations
            //  of loadModules() and createRootScope() with a single call to modules()
            //  (https://github.com/InsertKoinIO/koin/issues/847)
            koin.loadModules(DepsModuleProvider.modules)
            koin.createRootScope()
        }
    }

}