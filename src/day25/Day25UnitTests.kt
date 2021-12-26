package day25

import org.junit.Test
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
    fun testStepsUntilStopEmpty() {
        val input = convertToChars(listOf(
            "..."
        )
        )
        val helper = CucumberHelper(input)
        val stepsUntilStop = helper.runUntilStop()
        assertEquals(1, stepsUntilStop)
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
