package com.google.devfest.mvvmcoroutine.model.response
import com.google.gson.annotations.SerializedName


/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */

data class UserResponse(
        @SerializedName("data")
    val _data: List<Data>? = listOf(),
        @SerializedName("error")
    val error: Error? = null,
        @SerializedName("status")
    val _status: String? = ""
) {
    val data: List<Data> get() = _data.orEmpty()
    val status: String get() = _status.orEmpty()
}

data class Data(
    @SerializedName("email")
    val _email: String? = "",
    @SerializedName("id")
    val _id: Int? = 0,
    @SerializedName("name")
    val _name: String? = ""
) {
    val email: String get() = _email.orEmpty()
    val id: Int get() = _id ?: 0
    val name: String get() = _name.orEmpty()
}

data class Error(
        @SerializedName("code")
        val code: Int? = 0,
        @SerializedName("message")
        val message: String? = ""
)