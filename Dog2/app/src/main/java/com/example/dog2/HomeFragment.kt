package com.example.dog2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Scene
import androidx.transition.Transition

import com.example.dog2.databinding.FragmentHomeBinding
import com.example.dogbreed2.ApiServiceAdapter
import com.example.dogbreed2.HomeFragmentViewModel
class HomeFragment : Fragment() {

    private val dogcategory = mutableListOf<String>()
    var homeFragmentViewModel: HomeFragmentViewModel? = null
    lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: ApiServiceAdapter
    private var adapt:AdapterForHorizonatalRV?=null
    var lastItemClickedPosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentHomeBinding.inflate(layoutInflater)
        preparedogsclass()
        adapt= AdapterForHorizonatalRV(dogcategory)

        binding.horizRV.layoutManager = LinearLayoutManager(binding.horizRV.context,LinearLayoutManager.HORIZONTAL,false)


        binding.horizRV.adapter=adapt


    homeFragmentViewModel= ViewModelProvider(this)[HomeFragmentViewModel::
    class.java]

    homeFragmentViewModel!!.dogLiveData.observe(this)
    {
        Log.e("MainActivity", "DogList" + it.get(0).name)
        if (it != null) {
            homeFragmentViewModel!!.dogListview?.addAll(it)
            adapter = ApiServiceAdapter(this@HomeFragment, it)
            adapter.notifyDataSetChanged()
            binding.vertRV.adapter = adapter
        }
        adapter.setOnItemClickListener(object : ApiServiceAdapter.Onclickinter {
            override fun onClick(position: Int) {
                var animation=AnimationUtils.loadAnimation(context,R.anim.fade_in)
                lastItemClickedPosition = position
                var intent = Intent(context, MainActivity2::class.java)
                var dog = homeFragmentViewModel!!.dogListview[position]
                intent.putExtra("model", dog)
                //binding.vertRV.setAnimation(animation)
                startActivity(intent)

               //(context as Activity).overridePendingTransition(R.anim.from_left,R.anim.to_right)
             }


             override fun onLongclick(position: Int) {
                TODO("Not yet implemented")
            }

        })
    }}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
             return binding.root
    }
 private fun preparedogsclass() {
        dogcategory.add("All")
        dogcategory.add("New")
        dogcategory.add("Top")
        dogcategory.add("Black")
        dogcategory.add("Small")
        dogcategory.add("Puppy")
        dogcategory.add("White")
    }

}







