package com.google.devfest.mvvmcoroutine.repository

import com.google.devfest.mvvmcoroutine.model.response.Data
import com.google.devfest.mvvmcoroutine.repository.remote.UserRemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */

class UserRepository(private val userRemoteDataSource: UserRemoteDataSource) {

    suspend fun getAllUsers(result: (List<Data>) -> Unit) = withContext(Dispatchers.IO) {
        val response = userRemoteDataSource.getAllUsers()
        result.invoke(response)
    }

}