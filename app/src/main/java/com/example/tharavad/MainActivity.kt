package com.example.tharavad

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.getInstance
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onBackPressed() {


        val alertDialog : AlertDialog = AlertDialog.Builder(this).create()
        alertDialog.setTitle("Exit")
        alertDialog.setMessage("Do you want to exit?")

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE,"YES"){
                dialog, which ->
            if (getIntent().getBooleanExtra("EXIT", false))
            {
                finish();
                System.exit(0)
            }


            dialog.dismiss()
        }

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE,"NO"){
                dialog, which ->
            dialog.dismiss()
        }

        alertDialog.show()



    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        don.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        req.setOnClickListener {
            val intent = Intent(this, reuquest::class.java)
            startActivity(intent)
        }
        ban.setOnClickListener {
            val intent = Intent(this, Bank::class.java)
            startActivity(intent)
        }

        ctc.setOnClickListener {
            val intent = Intent(this, Contact::class.java)
            startActivity(intent)
        }

    }



}