package com.santa.adventcalendar.day21

import org.junit.Test
import kotlin.test.assertEquals

class Day21UnitTests {

    @Test
    fun rollTest(){
        val lastRoll = 100
        val diracHelper = DiracHelper()
        val diceRoll = diracHelper.getTripleDiceRoll(lastRoll)
        assertEquals(6, diceRoll)
    }

    @Test
    fun rollTwoTest(){
        val lastRoll = 3
        val diracHelper = DiracHelper()
        val diceRoll = diracHelper.getTripleDiceRoll(lastRoll)
        assertEquals(15, diceRoll)
    }

    @Test
    fun moveToNewSpaceTest(){
        val player1 = Player(4)
        val helper = DiracHelper()
        player1.move(helper.getTripleDiceRoll(100))
        assertEquals(10, player1.currentSpace)
    }
}