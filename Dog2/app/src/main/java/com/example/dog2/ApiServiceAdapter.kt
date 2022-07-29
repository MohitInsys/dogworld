package com.example.dogbreed2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dog2.ApiData
import com.example.dog2.BR

import com.example.dog2.HomeFragment
import com.example.dog2.R
import com.example.dog2.databinding.ItemofupperrecyclerviewhorizontalBinding
import com.example.dog2.databinding.ItemofverticalrecyclerviewBinding


class ApiServiceAdapter(val context: HomeFragment, var dog_mutable_list:List<ApiData>)
    :RecyclerView.Adapter<ApiServiceAdapter.MyViewHolder>() {

    private var dog_list: List<ApiData>? = null
    fun setDogList(dog_list: List<ApiData>?) {
        this.dog_list = dog_list

    }

    override fun getItemCount(): Int {
        return dog_mutable_list.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding = DataBindingUtil.inflate<ItemofverticalrecyclerviewBinding>(
            LayoutInflater.from(parent.getContext()), R.layout.itemofverticalrecyclerview, parent, false)

        return MyViewHolder(binding, minter)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.setVariable(BR.dogdata, dog_mutable_list[position])
        Glide.with(context).load(dog_mutable_list[position].image.url).into(holder.binding.imageofverticalRV)


    }


    class MyViewHolder(var binding: ItemofverticalrecyclerviewBinding, l: Onclickinter) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                l.onClick(adapterPosition)
            }
        }
    }

    interface Onclickinter {

        fun onClick(position: Int)
        fun onLongclick(position: Int)
    }


    lateinit var minter: Onclickinter
    fun setOnItemClickListener(listen: Onclickinter) {
        minter = listen
    }

}






