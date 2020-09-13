package com.example.mywork.Sign.Seekers.SignUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mywork.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.btn_back

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser
    private lateinit var database: FirebaseDatabase
    private lateinit var db_ref: DatabaseReference




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        db_ref = database.getReference("SEEKERS")

        btn_back.setOnClickListener {
            finish()

        }





        btnNext1.setOnClickListener {
            if (etInputSignUpNama.text!!.toString()==""){
                Toast.makeText(this,"Silahkan Lengkapi data Anda", Toast.LENGTH_SHORT).show()
            } else  if (etInputSignUpEmail.text!!.toString()==""){
                Toast.makeText(this,"Silahkan Lengkapi data Anda", Toast.LENGTH_SHORT).show()
            } else  if (etInputSignUpPassword.text!!.toString()==""){
                Toast.makeText(this,"Silahkan Lengkapi data Anda", Toast.LENGTH_SHORT).show()
            } else  if (etInputSignUpTelpon.text!!.toString()==""){
                Toast.makeText(this,"Silahkan Lengkapi data Anda", Toast.LENGTH_SHORT).show()
            } else {


            val dataSignUp1= Intent(this@SignUpActivity, SignUpActivity2::class.java)
            dataSignUp1.putExtra(SignUpActivity2.NAMA_SEEKERS, etInputSignUpNama.text!!.toString() )
            dataSignUp1.putExtra(SignUpActivity2.email_seekers,etInputSignUpEmail.text!!.toString() )
            dataSignUp1.putExtra(SignUpActivity2.password_seekers,etInputSignUpPassword.text!!.toString())
            dataSignUp1.putExtra(SignUpActivity2.telepon_seekers,etInputSignUpTelpon.text!!.toString())
            startActivity(dataSignUp1)
            }
        }
    }


}