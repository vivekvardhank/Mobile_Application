package com.example.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private  lateinit var signBut:Button
    private  lateinit var loginBut:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        signBut= findViewById(R.id.button)
        loginBut= findViewById(R.id.button2)

        signBut.setOnClickListener{
            val intent= Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        loginBut.setOnClickListener{
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}