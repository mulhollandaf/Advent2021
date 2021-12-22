package com.santa.adventcalendar.day21

import org.junit.Test
import kotlin.test.assertEquals

class Day21UnitTests {

    @Test
    fun rollTest(){
        val lastRoll = 100
        val dice = Dice(lastRoll)
        val diceRoll = dice.getTripleDiceRoll()
        assertEquals(6, diceRoll)
    }

    @Test
    fun rollTwoTest(){
        val lastRoll = 3
        val dice = Dice(lastRoll)
        val diceRoll = dice.getTripleDiceRoll()
        assertEquals(15, diceRoll)
    }

    @Test
    fun moveToNewSpaceTest(){
        val player1 = Player(4)
        val dice = Dice(0)
        player1.move(dice.getTripleDiceRoll())
        assertEquals(10, player1.currentSpace)
    }

    @Test
    fun moveWrapTest(){
        val player1 = Player(6)
        val dice = Dice(0)
        player1.move(dice.getTripleDiceRoll())
        assertEquals(2, player1.currentSpace)
    }

    @Test
    fun pointsTest() {
        val player1 = Player(4)
        val dice = Dice(0)
        player1.move(dice.getTripleDiceRoll())
        assertEquals(10, player1.totalScore)
    }

    @Test
    fun turnTrackerTest() {
        val helper = DiracHelper(4, 8)
        helper.player1Turn()
        assertEquals(1, helper.nP1Turns)
        assertEquals(10, helper.player1.totalScore)
    }

    @Test
    fun turnTracker2Test() {
        val helper = DiracHelper(4, 8)
        helper.player1Turn()
        helper.player2Turn()
        assertEquals(1, helper.nP2Turns)
        assertEquals(3, helper.player2.totalScore)
    }

    @Test
    fun playGameTest() {
        val helper = DiracHelper(4, 8)
        helper.playGame()
        assertEquals(1000, helper.player1.totalScore)
        assertEquals(745, helper.player2.totalScore)
        assertEquals(993, helper.diceRolls())
    }

    @Test
    fun playGameFinalTest() {
        val helper = DiracHelper(8, 10)
        helper.playGame()
        assertEquals(1000, helper.player1.totalScore)
        assertEquals(810, helper.player2.totalScore)
        assertEquals(747, helper.diceRolls())
    }

    @Test
    fun playQuantumGameTest() {
        val game = QuantumGame(4, 8)
        val score = game.play(game.initialState)
        assertEquals(444356092776315, score.first)
        assertEquals(341960390180808, score.second)
    }

    @Test
    fun playQuantumGameFinal() {
        val game = QuantumGame(8, 10)
        val score = game.play(game.initialState)
        assertEquals(218433063958910, score.first)
        assertEquals(189371397363999, score.second)
    }
}