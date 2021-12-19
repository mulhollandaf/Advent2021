package com.santa.adventcalendar.day15

class ChitonHelper (private val cavern: Array<Array<Int>>) {
    val ySize = cavern.size
    val xSize = cavern[0].size

    val ySizeBig = cavern.size * 5
    val xSizeBig = cavern[0].size * 5

    val bigCavern = expand()

    fun findBestPath(): Int {
        println("Expanded")
        val map = GridMap(bigCavern)
        println("mapMade")
        val start = map.getStart()
        val end = map.getEnd()
        println("Distances")
        return map.getShortestRouteCost(start, end)
    }

    fun expand() : Array<Array<Int>> {
        return Array(ySizeBig) { y ->
            Array(xSizeBig) { x->
                val xAdder = x / xSize
                val yAdder = y / ySize
                val origX = x % xSize
                val origY = y % ySize
                getExpandedValue(cavern[origY][origX] + xAdder + yAdder)
            }
        }
    }

    fun getExpandedValue(value: Int): Int {
        return (value-1) % 9 + 1
    }


}
