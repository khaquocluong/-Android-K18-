package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentHomeScreenBinding
import androidx.recyclerview.widget.LinearLayoutManager as LinearLayoutManager


class HomeScreenFragment : Fragment() {

    lateinit var binding: FragmentHomeScreenBinding
    lateinit var viewModel: HomeScreenViewModel
    lateinit var adapter: RestaurantAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeScreenBinding.inflate(inflater,container, false)
        val listRestaurant = binding.rvRestaurant
        viewModel = ViewModelProvider(this).get(HomeScreenViewModel::class.java)
        setUpLinearLayout()
        registerData()

        return binding.root
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


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
        val lynearLayout = LinearLayoutManager(context)
        binding.rvRestaurant.layoutManager = lynearLayout
        binding.rvRestaurant.adapter = adapter
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnOpenProfile.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_homeScreenFragment_to_profileFragment)
        }
    }
}