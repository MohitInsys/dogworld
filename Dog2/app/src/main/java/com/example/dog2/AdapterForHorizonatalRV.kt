package com.example.dog2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dog2.databinding.ItemofupperrecyclerviewhorizontalBinding
import com.example.dogbreed2.ApiServiceAdapter

class AdapterForHorizonatalRV(private var dogCategory: List<String> )
    :RecyclerView.Adapter<AdapterForHorizonatalRV.MyViewHolder>()
{

    class MyViewHolder(var binding:ItemofupperrecyclerviewhorizontalBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
             val binding = DataBindingUtil.inflate<ItemofupperrecyclerviewhorizontalBinding>(
            LayoutInflater.from(parent.getContext()),
            R.layout.itemofupperrecyclerviewhorizontal, parent, false)
            return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var item:String = dogCategory[position]
        holder.binding.setVariable(BR.category, item)
    }
    override fun getItemCount(): Int {
        return dogCategory.size
    }


}