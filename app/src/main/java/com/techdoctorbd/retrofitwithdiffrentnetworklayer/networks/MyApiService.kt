package com.techdoctorbd.retrofitwithdiffrentnetworklayer.networks

import com.techdoctorbd.retrofitwithdiffrentnetworklayer.models.User

interface MyApiService {
    fun userValidityCheck(userLoginCredential: User?, callback: ResponseCallback<String?>?)
    fun getJokeFromServer(userId: String?, callback: ResponseCallback<String?>?)
}