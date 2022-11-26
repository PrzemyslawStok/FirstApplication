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
    lateinit var levelTextView: TextView

    var leftInit = 0
    var rightInit = 0
    var downInit = 0
    var upInit = 0

    val levelArray = arrayOf(
        intArrayOf(-5, -7, 11, 3, 10),
        intArrayOf(-7, -11, 5, 13, 10)
    )

    var currentLevel = 0

    var mainValue = 0
    var noTrials = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGame2Binding.inflate(layoutInflater)

        counterTextView = binding.counterTextView
        levelTextView = binding.levelTextView

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

        //setContentView(R.layout.activity_game2)

    }

    fun initLayout() {
        val initTable = levelArray[currentLevel]

        leftInit = initTable[0]
        rightInit = initTable[1]
        upInit = initTable[2]
        downInit = initTable[3]

        binding.viewLeft.text = initText(leftInit)
        binding.viewRight.text = initText(rightInit)
        binding.viewDown.text = initText(downInit)
        binding.viewUp.text = initText(upInit)
        mainValue = initTable[4]


        binding.centerView.text = "$mainValue"
        levelTextView.text = "..."
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
            Toast.makeText(this, "Gra ukończona po ${noTrials} próbach.", Toast.LENGTH_LONG)
                .show()
            currentLevel++
            if (currentLevel >= levelArray.size) {
                endGame()
            }
            resetGame()
        }

    }

    fun resetGame() {
        mainValue = Random.nextInt(10, 100)
        noTrials = 0
        binding.centerView.text = "$mainValue"
        counterTextView.text = "$noTrials"

        initLayout()
    }

    fun endGame() {
        currentLevel = 0
        Toast.makeText(this, "Gra ukończona", Toast.LENGTH_LONG).show()
    }
}