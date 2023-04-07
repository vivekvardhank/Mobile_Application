package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import java.util.*

class LoginActivity : AppCompatActivity() {

    private lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton = findViewById(R.id.button4)

        loginButton.setOnClickListener {
            val intent = Intent(this, BookActivity::class.java)
            val usernameEditText = findViewById<EditText>(R.id.editTextTextPersonName2)
            val passwordEditText = findViewById<EditText>(R.id.editTextTextPassword3)

            val username = usernameEditText.text.toString().lowercase(Locale.ROOT)
            val password = passwordEditText.text.toString()


            if (username == "test" && password == "test") {
                // If username and password are correct, start the BookActivity
                val intent = Intent(this, BookActivity::class.java)
                startActivity(intent)
            } else {
                // If username and password are incorrect, show an error message
                Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT).show()
            }

        }
    }
}