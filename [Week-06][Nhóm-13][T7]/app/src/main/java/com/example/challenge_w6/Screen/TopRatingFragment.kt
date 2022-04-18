package com.example.challenge_w6.Screen

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge_w6.MovieAdapter
import com.example.challenge_w6.model.HomeVM
import com.example.challenge_w6.R
import com.example.challenge_w6.databinding.FragmentTopRatingBinding

class TopRatingFragment:Fragment() {
    private lateinit var binding : FragmentTopRatingBinding
    private lateinit var model : HomeVM
    private lateinit var adapter : MovieAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTopRatingBinding.inflate(inflater,container,false)
        model = ViewModelProvider(this)[HomeVM::class.java]
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpMovieList()
        registerMovieList()
        registerErrorList()
    }

    override fun onStart() {
        super.onStart()
        model.getRatedMovie()
    }

    private fun setUpMovieList() {
        adapter = MovieAdapter()
        val lm = LinearLayoutManager(context)
        binding.listRate.layoutManager = lm
        binding.listRate.adapter = adapter
    }

    private fun registerMovieList() {
        model.movieData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun registerErrorList() {
        model.errEvent.observe(viewLifecycleOwner){
            //show dialog
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_option,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val lm = LinearLayoutManager(context)
        val grid = GridLayoutManager(context,2)
        when(item.itemId) {
            R.id.list ->{
                binding.listRate.layoutManager = lm
            }
            R.id.grid -> {
                binding.listRate.layoutManager = grid
            }
        }
        return super.onOptionsItemSelected(item)
    }
}