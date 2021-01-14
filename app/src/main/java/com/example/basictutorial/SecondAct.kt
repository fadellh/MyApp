package com.example.basictutorial

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class SecondAct : AppCompatActivity(){
    private val storagePermission = { -> ActivityCompat.checkSelfPermission(this,android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnPhoto = findViewById<Button>(R.id.btnPhoto)
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)

        val person = intent.getSerializableExtra("EXTRA_PERSON") as Person
        val name = person.firstName
        val country = person.country
        tvWelcome.text = "Welcome $name from $country. You are ${person.role}"

        btnPhoto.setOnClickListener {
            requestPermission()
            if(storagePermission()){
                //Implicit Intent
                Intent(Intent.ACTION_GET_CONTENT).also {
                    it.type = "image/*"
                    startActivityForResult(it,0)
                }
            }
        }

        btnBack.setOnClickListener {
            finish()
        }

        btnNext.setOnClickListener {
            Intent(this,ThirdActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val avatarImage = findViewById<ImageView>(R.id.ivAva)
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == 0){
            val uri = data?.data
            avatarImage.setImageURI(uri)
        }
    }
        private fun requestPermission () {
            var permissionToRequest = mutableListOf<String>()
            if(!storagePermission()){
               permissionToRequest.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }

            if (permissionToRequest.isNotEmpty()){
                ActivityCompat.requestPermissions(this, permissionToRequest.toTypedArray(),0)
            }
        }

        override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
        ) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            if(requestCode == 0 && grantResults.isNotEmpty()){
                for (i in grantResults.indices){
                    if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                       Log.i("permission", "Permission ${permissions[i]} is granted")
                    }
                }
            }
        }

}