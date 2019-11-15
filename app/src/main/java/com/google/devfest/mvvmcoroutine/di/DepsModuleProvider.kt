package com.google.devfest.mvvmcoroutine.di

import org.koin.core.module.Module

/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */

object DepsModuleProvider {

    val modules: List<Module>
        get() {
            return ArrayList<Module>().apply {
                addAll(NetworkModules.modules)
                addAll(RepositoryModules.modules)
            }
        }

}