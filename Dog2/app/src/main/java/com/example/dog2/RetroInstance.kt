package com.example.dogbreed2

import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {
    private var retrofit:Retrofit?=null
    val base_url="https://api.thedogapi.com/"

    fun getRetroInstance(baseUrl :String):Retrofit{

        if(retrofit==null) {

        retrofit=Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!

    }
}