package com.example.test

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_form.*
import java.util.*

class CalendarActivity : AppCompatActivity() {

    private var calendar = Calendar.getInstance()
    private var year = calendar.get(Calendar.YEAR)
    private var month = calendar.get(Calendar.MONTH)
    private var day = calendar.get(Calendar.DAY_OF_MONTH)

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("SetText118n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        cal_btn1.setOnClickListener {  //캘린더뷰 만들기
            val datePickerDialog = DatePickerDialog(this, { _, year, month, day ->
                date_show1.text =
                    year.toString() + "-" + (month + 1).toString() + "-" + day.toString()
            }, year, month, day)
            datePickerDialog.show()
        }

        cal_btn2.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this, { _, year, month, day ->
                date_show2.text =
                    year.toString() + "-" + (month + 1).toString() + "-" + day.toString()
            }, year, month, day)
            datePickerDialog.show()
        }
    }
}