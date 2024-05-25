package com.example.bookstoreapp.api

import com.example.bookstoreapp.model.Book
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @Headers("Accept: application/json")
    @GET("books")
    fun getAllBooks(): Call<List<Book>>

    @GET("books/{id}")
    fun getByID(@Path("id") id: Int) : Call<List<Book>>

    @POST("books")
    fun addBook(@Body book:Book) : Call<Book>
}