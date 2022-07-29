package com.example.dogbreed2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dog2.ApiData

class MainRepository {
    private val apiServices:ApiServices
    companion object{
        const val TAG="MainRep"
    }
    init {
        apiServices=Common.getApiService
    }
    var getDogBreedLiveData= MutableLiveData<MutableList<ApiData>>()
    var newLiveData=getDogBreedLiveData as LiveData<List<ApiData>>
    suspend fun getDogBreedList():List<ApiData>? {
        try {
            val result = apiServices.getApiServices(0, 15)

            return result.body()
        } catch (e: Exception) {
            Log.e("Exception Tag", e.localizedMessage ?: "")
        }
            return  null
    }
}