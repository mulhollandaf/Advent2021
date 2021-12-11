package com.santa.adventcalendar.day6

import com.santa.adventcalendar.day6.BreedingHelper
import org.junit.Test
import kotlin.test.assertEquals

class Day6UnitTest {

    @Test
    fun decreaseDayCountTest(){
        val fish = mutableListOf(6, 3, 2)
        val breedingHelper = BreedingHelper(fish)
        breedingHelper.decreaseDaysToBreed(1)
        assertEquals(5, breedingHelper.getDaysToBreed()[0])
    }

    @Test
    fun noNewFishTest(){
        var fish = mutableListOf(6, 3, 2)
        val breedingHelper = BreedingHelper(fish)
        breedingHelper.processDay(1)
        val groupSize = breedingHelper.getNumberOfFish()
        assertEquals(3, groupSize)
    }

    @Test
    fun newFishTest(){
        var fish = mutableListOf(6, 0, 2)
        val breedingHelper = BreedingHelper(fish)
        breedingHelper.processDay(1)
        val groupSize = breedingHelper.getNumberOfFish()
        assertEquals(4, groupSize)
    }

    @Test
    fun practiceDataTest(){
        var fish = mutableListOf(3, 4, 3, 1, 2)
        val breedingHelper = BreedingHelper(fish)
        breedingHelper.processDay(80)
        val groupSize = breedingHelper.getNumberOfFish()
        assertEquals(5934, groupSize)
    }
}