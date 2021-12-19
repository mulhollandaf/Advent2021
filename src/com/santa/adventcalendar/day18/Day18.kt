package com.santa.adventcalendar.day18

import readInput

fun main() {
    val helper = SnailFishHelper()
    val inputs = readInput("day18Snails").toTypedArray()
    val maxMagnitude = getMaxMagnitude(inputs)
    val num = helper.addReduce(inputs)
    val mag = helper.getMagnitude(num)
    println("Finally $maxMagnitude")
}

fun getMaxMagnitude(inputs: Array<String>): Int {
    var max = 0
    val helper = SnailFishHelper()
    inputs.forEach { first ->
        inputs.forEach { second ->
            val num = helper.add(first, second)
            val reduce = helper.reduce(num)
            val mag = helper.getMagnitude(reduce)
            if (mag > max) {
                max = mag
            }
        }
    }
    return max
}
