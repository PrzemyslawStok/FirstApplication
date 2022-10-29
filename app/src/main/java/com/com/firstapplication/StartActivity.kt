package com.com.firstapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity() {
    var buttonGame1: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        buttonGame1 = findViewById(R.id.buttonGame1)
        buttonGame1?.setOnClickListener {

        }

    }
}