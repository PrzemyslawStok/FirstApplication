package com.com.firstapplication

import android.util.Log
import kotlin.random.Random

class Game3Algorithm(size: Int) {
    val tag = "GameArray"

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
        //printGameArray()

        for (i in row - 1..row + 1)
            for (j in col - 1..col + 1) {
                if (i >= 0 && i < gameArray.size && j >= 0 && j < gameArray.size)
                    gameArray[i][j] = !gameArray[i][j]
            }


        //printGameArray()
    }

    fun testGameAgl() {
        invertRegion(2, 2)
    }

    fun resetGameArray() {
        for (row in 0..gameArray.size - 1) {
            for (col in 0..gameArray.size - 1) {
                gameArray[row][col] = false
            }
        }

        addRandomMoves(3)
    }

    fun checkGameArray(): Boolean {
        var gameEnd = true
        for (row in 0..gameArray.size - 1) {
            for (col in 0..gameArray.size - 1) {
                if (gameArray[row][col] == false) {
                    gameEnd = false
                }
            }
        }
        Log.v(tag, "checkGame: $gameEnd")
        return gameEnd
    }

    fun addRandomMoves(moves: Int) {
        for (i in 0..moves) {
            val row = Random.nextInt(0, gameArray.size - 1)
            val col = Random.nextInt(0, gameArray.size - 1)
            invertRegion(row, col)
        }
    }
}