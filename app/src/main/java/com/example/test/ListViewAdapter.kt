package com.example.test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

var List = arrayListOf<ListViewItem>()

class ListViewAdapter(val context: Context, val List: ArrayList<ListViewItem>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View = LayoutInflater.from(context).inflate(R.layout.activity_edit, null)

        val dest = view.findViewById<TextView>(R.id.destination)
        val from = view.findViewById<TextView>(R.id.from)
        val to = view.findViewById<TextView>(R.id.to)

        val list = List[position]
        dest.text = list.destination
        from.text = list.from
        to.text = list.to

        return view
    }
    override fun getItem(position: Int): Any {
        return List[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return List.size
    }
}