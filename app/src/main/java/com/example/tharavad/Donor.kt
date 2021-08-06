package com.example.tharavad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_disp.*
import kotlinx.android.synthetic.main.activity_donor.*
import kotlinx.android.synthetic.main.activity_prof.*


class Donor : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor)

        readFireStoreData()

    }

    fun readFireStoreData() {
        val db = FirebaseFirestore.getInstance()
        db.collection("users")
            .get()
            .addOnCompleteListener  {

                val result: StringBuffer = StringBuffer()
                val result2: StringBuffer = StringBuffer()

                if(it.isSuccessful) {
                    for(document in it.result!!) {
                        result.append(document.data.getValue("Name")).append("\n\n")
                    }
                    doi.setText(result)
                    for(document in it.result!!) {
                        result2.append(document.data.getValue("Blood")).append("\n\n")
                    }
                    doc.setText(result2)
                }
            }

    }


}