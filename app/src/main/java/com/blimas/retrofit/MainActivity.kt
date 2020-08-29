package com.blimas.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val createService = RetrofitClient.createService(PostService::class.java)
        val callService : Call<List<PostModel>> = createService.list()

        val response = callService.enqueue(object  : Callback<List<PostModel>>{
            override fun onFailure(call: Call<List<PostModel>>, throwable: Throwable) {
                val s= throwable.message
                Log.i("onFailure", "onFailure: " + s)
            }

            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
                val res = response.body()
                Log.i("onResponse", "onResponse: " + res)
            }

        })
    }
}