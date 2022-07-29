package com.example.dog2

import java.io.Serializable

data class Image(
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
):Serializable