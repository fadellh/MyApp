package com.example.basictutorial

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basictutorial.ViewModel.MainViewModel
import com.example.basictutorial.ViewModel.MainViewModelFactory
import com.example.basictutorial.adapter.HomeImageAdapter
import com.example.basictutorial.databinding.FragmentHomeBinding
import com.example.basictutorial.databinding.FragmentProfileBinding
import com.example.basictutorial.model.Cat
import com.example.basictutorial.model.Image
import com.example.basictutorial.repository.Repository

class HomeFragment : Fragment (R.layout.fragment_home){
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        val myImage = "https://images.theconversation.com/files/350865/original/file-20200803-24-50u91u.jpg?ixlib=rb-1.1.0&rect=37%2C29%2C4955%2C3293&q=45&auto=format&w=926&fit=clip"
        var imgList = mutableListOf<Image>(
                Image("Bengal",myImage),
                Image("Macan",myImage),
                Image("Macan",myImage),
                Image("Has",myImage),
                Image("sa",myImage),
                Image("Macdsan",myImage),
                Image("Macaffan",myImage),
                Image("wwew",myImage),
                Image("Singan",myImage)
        )


        //  val context = (context as HomeAct)
        //Call Api
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Home", response.body()?.userId.toString())
                Log.d("Home", response.body()?.title!!)
                Log.d("Home", response.body()?.body!!)
            } else {
                Log.d("Home", response.errorBody().toString())
            }
        })

        //Call Cat API
        viewModel.getCat()
        viewModel.catResponse.observe(viewLifecycleOwner, Observer { response ->
            if(response.isSuccessful){
                val result = response.body()!!
                val adapter = HomeImageAdapter(result)
                binding.rvHome.adapter = adapter
                binding.rvHome.layoutManager = LinearLayoutManager(context)
            }else{
                Log.e("hohoho", response.errorBody().toString())
            }
        })


    }

}