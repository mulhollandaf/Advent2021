package com.santa.adventcalendar.day13

import readInput

fun main() {
    val points = readPoints()
    val helper = FoldHelper(points)
    //fold along x=655
    helper.fold(true, 655)
    //fold along y=447
    helper.fold(false, 447)
    //fold along x=327
    helper.fold(true, 327)
    //fold along y=223
    helper.fold(false, 223)
    //fold along x=163
    helper.fold(true, 163)
    //fold along y=111
    helper.fold(false, 111)
    //fold along x=81
    helper.fold(true, 81)
    //fold along y=55
    helper.fold(false, 55)
    //fold along x=40
    helper.fold(true, 40)
    //fold along y=27
    helper.fold(false, 27)
    //fold along y=13
    helper.fold(false, 13)
    //fold along y=6
    helper.fold(false, 6)
    //val count = helper.countDots()
    //println("$count stars in the sky")
    println(helper.getGridString())
}

fun readPoints(): Array<Pair<Int, Int>> {
    val lines = readInput("day13Points")
    return lines.map {
        val parts = it.split(",")
        Pair(parts[0].toInt(), parts[1].toInt())
    }.toTypedArray()
}
