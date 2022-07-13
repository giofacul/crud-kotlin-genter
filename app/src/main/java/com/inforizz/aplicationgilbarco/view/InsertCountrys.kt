package com.inforizz.aplicationgilbarco.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.inforizz.aplicationgilbarco.R

class InsertCountrys : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_countrys)

        val btnAddCountry = findViewById<Button>(R.id.buttonAddCountry)
        val nameCountry = findViewById<EditText>(R.id.nameCountry)

        btnAddCountry.setOnClickListener {
            if (nameCountry != null) {
                Toast.makeText(this, "PAÍS SALVO $nameCountry", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Coloque o país", Toast.LENGTH_SHORT).show()
            }
        }

    }
}