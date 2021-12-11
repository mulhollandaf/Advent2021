package com.santa.adventcalendar.day9

import readInput

fun main() {
    val depths = readHeights()
    val helper = HeightmapHelper(depths)
    val sum = helper.findLowPointsTotal()
    val basinProduct = helper.getTotalSizeOfThreeBiggestBasins()
    println("sum = $sum basinProduct = $basinProduct")
}

fun readHeights(): Array<Array<Int>> {
    return readInput("day9Heights").map { line ->
        getRowArray(line)
    }.toTypedArray()
}

fun getRowArray(line: String): Array<Int> {
    return line.map {
        Integer.parseInt(it.toString())
    }.toTypedArray()
}
