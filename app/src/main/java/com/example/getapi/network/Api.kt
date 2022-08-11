package com.example.getapi.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api{
    var RetrofitService: Jsoninfo?=null
    fun getInstance(): Jsoninfo {
        if (RetrofitService==null){
            val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build()
            RetrofitService=retrofit.create(Jsoninfo::class.java)
        }
        return RetrofitService!!
    }
}
