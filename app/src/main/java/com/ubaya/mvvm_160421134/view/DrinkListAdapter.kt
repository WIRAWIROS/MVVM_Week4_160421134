package com.ubaya.mvvm_160421134.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.mvvm_160421134.databinding.DrinkListItemBinding
import com.ubaya.mvvm_160421134.model.Drinks

class DrinkListAdapter(val drinkList:ArrayList<Drinks>)
    : RecyclerView.Adapter<DrinkListAdapter.DrinkViewHolder>()
{
    class DrinkViewHolder(var binding: DrinkListItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val binding = DrinkListItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return DrinkViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return drinkList.size
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.binding.txtID.text = drinkList[position].id
        holder.binding.txtName.text = drinkList[position].name
        holder.binding.txtCategory.text = drinkList[position].category
        holder.binding.txtIngredients.text = drinkList[position].ingredients.toString()
        holder.binding.txtExtras.text = drinkList[position].extras.toString()
    }
    fun updateDrinkList(newDrinkList: ArrayList<Drinks>) {
        drinkList.clear()
        drinkList.addAll(newDrinkList)
        notifyDataSetChanged()
    }


}