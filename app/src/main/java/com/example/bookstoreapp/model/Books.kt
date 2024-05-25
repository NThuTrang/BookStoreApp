package com.example.bookstoreapp.model

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("author") var author: String? = null,
    @SerializedName("imagefile") var imagefile: String? = null
)