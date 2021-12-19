package com.santa.adventcalendar.day18

class SnailFishHelper {
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

    fun add(num1: PairSnailNumber, num2: PairSnailNumber): PairSnailNumber {
        return PairSnailNumber(num1, num2)
    }

    fun canExplode(num: PairSnailNumber): Boolean {
        val depth = 1
        return canExplodeRecursive(num.first, depth) || canExplodeRecursive(num.second, depth)
    }

    private fun canExplodeRecursive(num: SnailNumber, depth: Int): Boolean {
        if (num is ConstantSnailNumber) {
            return false
        }
        num as PairSnailNumber

        if (depth == 4) {
            return true
        }
        return canExplodeRecursive(num.first, depth + 1) || canExplodeRecursive(num.second, depth + 1)
    }

    fun explode(num: PairSnailNumber) {
        val depth = 1
        explodeRecursive(num.first, depth) || explodeRecursive(num.second, depth)
    }

    private fun explodeRecursive(num: SnailNumber, depth: Int): Boolean {
        if (num is ConstantSnailNumber) {
            return false
        }
        num as PairSnailNumber

        if (depth == 4) {
            val foundLeftPair = explodeLeft(num.first as ConstantSnailNumber)
            val foundRightPair = explodeRight(num.second as ConstantSnailNumber)
            if (foundLeftPair && foundRightPair) {
                //set this pair to 0
                val grandparent = num.parent?.parent
                val zero = ConstantSnailNumber(0)
                zero.parent = grandparent
                if (num.parent?.first == num) {
                    num.parent?.first = zero

                } else {
                    num.parent?.second = zero
                }

            }
            return true
        }

        return explodeRecursive(num.first, depth + 1) || explodeRecursive(num.second, depth + 1)
    }

    private fun explodeLeft(number: ConstantSnailNumber): Boolean {
        //find first left constant
        var check = number.parent?.parent
        while (check?.parent != null && check.first !is ConstantSnailNumber) {
            check = check.parent as PairSnailNumber
        }
        if (check?.first is ConstantSnailNumber) {
            (check.first as ConstantSnailNumber).value += number.value
            return true
        } else {
            number.parent?.parent?.first = ConstantSnailNumber(0)
            number.parent?.parent?.first?.parent = number.parent?.parent
            return false
        }
    }

    private fun explodeRight(number: ConstantSnailNumber): Boolean {
        //find first right constant
        var check = number.parent?.parent
        while (check?.parent != null && check.second !is ConstantSnailNumber) {
            check = check.parent as PairSnailNumber
        }
        if (check?.second is ConstantSnailNumber) {
            (check.second as ConstantSnailNumber).value += number.value
            return true
        } else {
            number.parent?.parent?.second = ConstantSnailNumber(0)
            number.parent?.parent?.second?.parent = number.parent?.parent
            return false
        }
    }
}
