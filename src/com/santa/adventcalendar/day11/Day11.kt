package com.santa.adventcalendar.day11

import readInput

fun main() {
    val depths = readOctopi()
    val helper = OctopitHelper(depths)
    //val nFlashes = helper.getNFlashes(100)
    val nTurns = helper.getTurnAllFlash()
    //println("nFlashes = $nFlashes")
    println("nTurns until party = $nTurns")
}

fun readOctopi(): Array<Array<Int>> {
    return readInput("day11Octopi").map { line ->
        getRowArray(line)
    }.toTypedArray()
}

fun getRowArray(line: String): Array<Int> {
    return line.map {
        Integer.parseInt(it.toString())
    }.toTypedArray()
}
