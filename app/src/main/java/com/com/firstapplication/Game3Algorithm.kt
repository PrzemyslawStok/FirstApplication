package com.com.firstapplication

import android.util.Log

class Game3Algorithm {
    val tag = "GameArray"
    val size = 10

    var gameArray = Array(size) {
        BooleanArray(size) { false }
    }

    fun arrayRowToString(row: Int): String {
        var rowText = ""
        for (j in 0..gameArray.size - 1) {
            rowText += "${gameArray[row][j]} "
        }
        return rowText
    }

    fun printGameArray() {
        Log.i(tag, "Game array:")
        for (row in 0..gameArray.size - 1) {
            Log.i(tag, arrayRowToString(row))
        }
    }

    fun invertRegion(row: Int, col: Int) {
        printGameArray()

        for (i in row - 1..row + 1)
            for (j in col - 1..col + 1) {
                if (i >= 0 && i < gameArray.size && j >= 0 && j < gameArray.size)
                    gameArray[i][j] = !gameArray[i][j]
            }


        printGameArray()
    }

    fun testGameAgl() {
        invertRegion(2, 2)
    }
}