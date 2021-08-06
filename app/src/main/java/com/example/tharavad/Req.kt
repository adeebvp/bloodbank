package com.example.tharavad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_donor.*
import kotlinx.android.synthetic.main.activity_req.*

class Req : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_req)

        readFireStoreData()
    }

    fun readFireStoreData() {
        val db = FirebaseFirestore.getInstance()
        db.collection("request")
            .get()
            .addOnCompleteListener {

                val result: StringBuffer = StringBuffer()
                val result2: StringBuffer = StringBuffer()

                if (it.isSuccessful) {
                    for (document in it.result!!) {
                        result.append(document.data.getValue("Name")).append("\n\n")
                    }
                    ren.setText(result)
                    for (document in it.result!!) {
                        result2.append(document.data.getValue("Blood")).append("\n\n")
                    }
                    reb.setText(result2)
                }
            }
    }
}
