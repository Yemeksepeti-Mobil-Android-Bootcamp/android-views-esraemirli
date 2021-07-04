package com.emirli.foodappuidesign

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class FirstActivity : AppCompatActivity() {

    private lateinit var startedButton: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        initView()
        addListener()
    }

    private fun initView() {
        startedButton = findViewById(R.id.startedButton)
    }

    private fun addListener() {
        // Redirect to the MainActivity
        startedButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}