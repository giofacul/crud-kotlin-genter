package com.inforizz.aplicationgilbarco.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.inforizz.aplicationgilbarco.R

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val addCoutrys = findViewById<Button>(R.id.addCountrys)
        val addClients = findViewById<Button>(R.id.addClients)
        val searchClients = findViewById<Button>(R.id.searchClients)

        addCoutrys.setOnClickListener {
            val intent = Intent(this, InsertCountrys::class.java)
            startActivity(intent)
        }


        addClients.setOnClickListener {
            val intent = Intent(this, InsertClients::class.java)
            startActivity(intent)
        }

        searchClients.setOnClickListener {
            val intent = Intent(this, SearchClient::class.java)
            startActivity(intent)
        }


    }
}