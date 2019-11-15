package com.google.devfest.mvvmcoroutine.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadDepsModule()
        onViewReady(savedInstanceState)
    }

    abstract fun loadDepsModule()

    abstract fun onViewReady(savedInstanceState: Bundle?)

}