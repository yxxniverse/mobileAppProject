package com.example.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class EditActivity : AppCompatActivity() {
    var dogList = arrayListOf<ListViewItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Adapter = ListViewAdapter(this, List)
    }
}