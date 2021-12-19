package com.santa.adventcalendar.day18

import readInput

fun main() {
    val helper = SnailFishHelper()
    val inputs = readInput("day18test1").toTypedArray()
    val num = helper.addReduce(inputs)
    println("Finally $num")
}