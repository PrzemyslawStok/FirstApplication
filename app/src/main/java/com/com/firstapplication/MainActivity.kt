package com.com.firstapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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