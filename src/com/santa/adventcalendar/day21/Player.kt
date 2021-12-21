package com.santa.adventcalendar.day21


class Player(var currentSpace: Int) {
    fun move(diceRoll: Int) {
        currentSpace += diceRoll
    }

}
