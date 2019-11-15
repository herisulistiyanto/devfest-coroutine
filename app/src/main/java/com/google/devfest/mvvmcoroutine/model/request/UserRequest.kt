package com.google.devfest.mvvmcoroutine.model.request
import com.google.gson.annotations.SerializedName


/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */

data class UserRequest(
    @SerializedName("email")
    val email: String = "",
    @SerializedName("name")
    val name: String = ""
)