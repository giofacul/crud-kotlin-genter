package com.inforizz.aplicationgilbarco.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inforizz.aplicationgilbarco.R
import com.inforizz.aplicationgilbarco.helper.DBHelperClient


class SearchClient : AppCompatActivity() {

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_client)

        var adapter: MyRecyclerViewAdapter

        val animalNames: ArrayList<String> = ArrayList()
        animalNames.add("Horse")
        animalNames.add("Cow")
        animalNames.add("Camel")
        animalNames.add("Sheep")
        animalNames.add("Goat")

        // set up the RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.rvAnimals)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerViewAdapter(this, animalNames)
        adapter.setClickListener(this)
        recyclerView.adapter = adapter

        val printData = findViewById<ImageButton>(R.id.printSearchDatas)

        // below code is to add on  click
        // listener to our print name button
        printData.setOnClickListener {

            // creating a DBHelper class
            // and passing context to it
            val db = DBHelperClient(this, null)

            // below is the variable for cursor
            // we have called method to get
            // all names from our database
            // and add to name text view
            val cursor = db.getName()

            // moving the cursor to first position and
            // appending value in the text view
            cursor!!.moveToFirst()

            val name = findViewById<EditText>(R.id.rvAnimals)

            name.append(cursor.getString(cursor.getColumnIndex(DBHelperClient.NAME_COl)) + "\n")
//            age.append(cursor.getString(cursor.getColumnIndex(DBHelperClient.CNPJ_COL)) + "\n")

            // moving our cursor to next
            // position and appending values
            while (cursor.moveToNext()) {
                name.append(cursor.getString(cursor.getColumnIndex(DBHelperClient.NAME_COl)) + "\n")
//                age.append(cursor.getString(cursor.getColumnIndex(DBHelperClient.CNPJ_COL)) + "\n")
            }

            // at last we close our cursor
            cursor.close()
        }
    }
}
