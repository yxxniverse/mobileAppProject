package com.example.test
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlin.math.log

class MypageActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        database = Firebase.database.reference
        setContentView(R.layout.activity_mypage)
        val user = Firebase.auth.currentUser

        user?.let {
            val email = user.email
            var myName = database.child("users").child(user.uid).child("studentId").get().toString()
            var myNameView = findViewById<EditText>(R.id.mypage_name)
            myNameView.setText(myName)
        }
    }
}