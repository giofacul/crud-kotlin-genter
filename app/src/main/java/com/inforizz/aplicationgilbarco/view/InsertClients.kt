package com.inforizz.aplicationgilbarco.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.inforizz.aplicationgilbarco.R
import com.inforizz.aplicationgilbarco.helper.DBHelperClient

class InsertClients : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_clients)

        val addName = findViewById<Button>(R.id.buttonRegisterClient)
        val enterName = findViewById<EditText>(R.id.editTextNameClient)
        val enterCNPJ = findViewById<EditText>(R.id.editTextCNPJ)
        val enterCorporate = findViewById<EditText>(R.id.editTextCorporateName)
        val enterSpinner = findViewById<Spinner>(R.id.spinnerSelectedCountry)

        addName.setOnClickListener{

            // below we have created
            // a new DBHelper class,
            // and passed context to it
            val db = DBHelperClient(this, null)

            // creating variables for values
            // in name and age edit texts
            val name = enterName.text.toString()
            val cnpj = enterCNPJ.text.toString()
            val corporate = enterCorporate.text.toString()
            val spinner = enterSpinner.id.toString()

            // calling method to add
            // name to our database
            db.addClient(name, cnpj, corporate, spinner)

            // Toast to message on the screen
            Toast.makeText(this, name + " added to database", Toast.LENGTH_LONG).show()

            // at last, clearing edit texts
            enterName.text.clear()
            enterCNPJ.text.clear()
            enterCorporate.text.clear()
//            spinner.toString()
        }


    }
}