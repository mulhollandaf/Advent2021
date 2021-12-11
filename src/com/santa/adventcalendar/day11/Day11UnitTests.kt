package com.santa.adventcalendar.day11

import org.junit.Test
import kotlin.test.assertEquals

class Day11UnitTests {
    @Test
    fun testIncreaseValues() {
        val octopi = arrayOf(
            arrayOf(1, 1, 1),
            arrayOf(2, 2, 2),
            arrayOf(3, 3, 3)
        )
        val helper = OctopitHelper(octopi)
        helper.getNFlashes(1)
        assertEquals(2, octopi[0][0])
        assertEquals(3, octopi[1][0])
    }

    @Test
    fun testFirstStep() {
        val octopi = arrayOf(
            arrayOf(1,1,1,1,1),
            arrayOf(1,9,9,9,1),
            arrayOf(1,9,1,9,1),
            arrayOf(1,9,9,9,1),
            arrayOf(1,1,1,1,1)
        )
        val helper = OctopitHelper(octopi)
        val nFlashes = helper.getNFlashes(1)
        assertEquals(9, nFlashes)
    }

    @Test
    fun testTwoSteps() {
        val octopi = arrayOf(
            arrayOf(1,1,1,1,1),
            arrayOf(1,9,9,9,1),
            arrayOf(1,9,1,9,1),
            arrayOf(1,9,9,9,1),
            arrayOf(1,1,1,1,1)
        )
        val helper = OctopitHelper(octopi)
        val nFlashes = helper.getNFlashes(2)
        assertEquals(9, nFlashes)
        assertEquals(4, octopi[0][0])
    }

    @Test
    fun test10Steps() {
        val octopi = arrayOf(
            arrayOf(5, 4, 8, 3, 1, 4, 3, 2, 2, 3),
            arrayOf(2,7,4,5,8,5,4,7,1,1),
            arrayOf(5,2,6,4,5,5,6,1,7,3),
            arrayOf(6,1,4,1,3,3,6,1,4,6),
            arrayOf(6,3,5,7,3,8,5,4,7,8),
            arrayOf(4,1,6,7,5,2,4,6,4,5),
            arrayOf(2,1,7,6,8,4,1,7,2,1),
            arrayOf(6,8,8,2,8,8,1,1,3,4),
            arrayOf(4,8,4,6,8,4,8,5,5,4),
            arrayOf(5,2,8,3,7,5,1,5,2,6)
        )
        val helper = OctopitHelper(octopi)
        val nFlashes = helper.getNFlashes(10)
        assertEquals(204, nFlashes)
    }

    @Test
    fun test100Steps() {
        val octopi = arrayOf(
            arrayOf(5, 4, 8, 3, 1, 4, 3, 2, 2, 3),
            arrayOf(2, 7, 4, 5, 8, 5, 4, 7, 1, 1),
            arrayOf(5, 2, 6, 4, 5, 5, 6, 1, 7, 3),
            arrayOf(6, 1, 4, 1, 3, 3, 6, 1, 4, 6),
            arrayOf(6, 3, 5, 7, 3, 8, 5, 4, 7, 8),
            arrayOf(4, 1, 6, 7, 5, 2, 4, 6, 4, 5),
            arrayOf(2, 1, 7, 6, 8, 4, 1, 7, 2, 1),
            arrayOf(6, 8, 8, 2, 8, 8, 1, 1, 3, 4),
            arrayOf(4, 8, 4, 6, 8, 4, 8, 5, 5, 4),
            arrayOf(5, 2, 8, 3, 7, 5, 1, 5, 2, 6)
        )
        val helper = OctopitHelper(octopi)
        val nFlashes = helper.getNFlashes(100)
        assertEquals(1656, nFlashes)
    }

    @Test
    fun testSyncFlashes() {
        val octopi = arrayOf(
            arrayOf(5, 4, 8, 3, 1, 4, 3, 2, 2, 3),
            arrayOf(2, 7, 4, 5, 8, 5, 4, 7, 1, 1),
            arrayOf(5, 2, 6, 4, 5, 5, 6, 1, 7, 3),
            arrayOf(6, 1, 4, 1, 3, 3, 6, 1, 4, 6),
            arrayOf(6, 3, 5, 7, 3, 8, 5, 4, 7, 8),
            arrayOf(4, 1, 6, 7, 5, 2, 4, 6, 4, 5),
            arrayOf(2, 1, 7, 6, 8, 4, 1, 7, 2, 1),
            arrayOf(6, 8, 8, 2, 8, 8, 1, 1, 3, 4),
            arrayOf(4, 8, 4, 6, 8, 4, 8, 5, 5, 4),
            arrayOf(5, 2, 8, 3, 7, 5, 1, 5, 2, 6)
        )
        val helper = OctopitHelper(octopi)
        val nTurns = helper.getTurnAllFlash()
        assertEquals(195, nTurns)
    }
}