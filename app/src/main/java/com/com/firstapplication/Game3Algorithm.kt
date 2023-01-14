package com.com.firstapplication

import android.util.Log

class Game3Algorithm {
    val tag = "GameArray"
    val size = 3

    var levelTable = arrayOf(
        intArrayOf(0, 0, 1),
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0)
    )

    fun arrayRowToString(row: Int): String {
        var rowText = ""
        for (j in 0..size) {
            rowText += "${levelTable[row][j]} "
        }
        return rowText
    }

    fun printGameArray() {
        Log.i(tag, "Game array:")
        for (row in 0..size) {
            Log.i(tag, arrayRowToString(row))
        }
    }

    fun invertRegion(row: Int, col: Int){

    }
}