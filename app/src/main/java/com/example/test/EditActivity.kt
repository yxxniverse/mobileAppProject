package com.example.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    var arrayList = arrayListOf<ListViewItem>()

    val user = Firebase.auth.currentUser
    private lateinit var auth: FirebaseAuth
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        database = Firebase.database.reference
        setContentView(R.layout.activity_edit)

        auth = Firebase.auth
        database = Firebase.database.reference

        val destination = arrayOf(
            "대구시","울산시"
        )
        val startDate = arrayOf(
            "2021-12-24","2022-01-01"
        )
        val endDate = arrayOf(
            "2021-12-25","2021-01-03"
        )

        for(i in destination.indices){

            val editInfo = ListViewItem(destination[i], startDate[i], endDate[i])
            arrayList.add(editInfo)
        }


        val editAdapter = ListViewAdapter(this, arrayList)
        mainListView.adapter = editAdapter

    }

}

