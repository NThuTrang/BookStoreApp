package com.example.bookstoreapp.methods

import com.example.bookstoreapp.api.ApiClient
import com.example.bookstoreapp.model.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// tìm kiếm theo id, trả về bằng Callback
fun findBook(id: Int, callback: (Book) -> Unit) {
    val b = Book(0, "Không tìm thấy", "Không tìm thấy", "Không tìm thấy", "Không tìm thấy")
    var rs: Book

    val call = ApiClient.apiService.getByID(id)
    call.enqueue(object : Callback<List<Book>> {
        override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
            if (response.isSuccessful) {
                val r = response.body()
                rs = if((r != null) && r.isNotEmpty()) r[0] else b
                callback.invoke(rs)
            } else {
                callback.invoke(b)
            }
        }

        override fun onFailure(call: Call<List<Book>>, t: Throwable) {

        }

    })
}