package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivitySignupBinding
import com.example.myapplication.entities.UserDetails
import com.example.myapplication.entities.UserDetailsDao
import com.example.myapplication.runOnIO

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var userDetailsDao: UserDetailsDao
    private var isAllowed: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_signup)
        setContentView(binding.root)
        val database = AppDatabase.getDatabase(applicationContext)
        userDetailsDao = database.userDetailsDao()

        binding.editTextTextPersonName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                val userName: String = p0.toString()
                runOnIO {
                    if (userDetailsDao.isUserNamePresent(userName)) {
                        isAllowed = false
                        Toast.makeText(
                            applicationContext,
                            "Already present in database",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        isAllowed = true
                    }
                }
            }

        })
        binding.button3.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                if(isAllowed){
                    if(binding.editTextTextPassword.text.toString().equals(binding.editTextTextPassword2.text.toString())){
                        runOnIO {
                            userDetailsDao.insert(
                                UserDetails(
                                    userDetailsDao.getAll().size + 1,
                                    binding.editTextTextPersonName.text.toString(),
                                    binding.editTextTextPassword.text.toString()
                                )
                            )
                            println("User details saved.")
                        }
                        } else{
                            Toast.makeText(applicationContext,"Password doesn't match",Toast.LENGTH_LONG).show()
                    }
                } else{
                    Toast.makeText(applicationContext,"Username is already taken",Toast.LENGTH_LONG).show()
                }
            }
        })


    }
}