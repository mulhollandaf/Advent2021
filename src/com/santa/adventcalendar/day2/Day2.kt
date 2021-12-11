package com.santa.adventcalendar.day2

fun main() {
    part2()
}

fun part1() {
    val inputs = directionInput
    val locationHelper = LocationHelper(false)
    val location = locationHelper.move(inputs)
    println("Location depth = ${location.depth} position = ${location.position} aim = ${location.aim}")
    println("product = ${location.depth * location.position}")
}

fun part2() {
    val inputs = directionInput
    val locationHelper = LocationHelper(true)
    val location = locationHelper.move(inputs)
    println("Location depth = ${location.depth} position = ${location.position} aim = ${location.aim}")
    println("product = ${location.depth * location.position}")
}