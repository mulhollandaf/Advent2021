package com.santa.adventcalendar.day14

class FormulaHelper {
    var rulesMap = mapOf(
        "CH" to arrayOf("CB", "BH"),
        "HH" to arrayOf("HN", "NH"),
        "CB" to arrayOf("CH", "HB"),
        "NH" to arrayOf("NC", "CH"),
        "HB" to arrayOf("HC", "CB"),
        "HC" to arrayOf("HB", "BC"),
        "HN" to arrayOf("HC", "CN"),
        "NN" to arrayOf("NC", "CN"),
        "BH" to arrayOf("BH", "HH"),
        "NC" to arrayOf("NB", "BC"),
        "NB" to arrayOf("NB", "BB"),
        "BN" to arrayOf("BB", "BN"),
        "BB" to arrayOf("BN", "NB"),
        "BC" to arrayOf("BB", "BC"),
        "CC" to arrayOf("CN", "NC"),
        "CN" to arrayOf("CC", "CN")
    )

    fun getMaxMinDifference(formula: Map<String, Long>, start: Char, end: Char): Long {
        val countMap = HashMap<Char, Long>()
        formula.forEach { element ->
            val first = element.key[0]
            val second = element.key[1]
            val val1 = countMap[first] ?: 0
            countMap[first] = val1 + element.value
            val val2 = countMap[second] ?: 0
            countMap[second] = val2 + element.value

        }
        val startVal = countMap[start] ?: 0
        countMap[start] = startVal + 1

        val endVal = countMap[end] ?: 0
        countMap[end] = endVal + 1

        val max = (countMap.values.maxOrNull() ?: 0) / 2
        val min = (countMap.values.minOrNull() ?: 0) / 2
        return max - min
    }

    fun getNewCompound(currentFormula: Map<String, Long>): Map<String, Long>{
        var newFormulaList = HashMap<String, Long>()
        currentFormula.keys.forEach { compound ->
            val value = currentFormula[compound] ?: 0
            val to = rulesMap[compound]
            to?.forEach { newCompound ->
                val current = newFormulaList[newCompound] ?: 0L
                newFormulaList[newCompound] = current + value
            }
        }
        return newFormulaList
    }

    fun processSteps(formula:  Map<String, Long>, nSteps: Int): Map<String, Long> {
        var currentFormula = formula
        for (x in 0 until nSteps) {
            println("Step $x")
            currentFormula = getNewCompound(currentFormula)
            getMaxMinDifference(currentFormula, 'N', 'B')
        }

        return currentFormula
    }

}
