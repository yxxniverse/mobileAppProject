package com.example.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class EditActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var itemArrayList : ArrayList<ListViewItem>
    private lateinit var auth: FirebaseAuth
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_edit)
        super.onCreate(savedInstanceState)
        auth=Firebase.auth
        database = Firebase.database.reference
        val user = Firebase.auth.currentUser
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val destination = arrayOf(
            "대구시","울산시","포항시" //ex
        )
        val from = arrayOf(
            "2021-12-12","2021-12-24","2022-01-01"
        )
        val to = arrayOf(
            "2021-12-13","2021-12-25","2022-01-02"
        )

        itemArrayList = ArrayList()

        for (i in destination.indices){
            val item = ListViewItem(destination[i],from[i],to[i])
            itemArrayList.add(item)
        }
        //binding.listview.adapter = ListViewAdapter(this,itemArrayList)
    }
}

