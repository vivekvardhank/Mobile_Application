package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.entities.UserDetailsDao
import com.example.myapplication.runOnIO

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var userDetailsDao: UserDetailsDao
    private lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val database = AppDatabase.getDatabase(applicationContext)
        userDetailsDao = database.userDetailsDao()

        loginButton = findViewById(R.id.button4)
        val intent = Intent(this, BookActivity::class.java)
        println("Testing the method")
        binding.button4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                println("Entered into onlclick")
                runOnIO {  println("Data......."+ userDetailsDao.getAll())}
                var userName: String = binding.editTextTextPersonName2.text.toString()
                var password: String = binding.editTextTextPassword3.text.toString()
                println("Entering into loop")
                runOnIO {
                    if (userDetailsDao.isUserPresent(userName, password)) {
                        println("Entered into loop")
                        println(
                            "Result.........." + userDetailsDao.isUserPresent(userName, password)
                        )
                        loginButton.setOnClickListener {
                            startActivity(intent)
                        }
                    } else {
                        runOnUiThread {
                            Toast.makeText(
                                applicationContext,
                                "User Details are wrong try again",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        })


    }
}