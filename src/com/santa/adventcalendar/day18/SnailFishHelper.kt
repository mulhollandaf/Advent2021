package com.santa.adventcalendar.day18

class SnailFishHelper {
    fun add(num1: String, num2: String): String {
        return "[$num1,$num2]"
    }

    fun indexOfFirstExplode(num: String): Int {
        var depth = 0
        num.forEachIndexed{x, letter ->
            if (letter == '[') {
                depth++
            } else if (letter == ']') {
                depth--
            }
            if ( depth == 5 ) {
                return x
            }
        }

        return -1
    }

    fun explode(num: String): String? {
        val explodeIndex = indexOfFirstExplode(num)
        if (explodeIndex < 0) {
            return null //no explosion today
        }
        val leftSide = num.substring(0, explodeIndex)
        val rightSide = num.substring(explodeIndex + 5)
        val first = num[explodeIndex + 1].digitToInt()
        val second = num[explodeIndex + 3].digitToInt()

        val adjustedLeft = addToLeft(leftSide, first)
        val adjustedRight = addToRight(rightSide, second)

        return "${adjustedLeft}0${adjustedRight}"
    }

    private fun addToLeft(leftSide: String, first: Int): String {
        val indexOfFirstLeftVal = getFirstLeftVal(leftSide)
        val adjusted =  if (indexOfFirstLeftVal > 0) {
            //Add
            addExplodeLeft(leftSide, indexOfFirstLeftVal, first)
        }
        else {
            leftSide
        }
        return if (adjusted.lastIndexOfAny(numbers) == adjusted.length - 1) {
            "$adjusted,"
        } else {
            adjusted
        }
    }

    private fun addToRight(rightSide: String, second: Int): String {
        val indexOfFirstRightVal = getFirstRightVal(rightSide)
        val adjusted = if (indexOfFirstRightVal > 0) {
            //Add
            addExplodeRight(rightSide, indexOfFirstRightVal, second)
        }
        else {
            rightSide
        }

        return if (adjusted.indexOfAny(numbers) == 0) {
            return ",$adjusted"
        } else {
            adjusted
        }
    }

    private fun getFirstLeftVal(num: String): Int {
        return num.lastIndexOfAny(numbers)
    }

    private fun getFirstRightVal(num: String): Int {
        return num.indexOfAny(numbers)
    }

    private fun addExplodeLeft(leftSide: String, valIndex: Int, add: Int): String {
        val newValue = leftSide[valIndex].digitToInt() + add
        return leftSide.replaceRange(valIndex, valIndex + 1, newValue.toString())
    }

    private fun addExplodeRight(rightSide: String, valIndex: Int, add: Int): String {
        val newValue = rightSide[valIndex].digitToInt() + add
        return rightSide.replaceRange(valIndex, valIndex + 1, newValue.toString())
    }

    fun split(num: String): String? {
        val bigIndex = getFirstIndexOfBigNumber(num)
        if (bigIndex < 0) return null
        val bigNumber = Integer.parseInt(num.substring(bigIndex, bigIndex + 2))
        val first = bigNumber / 2
        val second = (bigNumber + 1) / 2
        return num.substring(0, bigIndex) + "[$first,$second]" + num.substring(bigIndex + 2)
    }

    private fun getFirstIndexOfBigNumber(num: String): Int {
        return "[0-9][0-9]".toRegex().find(num)?.range?.first ?: -1
    }

    fun reduce(num: String): String {
        var value = num
        var quit = false
        while (!quit) {
            val exploded = explode(value)
            if (exploded == null) {
                val split = split(value)
                if (split == null) {
                    quit = true
                    return value
                } else {
                    value = split
                }
            } else {
                value = exploded
            }
        }
        return value

    }

    fun addReduce(inputs: Array<String>): String {
        var sum: String? = null
        inputs.forEach { input ->
            if (sum == null) {
                sum = input
            } else {
                sum?.let {
                    sum = reduce(add(it, input))
                }
            }
        }
        return sum ?: ""
    }

    private val numbers = charArrayOf('0','1','2','3','4','5','6','7','8','9')
}
