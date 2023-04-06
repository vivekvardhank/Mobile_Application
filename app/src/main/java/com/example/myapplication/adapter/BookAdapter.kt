package com.example.myapplication.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.model.Book

class BookAdapter(var context: Context, var arrayList: ArrayList<Book>):BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(p0: Int): Any {
        return arrayList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view: View = View.inflate(context, R.layout.row_data,null)
        var bookName:TextView = view.findViewById(R.id.bookName)
        var bookImage:ImageView = view.findViewById(R.id.bookImage)
        var bookList:Book = arrayList.get(p0)
        bookImage.setImageResource(bookList.bookImage!!)
        bookName.text = bookList.bookName
        return view
    }
}