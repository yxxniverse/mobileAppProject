package com.example.test

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    lateinit var ref : DatabaseReference
    lateinit var listItem : ArrayList<ListViewItem>
    lateinit var listview: ListView

    val user = Firebase.auth.currentUser
    private lateinit var auth: FirebaseAuth
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_edit) //위치
        super.onCreate(savedInstanceState)

        listItem = arrayListOf()
        listview = findViewById(R.id.listView)
        ref = FirebaseDatabase.getInstance().getReference("외박신청")

        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
            }
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    listItem.clear()
                    for (e in snapshot.children){
                        val info = e.getValue(ListViewItem::class.java)
                        listItem.add(info!!)
                    }
                    val adapter = ListViewAdapter(this@EditActivity, listItem)
                    listview.adapter = adapter
                }
            }

        })
    }
}