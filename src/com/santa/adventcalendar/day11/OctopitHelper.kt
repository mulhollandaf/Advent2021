package com.santa.adventcalendar.day11

class OctopitHelper(val octopi: Array<Array<Int>>) {
    private val xSize = octopi[0].size
    private val ySize = octopi.size
    fun getNFlashes(nTurns: Int): Int {
        var nFlashes = 0
        for (x in 0 until nTurns)
        nFlashes += flashesFromTurn()
        return nFlashes
    }

    private fun flashesFromTurn(): Int {
        increaseAllEnergyBy1()
        var nFlashes = 0
        var newFlashes = checkForFlashes()
        while (newFlashes > 0) {
            nFlashes += newFlashes
            newFlashes = checkForFlashes()
        }

        return nFlashes
    }

    private fun checkForFlashes(): Int {
        var nFlashes = 0
        octopi.forEachIndexed { y, row ->
            row.forEachIndexed { x, cell ->
                if (cell > 9) {
                    nFlashes++
                    flash(x, y)
                }
            }
        }
        return nFlashes
    }

    private fun flash(x: Int, y: Int) {
        octopi[y][x] = 0
        incrementNeighbors(x, y)
    }

    private fun incrementNeighbors(x: Int, y: Int) {
        incrementNeighbor(x + 1, y)
        incrementNeighbor(x + 1, y + 1)
        incrementNeighbor(x + 1, y - 1)
        incrementNeighbor(x, y + 1)
        incrementNeighbor(x, y - 1)
        incrementNeighbor(x - 1, y)
        incrementNeighbor(x - 1, y + 1)
        incrementNeighbor(x - 1, y - 1)
    }

    private fun incrementNeighbor(x: Int, y: Int) {
        if (x >= xSize || x < 0 || y >= ySize || y < 0 || octopi[y][x] == 0) {
            return
        } else {
            octopi[y][x]++
        }
    }

    private fun increaseAllEnergyBy1() {
        octopi.forEachIndexed { y, row ->
            row.forEachIndexed { x, cell ->
                octopi[y][x] = cell + 1
            }
        }
    }

    fun getTurnAllFlash(): Int {
        var nFlashes = 0
        var nTurns = 0
        while (nFlashes != xSize * ySize) {
            nFlashes = flashesFromTurn()
            nTurns++
        }
        return nTurns
    }

}
