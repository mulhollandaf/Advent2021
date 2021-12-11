package com.santa.adventcalendar.day9

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day9UnitTest {

    @Test
    fun compareLeftTest() {
        val board = arrayOf(
            arrayOf(3, 2, 4),
            arrayOf(1, 5, 6),
            arrayOf(7, 8, 9)
        )
        val heightmapHelper = HeightmapHelper(board)
        val isLower = heightmapHelper.isLeftLowerOrSame(1, 1)
        assertTrue(isLower)
    }

    @Test
    fun compareRightTest() {
        val board = arrayOf(
            arrayOf(3, 2, 4),
            arrayOf(1, 5, 6),
            arrayOf(7, 8, 9)
        )
        val heightmapHelper = HeightmapHelper(board)
        val isLower = heightmapHelper.isRightLowerOrSame(1, 1)
        assertFalse(isLower)
    }

    @Test
    fun compareUpTest() {
        val board = arrayOf(
            arrayOf(3, 2, 4),
            arrayOf(1, 5, 6),
            arrayOf(7, 8, 9)
        )
        val heightmapHelper = HeightmapHelper(board)
        val isLower = heightmapHelper.isUpLowerOrSame(1, 1)
        assertTrue(isLower)
    }

    @Test
    fun compareDownTest() {
        val board = arrayOf(
            arrayOf(3, 2, 4),
            arrayOf(1, 5, 6),
            arrayOf(7, 8, 9)
        )
        val heightmapHelper = HeightmapHelper(board)
        val isLower = heightmapHelper.isDownLowerOrSame(1, 1)
        assertFalse(isLower)
    }

    @Test
    fun edgesTest() {
        val board = arrayOf(
            arrayOf(3, 2, 4),
            arrayOf(1, 5, 6),
            arrayOf(7, 8, 9)
        )
        val heightmapHelper = HeightmapHelper(board)

        assertFalse(heightmapHelper.isLeftLowerOrSame(0, 0))
        assertFalse(heightmapHelper.isUpLowerOrSame(0, 0))
        assertFalse(heightmapHelper.isRightLowerOrSame(2, 2))
        assertFalse(heightmapHelper.isDownLowerOrSame(2, 2))
    }

    @Test
    fun isLowestTest() {
        val board = arrayOf(
            arrayOf(3, 2, 4),
            arrayOf(1, 5, 6),
            arrayOf(7, 8, 9)
        )
        val heightmapHelper = HeightmapHelper(board)

        assertFalse(heightmapHelper.isLowest(0, 0))
        assertTrue(heightmapHelper.isLowest(1, 0))
        assertTrue(heightmapHelper.isLowest(0, 1))
        assertFalse(heightmapHelper.isLowest(2, 2))
    }

    @Test
    fun findLowestTest() {
        val board = arrayOf(
            arrayOf(3, 2, 4),
            arrayOf(1, 5, 6),
            arrayOf(7, 8, 9)
        )
        val heightmapHelper = HeightmapHelper(board)

        assertEquals(5, heightmapHelper.findLowPointsTotal())
    }

    @Test
    fun findLowestTestCase() {
        val board = arrayOf(
            arrayOf(2,1,9,9,9,4,3,2,1,0),
            arrayOf(3,9,8,7,8,9,4,9,2,1),
            arrayOf(9,8,5,6,7,8,9,8,9,2),
            arrayOf(8,7,6,7,8,9,6,7,8,9),
            arrayOf(9,8,9,9,9,6,5,6,7,8)
        )

        val heightmapHelper = HeightmapHelper(board)

        assertEquals(15, heightmapHelper.findLowPointsTotal())
    }

    @Test
    fun sameValue() {
        val board = arrayOf(
            arrayOf(9, 9, 9),
            arrayOf(1, 9, 6),
            arrayOf(7, 8, 9)
        )

        val heightmapHelper = HeightmapHelper(board)

        assertFalse(heightmapHelper.isLowest(0, 1))
    }

    @Test
    fun isPartOfBasinTest() {
        val board = arrayOf(
            arrayOf(2, 1, 9),
            arrayOf(3, 9, 8),
            arrayOf(9, 8, 5)
        )
        val heightmapHelper = HeightmapHelper(board)

        val isPart = heightmapHelper.isPartOfBasin(0, 1, 0, 0)
        assertTrue(isPart)
    }

    @Test
    fun isPartOfBasinNineTest() {
        val board = arrayOf(
            arrayOf(2, 1, 9),
            arrayOf(3, 9, 9),
            arrayOf(9, 8, 5)
        )
        val heightmapHelper = HeightmapHelper(board)

        val isPart = heightmapHelper.isPartOfBasin(0, 1, 0, 2)
        assertFalse(isPart)
    }

    @Test
    fun getBasinTest() {
        val board = arrayOf(
            arrayOf(2, 1, 9),
            arrayOf(3, 9, 9),
            arrayOf(9, 8, 5)
        )
        val heightmapHelper = HeightmapHelper(board)

        val basin = heightmapHelper.getBasin(Pair(0, 1))
        assertEquals(3, basin.size)
        assertEquals(Pair(0,1), basin[0])
        assertEquals(Pair(0,0), basin[1])
        assertEquals(Pair(1,0), basin[2])
    }

    @Test
    fun getBigBasinTest() {
        val board = arrayOf(
            arrayOf(2,1,9,9,9,4,3,2,1,0),
            arrayOf(3,9,8,7,8,9,4,9,2,1),
            arrayOf(9,8,5,6,7,8,9,8,9,2),
            arrayOf(8,7,6,7,8,9,6,7,8,9),
            arrayOf(9,8,9,9,9,6,5,6,7,8)
        )

        val heightmapHelper = HeightmapHelper(board)
        val basin1 = heightmapHelper.getBasin(Pair(0, 1))
        assertEquals(3, basin1.size)
        val basin2 = heightmapHelper.getBasin(Pair(0, 9))
        assertEquals(9, basin2.size)
    }

    @Test
    fun getAllBasinsTest() {
        val board = arrayOf(
            arrayOf(2,1,9,9,9,4,3,2,1,0),
            arrayOf(3,9,8,7,8,9,4,9,2,1),
            arrayOf(9,8,5,6,7,8,9,8,9,2),
            arrayOf(8,7,6,7,8,9,6,7,8,9),
            arrayOf(9,8,9,9,9,6,5,6,7,8)
        )

        val heightmapHelper = HeightmapHelper(board)
        val basins = heightmapHelper.getAllBasins()
        assertEquals(4, basins.size)
    }

    @Test
    fun getSizeOfThreeBiggestTest() {
        val board = arrayOf(
            arrayOf(2,1,9,9,9,4,3,2,1,0),
            arrayOf(3,9,8,7,8,9,4,9,2,1),
            arrayOf(9,8,5,6,7,8,9,8,9,2),
            arrayOf(8,7,6,7,8,9,6,7,8,9),
            arrayOf(9,8,9,9,9,6,5,6,7,8)
        )

        val heightmapHelper = HeightmapHelper(board)
        val size = heightmapHelper.getTotalSizeOfThreeBiggestBasins()
        assertEquals(1134, size)
    }
}