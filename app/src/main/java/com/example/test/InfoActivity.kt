package com.example.test

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class InfoActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        auth=Firebase.auth
        database = Firebase.database.reference
        val user = Firebase.auth.currentUser
        user?.let {
            val email = user.email

            var saveInfoBtn = findViewById<Button>(R.id.join_save)
            var userNameEditText = findViewById<EditText>(R.id.join_name)
            var userGenderRadio = findViewById<RadioGroup>(R.id.join_gender)
            var userGenderChecked = findViewById<RadioButton>(userGenderRadio.checkedRadioButtonId)
            var userStudentIdEditText = findViewById<EditText>(R.id.join_id)
            var userBirthdayEditText = findViewById<EditText>(R.id.join_birthday)
            var userDormNameEditText = findViewById<EditText>(R.id.join_dorm)
            var userDormRoomEditText = findViewById<EditText>(R.id.join_dorm2)

            saveInfoBtn.setOnClickListener {
                UserInfo(
                    email.toString(),
                    userNameEditText.text.toString(),
                    userGenderChecked.toString(),
                    userStudentIdEditText.text.toString(),
                    userBirthdayEditText.text.toString(),
                    userDormNameEditText.text.toString(),
                    userDormRoomEditText.text.toString()
                )
            }
        }
    }

    fun UserInfo(email:String, name:String, gender:String, studentId:String, birthday:String, dormName:String, dormRoom:String){

        database.child("dorm").child(dormName).child("users").child(studentId).child("userName").setValue(name)
        database.child("dorm").child(dormName).child("users").child(studentId).child("userGender").setValue(gender)
        database.child("dorm").child(dormName).child("users").child(studentId).child("userBirthday").setValue(birthday)
        database.child("dorm").child(dormName).child("users").child(studentId).child("userEmail").setValue(email)
        database.child("dorm").child(dormName).child("users").child(studentId).child("userDormRoom").setValue(dormRoom)

        Toast.makeText(
            this, "회원정보가 저장되었습니다.",
            Toast.LENGTH_SHORT
        ).show()
        finish()
    }
}