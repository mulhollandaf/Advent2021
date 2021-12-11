package com.santa.adventcalendar.day5

import org.junit.Test
import kotlin.test.assertEquals

class Day5UnitTest {
    @Test
    fun addVentTestX() {
        val board = VentBoard(10)
        val ventHelper = VentHelper(board)
        ventHelper.addVent(0, 9, 5, 9)
        assertEquals(1, ventHelper.getGasValue(1, 9))
    }

    @Test
    fun addVentTestY() {
        val board = VentBoard(10)
        val ventHelper = VentHelper(board)
        ventHelper.addVent(7, 0, 7, 4)
        assertEquals(1, ventHelper.getGasValue(7, 2))
    }

    @Test
    fun addMultipleVentsTest() {
        val board = VentBoard(10)
        val ventHelper = VentHelper(board)
        ventHelper.addVent(0, 9, 5, 9)
        ventHelper.addVent(7, 0, 7, 4)
        ventHelper.addVent(0, 9, 2, 9)
        assertEquals(2, ventHelper.getGasValue(1, 9))
    }

    @Test
    fun onlyHorizontalVerticalTest(){
        val board = VentBoard(10)
        val ventHelper = VentHelper(board)
        ventHelper.addVent(8, 0, 0, 8)
        assertEquals(0, ventHelper.getGasValue(8, 0))
    }

    @Test
    fun testOtherWayX() {
        val board = VentBoard(10)
        val ventHelper = VentHelper(board)

        ventHelper.addVent(2, 2, 2, 1)
        assertEquals(1, ventHelper.getGasValue(2, 1))

    }

    @Test
    fun practiceDataVentsTest(){
        val board = VentBoard(10)
        val ventHelper = VentHelper(board)
        ventHelper.addVent(0, 9, 5, 9)
        ventHelper.addVent(8, 0, 0, 8)
        ventHelper.addVent(9, 4, 3, 4)
        ventHelper.addVent(2, 2, 2, 1)
        ventHelper.addVent(7, 0, 7, 4)
        ventHelper.addVent(6, 4, 2, 0)
        ventHelper.addVent(0, 9, 2, 9)
        ventHelper.addVent(3, 4, 1, 4)
        ventHelper.addVent(0, 0, 8, 8)
        ventHelper.addVent(5, 5, 8, 2)
        val intersections = ventHelper.getNumberOfIntersections()
        assertEquals(2, ventHelper.getGasValue(1, 9))
        assertEquals(1, ventHelper.getGasValue(2, 1))
        assertEquals(0, ventHelper.getGasValue(5, 5))
        assertEquals(5, intersections)
    }

    @Test
    fun diagonalXIncreaseTest() {
        val board = VentBoard(10)
        val ventHelper = VentHelper(board, true)
        ventHelper.addVent(5, 5, 8, 2)
        assertEquals(1, ventHelper.getGasValue(6, 4))
    }

    @Test
    fun diagonalYIncreaseTest() {
        val board = VentBoard(10)
        val ventHelper = VentHelper(board, true)
        ventHelper.addVent(8, 0, 0, 8)
        assertEquals(1, ventHelper.getGasValue(7, 1))
    }

    @Test
    fun diagonalBothIncreaseTest() {
        val board = VentBoard(10)
        val ventHelper = VentHelper(board, true)
        ventHelper.addVent(0, 0, 8, 8)
        assertEquals(1, ventHelper.getGasValue(7, 7))
    }

    @Test
    fun diagonalBothDecreaseTest() {
        val board = VentBoard(10)
        val ventHelper = VentHelper(board, true)
        ventHelper.addVent(6, 4, 2, 0)
        assertEquals(1, ventHelper.getGasValue(5, 3))
    }

    @Test
    fun practiceDataDiagonalVentsTest(){
        val board = VentBoard(10)
        val ventHelper = VentHelper(board, true)
        ventHelper.addVent(0, 9, 5, 9)
        ventHelper.addVent(8, 0, 0, 8)
        ventHelper.addVent(9, 4, 3, 4)
        ventHelper.addVent(2, 2, 2, 1)
        ventHelper.addVent(7, 0, 7, 4)
        ventHelper.addVent(6, 4, 2, 0)
        ventHelper.addVent(0, 9, 2, 9)
        ventHelper.addVent(3, 4, 1, 4)
        ventHelper.addVent(0, 0, 8, 8)
        ventHelper.addVent(5, 5, 8, 2)
        val intersections = ventHelper.getNumberOfIntersections()
        assertEquals(12, intersections)
    }
}