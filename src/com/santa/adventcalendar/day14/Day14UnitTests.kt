package com.santa.adventcalendar.day14

import org.junit.Test
import kotlin.test.assertEquals

class Day14UnitTests {

    @Test
    fun addNewElementsTest(){
        val currentFormula = mapOf(Pair("NN", 1L), Pair("NC", 1L), Pair("CB", 1L))
        val formulaHelper = FormulaHelper()
        val newFormula = formulaHelper.getNewCompound(currentFormula)
        assertEquals(1L, newFormula["NC"])
    }

    @Test
    fun twoStepsTest(){
        val currentFormula = mapOf(Pair("NN", 1L), Pair("NC", 1L), Pair("CB", 1L))
        val formulaHelper = FormulaHelper()
        val newFormula = formulaHelper.processSteps(currentFormula, 10)
        val length = formulaHelper.getMaxMinDifference(newFormula, 'N', 'B')
        assertEquals(1588, length)
    }

    @Test
    fun maxMinTest(){
        val currentFormula = mapOf(Pair("NN", 1L), Pair("NC", 1L), Pair("CB", 1L))
        val formulaHelper = FormulaHelper()
        val newFormula = formulaHelper.processSteps(currentFormula, 10)
        val length = formulaHelper.getMaxMinDifference(newFormula, 'N', 'B')
        assertEquals(1588, length)
    }
}