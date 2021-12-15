package com.santa.adventcalendar.day13

import java.lang.Integer.max

class FoldHelper(dotsLocation: Array<Pair<Int, Int>>) {
    private var currentGrid = FoldGrid()
    init {
        currentGrid.placeDots(dotsLocation)
    }
    fun fold(isX: Boolean, x: Int) {
        if (isX) {
            xFold(x)
        } else {
            yFold(x)
        }
    }

    private fun yFold(yFold: Int) {
        val xSize = currentGrid.dots.size
        val oldYSize = currentGrid.dots[0].size
        val ySize = max(yFold, oldYSize - yFold - 1)
        val oldGrid = currentGrid
        currentGrid = FoldGrid()
        currentGrid.createGrid(xSize, ySize)
        for (x in 0 until xSize) {
            for (y in 0 until ySize) {
                val topY = yFold - y - 1
                val bottomY = yFold + y + 1
                val topValue = if (topY >= 0) {
                    oldGrid.dots[x][topY]
                } else false
                val bottomValue = if (bottomY < oldYSize) {
                    oldGrid.dots[x][bottomY]
                } else false
                currentGrid.dots[x][ySize - y - 1] = topValue || bottomValue
            }
        }
    }

    private fun xFold(xFold: Int) {
        val ySize = currentGrid.dots[0].size
        val oldXSize = currentGrid.dots.size
        val xSize = max(xFold, oldXSize - xFold - 1)
        val oldGrid = currentGrid
        currentGrid = FoldGrid()
        currentGrid.createGrid(xSize, ySize)
        for (x in 0 until xSize) {
            for (y in 0 until ySize) {
                val leftX = xFold - x - 1
                val rightX = xFold + x + 1
                val leftValue = if (leftX >= 0) {
                    oldGrid.dots[leftX][y]
                } else false
                val rightValue = if (rightX < oldXSize) {
                    oldGrid.dots[rightX][y]
                } else false
                currentGrid.dots[xSize - x - 1][y] = leftValue || rightValue
            }
        }
    }

    fun getValue(x: Int, y: Int): Boolean {
        return currentGrid.dots[x][y]
    }

    fun countDots(): Int {
        return currentGrid.dots.sumOf { column ->
            column.sumOf {
                if (it) 1L else 0L
            }
        }.toInt()
    }

    fun getGridString(): String {
        val xSize = currentGrid.dots.size
        val ySize = currentGrid.dots[0].size
        val builder = StringBuilder()
        for (y in 0 until ySize) {
            for (x in 0 until xSize) {
                val letter = if (currentGrid.dots[x][y]) "#" else "."
                builder.append(letter)
            }
            builder.append("\r\n")
        }
        return builder.toString()
    }

}
