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
    fun testMultiMoveEast() {
        val input = convertToChars(listOf(".>>"))
        val helper = CucumberHelper(input)
        val result = helper.move()
        assertEquals(listOf(".>."), result.toListString())

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
