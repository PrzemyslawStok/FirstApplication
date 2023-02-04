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

    val gameboardSize = 5

    var gameViewArray = Array(gameboardSize) {
        //BooleanArray(gameboardSize) { false }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGame3Binding.inflate(layoutInflater)
        testButton = binding.testButton
        gameboardView = binding.gameboardView
        gameAlg = Game3Algorithm(size = gameboardSize)

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
                val r = Random.nextInt(100, 255)
                val color = Color.rgb(r, r, r)
                view.setBackgroundColor(color)
                gameboardView.addView(view, params)

            }

        //drawGameboard()

        testButton.setOnClickListener {
            gameAlg.testGameAgl()
        }
    }

    fun drawGameboard() {
        for (row in 0..gameboardSize - 1)
            for (col in 0..gameboardSize - 1) {
                val view = View(this)
                val r = Random.nextInt(100, 255)
                val color = Color.rgb(r, r, r)
                view.setBackgroundColor(color)
            }
    }
}