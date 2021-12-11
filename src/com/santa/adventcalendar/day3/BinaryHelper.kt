package com.santa.adventcalendar.day3

class BinaryHelper {
    fun getGammaRate(input: Array<String>): String {
        var answer = ""
        val length = input[0].length
        for (x in 0 until length) {
            answer += getMostCommonDigit(input, x)
        }

        return answer
    }

    fun getEpsilonRate(input: Array<String>): String {
        val gamma = getGammaRate(input)
        return invert(gamma)
    }

    private fun invert(binary: String): String {
        val charArray = binary.map { digit ->
            if (digit == '1') {
                '0'
            } else {
                '1'
            }
        }.toCharArray()
        return String(charArray)
    }

    private fun getMostCommonDigit(input: Array<String>, x: Int): String {
        var moreOnes = 0
        input.forEach { binary ->
            if (binary[x] == '1') {
                moreOnes++
            } else {
                moreOnes--
            }
        }
        return if (moreOnes >= 0) {
            "1"
        } else {
            "0"
        }
    }

    fun toInt(binary: String): Int {
        var total = 0
        binary.forEach { digit ->
            total *= 2
            if (digit == '1') {
                total++
            }
        }
        return total
    }

    fun getOxygenRate(input: Array<String>): String {
        val length = input[0].length
        var remainingInputs = input
        for (x in 0 until length) {
            val mostCommon = getMostCommonDigit(remainingInputs, x)
            remainingInputs = filterByDigitValue(remainingInputs, x, mostCommon)
            if (remainingInputs.size == 1) {
                return remainingInputs[0]
            }
        }

        return remainingInputs[0]
    }

    private fun filterByDigitValue(
        remaining: Array<String>,
        index: Int,
        keepValue: String
    ): Array<String> {
        return remaining.filter { value ->
            value[index].toString() == keepValue
        }.toTypedArray()
    }

    fun getCO2Rate(input: Array<String>): String {
        val length = input[0].length
        var remainingInputs = input
        for (x in 0 until length) {
            val mostCommon = getMostCommonDigit(remainingInputs, x)
            val leastCommon = if (mostCommon == "1") "0" else "1"
            remainingInputs = filterByDigitValue(remainingInputs, x, leastCommon)
            if (remainingInputs.size == 1) {
                return remainingInputs[0]
            }
        }

        return remainingInputs[0]
    }

}