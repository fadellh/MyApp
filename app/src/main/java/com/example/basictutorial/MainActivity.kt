package com.example.basictutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnApply = findViewById<Button>(R.id.btnApply)
        val spinner: Spinner = findViewById(R.id.spnRole)
        val dropDownList = listOf<String>("Dokter", "Agen", "Bidan")
        val adapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,dropDownList);
        spinner.adapter = adapter
        var role: String = "";

        spinner.onItemSelectedListener = object  : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
                // An item was selected. You can retrieve the selected item using
                // parent.getItemAtPosition(pos)
                 role = parent.getItemAtPosition(pos).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }

        btnApply.setOnClickListener {
            val firstName = findViewById<EditText>(R.id.etFirtsName).text.toString()
            val lastName = findViewById<EditText>(R.id.etLastName).text.toString()
            val birthDate = findViewById<EditText>(R.id.etBirthDate).text.toString()
            val country = findViewById<EditText>(R.id.etCountry).text.toString()
            val roleInput = role;

                if(firstName != "" && country != "" && roleInput != ""){
                Log.i("coba","ga null $firstName")
                Intent(this,SecondAct::class.java).also {
                    val person = Person(firstName,lastName,birthDate,country, role)
                    it.putExtra("EXTRA_PERSON",person)
                    startActivity(it)
                }
            } else{
                Log.i("coba","null")
                Toast.makeText(this, "Please Fill your First Name and Country", Toast.LENGTH_SHORT).show()
            }
        }


    }
}