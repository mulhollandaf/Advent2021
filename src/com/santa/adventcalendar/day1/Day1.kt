package com.santa.adventcalendar.day1

fun main() {
    part2()
}

fun part1() {
    val input = DepthInput().depths
    val depthHelper = DepthHelper()
    val increases = depthHelper.countIncreases(input)

    println("Number of increases = $increases")
}

fun part2() {
    val input = DepthInput().depths
    val depthHelper = DepthHelper()
    val increases = depthHelper.windowIncreases(input)
    println("Number of windowed increases = $increases")
}