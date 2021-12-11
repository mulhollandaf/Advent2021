package com.santa.adventcalendar.day2

import junit.framework.Assert.assertEquals
import org.junit.Test

class Day2UnitTest {

    @Test
    fun testDepthControl() {
        val inputs = arrayOf("down 10", "up 4")
        val locationHelper = LocationHelper(false)
        val location = locationHelper.move(inputs)
        assertEquals(6, location.depth)
    }

    @Test
    fun testAimControl() {
        val inputs = arrayOf("down 10", "up 4")
        val locationHelper = LocationHelper(true)
        val location = locationHelper.move(inputs)
        assertEquals(0, location.depth)
        assertEquals(6, location.aim)
    }

    @Test
    fun testPositionControl() {
        val inputs = arrayOf("forward 2", "forward 6")
        val locationHelper = LocationHelper(true)
        val location = locationHelper.move(inputs)
        assertEquals(8, location.position)
        assertEquals(0, location.aim)
    }

    @Test
    fun testLocationControlNoAim() {
        val inputs = arrayOf("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")
        val locationHelper = LocationHelper(false)
        val location = locationHelper.move(inputs)
        assertEquals(15, location.position)
        assertEquals(10, location.depth)
    }

    @Test
    fun testLocationControlWithAim() {
        val inputs = arrayOf("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")
        val locationHelper = LocationHelper(true)
        val location = locationHelper.move(inputs)
        assertEquals(15, location.position)
        assertEquals(60, location.depth)
        assertEquals(10, location.aim)
    }

    @Test
    fun testLocationWithInputs() {
        val inputs = directionInput
        val locationHelper = LocationHelper(true)
        val location = locationHelper.move(inputs)
        assertEquals(1905, location.position)
        assertEquals(810499, location.depth)//was 907 for part 1
        assertEquals(907, location.aim)
    }
}