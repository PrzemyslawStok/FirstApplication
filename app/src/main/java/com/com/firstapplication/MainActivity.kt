package com.com.firstapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a = 10.0f
        println("Wprowadzono liczbę: ${a}")
        Log.i("MainActivity","Wprowadzono liczbę: ${a}")

        for( i in 1..10){
            println("$i")
        }

    }
}