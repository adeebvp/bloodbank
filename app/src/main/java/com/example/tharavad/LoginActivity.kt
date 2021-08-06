package com.example.tharavad

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        FirebaseAuth.getInstance().signOut()







        si.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        log.setOnClickListener {

            doLogin()
        }




    }

    private fun doLogin() {

        if (username.text.toString().isEmpty()) {
            username.error = "Please enter email"
            username.requestFocus()
            return
        }



        if (!Patterns.EMAIL_ADDRESS.matcher(username.text.toString()).matches()) {
            username.error = "Please enter valid email"
            username.requestFocus()
            return
        }

        if (password.text.toString().isEmpty()) {
            password.error = "Please enter password"
            password.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(username.text.toString(), password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)

                } else {

                    updateUI(null)
                }
            }
    }



    private fun updateUI(currentUser: FirebaseUser?) {

        var a = 0

        if (username.text.toString()=="fifops6969@gmail.com")
        {
             a = 1
        }

        if (currentUser != null) {
            if(currentUser.isEmailVerified) {

                if(a==1)
                {
                    startActivity(Intent(this, Admin::class.java))
                }

                else {
                    startActivity(Intent(this, prof::class.java))
                    val intent = Intent(this@LoginActivity,prof::class.java)
                    intent.putExtra("Username",username.text.toString())
                    startActivity(intent)
                }


                Toast.makeText(
                    baseContext, "Logged in Successfully",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }else{
                Toast.makeText(
                    baseContext, "Please verify your email address.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(
                baseContext, "Check Your Credentials",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}