package com.example.test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_edit.*
import kotlin.properties.Delegates

class EditActivity : AppCompatActivity() {

    var arrayList = arrayListOf<ListViewItem>()
    var keyList = arrayListOf<String>()
    lateinit var key : String
    var i by Delegates.notNull<Int>()
    val destination = arrayListOf<String>()
    val startDate = arrayListOf<String>()
    val endDate = arrayListOf<String>()
    val user = Firebase.auth.currentUser
    private lateinit var auth: FirebaseAuth
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        database = Firebase.database.reference
        setContentView(R.layout.activity_edit)

        user?.let {
            database.child("users").child(user.uid).child("외박신청")
                .addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(error: DatabaseError) {
                    }
                    override fun onDataChange(snapshot: DataSnapshot) {
                        i = 0
                        for (data in snapshot.children){
                            key = data.key.toString()

                            keyList.add(key)

                            destination.add(snapshot.child(key).child("destination").value.toString())
                            startDate.add(snapshot.child(key).child("start_date").value.toString())
                            endDate.add(snapshot.child(key).child("end_date").value.toString())

                            val editInfo = ListViewItem(destination[i], startDate[i], endDate[i])
                            arrayList.add(editInfo)
                            i++
                        }
                    }

                })
            val editAdapter = ListViewAdapter(this, arrayList)
            mainListView.adapter = editAdapter
        }
    }
}

