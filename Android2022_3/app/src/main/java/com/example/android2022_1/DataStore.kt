package com.example.android2022_1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class DataStore(context : Context?) : SQLiteOpenHelper(context, "course.db", null, 1){
    override fun onCreate(p0: SQLiteDatabase?) {
        var sql = "Create table users (email text primary key, password text)"
        p0?.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
    //add User
    fun addUser(email: String, password: String){
        var db = this.writableDatabase
        var values = contentValuesOf()
        values.put("email", email)
        values.put("password", password)
        db.insert("users", null, values)
    }
    //get user
    fun getUser(email: String, password: String):Boolean{
        var db = this.readableDatabase
        var cursor = db.rawQuery("select * from users where email = ? and password = ?", arrayOf(email, password))
        var ret = false
        if( cursor.count > 0){
            ret =  true
        }
        return ret
    }


}