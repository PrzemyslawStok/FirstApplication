package com.com.firstapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.gridlayout.widget.GridLayout
import com.com.firstapplication.databinding.ActivityGame3Binding

class Game3Activity : AppCompatActivity() {
    lateinit var binding: ActivityGame3Binding
    lateinit var gameboardView: GridLayout
    lateinit var testButton: Button

    val gameboardSize = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGame3Binding.inflate(layoutInflater)
        testButton = binding.testButton
        gameboardView = binding.gameboardView

        setContentView(binding.root)

        val gameAgl = Game3Algorithm(size = gameboardSize)

        gameboardView.rowCount = gameboardSize
        gameboardView.columnCount = gameboardSize

        testButton.setOnClickListener {
            gameAgl.testGameAgl()
        }
    }
}