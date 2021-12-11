package com.santa.adventcalendar.day1

import org.junit.Assert.assertEquals
import org.junit.Test

class Day1UnitTest {
    @Test
    fun testGoingUp() {
        val input = arrayOf(0, 1, 2)
        val depthHelper = DepthHelper()
        val increases = depthHelper.countIncreases(input)
        assertEquals(2, increases)
    }

    @Test
    fun testGoingUpAndDown() {
        val input = arrayOf(0, 1, 2, 1)
        val depthHelper = DepthHelper()
        val increases = depthHelper.countIncreases(input)
        assertEquals(2, increases)
    }

    @Test
    fun testActualDepths() {
        val input = DepthInput().depths
        val depthHelper = DepthHelper()
        val increases = depthHelper.countIncreases(input)
        assertEquals(1581, increases)
    }

    @Test
    fun testWindowTotal() {
        val input = arrayOf(199, 200, 208)
        val depthHelper = DepthHelper()
        val total = depthHelper.getWindowTotal(input, 0)
        assertEquals(607, total)
    }

    @Test
    fun testWindowUpAndDown() {
        val input = arrayOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        val depthHelper = DepthHelper()
        val increases = depthHelper.windowIncreases(input)
        assertEquals(5, increases)
    }

    @Test
    fun testWindowData() {
        val input = DepthInput().depths
        val depthHelper = DepthHelper()
        val increases = depthHelper.windowIncreases(input)
        assertEquals(1618, increases)
    }
}

