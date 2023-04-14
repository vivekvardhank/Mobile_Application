package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.adapter.BookAdapter
import com.example.myapplication.model.Book

class BookActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private var arrayList: ArrayList<Book>? = null
    private var gridView: GridView? = null
    private var bookAdapter: BookAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        gridView = findViewById(R.id.bookGridView)
        arrayList = ArrayList()
        arrayList = setDataList()
        bookAdapter = BookAdapter(applicationContext, arrayList!!)
        gridView?.adapter = bookAdapter
        gridView?.onItemClickListener = this
//        gridView?.setOnClickListener(object: View.OnClickListener {
//            override fun onClick(p0: View?) {
//                val intent= Intent(applicationContext,BookDetailsActivity::class.java)
//                intent.putExtra("name", arrayList!!.get(0).bookName)
//                intent.putExtra("Image", arrayList!!.get(0).bookImage)
//                startActivity(intent)
//            }
//
//        })
    }

    private fun setDataList(): ArrayList<Book> {
        var bookList: ArrayList<Book> = ArrayList()
        bookList.add(Book("The Alchemist", R.drawable.alchemist))
        bookList.add(Book("His Name is George Floyd", R.drawable.hisnameis))
        bookList.add(Book("UAB SweatShirt", R.drawable.uabsweatshirt))
        bookList.add(Book("UAB T Shirt", R.drawable.uabtshirt))
        bookList.add(Book("Web App Dev", R.drawable.webappdev))
        bookList.add(Book("Rule Book", R.drawable.book2))
        bookList.add(Book("Design How People Learn", R.drawable.designhowpeoplelearn))
        bookList.add(Book("Cloud Computing", R.drawable.cloudcomputing))
        bookList.add(Book("Information Security", R.drawable.informationsecurity))
        bookList.add(Book("UAB Hoodie", R.drawable.sweatshirt))
        bookList.add(Book("UAB Silver Pendant", R.drawable.uabpendant))
        return bookList
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        var items: Book = arrayList!!.get(p2)
        Toast.makeText(applicationContext, items.bookName, Toast.LENGTH_LONG).show()
        val intent = Intent(applicationContext, BookDetailsActivity::class.java)
        intent.putExtra("name", arrayList!!.get(p2).bookName)
        intent.putExtra("Image", arrayList!!.get(p2).bookImage)
        startActivity(intent)

    }
}