package com.santa.adventcalendar.day15

import org.junit.Test
import kotlin.test.assertEquals

class Day15UnitTests {
    @Test
    fun bestPathTest(){
        val cavern = arrayOf(
            arrayOf(1, 1, 6),
            arrayOf(1, 3, 8),
            arrayOf(2, 1, 3))
        val chitonHelper = ChitonHelper(cavern)
        val score = chitonHelper.findBestPath()
        assertEquals(100, score)
    }

    @Test
    fun practiceDataTest() {
        val testData = arrayOf(
            "1163751742",
            "1381373672",
            "2136511328",
            "3694931569",
            "7463417111",
            "1319128137",
            "1359912421",
            "3125421639",
            "1293138521",
            "2311944581")
        val cavern = InputHelper().parse(testData)
        val chitonHelper = ChitonHelper(cavern)
        val score = chitonHelper.findBestPath()
        assertEquals(315, score)
    }

    @Test
    fun expandedValueTest() {
        val testData = arrayOf(
            "1163751742",
            "1381373672",
            "2136511328",
            "3694931569",
            "7463417111",
            "1319128137",
            "1359912421",
            "3125421639",
            "1293138521",
            "2311944581")
        val cavern = InputHelper().parse(testData)
        val chitonHelper = ChitonHelper(cavern)
        val value = chitonHelper.getExpandedValue(13)
        assertEquals(4, value)
    }


}