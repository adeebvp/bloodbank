package com.example.tharavad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.exitProcess

class Admin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        dona.setOnClickListener {
            val intent = Intent(this, Donor::class.java)
            startActivity(intent)
        }

        requ.setOnClickListener {
            val intent = Intent(this, Req::class.java)
            startActivity(intent)
        }

        out.setOnClickListener {
            val intent = Intent(this@Admin, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            intent.putExtra("EXIT", true)
            startActivity(intent)
            Toast.makeText(
                baseContext, "Logged Out",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}