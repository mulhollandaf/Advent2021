package com.santa.adventcalendar.day21

class Dice(var lastRoll: Int = 0) {
    fun getTripleDiceRoll(): Int {
        var totalRoll = 0
        for (eachRoll in 1 .. 3) {
            if (lastRoll == 100) {
                lastRoll = 1
            } else {
                lastRoll += 1
            }
            totalRoll += lastRoll
        }

        return totalRoll
    }
}