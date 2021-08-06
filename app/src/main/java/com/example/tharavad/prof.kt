package com.example.tharavad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.*
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_prof.*
import kotlinx.android.synthetic.main.activity_prof.ad
import kotlinx.android.synthetic.main.activity_reuquest.*
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_disp.*
import kotlinx.android.synthetic.main.activity_login.*

class prof : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prof)



        readFireStoreData()

        ad.setOnClickListener {
            val Name = nam.text.toString()
            val Mob = mob.text.toString().toDouble()
            val Email = add.text.toString()
            val Age = ag.text.toString().toInt()
            val Blood = blo.text.toString()





            saveFireStore(Name, Mob, Email, Age, Blood)


        }



    }

    fun saveFireStore(Name: String, Mob: Double, Email:String, Age:Int, Blood:String) {
        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String, Any> = HashMap()
        user["Name"] = Name
        user["Mobile"] = Mob
        user["Email"] = Email
        user["Age"] = Age
        user["Blood"] = Blood

        db.collection("users").document(Email)


            .set(user)
            .addOnSuccessListener {
                Toast.makeText(this@prof, "Profile Saved  ", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, disp::class.java))
                val intent = Intent(this@prof,disp::class.java)
                intent.putExtra("name",Email).putExtra("blood",Blood)
                startActivity(intent)


            }
            .addOnFailureListener {
                Toast.makeText(this@prof, "Failed to Save ", Toast.LENGTH_SHORT).show()
            }

    }

    fun readFireStoreData() {
        val profileName =intent.getStringExtra("Username").toString()
        val db = FirebaseFirestore.getInstance()
        db.collection("users").document(profileName)
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    nam.setText("${document["Name"]}")
                    mob.setText("${document["Mobile"]}")
                    add.setText("${document["Email"]}")
                    ag.setText("${document["Age"]}")
                    blo.setText("${document["Blood"]}")


                } else {
                    nam.setText("")
                    mob.setText("")
                    add.setText("")
                    ag.setText("")
                    blo.setText("")
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(
                    baseContext, "Not  Successfully",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }


    }



}