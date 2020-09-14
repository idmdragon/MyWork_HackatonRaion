package com.example.mywork.Pengaturan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.RadioButton
import com.example.mywork.R
import com.example.mywork.Sign.Seekers.SeekersModel
import com.example.mywork.Sign.Seekers.SignUp.SignUpActivity2
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import kotlinx.android.synthetic.main.activity_edit_profil.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up2.*
import kotlinx.android.synthetic.main.activity_sign_up2.radioBtnKelamin
import kotlinx.android.synthetic.main.activity_sign_up2.radioBtnStatus

class EditProfilActivity : AppCompatActivity() {

    var TanggalLahir = ""
    var Kelamin = ""
    var Status  = ""

    private lateinit var user: FirebaseUser
    private lateinit var database: FirebaseDatabase
    private lateinit var db_ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)



        user = FirebaseAuth.getInstance().currentUser!!
        database = FirebaseDatabase.getInstance()
        db_ref = database.getReference("SEEKERS")

  db_ref.child(user.uid).addValueEventListener(object : ValueEventListener{
      override fun onDataChange(snapshot: DataSnapshot) {
          var getData = snapshot.getValue<SeekersModel>()
          etInputEditNama.text = Editable.Factory.getInstance().newEditable(getData?.nama)
          etInputEditEmail.text = Editable.Factory.getInstance().newEditable(getData?.email)
          etInputEditPassword.text = Editable.Factory.getInstance().newEditable("********")
          etInputEditTelpon.text = Editable.Factory.getInstance().newEditable(getData?.nomerTelepon)
      }

      override fun onCancelled(error: DatabaseError) {

      }

  })




    }
    fun edit_button_kelamin(view: View){
        val radio: RadioButton = findViewById(radioBtnKelamin.checkedRadioButtonId)
        Kelamin =radio.text.toString()

    }
    fun edit_button_status(view: View){
        val radio: RadioButton = findViewById(radioBtnStatus.checkedRadioButtonId)
        Status =radio.text.toString()

    }
}