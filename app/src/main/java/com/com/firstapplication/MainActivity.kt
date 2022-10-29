package com.com.firstapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var counterText: TextView? = null
    var mainBackround: LinearLayout? = null
    var resetButton: Button? = null

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainBackround = findViewById(R.id.mainBackground)
        counterText = findViewById(R.id.counterTextView)
        resetButton = findViewById(R.id.resetButton)

        counterText?.text = "${counter}"

        mainBackround?.setOnClickListener {
            counter += 1
            counterText?.text = "${counter}"
        }

        mainBackround?.setOnLongClickListener {
            counter = 0
            counterText?.text = "${counter}"
            true
        }

        resetButton?.setOnClickListener {
            counter = 0
            counterText?.text = "${counter}"
        }

    }

    fun f0() {
        val tag = "MainActivity"

        val a = 10.0f
        println("Wprowadzono liczbę: ${a}")
        Log.i("MainActivity", "Wprowadzono liczbę: ${a}")

        for (i in 1..10) {
            Log.i(tag, "$i")
        }

        val x = 1.0
        val y = 2.0

        Log.i(tag, "$x+$y=${add(x, y)}")

        val A = mutableListOf(1, 2, 3, 4, 5)
        A.add(20)


        for (a0 in A) {
            Log.i(tag, "$a0")
        }

        val B = IntArray(10) { it + 1 }

        for (b0 in B) {
            Log.i(tag, "$b0")
        }
    }

    fun add(a: Double, b: Double): Double {
        return a + b
    }

}