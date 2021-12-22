package com.santa.adventcalendar.day21

class DiracHelper(start1: Int, start2: Int) {
    var nP1Turns: Int = 0
    var nP2Turns: Int = 0
    val player1 = Player(start1)
    val player2 = Player(start2)
    val dice = Dice(0)

    fun player1Turn() {
        player1.move(dice.getTripleDiceRoll())
        nP1Turns++
    }

    fun player2Turn() {
        player2.move(dice.getTripleDiceRoll())
        nP2Turns++
    }

    fun playGame() {
        while (player2.totalScore < 1000 && player1.totalScore < 1000) {
            player1Turn()
            if (player1.totalScore < 1000) {
                player2Turn()
            }
        }
    }

    fun diceRolls(): Int {
        return (nP1Turns + nP2Turns) * 3
    }

}
