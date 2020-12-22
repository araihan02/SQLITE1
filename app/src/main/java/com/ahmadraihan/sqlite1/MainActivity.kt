package com.ahmadraihan.sqlite1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.ahmadraihan.sqlite1.DBHelper

class MainActivity : AppCompatActivity() {
    lateinit var userDBHelper: DBHelper
    lateinit var inputemail: EditText
    lateinit var inputnama: EditText
    lateinit var inputalamat: EditText
    lateinit var inputjk: EditText
    lateinit var inputtelepon: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputemail = findViewById(R.id.input_email)
        inputnama = findViewById(R.id.input_nama)
        inputalamat = findViewById(R.id.input_alamat)
        inputjk = findViewById(R.id.input_jk)
        inputtelepon = findViewById(R.id.input_telepon)
        userDBHelper = DBHelper(this)
    }
    fun addData(v: View){
        var emailin = inputemail.text.toString()
        var namain = inputnama.text.toString()
        var alamatin = inputalamat.text.toString()
        var jkin = inputjk.text.toString()
        var teleponin = inputtelepon.text.toString()
        userDBHelper.insertData(emailin, namain, alamatin, jkin, teleponin)
        inputemail.setText("")
        inputnama.setText("")
        inputalamat.setText("")
        inputjk.setText("")
        inputtelepon.setText("")

    }
    fun showAll(v: View){
        var pindah = Intent(this, RvDbActivity::class.java)
        startActivity(pindah)
    }
}