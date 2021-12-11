package com.santa.adventcalendar.day10

import java.util.*

class SyntaxHelper {
    private val starting = "[{(<"
    private val syntaxStack = Stack<Char>()
    fun getErrorValue(lines: String): Int {
        syntaxStack.clear()
        lines.forEach { syntax ->
            if (starting.contains(syntax)) {
                syntaxStack.push(syntax)
            }
            else if (syntaxStack.isEmpty()){
                return 0
            }
            else {
                val pop = syntaxStack.pop()
                if (syntax == ']' && pop != '[') {
                    return 57
                } else if (syntax == '}' && pop != '{') {
                    return 1197
                } else if (syntax == ')' && pop != '(') {
                    return 3
                } else if (syntax == '>' && pop != '<') {
                    return 25137
                }
            }
        }
        return 0
    }

    fun getTotalError(lines: List<String>): Int {
        return lines.sumOf { line ->
            getErrorValue(line)
        }
    }

    fun getIncompleteValue(lines: String): Long {
        syntaxStack.clear()
        lines.forEach { syntax ->
            if (starting.contains(syntax)) {
                syntaxStack.push(syntax)
            }
            else if (syntaxStack.isEmpty()){
                return 0
            }
            else {
                val pop = syntaxStack.pop()
                if (syntax == ']' && pop != '[') {
                    return 0
                } else if (syntax == '}' && pop != '{') {
                    return 0
                } else if (syntax == ')' && pop != '(') {
                    return 0
                } else if (syntax == '>' && pop != '<') {
                    return 0
                }
            }
        }
        return scoreQueue(syntaxStack)
    }

    private fun scoreQueue(syntaxStack: Stack<Char>): Long {
        var score = 0L
        val size = syntaxStack.size
        for (x in 0 until size) {
            score = score * 5 + scoreOf(syntaxStack.pop())
        }

        return score
    }

    private fun scoreOf(letter: Char): Int {
        return when(letter) {
            '(' -> 1
            '[' -> 2
            '{' -> 3
            '<' -> 4
            else -> 0
        }
    }

    fun getMiddleIncomplete(lines: List<String>): Long {
        val errors = lines.map { line ->
            getIncompleteValue(line)
        }.filter { it != 0L }.sorted()
        val mid = (errors.size / 2)
        return errors[mid]
    }

}
