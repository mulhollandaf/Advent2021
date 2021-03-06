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

        //Check if two digit
        val first = getNumber(num, explodeIndex + 1)
        var offset = 0
        if (first > 9) {
            offset++
        }
        val second = getNumber(num, explodeIndex + 3 + offset)
        if (second > 9) {
            offset++
        }

        val rightSide = num.substring(explodeIndex + 5 + offset)

        val adjustedLeft = addToLeft(leftSide, first)
        val adjustedRight = addToRight(rightSide, second)

        return "${adjustedLeft}0${adjustedRight}"
    }

    private fun getNumber(num: String, explodeIndex: Int): Int {
        val number = num[explodeIndex].digitToInt()
        return if (num[explodeIndex - 1].isDigit()) {
            return number + 10 * num[explodeIndex - 1].digitToInt()
        } else if (num[explodeIndex + 1].isDigit()) {
            number * 10 + num[explodeIndex + 1].digitToInt()
        } else number
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
        val newValue = getNumber(leftSide, valIndex)
        val offset = if (newValue > 9) 1 else 0
        val sum = newValue + add
        return leftSide.replaceRange(valIndex - offset, valIndex + 1, sum.toString())
    }

    private fun addExplodeRight(rightSide: String, valIndex: Int, add: Int): String {
        val newValue = getNumber(rightSide, valIndex)
        val offset = if (newValue > 9) 1 else 0
        val sum = newValue + add
        return rightSide.replaceRange(valIndex, valIndex + 1 + offset, sum.toString())
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
        var last = ""
        var quit = false
        while (!quit) {
            val exploded = explode(value)
            if (exploded == null) {
                val split = split(value)
                if (split == null) {
                    quit = true
                    return value
                } else {
                    last = value
                    value = split
                }
            } else {
                last = value
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
                    println("Adding $it to $input")
                    sum = reduce(add(it, input))
                    println(sum)
                }
            }
        }
        return sum ?: ""
    }

    fun getMagnitude(num: String): Int {
        val pair = parse(num)
        return getMagnitudeRecursive(pair)
    }

    private fun getMagnitudeRecursive(number: SnailNumber): Int {
        if (number is ConstantSnailNumber) {
            return number.value
        }
        number as PairSnailNumber
        return 3* getMagnitudeRecursive(number.first) + 2* getMagnitudeRecursive(number.second)
    }

    private var index = 0
    fun parse(string: String): PairSnailNumber {
        index = 0
        val top = parsePairRecursive(string)
        tellChildrenWhoDaddyIs(top)
        return top
    }

    private fun tellChildrenWhoDaddyIs(parent: PairSnailNumber) {
        parent.first.parent = parent
        parent.second.parent = parent
        if (parent.first is PairSnailNumber) {
            tellChildrenWhoDaddyIs(parent.first as PairSnailNumber)
        }
        if (parent.second is PairSnailNumber) {
            tellChildrenWhoDaddyIs(parent.second as PairSnailNumber)
        }
    }

    private fun parsePairRecursive(string: String): PairSnailNumber {
        index++
        val first = parseRecursive(string)
        if (string[index] == ',') index++
        val second = parseRecursive(string)
        index++
        return PairSnailNumber(first, second)
    }

    private fun parseRecursive(string: String): SnailNumber {
        var num = 0
        while (string[index] != ']' && string[index] != ',') {
            if (string[index] == '[') {
                return parsePairRecursive(string)
            } else {
                num = num * 10 + string[index].digitToInt()
                index++
            }
        }
        index++
        return ConstantSnailNumber(num)
    }

    private val numbers = charArrayOf('0','1','2','3','4','5','6','7','8','9')
}
