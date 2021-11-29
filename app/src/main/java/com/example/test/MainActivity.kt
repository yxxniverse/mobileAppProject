package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calendar)
        auth = FirebaseAuth.getInstance()
        var logoutBtn = findViewById<Button>(R.id.logout_btn)

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
    }
}