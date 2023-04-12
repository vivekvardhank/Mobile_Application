package com.example.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.entities.UserDetailsDao

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userDetailsDao: UserDetailsDao
    private  lateinit var signBut:Button
    private  lateinit var loginBut:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val database = AppDatabase.getDatabase(applicationContext)
        userDetailsDao = database.userDetailsDao()

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