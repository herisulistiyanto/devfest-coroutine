package com.google.devfest.mvvmcoroutine.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.devfest.mvvmcoroutine.model.response.Data
import com.google.devfest.mvvmcoroutine.repository.UserRepository

/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */

class DashboardViewModel(private val userRepository: UserRepository): ViewModel() {

    private val _users = MutableLiveData<List<Data>>()
    val users: LiveData<List<Data>> get() = _users

    fun fetchUsers() {
        TODO()
    }

}