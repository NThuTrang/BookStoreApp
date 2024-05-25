package com.example.bookstoreapp.methods

import com.example.bookstoreapp.api.ApiClient
import com.example.bookstoreapp.model.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// hàm xử lý và trả kết quả bằng kỹ thuật callback
fun getBooks(callback: (MutableList<Book>) -> Unit) {
    var list = mutableListOf<Book>()
    val call = ApiClient.apiService.getAllBooks()

    // xử lý gọi bất đồng bộ
    call.enqueue(object : Callback<List<Book>> {
        override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
            if (response.isSuccessful) {
                response.body()?.let {
                    list = it as MutableList<Book>
                }
                callback.invoke(list)
            }
        }

        override fun onFailure(call: Call<List<Book>>, t: Throwable) {

        }

    })
}