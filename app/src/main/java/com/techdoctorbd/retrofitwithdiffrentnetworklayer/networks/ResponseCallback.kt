package com.techdoctorbd.retrofitwithdiffrentnetworklayer.networks

interface ResponseCallback<T> {
    fun onSuccess(data: T)
    fun onError(throwable: Throwable)
}