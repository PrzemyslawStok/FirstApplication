package com.com.firstapplication

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.com.firstapplication.databinding.ActivityGame2Binding

class Game2Activity : AppCompatActivity() {
    lateinit var binding: ActivityGame2Binding

    val currentLevelKey = "current_level_key"

    //var counterText: TextView? = null
    lateinit var counterTextView: TextView
    lateinit var levelTextView: TextView
    lateinit var recordTextView: TextView

    var leftInit = 0
    var rightInit = 0
    var downInit = 0
    var upInit = 0

    var levelArray = arrayOf(
        intArrayOf(18, 4, -5, -1, 6, 5),
        intArrayOf(-3, -15, 10, 24, 7, 0),
        intArrayOf(-5, -7, 11, 3, 9, 15),
        intArrayOf(-7, -11, 5, 13, 10, 0),
        intArrayOf(-7, -8, 5, 3, 10, 0)
    )

    var currentLevel = 0
    var currentLevelRecord = 0

    var mainValue = 0
    var noTrials = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGame2Binding.inflate(layoutInflater)

        counterTextView = binding.counterTextView
        levelTextView = binding.levelTextView
        recordTextView = binding.recordTextView

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

    fun getGameState() {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        currentLevel = sharedPref.getInt(currentLevelKey, 0)
    }

    fun saveGameState() {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.putInt(currentLevelKey, currentLevel)
        editor.apply()
    }

    fun initLayout() {
        getGameState()

        val initTable = levelArray[currentLevel]

        leftInit = initTable[0]
        rightInit = initTable[1]
        upInit = initTable[2]
        downInit = initTable[3]
        mainValue = initTable[4]
        currentLevelRecord = initTable[5]


        binding.viewLeft.text = initText(leftInit)
        binding.viewRight.text = initText(rightInit)
        binding.viewDown.text = initText(downInit)
        binding.viewUp.text = initText(upInit)

        binding.centerView.text = "$mainValue"
        levelTextView.text = "${currentLevel + 1}"
        recordTextView.text = "$currentLevelRecord"
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
            Toast.makeText(
                this,
                "Poziom ${currentLevel} ukończony po ${noTrials} próbach.",
                Toast.LENGTH_LONG
            )
                .show()
            currentLevel++
            saveGameState()

            if (currentLevel >= levelArray.size) {
                endGame()
            } else
                levelTextView.text = "${currentLevel + 1}"

            nextLevel()
        }

    }

    fun nextLevel() {
        if (noTrials < currentLevelRecord) {
            currentLevelRecord = noTrials
        }
        noTrials = 0
        counterTextView.text = "$noTrials"

        initLayout()
    }

    fun endGame() {
        currentLevel = 0
        Toast.makeText(this, "Gra ukończona", Toast.LENGTH_LONG).show()
    }
}