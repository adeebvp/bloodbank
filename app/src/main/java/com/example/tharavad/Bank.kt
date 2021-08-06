package com.example.tharavad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_bank.*
import kotlinx.android.synthetic.main.activity_disp.*
import kotlinx.android.synthetic.main.activity_prof.*

class Bank : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank)

        readFireStoreData()
    }


    fun readFireStoreData() {
        val db = FirebaseFirestore.getInstance()


        db.collection("bank").document("${"A+ve"}")
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    text1.setText("A+ve= ${document["unit"]} Unit(s)")
                } else {
                    n.setText("No such document")
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(
                    baseContext, "NOt  Successfully",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }




        db.collection("bank").document("${"A-ve"}")
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    text2.setText("A-ve = ${document["unit"]} Unit(s)")
                } else {
                    n.setText("No such document")
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(
                    baseContext, "NOt  Successfully",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }

        db.collection("bank").document("${"B+ve"}")
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    text3.setText("B+ve = ${document["unit"]} Unit(s)")
                } else {
                    n.setText("No such document")
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(
                    baseContext, "NOt  Successfully",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }

        db.collection("bank").document("${"B-ve"}")
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    text4.setText("B-ve = ${document["unit"]} Unit(s)")
                } else {
                    n.setText("No such document")
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(
                    baseContext, "NOt  Successfully",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }

        db.collection("bank").document("${"O+ve"}")
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    text5.setText("O+ve = ${document["unit"]} Unit(s)")
                } else {
                    n.setText("No such document")
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(
                    baseContext, "NOt  Successfully",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }

        db.collection("bank").document("${"O-ve"}")
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    text6.setText("O-ve = ${document["unit"]} Unit(s)")
                } else {
                    n.setText("No such document")
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(
                    baseContext, "NOt  Successfully",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }

        db.collection("bank").document("${"AB+ve"}")
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    text7.setText("AB+ve = ${document["unit"]} Unit(s)")
                } else {
                    n.setText("No such document")
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(
                    baseContext, "NOt  Successfully",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }


        db.collection("bank").document("${"AB-ve"}")
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    text8.setText("AB-ve = ${document["unit"]} Unit(s)")
                } else {
                    n.setText("No such document")
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(
                    baseContext, "NOt  Successfully",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }


    }






}