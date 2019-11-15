package com.google.devfest.mvvmcoroutine.model.response
import com.google.gson.annotations.SerializedName


/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */

data class UserDetailResponse(
    @SerializedName("data")
    val data: Data? = null,
    @SerializedName("error")
    val error: Error? = null,
    @SerializedName("status")
    val status: String? = ""
)
