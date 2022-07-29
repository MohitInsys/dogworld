package com.example.dogbreed2

import retrofit2.Retrofit
import retrofit2.create

object Common {
   private const val baseurl="https://api.thedogapi.com/"
    val getApiService:ApiServices
    get() = RetroInstance.getRetroInstance(baseurl).create(ApiServices::class.java)
}