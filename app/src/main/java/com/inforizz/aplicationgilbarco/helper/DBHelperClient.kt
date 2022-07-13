package com.inforizz.aplicationgilbarco.helper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelperClient(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME_CLIENT, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                NAME_COl + " TEXT," +
                CNPJ_COL + " TEXT," +
                CORPORATE_COL + " TEXT," +
                COUNTRY_COL + " TEXT," + ")")

        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addClient(name: String, cnpj: String, corporate: String, country: String) {

        val values = ContentValues()

        values.put(NAME_COl, name)
        values.put(CNPJ_COL, cnpj)
        values.put(CORPORATE_COL, corporate)
        values.put(COUNTRY_COL, country)

        val db = this.writableDatabase

        // all values are inserted into database
        db.insert(TABLE_NAME, null, values)

        // at last we are
        // closing our database
        db.close()
    }

    // below method is to get
    // all data from our database
    fun getName(): Cursor? {

        val db = this.readableDatabase

        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)

    }

    companion object {
        // here we have defined variables for our database

        // below is variable for database name
        private val DATABASE_NAME_CLIENT = "DATABASE_NAME_CLIENT"

        // below is the variable for database version
        private val DATABASE_VERSION = 1

        // below is the variable for table name
        val TABLE_NAME = "table_client"
        val ID_COL = "id_client"
        val NAME_COl = "name_client"
        val CNPJ_COL = "cnpj_client"
        val CORPORATE_COL = "corporate_client"
        val COUNTRY_COL = "country_client"
    }
}
