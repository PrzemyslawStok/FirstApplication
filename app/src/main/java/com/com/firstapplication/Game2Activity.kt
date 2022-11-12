package com.com.firstapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.com.firstapplication.databinding.ActivityGame2Binding

class Game2Activity : AppCompatActivity() {
    lateinit var binding: ActivityGame2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGame2Binding.inflate(layoutInflater)

        setContentView(binding.root)


        //setContentView(R.layout.activity_game2)

    }
}