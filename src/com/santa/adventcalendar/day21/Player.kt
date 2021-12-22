package com.santa.adventcalendar.day21


class Player(var currentSpace: Int) {
    var totalScore = 0
    fun move(diceRoll: Int) {
        currentSpace += diceRoll
        currentSpace = (currentSpace - 1) % 10 + 1
        totalScore += currentSpace
    }
}
