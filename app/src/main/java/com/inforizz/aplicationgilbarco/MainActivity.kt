package com.inforizz.aplicationgilbarco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO CREATE SPLASHSCREEN

        val intent = Intent(this, LoginScreen::class.java)
        startActivity(intent)
    }
}