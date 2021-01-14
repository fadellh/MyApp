package com.example.basictutorial

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.basictutorial.databinding.FragmentProfileBinding

class ProfileFragment : Fragment (R.layout.fragment_profile){
    private lateinit var binding: FragmentProfileBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
      //  val context = (context as HomeAct)
        binding.btnProfile.setOnClickListener {
            Intent(context,MainActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}