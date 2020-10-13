package com.techdoctorbd.retrofitwithdiffrentnetworklayer.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("password")
    val password: String
)