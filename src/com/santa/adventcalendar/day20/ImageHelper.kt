package com.santa.adventcalendar.day20

class ImageHelper {
    fun getNeighbors(trenchMap: Array<Array<Int>>, x: Int, y:Int): List<Int> {
        val neighbors = mutableListOf<Int>()
        for (x in x-1..x+1) {
            for (y in y-1..y+1) {
                if (x < 0 || y < 0 || x >= trenchMap.size || y >= trenchMap[0].size) {
                    neighbors.add(0)
                } else {
                    neighbors.add(trenchMap[x][y])
                }
            }
        }
        /* neighbors.add(trenchMap[x-1][y-1])
        neighbors.add(trenchMap[x-1][y])
        neighbors.add(trenchMap[x-1][y+1])
        neighbors.add(trenchMap[x][y-1])
        neighbors.add(trenchMap[x][y])
        neighbors.add(trenchMap[x][y+1])
        neighbors.add(trenchMap[x+1][y-1])
        neighbors.add(trenchMap[x+1][y])
        neighbors.add(trenchMap[x+1][y+1]) */
        return neighbors
    }

    fun getPixelIndex(neighborsList: List<Int>): Int {
        var pixelIndex = 0
        var curBinary = 256
        neighborsList.forEach{ neighbor ->
            pixelIndex += neighbor * curBinary
            curBinary /= 2
        }
        return pixelIndex
    }

    fun getPixelBrightness(key: Array<Int>, pixelIndex: Int): Int {
        return key[pixelIndex]
    }

    fun addRing(trenchMap: Array<Array<Int>>, increase: Int): Array<Array<Int>> {
        val xSize = trenchMap.size
        val ySize = trenchMap[0].size
        return Array(xSize + increase * 2) { x->
            Array(ySize + increase * 2) { y ->
                val oldX = x - increase
                val oldY = y - increase
                if (oldX < 0 || oldY < 0 || oldX >= xSize || oldY >= ySize) {
                    0
                } else {
                    trenchMap[oldX][oldY]
                }
            }
        }
    }

    fun createKey(keyString: String): Array<Int> {
        return keyString.map { letter ->
            if (letter == '#') 1 else 0
        }.toTypedArray()
    }

    fun transform(grid: Array<Array<Int>>, key: Array<Int>): Array<Array<Int>> {
        return Array(grid.size) { x ->
            Array(grid[0].size) { y ->
                val neighbors = getNeighbors(grid, x, y)
                val index = getPixelIndex(neighbors)
                getPixelBrightness(key, index)
            }
        }
    }

    fun getLit(transformed: Array<Array<Int>>, cutSize: Int): Int {
        var sum = 0
        val xSize = transformed.size
        val ySize = transformed[0].size
        transformed.forEachIndexed { x, column ->
            column.forEachIndexed { y, cell ->
                if (x <= cutSize || y <= cutSize || x >= xSize - cutSize || y >= ySize - cutSize) {
                    //cut this
                } else {
                    sum += cell
                }
            }
        }
        return sum
    }


}
