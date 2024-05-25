package com.example.bookstoreapp.methods

import com.example.bookstoreapp.api.ApiClient
import com.example.bookstoreapp.model.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun addBook(book: Book, callback: (Boolean) -> Unit) {
    var rs: Boolean
    val call = ApiClient.apiService.addBook(book)

    call.enqueue(object : Callback<Book> {
        override fun onResponse(call: Call<Book>, response: Response<Book>) {
            rs = response.isSuccessful
            callback.invoke(rs)
        }

        override fun onFailure(call: Call<Book>, t: Throwable) {
            callback.invoke(false)
        }
    })
}