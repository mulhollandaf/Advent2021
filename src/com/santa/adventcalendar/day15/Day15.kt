package com.santa.adventcalendar.day15

import readInput

fun main() {
    val lines = readInput("day15Grid").toTypedArray()
    val helper = ChitonHelper(InputHelper().parse(lines))
    helper.expand()
    val easiest = helper.findBestPath()
    println("Easy Peasy $easiest")
}