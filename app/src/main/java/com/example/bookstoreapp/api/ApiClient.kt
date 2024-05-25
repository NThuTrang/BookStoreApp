package com.example.bookstoreapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val URL = "http://192.168.10.20:3000"

    // biến kết nối đến API thông qua IP Address
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // biến cung cấp lời gọi đến các interface function
    val apiService: ApiService = retrofit.create(ApiService::class.java)

}