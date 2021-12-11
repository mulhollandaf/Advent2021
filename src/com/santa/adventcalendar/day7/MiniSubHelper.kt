package com.santa.adventcalendar.day7

import kotlin.math.abs

class MiniSubHelper(private val isHard: Boolean = false) {
    fun getMoveCost(start: Int, end: Int): Int {
        return abs(start - end)
    }

    fun moveSetTo(crabs: Array<Int>, moveTo: Int): Int {
        return crabs.sumOf{ crab ->
            if (isHard) {
                getMoveCostHard(crab, moveTo)
            } else {
                getMoveCost(crab, moveTo)
            }
        }
    }

    fun getMostEfficient(crabs: Array<Int>): Int {
        val max = crabs.maxOrNull() ?: return 0
        var minPosition = -1
        var minCost = Int.MAX_VALUE
        for(x in 0..max) {
            val cost = moveSetTo(crabs, x)
            if(cost < minCost) {
                minCost = cost
                minPosition = x
            }
        }

        return minPosition
    }

    fun getMoveCostHard(start: Int, end: Int): Int {
        var sum = 0
        for (x in 1 .. abs(start-end)) {
            sum += x
        }
        return sum
    }

}
