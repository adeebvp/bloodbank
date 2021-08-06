package com.example.tharavad

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_disp.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_prof.*
import kotlinx.coroutines.delay

class disp : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disp)


        readFireStoreData()

        d.setOnClickListener {

            saveFireStore()
            startActivity(Intent(this, Done::class.java))

        }

        out.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this@disp, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            intent.putExtra("EXIT", true)
            startActivity(intent)
            Toast.makeText(
                baseContext, "Logged Out",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    fun readFireStoreData() {
        val db = FirebaseFirestore.getInstance()
        val profile =intent.getStringExtra("name").toString()
        db.collection("users").document(profile)
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    n.setText("Name : ${document["Name"]}")
                    m.setText("Mobile Number : ${document["Mobile"]}")
                    e.setText("Email: ${document["Email"]}")
                    a.setText("Age: ${document["Age"]}")
                    b.setText("Blood Group: ${document["Blood"]}")
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



    fun saveFireStore() {
        val db = FirebaseFirestore.getInstance()
        val blo =intent.getStringExtra("blood").toString()
        val docref = db.collection("bank").document(blo)
        db.runTransaction {
            transaction ->
            val snapshot = transaction.get(docref)
            val newblood = snapshot.getDouble("unit")!! + 1
            transaction.update(docref,"unit",newblood)
        }
    }


}