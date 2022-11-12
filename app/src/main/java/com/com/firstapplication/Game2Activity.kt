package com.com.firstapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.com.firstapplication.databinding.ActivityGame2Binding

class Game2Activity : AppCompatActivity() {
    lateinit var binding: ActivityGame2Binding

    val leftInit = -5
    val rightInit = -7
    val downInit = 11
    val upInit = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGame2Binding.inflate(layoutInflater)

        setContentView(binding.root)

        initLayout()

        resetGame()


        //setContentView(R.layout.activity_game2)

    }

    fun initLayout() {
        binding.viewRight.text = initText(rightInit)
        binding.viewLeft.text = initText(leftInit)
        binding.viewDown.text = initText(downInit)
        binding.viewUp.text = initText(upInit)
    }

    fun initText(value: Int): String {
        if (value > 0)
            return "+$value"
        else
            return "$value"
    }

    fun resetGame() {

    }
}