package com.santa.adventcalendar.day22

import org.junit.Test
import readInput
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

//Thanks to Todd Ginsberg for help on this one
//https://todd.ginsberg.com/post/advent-of-code/2021/day22/
class Day22UnitTests {
    @Test
    fun testVolume() {
        val cuboid1 = Cuboid(10..12, 10..12, 10..12, true)
        val volume = cuboid1.volume()
        assertEquals(27, volume)
    }

    @Test
    fun testPartVolume() {
        val cuboid1 = Cuboid(10..12, 10..12, 10..12, true)
        val cuboid2 = Cuboid(11..13, 11..13, 11..13, true)
        val helper = CuboidHelper(arrayOf(cuboid1, cuboid2))
        val volume = helper.findVolume()
        assertEquals(46, volume)
    }

    @Test
    fun testOffVolume() {
        val cuboid = Cuboid(9..11, 9..11, 9..11, false)
        val volume = CuboidHelper(arrayOf(cuboid)).findVolume()
        assertEquals(0, volume)
    }

    @Test
    fun testSmallExampleVolume() {
        val cuboid1 = Cuboid(10..12, 10..12, 10..12, true)
        val cuboid2 = Cuboid(11..13, 11..13, 11..13, true)
        val cuboid3 = Cuboid(9..11, 9..11, 9..11, false)
        val cuboid4 = Cuboid(10..10, 10..10, 10..10, true)
        val helper = CuboidHelper(arrayOf(cuboid1, cuboid2, cuboid3, cuboid4))
        val volume = helper.findVolume()
        assertEquals(39, volume)
    }

    @Test
    fun testCuboidReader() {
        val lines = readInput("day22LargeExample")
        val reader = CuboidReader()
        val cuboids = lines.map{ line ->
            reader.readCuboid(line)
        }.toTypedArray()
        assertNotNull(cuboids[0])
    }

    @Test
    fun testLargeExample() {
        val lines = readInput("day22LargeExample")
        val reader = CuboidReader()
        val cuboids = lines.map{ line ->
            reader.readCuboid(line)
        }.toTypedArray()
        val helper = CuboidHelper(cuboids)
        val volume = helper.findVolume()
        assertEquals(590784, volume)
    }

    @Test
    fun test50() {
        val lines = readInput("day2250")
        val reader = CuboidReader()
        val cuboids = lines.map{ line ->
            reader.readCuboid(line)
        }.toTypedArray()
        val helper = CuboidHelper(cuboids)
        val volume = helper.findVolume()
        assertEquals(591365, volume)
    }

    @Test
    fun testLargerExample() {
        val lines = readInput("day22LargerExample")
        val reader = CuboidReader()
        val cuboids = lines.map{ line ->
            reader.readCuboid(line)
        }.toTypedArray()
        val helper = CuboidHelper(cuboids)
        val volume = helper.findVolume()
        assertEquals(2758514936282235, volume)
    }

    @Test
    fun testPart2() {
        val lines = readInput("day22Full")
        val reader = CuboidReader()
        val cuboids = lines.map{ line ->
            reader.readCuboid(line)
        }.toTypedArray()
        val helper = CuboidHelper(cuboids)
        val volume = helper.findVolume()
        assertEquals(1211172281877240, volume)
    }
}