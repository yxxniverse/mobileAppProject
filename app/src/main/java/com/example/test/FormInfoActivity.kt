package com.example.test

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FormInfoActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        auth=Firebase.auth
        database = Firebase.database.reference
        val user = Firebase.auth.currentUser

        user?.let {

            var saveFormInfoBtn = findViewById<Button>(R.id.enter_btn)

            var destinationEditText = findViewById<EditText>(R.id.states)
            var durationStartTextView = findViewById<TextView>(R.id.date_show1)
            var durationEndTextView = findViewById<TextView>(R.id.date_show2)
            var reasonEditText = findViewById<EditText>(R.id.reason_pwd)
            var agreementCheckBox = findViewById<CheckBox>(R.id.agm_cb)

            saveFormInfoBtn.setOnClickListener {
                UserFormInfo(
                    destinationEditText.text.toString(),
                    durationStartTextView.text.toString(),
                    durationEndTextView.text.toString(),
                    reasonEditText.text.toString(),
                    agreementCheckBox.text.toString(),
                    user.uid.toString()
                )
            }
        }
    }

    fun UserFormInfo(destination:String, durationStart:String, durationEnd:String, reason:String, agreement:String, uId:String){

        var formMap = HashMap<String, String>()
        formMap.put("start_date",durationStart)
        formMap.put("end_date", durationEnd)
        formMap.put("reason", reason)
        formMap.put("agreement",agreement)

        database.child("users").child(uId).child("외박신청").setValue(formMap)

        Toast.makeText(
            this, "외박 신청이 완료되었습니다.",
            Toast.LENGTH_SHORT
        ).show()
        finish()
    }
}

