package com.example.mywork.Sign.Seekers.SignUp

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.RadioButton
import android.widget.Toast
import com.example.mywork.R
import kotlinx.android.synthetic.main.activity_sign_up2.*
import kotlinx.android.synthetic.main.activity_sign_up2.btnNext
import kotlinx.android.synthetic.main.activity_sign_up2.btn_back
import java.util.*

class SignUpActivity2 : AppCompatActivity(),DatePickerDialog.OnDateSetListener {

     var day = 0
     var month = 0
     var year = 0

     var savedDay = 0
     var savedMonth = ""
     var savedYear = 0


     var TanggalLahir = ""
      var Kelamin = ""
      var Status  = ""


    companion object {
        const val NAMA_SEEKERS = "nama_seekers"
        const val email_seekers = "email_seekers"
        const val password_seekers = "password_seekers"
        const val telepon_seekers = "telepon_seekers"

    }
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)

        //data user dari activity1
        val nama = intent.getStringExtra(SignUpActivity3.NAMA_SEEKERS)
        val email = intent.getStringExtra(SignUpActivity3.email_seekers)
        val password = intent.getStringExtra(SignUpActivity3.password_seekers)
        val telepon = intent.getStringExtra(SignUpActivity3.telepon_seekers)


            btnNext.setOnClickListener {
                if(TanggalLahir == ""){
                    Toast.makeText(this,"Silahkan Lengkapi data Anda",Toast.LENGTH_SHORT).show()
                }else if(Kelamin==""){
                    Toast.makeText(this,"Silahkan Lengkapi data Anda",Toast.LENGTH_SHORT).show()
                }else if(Status==""){
                    Toast.makeText(this,"Silahkan Lengkapi data Anda",Toast.LENGTH_SHORT).show()
                } else{
                    val dataSignUp2= Intent(this@SignUpActivity2, SignUpActivity3::class.java)
                    dataSignUp2.putExtra(SignUpActivity3.NAMA_SEEKERS, nama )
                    dataSignUp2.putExtra(SignUpActivity3.email_seekers,email )
                    dataSignUp2.putExtra(SignUpActivity3.password_seekers,password)
                    dataSignUp2.putExtra(SignUpActivity3.telepon_seekers,telepon)
                    dataSignUp2.putExtra(SignUpActivity3.kelamin_seekers,Kelamin)
                    dataSignUp2.putExtra(SignUpActivity3.status_seekers,Status)
                    dataSignUp2.putExtra(SignUpActivity3.tanggal_lahir_seekers,TanggalLahir)

                    startActivity(dataSignUp2)
                }

            //send data ke activity 3

            }




        btn_back.setOnClickListener {
            finish()
        }

        //input tanggal
        datePick()
    }

    fun radio_button_kelamin(view: View){
        val radio: RadioButton = findViewById(radioBtnKelamin.checkedRadioButtonId)
        Kelamin =radio.text.toString()

    }
    fun radio_button_status(view: View){
        val radio: RadioButton = findViewById(radioBtnStatus.checkedRadioButtonId)
        Status =radio.text.toString()

    }

    fun getDate(){
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)

    }

    fun datePick(){
        tv_tanggal_lahir.setOnClickListener {
            getDate()
            DatePickerDialog(this,this,year,month,day).show()
        }

        btn_date.setOnClickListener {
            getDate()
            DatePickerDialog(this,this,year,month,day).show()
        }
    }
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
       savedDay = dayOfMonth

        savedYear=year
        when(month){
            1 -> savedMonth = "Januari"
            2 -> savedMonth = "Februari"
            3 -> savedMonth = "Maret"
            4 -> savedMonth = "April"
            5 -> savedMonth = "Mei"
            6 -> savedMonth = "Juni"
            7 -> savedMonth = "Juli"
            8 -> savedMonth = "Agustus"
            9 -> savedMonth = "September"
            10 -> savedMonth = "Oktober"
            11 -> savedMonth = "November"
            12 -> savedMonth = "Desember"

        }
        tv_tanggal_lahir.text = "$savedDay  $savedMonth  $savedYear"
        TanggalLahir = "$savedDay  $savedMonth  $savedYear"
        getDate()
    }
}