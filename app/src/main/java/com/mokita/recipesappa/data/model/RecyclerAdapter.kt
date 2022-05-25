package com.mokita.recipesappa.data.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mokita.recipesappa.databinding.ItemRecipeBinding

class RecyclerAdapter(private val recipesList: List<Recipe>): RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(binding: ItemRecipeBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Recipe){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(recipesList[position])
    }

    override fun getItemCount() = recipesList.size

}