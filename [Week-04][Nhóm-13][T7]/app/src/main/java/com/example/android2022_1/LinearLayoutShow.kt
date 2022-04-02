package com.example.android2022_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android2022_1.databinding.ActivityRecycleViewBinding

class LinearLayoutShow : AppCompatActivity() {
    private lateinit var binding: ActivityRecycleViewBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter : RestaurantAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycle_view)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setUpLinearLayout()
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
    private fun setUpLinearLayout(){
        adapter = RestaurantAdapter()
        val lynearLayout = LinearLayoutManager(this)
        binding.rvRestaurant.layoutManager = lynearLayout
        binding.rvRestaurant.adapter = adapter
    }
}