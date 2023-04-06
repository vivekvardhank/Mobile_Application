package com.example.myapplication.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.adapter.BookAdapter
import com.example.myapplication.model.Book

class BookActivity: AppCompatActivity(), AdapterView.OnItemClickListener {
    private var arrayList:ArrayList<Book> ? = null
    private var gridView:GridView ? = null
    private var bookAdapter:BookAdapter ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        gridView = findViewById(R.id.bookGridView)
        arrayList = ArrayList()
        arrayList = setDataList()
        bookAdapter = BookAdapter(applicationContext, arrayList!!)
        gridView?.adapter = bookAdapter
        gridView?.onItemClickListener = this
    }

    private fun setDataList(): ArrayList<Book>{
        var bookList:ArrayList<Book> = ArrayList()
//        bookList.add(Book("AI",R.drawable.ai))
//        bookList.add(Book("Database",R.drawable.database))
//        bookList.add(Book("Pocket Book",R.drawable.pocketbook))
        bookList.add(Book("Web App Dev",R.drawable.webappdev))
        bookList.add(Book("Rule Book",R.drawable.book2))

        return bookList
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        var items:Book = arrayList!!.get(p2)
        Toast.makeText(applicationContext,items.bookName,Toast.LENGTH_LONG).show()
    }
}