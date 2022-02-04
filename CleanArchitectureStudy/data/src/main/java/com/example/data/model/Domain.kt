package com.example.data.model

import com.google.gson.annotations.SerializedName

class Domain<T>(
    @SerializedName("code")
    val code: Int,

    @SerializedName("msg")
    val message: String,

    @SerializedName("data")
    val data: T
)