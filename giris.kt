package com.yildizsoft.fatih.br

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_giris.*

class giris : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giris)
        ilerimenu.setOnClickListener {
            var intent=Intent(this,activity_menu::class.java)
            this.startActivity(intent)
        }
    }
}
