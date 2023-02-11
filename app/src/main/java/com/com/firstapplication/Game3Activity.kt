package com.com.firstapplication

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.com.firstapplication.databinding.ActivityGame3Binding

class Game3Activity : AppCompatActivity() {
    lateinit var binding: ActivityGame3Binding
    lateinit var gameboardView: GridLayout
    lateinit var resetButton: Button

    lateinit var trialsTextView: TextView

    lateinit var gameAlg: Game3Algorithm
    var trueColor: Int? = null
    var falseColor: Int? = null

    var trueBackround: Drawable? = null
    var falseBackground: Drawable? = null

    val gameboardSize = 5
    var trialsNumber = 0

    var gameViewArray = Array(gameboardSize) {
        Array<View?>(gameboardSize) { null }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGame3Binding.inflate(layoutInflater)
        resetButton = binding.resetButton
        gameboardView = binding.gameboardView
        trialsTextView = binding.trialsNumberTextView

        gameAlg = Game3Algorithm(size = gameboardSize)
        gameAlg.resetGameArray()

        trueColor = Color.rgb(200, 200, 200)
        falseColor = Color.rgb(100, 100, 100)

        trueBackround = ResourcesCompat.getDrawable(resources, R.drawable.true_background, null)
        falseBackground = ResourcesCompat.getDrawable(resources, R.drawable.false_background, null)

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
                    if (checkGame()) {
                        Toast.makeText(
                            this,
                            "Poziom ukończony po ${trialsNumber} próbach.",
                            Toast.LENGTH_LONG
                        )
                            .show()
                        trialsNumber = 0
                        trialsTextView.text = "${trialsNumber}"
                        resetGame()
                    } else {
                        trialsNumber++
                        trialsTextView.text = "${trialsNumber}"
                    }
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

        resetButton.setOnClickListener {
            resetGame()
        }
    }

    fun drawGameboard() {
        for (row in 0..gameboardSize - 1)
            for (col in 0..gameboardSize - 1) {

                val view = gameViewArray[row][col]
                val field = gameAlg.gameArray[row][col]

                if (field)
                    trueBackround?.let {
                        view?.background = it
                    }
                else
                    falseBackground?.let { view?.background = it }

            }
    }

    fun resetGame() {
        gameAlg.resetGameArray()
        drawGameboard()
        trialsNumber = 0
        trialsTextView.text = "${trialsNumber}"
    }

    fun checkGame(): Boolean {
        return gameAlg.checkGameArray()
    }
}