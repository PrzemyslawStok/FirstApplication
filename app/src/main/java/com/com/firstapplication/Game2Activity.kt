package com.com.firstapplication

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.com.firstapplication.databinding.ActivityGame2Binding
import kotlin.random.Random

class Game2Activity : AppCompatActivity() {
    lateinit var binding: ActivityGame2Binding

    //var counterText: TextView? = null
    lateinit var counterTextView: TextView

    val leftInit = -5
    val rightInit = -7
    val downInit = 11
    val upInit = 3

    var mainValue = 0
    var noTrials = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGame2Binding.inflate(layoutInflater)

        counterTextView = binding.counterTextView
        counterTextView.setText("$noTrials")


        setContentView(binding.root)

        initLayout()
        binding.viewLeft.setOnClickListener {
            mainValue += leftInit
            binding.centerView.text = "$mainValue"

            checkGame()
        }

        binding.viewRight.setOnClickListener {
            mainValue += rightInit
            binding.centerView.text = "$mainValue"

            checkGame()
        }

        binding.viewDown.setOnClickListener {
            mainValue += downInit
            binding.centerView.text = "$mainValue"

            checkGame()
        }

        binding.viewUp.setOnClickListener {
            mainValue += upInit
            binding.centerView.text = "$mainValue"

            checkGame()
        }

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

    fun checkGame() {
        noTrials++
        counterTextView.setText("$noTrials")

        if (mainValue == 0) {
            Toast.makeText(this, "Gra ukończona po ${noTrials} próbach.", Toast.LENGTH_LONG).show()
            resetGame()
        }

    }

    fun resetGame() {
        mainValue = Random.nextInt(10, 100)
        binding.centerView.text = "$mainValue"
    }
}