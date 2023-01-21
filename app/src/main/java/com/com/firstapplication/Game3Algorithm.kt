package com.com.firstapplication

import android.util.Log

class Game3Algorithm {
    val tag = "GameArray"
    val size = 5

    var gameArray = arrayOf(
        booleanArrayOf(false, false, false, false, true),
        booleanArrayOf(false, false, false, false, false),
        booleanArrayOf(false, false, false, false, false),
        booleanArrayOf(false, false, false, false, false),
        booleanArrayOf(false, false, false, false, false)
    )

    fun arrayRowToString(row: Int): String {
        var rowText = ""
        for (j in 0..size - 1) {
            rowText += "${gameArray[row][j]} "
        }
        return rowText
    }

    fun printGameArray() {
        Log.i(tag, "Game array:")
        for (row in 0..size - 1) {
            Log.i(tag, arrayRowToString(row))
        }
    }

    fun invertRegion(row: Int, col: Int) {
        printGameArray()


        for (i in row - 1..row + 1)
            for (j in col - 1..col + 1) {

            }

        gameArray[row][col] = !gameArray[row][col]

        printGameArray()
    }

    fun testGameAgl() {
        invertRegion(1, 1)
    }
}