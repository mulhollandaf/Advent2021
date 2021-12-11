package com.santa.adventcalendar.day3
import junit.framework.Assert.assertEquals
import org.junit.Test

class Day3UnitTest {
    @Test
    fun testGammaRate() {
        val input = arrayOf("101", "100", "100")
        val binaryHelper = BinaryHelper()
        val gammaRate = binaryHelper.getGammaRate(input)
        assertEquals("100", gammaRate)
    }

    @Test
    fun testGammaTest() {
        val input = arrayOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010",
        )

        val binaryHelper = BinaryHelper()
        val gammaRate = binaryHelper.getGammaRate(input)
        assertEquals("10110", gammaRate)
    }

    @Test
    fun testEpsilonTest() {
        val input = arrayOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010",
        )

        val binaryHelper = BinaryHelper()
        val epsilonRate = binaryHelper.getEpsilonRate(input)
        assertEquals("01001", epsilonRate)
    }

    @Test
    fun testToInt() {
        val binaryHelper = BinaryHelper()
        val number = binaryHelper.toInt("1001")
        assertEquals(9, number)
    }

    @Test
    fun testActual() {
        val input = binaryInput
        val binaryHelper = BinaryHelper()
        val gamma = binaryHelper.getGammaRate(input)
        val epsilon = binaryHelper.getEpsilonRate(input)
        val intGamma = binaryHelper.toInt(gamma)
        val intEpsilon = binaryHelper.toInt(epsilon)
        assertEquals(741950, intGamma * intEpsilon)
    }

    @Test
    fun testOxygen() {
        val input = arrayOf("101", "100", "110")
        val binaryHelper = BinaryHelper()
        val oxygenRate = binaryHelper.getOxygenRate(input)
        assertEquals("101", oxygenRate)
    }

    @Test
    fun testOxygenTest() {
        val input = arrayOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010",
        )

        val binaryHelper = BinaryHelper()
        val oxygenRate = binaryHelper.getOxygenRate(input)
        assertEquals("10111", oxygenRate)
    }

    @Test
    fun testC02() {
        val input = arrayOf("001", "100", "110")
        val binaryHelper = BinaryHelper()
        val co2Rate = binaryHelper.getCO2Rate(input)
        assertEquals("001", co2Rate)
    }

    @Test
    fun testCO2Test() {
        val input = arrayOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010",
        )

        val binaryHelper = BinaryHelper()
        val co2Rate = binaryHelper.getCO2Rate(input)
        assertEquals("01010", co2Rate)
    }

    @Test
    fun testActualOC() {
        val input = binaryInput
        val binaryHelper = BinaryHelper()
        val oxygen = binaryHelper.getOxygenRate(input)
        val co2 = binaryHelper.getCO2Rate(input)
        val intOxygen = binaryHelper.toInt(oxygen)
        val intCO2 = binaryHelper.toInt(co2)
        assertEquals(903810, intOxygen * intCO2)
    }
}