package com.example.tharavad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_prof.*
import kotlinx.android.synthetic.main.activity_reuquest.*

class reuquest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reuquest)


        sub.setOnClickListener {

            val Name = na.text.toString()
            val Mob = mo.text.toString().toDouble()
            val Email = em.text.toString()
            val Age = age.text.toString().toInt()
            val Blood = bl.text.toString()

            saveFireStore(Name, Mob, Email, Age, Blood)
            val intent = Intent(this, Done::class.java)
            startActivity(intent)
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

        db.collection("request").document(Email)


            .set(user)
            .addOnSuccessListener {
                startActivity(Intent(this, Done::class.java))

            }
            .addOnFailureListener {
                Toast.makeText(this@reuquest, "Failed to Save ", Toast.LENGTH_SHORT).show()
            }

    }



}
