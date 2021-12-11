package com.santa.adventcalendar.day5

import readInput

fun main() {
    val vents = readInVents()
    val board = VentBoard(1000)
    val ventHelper = VentHelper(board, true)
    vents.forEach { vent ->
        ventHelper.addVent(vent[0], vent[1], vent[2], vent[3])
    }
    val nIntersections = ventHelper.getNumberOfIntersections()
    println("nIntersections = $nIntersections")
}

fun readInVents(): List<Array<Int>> {
    val vents = mutableListOf<Array<Int>>()
    val lines = readInput("day5Vents")
    lines.forEach{ line ->
        vents.add(parseLine(line))
    }
    return vents
}

fun parseLine(line: String): Array<Int> {
    val parts = line.split("->")
    val first = parts[0].split(",")
    val second = parts[1].split(",")
    val x1 = Integer.parseInt(first[0].trim())
    val y1 = Integer.parseInt(first[1].trim())
    val x2 = Integer.parseInt(second[0].trim())
    val y2 = Integer.parseInt(second[1].trim())
    return arrayOf(x1, y1, x2, y2)
}
