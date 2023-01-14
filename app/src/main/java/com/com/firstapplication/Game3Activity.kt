package com.com.firstapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.com.firstapplication.databinding.ActivityGame3Binding

class Game3Activity : AppCompatActivity() {
    lateinit var binding: ActivityGame3Binding
    lateinit var testButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGame3Binding.inflate(layoutInflater)
        testButton = binding.testButton

        setContentView(binding.root)

        testButton.setOnClickListener {
            val gameAgl = Game3Algorithm()
            gameAgl.testGameAgl()
        }
    }
}