package com.google.devfest.mvvmcoroutine.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.devfest.mvvmcoroutine.model.response.Data
import com.google.devfest.mvvmcoroutine.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */

class DashboardViewModel(private val userRepository: UserRepository): ViewModel() {

    private val _users = MutableLiveData<List<Data>>()
    val users: LiveData<List<Data>> get() = _users

    fun fetchUsers() {
        viewModelScope.launch(Dispatchers.Main) {
            userRepository.getAllUsers {
                _users.postValue(it)
            }
        }
    }

}