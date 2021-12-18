package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class MainActivity : AppCompatActivity() {

    val user = Firebase.auth.currentUser
    private lateinit var auth: FirebaseAuth
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calendar)
        auth = Firebase.auth
        database = Firebase.database.reference
        var logoutBtn = findViewById<Button>(R.id.logout_btn)
        var mypageBtn = findViewById<Button>(R.id.mypage_btn)
        var overnightBtn = findViewById<Button>(R.id.overnight_submission_btn)

        user?.let {
            database.child("users").child(user.uid)
                .addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(error: DatabaseError) {
                    }
                    override fun onDataChange(snapshot: DataSnapshot) {

                        var menuNameView = findViewById<TextView>(R.id.userNameView)
                        var menuDormView = findViewById<TextView>(R.id.dormNameView)

                        var CurrentUserName = snapshot.child("name").value.toString()
                        var CurrentUserDorm = snapshot.child("dormName").value.toString()

                        menuNameView.setText(CurrentUserName)
                        menuDormView.setText(CurrentUserDorm)
                    }
                })
        }

        logoutBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            auth?.signOut()
            Toast.makeText(
                baseContext, "로그아웃 되었습니다",
                Toast.LENGTH_SHORT
            ).show()
        }
        mypageBtn.setOnClickListener {
            startActivity(Intent(this,MypageActivity::class.java))
        }
        overnightBtn.setOnClickListener {
            startActivity(Intent(this,FormInfoActivity::class.java))
        }
    }
}