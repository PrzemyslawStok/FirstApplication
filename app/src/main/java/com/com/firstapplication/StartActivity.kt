package com.com.firstapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity() {
    lateinit var buttonGame1: Button
    lateinit var buttonGame2: Button
    lateinit var buttonGame3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_start)

        buttonGame1 = findViewById(R.id.buttonGame1)
        buttonGame1.setOnClickListener {
            val game1Activity = Intent(this, Game1Activity::class.java)
            startActivity(game1Activity)
        }

        buttonGame2 = findViewById(R.id.buttonGame2)
        buttonGame2.setOnClickListener {
            val game2Activity = Intent(this, Game2Activity::class.java)
            startActivity(game2Activity)
        }

        buttonGame3 = findViewById(R.id.buttonGame3)
        buttonGame3.setOnClickListener {
            val game3Activity = Intent(this, Game3Activity::class.java)
            startActivity(game3Activity)
        }

    }
}