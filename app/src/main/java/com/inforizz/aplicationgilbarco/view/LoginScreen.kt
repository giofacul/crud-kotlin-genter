package com.inforizz.aplicationgilbarco.view

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.inforizz.aplicationgilbarco.R

class LoginScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        val logintohome = findViewById<Button>(R.id.buttonLogin)
        val emaillogin = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val passlogin = findViewById<EditText>(R.id.editTextTextPassword)

        val emailStringLogin = getString(R.string.user_email_to_login)
        val passwordStringLogin = getString(R.string.user_password_to_login)

        val toastEmail = getString(R.string.toast_error_email)
        val toastPassword = getString(R.string.toast_error_password)

        logintohome.setOnClickListener {
            if (emaillogin.text.toString() == emailStringLogin
                && passlogin.text.toString() == passwordStringLogin
            ) {
                val intent = Intent(this, HomeScreen::class.java)
                startActivity(intent)
            } else if (emaillogin.text.isEmpty() || emaillogin.text == null) {
                Toast.makeText(this, toastEmail, Toast.LENGTH_SHORT).show()
            } else if (passlogin.text.isEmpty() || passlogin.text == null) {
                Toast.makeText(this, toastPassword, Toast.LENGTH_SHORT).show()
            } else {
//                Toast.makeText(this, "LOGIN INVÁLIDO", Toast.LENGTH_SHORT).show()
                Toast.makeText(
                    this,
                    "LOGIN ${emaillogin.text} SENHA ${passlogin.text}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}