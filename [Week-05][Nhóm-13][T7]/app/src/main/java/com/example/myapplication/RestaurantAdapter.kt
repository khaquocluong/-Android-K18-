package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.example.myapplication.Model.Restaurant

class RestaurantAdapter : ListAdapter<Restaurant, RestaurantAdapter.RestaurantViewHolder>(RestaurantDiffUtil()) {

    class RestaurantDiffUtil : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = getItem(position)
        holder.bindData(restaurant)
    }

    class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        companion object {
            fun from(parent: ViewGroup): RestaurantViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_view_restaurant, parent, false)
                return RestaurantViewHolder(view)
            }
        }
        fun bindData(res : Restaurant){
            val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
            val tvDescription = itemView.findViewById<TextView>(R.id.tv_description)
            val ivAvatar = itemView.findViewById<ImageView>(R.id.img_avt)

            tvTitle.text = res.name
            tvDescription.text = res.addressRestaurant
            ivAvatar.setImageResource(res.avatar)
        }
    }
}