package com.techdoctorbd.retrofitwithdiffrentnetworklayer.networks

import com.techdoctorbd.retrofitwithdiffrentnetworklayer.models.ServerResponse
import com.techdoctorbd.retrofitwithdiffrentnetworklayer.models.User
import com.techdoctorbd.retrofitwithdiffrentnetworklayer.retrofit.RetrofitApiClient
import com.techdoctorbd.retrofitwithdiffrentnetworklayer.retrofit.RetrofitApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkCall : MyApiService {
    override fun userValidityCheck(
        userLoginCredential: User?,
        callback: ResponseCallback<String?>?
    ) {
        val retrofitApiInterface: RetrofitApiInterface =
            RetrofitApiClient.getClient()!!.create(RetrofitApiInterface::class.java)
        val call = retrofitApiInterface.getUserValidity(userLoginCredential)
        call!!.enqueue(object : Callback<ServerResponse?> {
            override fun onResponse(
                call: Call<ServerResponse?>,
                response: Response<ServerResponse?>
            ) {
                val validity: ServerResponse? = response.body()
                callback!!.onSuccess(validity!!.messageString)
            }

            override fun onFailure(call: Call<ServerResponse?>, t: Throwable) {
                callback!!.onError(t)
            }

        })

    }

    override fun getJokeFromServer(userId: String?, callback: ResponseCallback<String?>?) {
        val retrofitApiInterface: RetrofitApiInterface =
            RetrofitApiClient.getClient()!!.create(RetrofitApiInterface::class.java)
        val call = retrofitApiInterface.getJoke(userId)
        call!!.enqueue(object : Callback<ServerResponse?> {
            override fun onResponse(
                call: Call<ServerResponse?>,
                response: Response<ServerResponse?>
            ) {
                val validity: ServerResponse? = response.body()
                callback!!.onSuccess(validity!!.messageString)
            }

            override fun onFailure(call: Call<ServerResponse?>, t: Throwable) {
                callback!!.onError(t)
            }

        })
    }


}