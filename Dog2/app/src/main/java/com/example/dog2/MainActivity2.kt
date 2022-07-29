package com.example.dog2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.dog2.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
   lateinit var  binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this@MainActivity2,R.layout.activity_main2)
      //  var animation= AnimationUtils.loadAnimation(this,R.anim.fade_in)
        var i=intent.getSerializableExtra("model") as ApiData
    //    MainActivity2.setAnimation(animation)
        (this).overridePendingTransition(R.anim.fade_in,R.anim.fade_in)
       Glide.with(this@MainActivity2).load(i.image.url).into(binding.imageofsecAct)
       binding.setVariable(BR.dogData2,i)

    }



}