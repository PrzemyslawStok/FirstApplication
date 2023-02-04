package com.com.firstapplication

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.gridlayout.widget.GridLayout
import com.com.firstapplication.databinding.ActivityGame3Binding
import kotlin.random.Random

class Game3Activity : AppCompatActivity() {
    lateinit var binding: ActivityGame3Binding
    lateinit var gameboardView: GridLayout
    lateinit var testButton: Button

    lateinit var gameAlg: Game3Algorithm
    var trueColor: Int? = null
    var falseColor: Int? = null

    val gameboardSize = 5

    var gameViewArray = Array(gameboardSize) {
        Array<View?>(gameboardSize) { null }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGame3Binding.inflate(layoutInflater)
        testButton = binding.testButton
        gameboardView = binding.gameboardView
        gameAlg = Game3Algorithm(size = gameboardSize)

        trueColor = Color.rgb(200, 200, 200)
        falseColor = Color.rgb(100, 100, 100)

        setContentView(binding.root)

        gameboardView.rowCount = gameboardSize
        gameboardView.columnCount = gameboardSize

        val params = android.widget.GridLayout.LayoutParams(
            android.widget.GridLayout.spec(android.widget.GridLayout.UNDEFINED, 1f),
            android.widget.GridLayout.spec(android.widget.GridLayout.UNDEFINED, 1f)
        )

        params.width = 100
        params.height = 100

        for (row in 0..gameboardSize - 1)
            for (col in 0..gameboardSize - 1) {
                val view = View(this)
                gameViewArray[row][col] = view
                gameboardView.addView(gameViewArray[row][col], params)
            }

        drawGameboard()

        testButton.setOnClickListener {
            gameAlg.testGameAgl()
            drawGameboard()
        }
    }

    fun drawGameboard() {
        for (row in 0..gameboardSize - 1)
            for (col in 0..gameboardSize - 1) {

                val view = gameViewArray[row][col]
                val field = gameAlg.gameArray[row][col]

                if (field)
                    trueColor?.let { view?.setBackgroundColor(it) }
                else
                    falseColor?.let { view?.setBackgroundColor(it) }


            }
    }
}