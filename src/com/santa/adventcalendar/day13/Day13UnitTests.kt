package com.santa.adventcalendar.day13

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day13UnitTests {

    @Test
    fun dotsOrTest(){
        val dotsLocation = arrayOf(Pair(0,0), Pair(3,1))
        val foldHelper = FoldHelper(dotsLocation)
        foldHelper.fold(true, 2)
        assertTrue(foldHelper.getValue(0, 0))
        assertTrue(foldHelper.getValue(1, 1))
        assertFalse(foldHelper.getValue(1, 0))
    }

    @Test
    fun dotsAndTest(){
        val dotsLocation = arrayOf(Pair(0,0), Pair(4,0))
        val foldHelper = FoldHelper(dotsLocation)
        foldHelper.fold(true, 2)
        assertTrue(foldHelper.getValue(0, 0))
        assertFalse(foldHelper.getValue(1, 0))
    }

    @Test
    fun unevenFoldTest(){
        val dotsLocation = arrayOf(Pair(0,1), Pair(3,0))
        val foldHelper = FoldHelper(dotsLocation)
        foldHelper.fold(true, 1)
        assertTrue(foldHelper.getValue(0, 0))
        assertFalse(foldHelper.getValue(0, 1))
        assertTrue(foldHelper.getValue(1, 1))
    }
}