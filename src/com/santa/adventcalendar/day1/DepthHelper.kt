package com.santa.adventcalendar.day1

class DepthHelper {
    fun countIncreases(depths: Array<Int>): Int {
        var increase = 0
        depths.forEachIndexed { index, depth ->
            if (index == (depths.size - 1)) {
                return increase
            }
            if (depths[index + 1] > depth) {
                increase++
            }
        }
        return increase
    }

    fun windowIncreases(depths: Array<Int>): Int {
        var increase = 0
        depths.forEachIndexed { index, _ ->
            if (index == (depths.size - 3)) {
                return increase
            }
            val window = getWindowTotal(depths, index)
            val nextWindow = getWindowTotal(depths, index + 1)
            if (nextWindow > window) {
                increase++
            }
        }
        return increase
    }

    fun getWindowTotal(depths: Array<Int>, startIndex: Int): Int {
        return depths[startIndex] + depths[startIndex + 1] + depths[startIndex + 2]
    }
}