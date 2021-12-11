package com.santa.adventcalendar.day8

import java.util.*

class DigitHelper {
    fun filterSegments(segments: List<String>): Int {
        var ones = 0
        var sevens = 0
        var fours = 0
        var eights = 0
        var total = 0
        val onesFilteredList = segments.filter { x -> x.length == 2}
        val sevensFilteredList = segments.filter {x -> x.length == 3}
        val foursFilteredList = segments.filter {x -> x.length == 4}
        val eightsFilteredList = segments.filter { x -> x.length == 7}
        ones = onesFilteredList.size
        sevens = sevensFilteredList.size
        fours = foursFilteredList.size
        eights = eightsFilteredList.size
        total = ones + sevens + fours + eights
        return total
    }

    fun getNumberofOnesSegments(segments: List<String>): Int {
        var ones = 0
        var onesFilteredList = segments.filter {x -> x.length == 2}
        ones = onesFilteredList.size
        return ones
    }

    fun getNumberofSevensSegments(segments: List<String>): Int {
        var sevens = 0
        var sevensFilteredList = segments.filter {x -> x.length == 3}
        sevens = sevensFilteredList.size
        return sevens
    }

    fun getNumberofFoursSegments(segments: List<String>): Int {
        var fours = 0
        var foursFilteredList = segments.filter {x -> x.length == 4}
        fours = foursFilteredList.size
        return fours
    }

    fun getNumberofEightsSegments(segments: List<String>): Int {
        var eights = 0
        var eightsFilteredList = segments.filter {x -> x.length == 7}
        eights = eightsFilteredList.size
        return eights
    }

    fun findOne(segments: List<String>): String {
        segments.forEach {
            if (it.length == 2) {
                return it
            }
        }

        return ""
    }

    fun findTwo(segments: List<String>): String {
        val one = findOne(segments)
        val three = findThree(segments)
        val four = findFour(segments)
        val five = findFive(segments)
        val six = findSix(segments)
        val seven = findSeven(segments)
        val eight = findEight(segments)
        val nine = findNine(segments)
        val zero = findZero(segments)
        segments.forEach {
            if (it != one &&
                    it != three &&
                    it != four &&
                    it != five &&
                    it != six &&
                    it != seven &&
                    it != eight &&
                    it != nine &&
                    it != zero) {
                return it
            }
        }



        return ""
    }

    fun findThree(segments: List<String>): String {
        val one = findOne(segments)
        segments.forEach {
            if (it.length == 5 &&
                it.contains(one[0]) &&
                it.contains(one[1])) {
                return it
            }
        }
        return ""
    }

    fun findFour(segments: List<String>): String {
        segments.forEach {
            if (it.length == 4) {
                return it
            }
        }
        return ""
    }

    fun findFive(segments: List<String>): String {
        val six = findSix(segments)
        segments.forEach {
            if (it.length == 5) {
                var hasAll = true
                it.forEach { digit ->
                    hasAll = hasAll && six.contains(digit)
                }
                if (hasAll) {
                    return it
                }
            }
        }
        return ""
    }

    fun findSix(segments: List<String>): String {
        val zero = findZero(segments)
        val nine = findNine(segments)
        segments.forEach {
            if (it != nine &&
                it != zero &&
                it.length == 6
            ) {
                return it
            }
        }
        return ""
    }

    fun findSeven(segments: List<String>): String {
        segments.forEach {
            if (it.length == 3) {
                return it
            }
        }
        return ""
    }

    fun findEight(segments: List<String>): String {
        segments.forEach {
            if (it.length == 7) {
                return it
            }
        }
        return ""
    }

    fun findNine(segments: List<String>): String {
        val four = findFour(segments)
        segments.forEach {
            if (it.length == 6) {
                var hasAll = true
                four.forEach { digit ->
                    hasAll = hasAll && it.contains(digit)
                }
                if (hasAll) {
                    return it
                }
            }
        }
        return ""
    }

    fun findZero(segments: List<String>): String {
        val one = findOne(segments)
        val nine = findNine(segments)
        segments.forEach {
            if (it != nine &&
                it.length == 6 &&
                it.contains(one[0]) &&
                it.contains(one[1])
            ) {
                return it
            }
        }
        return ""
    }

    fun findLastFour(segments: List<String>, lastFour: List<String>): Int {
        val key = arrayOf(
            findZero(segments).toSortedSet(),
            findOne(segments).toSortedSet(),
            findTwo(segments).toSortedSet(),
            findThree(segments).toSortedSet(),
            findFour(segments).toSortedSet(),
            findFive(segments).toSortedSet(),
            findSix(segments).toSortedSet(),
            findSeven(segments).toSortedSet(),
            findEight(segments).toSortedSet(),
            findNine(segments).toSortedSet()
        )

        return findDigit(key, lastFour[0].toSortedSet()) * 1000 +
                findDigit(key, lastFour[1].toSortedSet()) * 100 +
                findDigit(key, lastFour[2].toSortedSet()) * 10 +
                findDigit(key, lastFour[3].toSortedSet())
    }

    private fun findDigit(key: Array<SortedSet<Char>>, value: SortedSet<Char>): Int {
        key.forEachIndexed { x, keyValue ->
            if (keyValue == value) {
                return x
            }
        }

        return 0
    }
}
