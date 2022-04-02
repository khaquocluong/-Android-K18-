package com.example.android2022_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android2022_1.databinding.ActivityRecycleViewBinding

class GidLayoutShow : AppCompatActivity() {
    private lateinit var binding: ActivityRecycleViewBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter : RestaurantAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycle_view)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setGidLayout()
        registerData()
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadData()
    }
    private fun registerData(){
        viewModel.listOfData.observe(this){ listOfRestaurant->
            adapter.submitList(listOfRestaurant)
        }
    }
    private fun setGidLayout(){
        adapter = RestaurantAdapter()
        val gridLayout = GridLayoutManager(this, 3)
        binding.rvRestaurant.layoutManager = gridLayout
        binding.rvRestaurant.adapter = adapter
    }
}