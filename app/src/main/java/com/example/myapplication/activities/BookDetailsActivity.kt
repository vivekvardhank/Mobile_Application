package com.example.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R

class BookDetailsActivity : AppCompatActivity() {
    private var textView: TextView? = null
    private var imageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        textView = findViewById(R.id.bookDetailsName)
        imageView = findViewById(R.id.bookDetailsImage)

        val intent: Intent? = getIntent()
        textView!!.setText(intent?.getStringExtra("name"))
        intent?.getIntExtra("Image",0)?.let { imageView!!.setImageResource(it) }

        val cartImageView: ImageView = findViewById(R.id.imageView2)
        cartImageView.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }


    }
}