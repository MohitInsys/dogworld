package com.example.dogbreed2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dog2.ApiData
import kotlinx.coroutines.launch




 class HomeFragmentViewModel:ViewModel() {

        val mainrep by lazy{
                MainRepository()
        }
        val getDogList by lazy {
                MutableLiveData<List<ApiData>>()
        }
        var dogListview=mutableListOf<ApiData>()



         val dogLiveData=getDogList as LiveData<List<ApiData>>
        init {
            viewModelScope.launch {
                    val dogBreedList=mainrep.getDogBreedList()
                    getDogList.value=dogBreedList
            }

        }



}

