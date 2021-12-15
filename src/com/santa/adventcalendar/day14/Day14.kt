package com.santa.adventcalendar.day14

import readInput

fun main() {
    val formula = "PBFNVFFPCPCPFPHKBONB"
    val formulaMap = formulaToMap(formula)
    val rulesMap = readRules()
    val formulaHelper = FormulaHelper()
    formulaHelper.rulesMap = rulesMap
    val newFormula = formulaHelper.processSteps(formulaMap, 40)
    val length = formulaHelper.getMaxMinDifference(newFormula, 'P', 'B')
    println("Size has grown to $length")
}

fun formulaToMap(formula: String): Map<String, Long> {
    val map = HashMap<String, Long>()
    formula.forEachIndexed{ x, letter ->
        if (x < formula.length - 1) {
            val builder = StringBuilder()
            builder.append(letter).append(formula[x+1])
            val key = builder.toString()
            val current = map[key] ?: 0L
            map[key] = current + 1
        }
    }

    return map
}

fun readRules(): Map<String, Array<String>> {
    val map = HashMap<String, Array<String>>()

    val lines = readInput("day14Rules")
    lines.forEach { line ->
        val parts = line.split(" -> ")
        val key = parts[0]
        val value1 = parts[0].substring(0, 1) + parts[1]
        val value2 = parts[1] + parts[0].substring(1, 2)
        map[key] = arrayOf(value1, value2)
    }

    return map
}
