package com.santa.adventcalendar.day9

class HeightmapHelper(val board: Array<Array<Int>>) {

    private val xSize = board.size
    private val ySize = board[0].size

    fun isLeftLowerOrSame(x: Int, y: Int): Boolean {
        if (x <= 0) return false
        return (board[x-1][y] <= board[x][y])
    }

    fun isRightLowerOrSame(x: Int, y: Int): Boolean {
        if (x >= xSize - 1) return false
        return (board[x+1][y] <= board[x][y])
    }

    fun isUpLowerOrSame(x: Int, y: Int): Boolean {
        if (y == 0) return false
        return (board[x][y-1] <= board[x][y])
    }

    fun isDownLowerOrSame(x: Int, y: Int): Boolean {
        if (y >= ySize - 1) return false
        return (board[x][y+1] <= board[x][y])
    }

    fun findLowPointsTotal(): Int {
        var total = 0
        for (x in 0 until xSize) {
            for (y in 0 until ySize) {
                if (isLowest(x, y)) {
                    total += board[x][y] + 1
                }
            }
        }

        return total
    }

    fun isLowest(x: Int, y: Int): Boolean {
        return (!isLeftLowerOrSame(x, y) && !isRightLowerOrSame(x, y) && !isUpLowerOrSame(x, y) && !isDownLowerOrSame(x, y))
    }

    fun isPartOfBasin(x: Int, y: Int, nX: Int, nY: Int): Boolean {
        if (currentBasin.contains(Pair(nX, nY)) || isInvalid(nX, nY)) {
            return false
        }
        if (nX == 1 && nY == 8) {
            val stop = true
        }
        val xMinus = nX - 1
        val yMinus = nY - 1
        val xPlus = nX + 1
        val yPlus = nY + 1
        if (board[nX][nY] == 9)
            return false
        val checkLeft = isInvalid(xMinus, nY) ||
                board[xMinus][nY] >= board[nX][nY] ||
                (xMinus == x && nY == y) ||
                currentBasin.contains(Pair(xMinus, nY))
        val checkRight = isInvalid(xPlus, nY) ||
                board[xPlus][nY] >= board[nX][nY] ||
                (xPlus == x && nY == y) ||
                currentBasin.contains(Pair(xPlus, nY))
        val checkUp = isInvalid(nX, yPlus) ||
                board[nX][yPlus] >= board[nX][nY] ||
                (nX == x && yPlus == y) ||
                currentBasin.contains(Pair(nX, yPlus))
        val checkDown = isInvalid(nX, yMinus) ||
                board[nX][yMinus] >= board[nX][nY] ||
                (nX == x && yMinus == y) ||
                currentBasin.contains(Pair(nX, yMinus))

        return checkLeft && checkRight && checkUp && checkDown
    }

    private fun isInvalid(x: Int, y: Int): Boolean {
        if (x < 0 || x > xSize - 1 || y < 0 || y > ySize - 1)
            return true
        return false
    }

    private var currentBasin = mutableListOf<Pair<Int, Int>>()

    fun getBasin(point: Pair<Int, Int>): List<Pair<Int, Int>> {
        currentBasin = mutableListOf()
        val x = point.first
        val y = point.second
        getBasinRecursive(x, y)
        return currentBasin
    }

    private fun getBasinRecursive(x: Int, y: Int) {
        currentBasin.add(Pair(x, y))
        if (isPartOfBasin(x, y, x-1, y)) {
            getBasinRecursive(x - 1, y)
        }
        if (isPartOfBasin(x, y, x+1, y)) {
            getBasinRecursive(x + 1, y)
        }
        if (isPartOfBasin(x, y, x, y - 1)) {
            getBasinRecursive(x, y - 1)
        }
        if (isPartOfBasin(x, y, x, y + 1)) {
            getBasinRecursive(x, y + 1)
        }
    }

    fun getAllBasins(): List<List<Pair<Int, Int>>> {
        val lowPoints = getAllLowestPoints()
        return lowPoints.map { lowestPoint ->
            getBasin(lowestPoint)
        }
    }

    private fun getAllLowestPoints(): List<Pair<Int, Int>> {
        val lowest = mutableListOf<Pair<Int, Int>>()
        for (x in 0 until xSize) {
            for (y in 0 until ySize) {
                if (isLowest(x, y)) {
                    lowest.add(Pair(x, y))
                }
            }
        }

        return lowest
    }

    fun getTotalSizeOfThreeBiggestBasins(): Int {
        val basins = getAllBasins()
        val sorted = basins.sortedByDescending { it.size }
        return sorted[0].size * sorted[1].size * sorted[2].size
    }
}