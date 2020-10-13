package com.techdoctorbd.retrofitwithdiffrentnetworklayer.models

import com.google.gson.annotations.SerializedName

data class ServerResponse(
    @SerializedName("status")
    val statusString: String,
    @SerializedName("message")
    val messageString: String
)