package com.santa.adventcalendar.day18

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Day18UnitTests {

    @Test
    fun createPairTest () {
        val snailNumber = PairSnailNumber(ConstantSnailNumber(1), ConstantSnailNumber(2))
        val snailNumber2 = PairSnailNumber(
            PairSnailNumber(
                ConstantSnailNumber(1),
                ConstantSnailNumber(2)
            ),
            ConstantSnailNumber(3)
        )
    }

    @Test
    fun parseTest() {
        val helper = SnailFishHelper()
        assertEquals("[1,2]", helper.parse("[1,2]").toString())
        assertEquals("[[1,2],3]", helper.parse("[[1,2],3]").toString())
        assertEquals("[9,[8,7]]", helper.parse("[9,[8,7]]").toString())
        assertEquals("[[1,9],[8,5]]", helper.parse("[[1,9],[8,5]]").toString())
        assertEquals("[[[[1,2],[3,4]],[[5,6],[7,8]]],9]",
            helper.parse("[[[[1,2],[3,4]],[[5,6],[7,8]]],9]").toString())
        assertEquals("[[[9,[3,8]],[[0,9],6]],[[[3,7],[4,9]],3]]",
            helper.parse("[[[9,[3,8]],[[0,9],6]],[[[3,7],[4,9]],3]]").toString())
        assertEquals("[[[[1,3],[5,3]],[[1,3],[8,7]]],[[[4,9],[6,9]],[[8,2],[7,3]]]]",
            helper.parse("[[[[1,3],[5,3]],[[1,3],[8,7]]],[[[4,9],[6,9]],[[8,2],[7,3]]]]").toString())
    }

    @Test
    fun addTwoTest(){
        val helper = SnailFishHelper()
        val num1 = helper.parse("[1,2]")
        val num2 = helper.parse("[[3,4],5]")
        val sum = helper.add(num1, num2)
        assertEquals("[[1,2],[[3,4],5]]", sum.toString())
    }

    @Test
    fun canExplodeTest() {
        val helper = SnailFishHelper()
        val num = helper.parse("[[[[[9,8],1],2],3],4]")
        assertTrue(helper.canExplode(num))

    }
    @Test
    fun explodeTest() {
        val helper = SnailFishHelper()
        val num = helper.parse("[[[[[9,8],1],2],3],4]")
        helper.explode(num)
        assertEquals("[[[[0,9],2],3],4]", num.toString())
    }

    @Test
    fun explode2Test() {
        val helper = SnailFishHelper()
        val num = helper.parse("[7,[6,[5,[4,[3,2]]]]]")
        helper.explode(num)
        assertEquals("[7,[6,[5,[7,0]]]]", num.toString())
    }

    @Test
    fun explode3Test() {
        val helper = SnailFishHelper()
        val num = helper.parse("[[6,[5,[4,[3,2]]]],1]")
        helper.explode(num)
        assertEquals("[[6,[5,[7,0]]],3]", num.toString())
    }

    @Test
    fun explode4Test() {
        val helper = SnailFishHelper()
        val num = helper.parse("[[3,[2,[1,[7,3]]]],[6,[5,[4,[3,2]]]]]")
        helper.explode(num)
        assertEquals("[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]", num.toString())
    }

}