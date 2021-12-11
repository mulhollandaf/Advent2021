package com.santa.adventcalendar.day10

import readInput

fun main() {
    val syntaxLines = readInput("day10Syntax")
    val helper = SyntaxHelper()
    val error = helper.getTotalError(syntaxLines)
    val incomplete = helper.getMiddleIncomplete(syntaxLines)
    println("Error is $error middle incomplete = $incomplete")
}