package com.example.mywork.Sign.Seekers.SignUp

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.mywork.R
import com.example.mywork.Sign.Seekers.SeekersModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_edit_profil.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.btnNext1
import kotlinx.android.synthetic.main.activity_sign_up.btn_back
import kotlinx.android.synthetic.main.activity_sign_up.etInputSignUpEmail
import kotlinx.android.synthetic.main.activity_sign_up.etInputSignUpNama
import kotlinx.android.synthetic.main.activity_sign_up.etInputSignUpPassword
import kotlinx.android.synthetic.main.activity_sign_up.etInputSignUpTelpon
import kotlinx.android.synthetic.main.activity_sign_up.selectButton
import java.io.ByteArrayOutputStream
import java.lang.Exception
import java.util.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser
    private lateinit var database: FirebaseDatabase


    private lateinit var userRef: DatabaseReference

    private lateinit var imagePreview: ImageView

    companion object {
        const val PICTURE: Int = 1
    }
    private val storage by lazy { FirebaseStorage.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        userRef = database.getReference("SEEKERS")


        imagePreview = findViewById(R.id.image_view2)
        btn_back.setOnClickListener {
            finish()

        }

        selectButton.setOnClickListener {
            val pickPhoto = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(pickPhoto, PICTURE)
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
    fun uploadPictureDatabase(imageView: ImageView) {
        imageView.isDrawingCacheEnabled = true
        imageView.buildDrawingCache()
        val bitmap = (imageView.drawable as BitmapDrawable).bitmap

        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        val filename = "images/" + UUID.randomUUID().toString()
        val ref = storage.getReference(filename)

        val uploadTask = ref.putBytes(data)
        uploadTask.addOnSuccessListener {
            Log.d("UploadDebug: ", "Success: ${ref.downloadUrl}")

        }.addOnFailureListener {
            Log.d("UploadDebug: ", it.message.toString())
        }

        val urlTask = uploadTask.continueWithTask { task ->
            if (!task.isSuccessful) {
                task.exception?.let {
                    throw it
                }
            }
            ref.downloadUrl
        }.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val downloadUri = task.result
                Log.d("UploadDebug: ", "download url: $downloadUri")
            } else {

            }
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode === Activity.RESULT_OK) {
            when (requestCode) {
                PICTURE -> {
                    val selectedImageURI: Uri = data!!.data!!
//                        image_uri.setText(selectedImageURI.toString())
                    Picasso.get().load(selectedImageURI)
                        .centerCrop().fit()
                        .into(imagePreview, object : Callback {
                            override fun onSuccess() {
                                uploadPictureDatabase(imagePreview)
                            }

                            override fun onError(e: Exception?) {
                            }
                        })
                }
            }
        }
    }




}