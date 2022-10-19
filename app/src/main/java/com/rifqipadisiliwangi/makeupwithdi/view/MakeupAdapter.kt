package com.rifqipadisiliwangi.makeupwithdi.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rifqipadisiliwangi.makeupwithdi.databinding.ItemListBinding
import com.rifqipadisiliwangi.makeupwithdi.model.ResponDataMakeupItem

class MakeupAdapter (var listMakeup : List<ResponDataMakeupItem>): RecyclerView.Adapter<MakeupAdapter.ViewHolder>() {


    class ViewHolder (var binding : ItemListBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MakeupAdapter.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.binding.brand.text = listMakeup[position].brand
        holder.binding.name.text = listMakeup[position].name
        holder.binding.price.text = listMakeup[position].price
        Glide.with(holder.itemView.context).load(listMakeup[position].imageLink).into(holder.binding.imgMakeup)
    }

    override fun getItemCount(): Int {
        return listMakeup.size
    }
}