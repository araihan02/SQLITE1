package com.ahmadraihan.sqlite1

import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        val DATABASE_NAME = "Coba.db"
        val DATABASE_VERSION = 1
        private val SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DBInfo.UserInput.TABLE_INI + " (" + DBInfo.UserInput.COL_EMAIL +
                    " VARCHAR(200) PRIMARY KEY, " + DBInfo.UserInput.COL_NAMA + " TEXT, " +
                    DBInfo.UserInput.COL_ALAMAT + " VARCHAR(200), " + DBInfo.UserInput.COL_JK +
                    " TEXT, "+ DBInfo.UserInput.COL_TELEPON + " TEXT)"
        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DBInfo.UserInput.TABLE_INI
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insertData(emailin: String, namain: String, alamatin: String, jkin: String, teleponin: String): Boolean {
        val db = writableDatabase
        val namatablet = DBInfo.UserInput.TABLE_INI
        val emailt = DBInfo.UserInput.COL_EMAIL
        val namat = DBInfo.UserInput.COL_NAMA
        val alamatt = DBInfo.UserInput.COL_ALAMAT
        val jkt = DBInfo.UserInput.COL_JK
        val telepont = DBInfo.UserInput.COL_TELEPON
        var sql = "INSERT INTO "+ namatablet +"("+emailt+", "+namat+", "+alamatt+", "+jkt+", "+telepont+") " +
                "VALUES('"+emailin+"', '"+namain+"', '"+alamatin+"', '"+jkin+"', '"+teleponin+"')"
        db.execSQL(sql)
        return true
    }

    fun fullData():ArrayList<DBModel> {
//        val users = ArrayList<DBModel>()
        val users = arrayListOf<DBModel>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("SELECT * FROM "+DBInfo.UserInput.TABLE_INI, null)
        } catch (e: SQLException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var emailt: String
        var namat: String
        var alamatt: String
        var jkt: String
        var tetepont: String
        if (cursor!!.moveToFirst()){
            while (cursor.isAfterLast==false){
                emailt = cursor.getString(cursor.getColumnIndex(DBInfo.UserInput.COL_EMAIL))
                namat = cursor.getString(cursor.getColumnIndex(DBInfo.UserInput.COL_NAMA))
                alamatt = cursor.getString(cursor.getColumnIndex(DBInfo.UserInput.COL_ALAMAT))
                jkt = cursor.getString(cursor.getColumnIndex(DBInfo.UserInput.COL_JK))
                tetepont = cursor.getString(cursor.getColumnIndex(DBInfo.UserInput.COL_TELEPON))

                users.add(DBModel(emailt, namat, alamatt, jkt, tetepont))
                cursor.moveToNext()
            }
        }
        return  users
    }

}

