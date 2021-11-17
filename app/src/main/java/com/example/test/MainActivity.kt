package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var editId : EditText;
    lateinit var userId : String;
    lateinit var loginBtn : Button;
    lateinit var joinBtn : Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginBtn = findViewById<Button>(R.id.login_btn)
        loginBtn.setOnClickListener {
            var loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }
        joinBtn = findViewById<Button>(R.id.join_btn)
        joinBtn.setOnClickListener {
                var joinIntent = Intent(this, JoinActivity::class.java)
                startActivity(joinIntent)
        }

    }
}