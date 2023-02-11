package com.com.firstapplication

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.com.firstapplication.databinding.ActivityGame3Binding

class Game3Activity : AppCompatActivity() {
    lateinit var binding: ActivityGame3Binding
    lateinit var gameboardView: GridLayout
    lateinit var testButton: Button

    lateinit var gameAlg: Game3Algorithm
    var trueColor: Int? = null
    var falseColor: Int? = null

    var trueBackround: GradientDrawable? = null
    var falseBackground: GradientDrawable? = null

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

        for (row in 0..gameboardSize - 1)
            for (col in 0..gameboardSize - 1) {
                val view = View(this)

                view.setPadding(2, 2, 2, 2)

                view.setOnClickListener {
                    gameAlg.invertRegion(row, col)
                    drawGameboard()
                }

                val params = GridLayout.LayoutParams(
                    GridLayout.spec(GridLayout.UNDEFINED, 1f),
                    GridLayout.spec(GridLayout.UNDEFINED, 1f)
                )

                params.width = 0
                params.height = 0

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
                    trueColor?.let {
                        view?.setBackgroundColor(it)
                    }
                else
                    falseColor?.let { view?.setBackgroundColor(it) }



            }
    }
}