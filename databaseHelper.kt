package com.yildizsoft.fatih.br

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,1) {

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME)
    }
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $TABLE_NAME (ID INTEGER PRIMARY KEY AUTOINCREMENT,image BLOG)")



    }
    fun insertData(image: ByteArray){
        val db=this.writableDatabase
        val contentValues= ContentValues()

        contentValues.put(COL_3,image)
        db.insert(TABLE_NAME,null,contentValues)
    }
    val allData: Cursor
        get(){
            val db=this.writableDatabase
            val res=db.rawQuery("select * from $TABLE_NAME",null)
            return res
        }
    fun updateData(id:String,name:String,image: ByteArray):Boolean{

        val db=this.writableDatabase
        val contentValues= ContentValues()
        contentValues.put(COL_1,id)

        contentValues.put(COL_3,image)
        db.update(TABLE_NAME,contentValues,"ID= ?", arrayOf(id))
        return true
    }
    fun getData(id:Int){
        val db=this.writableDatabase
        db?.execSQL("select ID,image from $TABLE_NAME where ID=$id ")


    }


    fun deleteData(id:String): Int {
        val db=this.writableDatabase
        return db.delete(TABLE_NAME,"ID=?", arrayOf(id))
    }

    companion object {
        val DATABASE_NAME="img.db"

        val TABLE_NAME="images"

        val COL_1="ID"

        val COL_3="image"
    }
}
class Employee(val id:String,val image:ByteArray)