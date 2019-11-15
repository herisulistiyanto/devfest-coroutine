package com.google.devfest.mvvmcoroutine.ui.dashboard

import com.google.devfest.mvvmcoroutine.common.DiffCallback
import com.google.devfest.mvvmcoroutine.di.BaseViewModelProvider
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */

object DashboardModule: BaseViewModelProvider {

    override fun loadModules() = lazyLoadModule

    private val lazyLoadModule by lazy { loadKoinModules(viewModelModule) }

    private val viewModelModule = module {
        viewModel { DashboardViewModel(get()) }
        factory { DiffCallback() }
    }
}