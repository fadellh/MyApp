package com.example.basictutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.basictutorial.ViewModel.MainViewModel
import com.example.basictutorial.ViewModel.MainViewModelFactory
import com.example.basictutorial.databinding.ActivityHomeBinding
import com.example.basictutorial.repository.Repository
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.internal.NavigationMenuItemView

class HomeAct : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val referralFragment = AddFragment()
        var searchFragment = SearchFragment()
        val billFragment = BillFragment()
        val profileFragment = ProfileFragment()
        //val btnNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        setCurrentFragment(homeFragment)

        binding.bottomNavigationView.background = null

        binding.fabRefferal.setOnClickListener {
            setCurrentFragment(referralFragment)
        }

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miHome -> setCurrentFragment(homeFragment)
                R.id.miSearch -> setCurrentFragment(searchFragment)
                R.id.miBill -> setCurrentFragment(billFragment)
                R.id.miProfile -> setCurrentFragment(profileFragment)
            }

            true
        }

        binding.bottomNavigationView.getOrCreateBadge(R.id.miBill).apply {
            number= 5
            isVisible= true
        }
        //delegate.findViewById<>(R.id.bottomNavigationView).set
    }
    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frfirst,fragment)
            commit()
        }
    }

    private fun setAddFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frfirst,fragment)
            addToBackStack(null)
            commit()
        }
    }

}