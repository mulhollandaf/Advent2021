package com.santa.adventcalendar.day3

fun main() {
    part2()
}

fun part1() {
    val input = binaryInput
    val binaryHelper = BinaryHelper()
    val gamma = binaryHelper.getGammaRate(input)
    val epsilon = binaryHelper.getEpsilonRate(input)
    val intGamma = binaryHelper.toInt(gamma)
    val intEpsilon = binaryHelper.toInt(epsilon)
    println("gamma = $intGamma epsilon = $intEpsilon product = ${intGamma * intEpsilon}")
}

fun part2() {
    val input = binaryInput
    val binaryHelper = BinaryHelper()
    val oxygen = binaryHelper.getOxygenRate(input)
    val co2 = binaryHelper.getCO2Rate(input)
    val intOxygen = binaryHelper.toInt(oxygen)
    val intCO2 = binaryHelper.toInt(co2)
    println("oxygen = $intOxygen co2 = $intCO2 product = ${intOxygen * intCO2}")
}