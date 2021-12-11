package com.santa.adventcalendar.day7

import org.junit.Test
import kotlin.test.assertEquals

class Day7UnitTest {
    @Test
    fun costToMoveCrabTest(){
        val miniSubHelper = MiniSubHelper()
        val cost = miniSubHelper.getMoveCost(3, 7)
        assertEquals(4, cost)
    }
    @Test
    fun costToMoveCrabBackTest(){
        val miniSubHelper = MiniSubHelper()
        val cost = miniSubHelper.getMoveCost(7, 2)
        assertEquals(5, cost)
    }

    @Test
    fun costMoveRowToTest() {
        val miniSubHelper = MiniSubHelper()
        val cost = miniSubHelper.moveSetTo(arrayOf(3, 4), 7)
        assertEquals(7, cost)
    }

    @Test
    fun findMostEfficientTest() {
        val miniSubHelper = MiniSubHelper()
        val mostEfficient = miniSubHelper.getMostEfficient(arrayOf(3, 4, 5))
        assertEquals(4, mostEfficient)
    }

    @Test
    fun findMostEfficientDataTest() {
        val miniSubHelper = MiniSubHelper()
        val mostEfficient = miniSubHelper.getMostEfficient(arrayOf(16,1,2,0,4,2,7,1,2,14))
        assertEquals(2, mostEfficient)
        val cost = miniSubHelper.moveSetTo(arrayOf(16,1,2,0,4,2,7,1,2,14), 2)
        assertEquals(37, cost)
    }

    @Test
    fun costToMoveCrabHardTest(){
        val miniSubHelper = MiniSubHelper()
        val cost = miniSubHelper.getMoveCostHard(3, 7)
        assertEquals(10, cost)
    }

    @Test
    fun costToMoveCrabBackHardTest(){
        val miniSubHelper = MiniSubHelper(true)
        val cost = miniSubHelper.getMoveCostHard(7, 2)
        assertEquals(15, cost)
    }

    @Test
    fun costMoveRowToHardTest() {
        val miniSubHelper = MiniSubHelper(true)
        val cost = miniSubHelper.moveSetTo(arrayOf(3, 4), 7)
        assertEquals(16, cost)
    }

    @Test
    fun findMostEfficientHardTest() {
        val miniSubHelper = MiniSubHelper(true)
        val mostEfficient = miniSubHelper.getMostEfficient(arrayOf(3, 4, 5))
        assertEquals(4, mostEfficient)
    }

    @Test
    fun findMostEfficientDataHardTest() {
        val miniSubHelper = MiniSubHelper(true)
        val mostEfficient = miniSubHelper.getMostEfficient(arrayOf(16,1,2,0,4,2,7,1,2,14))
        assertEquals(5, mostEfficient)
        val cost = miniSubHelper.moveSetTo(arrayOf(16,1,2,0,4,2,7,1,2,14), 5)
        assertEquals(168, cost)
    }
}