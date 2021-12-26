package day25

import org.junit.Test
import readInput
import kotlin.test.assertEquals

class Day25UnitTests {
    @Test
    fun testOneMoveEast() {
        val input = convertToChars(listOf(".>."))
        val helper = CucumberHelper(input)
        val result = helper.move()
        assertEquals(listOf("..>"), result.toListString())

    }

    @Test
    fun testOneMoveEastWrap() {
        val input = convertToChars(listOf("..>"))
        val helper = CucumberHelper(input)
        val result = helper.move()
        assertEquals(listOf(">.."), result.toListString())

    }

    @Test
    fun testMultiMoveEast() {
        val input = convertToChars(listOf(".>>"))
        val helper = CucumberHelper(input)
        val result = helper.move()
        assertEquals(listOf(">>."), result.toListString())

    }

    @Test
    fun testOneMoveSouth() {
        val input = convertToChars(listOf(".v.", "..."))
        val helper = CucumberHelper(input)
        val result = helper.move()
        assertEquals(listOf("...", ".v."), result.toListString())

    }

    @Test
    fun testOneMoveSouthWrap() {
        val input = convertToChars(listOf("...", ".v."))
        val helper = CucumberHelper(input)
        val result = helper.move()
        assertEquals(listOf(".v.", "..."), result.toListString())

    }

    @Test
    fun testMultiMoveSouth() {
        val input = convertToChars(listOf(".v.", ".v.", "..."))
        val helper = CucumberHelper(input)
        val result = helper.move()
        assertEquals(listOf(".v.", "...", ".v."), result.toListString())

    }

    @Test
    fun testTry1() {
        val input = convertToChars(listOf(".>v.v.", "....>."))
        val helper = CucumberHelper(input)
        val result = helper.move()
        assertEquals(listOf(".>....", "..v.v>"), result.toListString())

    }

    @Test
    fun testBig1() {
        val input = convertToChars(listOf(
            "...>...",
            ".......",
            "......>",
            "v.....>",
            "......>",
            ".......",
            "..vvv.."
        )
        )
        val helper = CucumberHelper(input)
        val result = helper.move()
        assertEquals(listOf(
            "..vv>..",
            ".......",
            ">......",
            "v.....>",
            ">......",
            ".......",
            "....v.."

        ), result.toListString())

    }

    @Test
    fun testBig2() {
        val input = convertToChars(listOf(
            "..vv>..",
            ".......",
            ">......",
            "v.....>",
            ">......",
            ".......",
            "....v.."
        )
        )
        val helper = CucumberHelper(input)
        val result = helper.move()
        assertEquals(listOf(
            "....v>.",
            "..vv...",
            ".>.....",
            "......>",
            "v>.....",
            ".......",
            "......."

        ), result.toListString())

    }

    @Test
    fun testBroken() {
        val helper = CucumberHelper(convertToChars(listOf("v.....>", ".......")))
        val result = helper.move()
        assertEquals(listOf("......>", "v......"), result.toListString())
    }

    @Test
    fun testBroken2() {
        val helper = CucumberHelper(convertToChars(listOf(">>.", "v..")))
        val result = helper.move()
        assertEquals(listOf(">.>", "v.."), result.toListString())
    }

    @Test
    fun testBroken3() {
        val input = listOf(
            "..>>v>vv..",
            "..v.>>vvv.",
            "..>>v>>v..",
            "v.>>>>>vvv",
            ".......>v.",
            "v>v....>>v",
            "vvv.>....>",
            ">vv...>...",
            ".>v.vv.v..",
        )

        val helper = CucumberHelper(convertToChars(input))
        val result = helper.move()
        helper.output(result)
    }

    @Test
    fun testStepsUntilStopEmpty() {
        val input = convertToChars(
            listOf(
            "..."
            )
        )
        val helper = CucumberHelper(input)
        val stepsUntilStop = helper.runUntilStop()
        assertEquals(1, stepsUntilStop)
    }

    @Test
    fun testStepsUntilStopExample() {
        val input = convertToChars(
            listOf(
                "v...>>.vv>",
                ".vv>>.vv..",
                ">>.>v>...v",
                ">>v>>.>.v.",
                "v>v.vv.v..",
                ">.>>..v...",
                ".vv..>.>v.",
                "v.v..>>v.v",
                "....v..v.>",
            )
        )
        val helper = CucumberHelper(input)
        val stepsUntilStop = helper.runUntilStop()
        assertEquals(58, stepsUntilStop)
    }

    @Test
    fun testPart1() {
        val input = readInput("day25Full")
        val helper = CucumberHelper(convertToChars(input))
        val stepsUntilStop = helper.runUntilStop()
        assertEquals(571, stepsUntilStop)
    }

    private fun convertToChars(listOf: List<String>): List<CharArray> {
        return listOf.map { row ->
            row.toCharArray()
        }
    }
}

private fun List<CharArray>.toListString(): List<String> {
    return this.map {
        String(it)
    }
}
