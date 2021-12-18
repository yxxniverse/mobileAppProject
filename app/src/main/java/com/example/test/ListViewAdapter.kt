package com.example.test

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ListViewAdapter(private val context: Activity, private val arrayList: ArrayList<ListViewItem>) : ArrayAdapter<ListViewItem>(context,
    R.layout.custom_listview_item,arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.custom_listview_item,null)

        val destination : TextView = view.findViewById(R.id.destination)
        val start_date : TextView = view.findViewById(R.id.from)
        val end_date : TextView = view.findViewById(R.id.to)

        destination.text = arrayList[position].destination
        start_date.text = arrayList[position].from
        end_date.text = arrayList[position].to

        return view
    }

}