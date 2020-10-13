package com.techdoctorbd.retrofitwithdiffrentnetworklayer.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.techdoctorbd.retrofitwithdiffrentnetworklayer.R
import com.techdoctorbd.retrofitwithdiffrentnetworklayer.models.User
import com.techdoctorbd.retrofitwithdiffrentnetworklayer.networks.MyApiService
import com.techdoctorbd.retrofitwithdiffrentnetworklayer.networks.NetworkCall
import com.techdoctorbd.retrofitwithdiffrentnetworklayer.networks.ResponseCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            val user = User(ed_user_id.text.toString(), ed_password.text.toString())
            checkUserValidity(user)
        }

        btn_get_jokes.setOnClickListener {
            getJokeFromServer(user_id_jokes.text.toString())
        }

    }

    private fun getJokeFromServer(userId: String) {
        val myApiService: MyApiService = NetworkCall()

        myApiService.getJokeFromServer(userId,object : ResponseCallback<String?>{
            override fun onSuccess(data: String?) {
                tv_jokes.text = data
            }

            override fun onError(throwable: Throwable) {
                Toast.makeText(this@MainActivity,"${throwable.message}",Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun checkUserValidity(user: User) {
        val myApiService: MyApiService = NetworkCall()

        myApiService.userValidityCheck(user,object : ResponseCallback<String?>{
            override fun onSuccess(data: String?) {
                Toast.makeText(this@MainActivity,"$data",Toast.LENGTH_SHORT).show()
            }

            override fun onError(throwable: Throwable) {
                Toast.makeText(this@MainActivity,"${throwable.message}",Toast.LENGTH_SHORT).show()
            }

        })
    }
}