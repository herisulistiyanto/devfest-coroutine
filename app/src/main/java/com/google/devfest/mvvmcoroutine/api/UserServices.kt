package com.google.devfest.mvvmcoroutine.api

import com.google.devfest.mvvmcoroutine.model.request.UserRequest
import com.google.devfest.mvvmcoroutine.model.response.UserDetailResponse
import com.google.devfest.mvvmcoroutine.model.response.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */

interface UserServices {

    @GET("/api/v1/student/all")
    suspend fun getAllUsers(): Response<UserResponse>

    @GET("/api/v1/student/{id}")
    suspend fun getUser(@Path("id") id: Int): Response<UserDetailResponse>

    @PUT("/api/v1/student/{id}")
    suspend fun editUser(@Path("id") id: Int, @Body request: UserRequest): Response<UserDetailResponse>

}