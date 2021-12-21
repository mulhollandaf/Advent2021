package com.santa.adventcalendar.day21

class DiracHelper {
    fun getTripleDiceRoll(lastRoll: Int): Int {
        var totalRoll = 0
        var roll = lastRoll

        for (eachRoll in 1 .. 3) {
            if (roll == 100) {
                roll = 1
            } else {
                roll += 1
            }
            totalRoll += roll
        }

        return totalRoll
    }


}
