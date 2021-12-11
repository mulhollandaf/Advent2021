package com.santa.adventcalendar.day5

class VentHelper(private val board: VentBoard, private val includeDiagonals: Boolean = false) {
    fun addVent(x1: Int, y1: Int, x2: Int, y2: Int) {
        if (y1 == y2) {
            if (x1 > x2) {
                placeXVents(x2, x1, y1)
            } else {
                placeXVents(x1, x2, y1)
            }
        } else if (x1 == x2) {
            if (y1 > y2) {
                placeYVents(y2, y1, x1)
            } else {
                placeYVents(y1, y2, x1)
            }
        } else if (includeDiagonals) {
            placeDiagonalVents(x1, y1, x2, y2)
        }
    }

    private fun placeDiagonalVents(x1: Int, y1: Int, x2: Int, y2: Int) {
        val flip = x1 > x2
        val startX = if (x1 > x2) x2 else x1
        val endX = if (x1 > x2) x1 else x2

        val startY = if (flip) y2 else y1

        val xIncrement = if (x1 > x2) -1 else 1
        val yIncrement = if (y1 > y2) -1 else 1

        for(x in 0 .. (endX - startX)) {
           board.gasValues[startX + x][startY + (x) * xIncrement * yIncrement]++
        }

    }

    private fun placeYVents(y1: Int, y2: Int, x: Int) {
        for(y in y1 .. y2) {
            board.gasValues[x][y]++
        }
    }

    private fun placeXVents(x1: Int, x2: Int, y: Int) {
        for (x in x1..x2) {
            board.gasValues[x][y]++
        }
    }

    fun getGasValue(x: Int, y: Int): Int {
        return board.gasValues[x][y]
    }

    fun getNumberOfIntersections(): Int {
        var counter = 0
        board.gasValues.forEach { row ->
            row.forEach {
                if (it >= 2) {
                    counter++
                }
            }
        }
        return counter
    }

}
