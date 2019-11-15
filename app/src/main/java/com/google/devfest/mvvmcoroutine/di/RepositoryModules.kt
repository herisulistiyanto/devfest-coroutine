package com.google.devfest.mvvmcoroutine.di

import com.google.devfest.mvvmcoroutine.repository.UserRepository
import com.google.devfest.mvvmcoroutine.repository.remote.UserRemoteDataSource
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */

object RepositoryModules: BaseModule {

    override val modules: List<Module>
        get() = listOf(
                remoteDataSources,
                repoModules
        )

    private val repoModules = module {
        single { UserRepository(get()) }
    }

    private val remoteDataSources = module {
        single { UserRemoteDataSource(get()) }
    }
}