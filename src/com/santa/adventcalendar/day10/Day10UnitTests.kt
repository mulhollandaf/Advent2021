package com.santa.adventcalendar.day10

import org.junit.Test
import kotlin.test.assertEquals

class Day10UnitTests {

    @Test
    fun chunkErrorTest(){
        val lines = "[[{<)>}]]"
        val syntaxHelper = SyntaxHelper()
        val error = syntaxHelper.getErrorValue(lines)
        assertEquals(3, error)
    }
    @Test
    fun chunkNoErrorTest(){
        val lines = "[({(<(())[]>[[{[]{<()<>>"
        val syntaxHelper = SyntaxHelper()
        val error = syntaxHelper.getErrorValue(lines)
        assertEquals(0, error)
    }

    @Test
    fun totalErrorTest() {
        val lines = listOf(
            "[({(<(())[]>[[{[]{<()<>>",
            "[(()[<>])]({[<{<<[]>>(",
            "{([(<{}[<>[]}>{[]{[(<()>",
            "(((({<>}<{<{<>}{[]{[]{}",
            "[[<[([]))<([[{}[[()]]]",
            "[{[{({}]{}}([{[{{{}}([]",
            "{<[[]]>}<{[{[{[]{()[[[]",
            "[<(<(<(<{}))><([]([]()",
            "<{([([[(<>()){}]>(<<{{",
            "<{([{{}}[<[[[<>{}]]]>[]]"
        )
        val syntaxHelper = SyntaxHelper()
        val error = syntaxHelper.getTotalError(lines)
        assertEquals(26397, error)
    }

    @Test
    fun incompleteScoreTest(){
        val lines = "[({(<(())[]>[[{[]{<()<>>"
        val syntaxHelper = SyntaxHelper()
        val error = syntaxHelper.getIncompleteValue(lines)
        assertEquals(288957, error)
    }

    @Test
    fun midIncompleteTest() {
        val lines = listOf(
            "[({(<(())[]>[[{[]{<()<>>",
            "[(()[<>])]({[<{<<[]>>(",
            "{([(<{}[<>[]}>{[]{[(<()>",
            "(((({<>}<{<{<>}{[]{[]{}",
            "[[<[([]))<([[{}[[()]]]",
            "[{[{({}]{}}([{[{{{}}([]",
            "{<[[]]>}<{[{[{[]{()[[[]",
            "[<(<(<(<{}))><([]([]()",
            "<{([([[(<>()){}]>(<<{{",
            "<{([{{}}[<[[[<>{}]]]>[]]"
        )
        val syntaxHelper = SyntaxHelper()
        val incomplete = syntaxHelper.getMiddleIncomplete(lines)
        assertEquals(288957, incomplete)
    }
}