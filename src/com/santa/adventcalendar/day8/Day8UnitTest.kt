package com.santa.adventcalendar.day8

import org.junit.Test
import kotlin.test.assertEquals

class Day8UnitTest {

    @Test
    fun anyOnesTest(){
        var segments = listOf("ab", "cdfeb", "fcadb", "cdfeb", "cdbaf")
        val digitHelper = DigitHelper()
        val ones = digitHelper.getNumberofOnesSegments(segments)
        assertEquals(1, ones)
    }

    @Test
    fun anySevensTest(){
        var segments = listOf<String>("cefabd", "cdfgeb", "eafb", "dab", "cagedb")
        val digitHelper = DigitHelper()
        val sevens = digitHelper.getNumberofSevensSegments(segments)
        assertEquals(1, sevens)
    }

    @Test
    fun anyFoursTest(){
        var segments = listOf<String>("cagedb", "ab", "eafb", "cdfeb", "fcadb", "cdfeb", "cdbaf")
        val digitHelper = DigitHelper()
        val fours = digitHelper.getNumberofFoursSegments(segments)
        assertEquals(1, fours)
    }

    @Test
    fun anyEightsTest(){
        var segments = listOf<String>("acedgfb", "fcadb", "cdfeb", "cdbaf")
        val digitHelper = DigitHelper()
        val eights = digitHelper.getNumberofEightsSegments(segments)
        assertEquals(1, eights)
    }

    @Test
    fun practiceDataTest(){
        var segments = listOf("fdgacbe", "cefdb", "cefbgd", "gcbe", "fcgedb", "cgb", "dgebacf", "gc", "cg", "cg",
            "fdcagb", "cbg", "efabcd", "cedba", "gadfec", "cb", "gecf", "egdcabf", "bgf", "bfgea", "gebdcfa", "ecba", "ca",
            "fadegcb", "cefg", "dcbef", "fcge", "gbcadfe", "ed", "bcgafe", "cdgba", "cbgef", "gbdfcae", "bgc", "cg", "cgb",
            "fgae", "cfgab", "fg", "bagce")
        val digitHelper = DigitHelper()
        val total = digitHelper.filterSegments(segments)
        assertEquals(26, total)
    }

    @Test
    fun findOneTest() {
        val segments = listOf("acedgfb", "cdfbe", "gcdfa", "fbcad", "dab", "cefabd", "cdfgeb", "eafb", "cagedb", "ab")
        val digitHelper = DigitHelper()
        val one = digitHelper.findOne(segments)
        assertEquals("ab", one)
    }

    @Test
    fun findTwoTest() {
        val segments = listOf("acedgfb", "cdfbe", "gcdfa", "fbcad", "dab", "cefabd", "cdfgeb", "eafb", "cagedb", "ab")
        val digitHelper = DigitHelper()
        val two = digitHelper.findTwo(segments)
        assertEquals("gcdfa", two)
    }

    @Test
    fun findThreeTest() {
        val segments = listOf("acedgfb", "cdfbe", "gcdfa", "fbcad", "dab", "cefabd", "cdfgeb", "eafb", "cagedb", "ab")
        val digitHelper = DigitHelper()
        val three = digitHelper.findThree(segments)
        assertEquals("fbcad", three)
    }

    @Test
    fun findFourTest() {
        val segments = listOf("acedgfb", "cdfbe", "gcdfa", "fbcad", "dab", "cefabd", "cdfgeb", "eafb", "cagedb", "ab")
        val digitHelper = DigitHelper()
        val four = digitHelper.findFour(segments)
        assertEquals("eafb", four)
    }

    @Test
    fun findFiveTest() {
        val segments = listOf("acedgfb", "cdfbe", "gcdfa", "fbcad", "dab", "cefabd", "cdfgeb", "eafb", "cagedb", "ab")
        val digitHelper = DigitHelper()
        val five = digitHelper.findFive(segments)
        assertEquals("cdfbe", five)
    }

    @Test
    fun findSixTest() {
        val segments = listOf("acedgfb", "cdfbe", "gcdfa", "fbcad", "dab", "cefabd", "cdfgeb", "eafb", "cagedb", "ab")
        val digitHelper = DigitHelper()
        val six = digitHelper.findSix(segments)
        assertEquals("cdfgeb", six)
    }

    @Test
    fun findSevenTest() {
        val segments = listOf("acedgfb", "cdfbe", "gcdfa", "fbcad", "dab", "cefabd", "cdfgeb", "eafb", "cagedb", "ab")
        val digitHelper = DigitHelper()
        val seven = digitHelper.findSeven(segments)
        assertEquals("dab", seven)
    }

    @Test
    fun findEightTest() {
        val segments = listOf("acedgfb", "cdfbe", "gcdfa", "fbcad", "dab", "cefabd", "cdfgeb", "eafb", "cagedb", "ab")
        val digitHelper = DigitHelper()
        val eight = digitHelper.findEight(segments)
        assertEquals("acedgfb", eight)
    }

    @Test
    fun findNineTest() {
        val segments = listOf("acedgfb", "cdfbe", "gcdfa", "fbcad", "dab", "cefabd", "cdfgeb", "eafb", "cagedb", "ab")
        val digitHelper = DigitHelper()
        val nine = digitHelper.findNine(segments)
        assertEquals("cefabd", nine)
    }

    @Test
    fun findZeroTest() {
        val segments = listOf("acedgfb", "cdfbe", "gcdfa", "fbcad", "dab", "cefabd", "cdfgeb", "eafb", "cagedb", "ab")
        val digitHelper = DigitHelper()
        val zero = digitHelper.findZero(segments)
        assertEquals("cagedb", zero)
    }

    @Test
    fun findLastFourTest() {
        val segments = listOf("acedgfb", "cdfbe", "gcdfa", "fbcad", "dab", "cefabd", "cdfgeb", "eafb", "cagedb", "ab")
        val digitHelper = DigitHelper()
        val lastFour = listOf("cdfeb", "fcadb", "cdfeb", "cdbaf")
        val lastFourInt = digitHelper.findLastFour(segments, lastFour)
        assertEquals(5353, lastFourInt)
    }
}