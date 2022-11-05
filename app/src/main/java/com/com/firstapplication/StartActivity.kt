package com.com.firstapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity() {
    var buttonGame1: Button? = null
    var buttonGame2: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_start)

        buttonGame1 = findViewById(R.id.buttonGame1)
        buttonGame1?.setOnClickListener {
            val game1Activity = Intent(this, Game1Activity::class.java)
            startActivity(game1Activity)
        }

        buttonGame2 = findViewById(R.id.buttonGame2)
        buttonGame2?.setOnClickListener {
            val game1Activity = Intent(this, Game2Activity::class.java)
            startActivity(game1Activity)
        }

    }
}