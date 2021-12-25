package com.santa.adventcalendar.day19

import java.io.File

fun main() {
    val input = File("input", "day19Scanners.txt").readText()
    val helper = ScannerHelper(input)
    val solution = helper.solve()
    println("Beacons - ${solution.beacons.size}")
}