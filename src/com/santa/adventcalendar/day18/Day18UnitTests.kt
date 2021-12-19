package com.santa.adventcalendar.day18

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Day18UnitTests {
    @Test
    fun addTwoTest(){
        val helper = SnailFishHelper()
        val num1 = "[1,2]"
        val num2 = "[[3,4],5]"
        val sum = helper.add(num1, num2)
        assertEquals("[[1,2],[[3,4],5]]", sum)
    }

    @Test
    fun canExplodeTest() {
        val helper = SnailFishHelper()
        val num = "[[[[[9,8],1],2],3],4]"
        assertTrue(helper.indexOfFirstExplode(num) > -1)

    }
    @Test
    fun explodeTest() {
        val helper = SnailFishHelper()
        val num = "[[[[[9,8],1],2],3],4]"
        val exploded = helper.explode(num)
        assertEquals("[[[[0,9],2],3],4]", exploded)
    }

    @Test
    fun explodeTwoDigitTest() {
        val helper = SnailFishHelper()
        val num = "[[[[[9,18],1],2],3],4]"
        val exploded = helper.explode(num)
        assertEquals("[[[[0,19],2],3],4]", exploded)
    }

    @Test
    fun explodeDoubleTwoDigitTest() {
        val helper = SnailFishHelper()
        val num = "[[[[[19,18],1],2],3],4]"
        val exploded = helper.explode(num)
        assertEquals("[[[[0,19],2],3],4]", exploded)
    }

    @Test
    fun explodeIntoTwoDigitTest() {
        val helper = SnailFishHelper()
        val num = "[[[[4,0],[5,4]],[[7,7],[0,[6,7]]]],[10,[[11,9],[11,0]]]]"
        val exploded = helper.explode(num)
        assertEquals("[[[[4,0],[5,4]],[[7,7],[6,0]]],[17,[[11,9],[11,0]]]]", exploded)
    }

    @Test
    fun explodeIntoTwoDigitsLeft() {
        val helper = SnailFishHelper()
        val num = "[[[[12,12],[6,14]],[[15,0],[17,[8,1]]]],[2,9]]"
        val exploded = helper.explode(num)
        assertEquals("[[[[12,12],[6,14]],[[15,0],[25,0]]],[3,9]]", exploded)
    }

    @Test
    fun explode2Test() {
        val helper = SnailFishHelper()
        val num = "[7,[6,[5,[4,[3,2]]]]]"
        val exploded = helper.explode(num)
        assertEquals("[7,[6,[5,[7,0]]]]", exploded)
    }

    @Test
    fun explode3Test() {
        val helper = SnailFishHelper()
        val num = "[[6,[5,[4,[3,2]]]],1]"
        val exploded = helper.explode(num)
        assertEquals("[[6,[5,[7,0]]],3]", exploded)
    }

    @Test
    fun explode4Test() {
        val helper = SnailFishHelper()
        val num = "[[3,[2,[1,[7,3]]]],[6,[5,[4,[3,2]]]]]"
        val exploded = helper.explode(num)
        assertEquals("[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]", exploded)
    }

    @Test
    fun explode5Test() {
        val helper = SnailFishHelper()
        val num = "[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]"
        val exploded = helper.explode(num)
        assertEquals("[[3,[2,[8,0]]],[9,[5,[7,0]]]]", exploded)
    }

    @Test
    fun splitTest() {
        val helper = SnailFishHelper()
        val num = "[[[[0,7],4],[15,[0,13]]],[1,1]]"
        val split = helper.split(num)
        assertEquals("[[[[0,7],4],[[7,8],[0,13]]],[1,1]]", split)
    }

    @Test
    fun split2Test() {
        val helper = SnailFishHelper()
        val num = "[[[[0,7],4],[[7,8],[0,13]]],[1,1]]"
        val split = helper.split(num)
        assertEquals("[[[[0,7],4],[[7,8],[0,[6,7]]]],[1,1]]", split)
    }

    @Test
    fun reduceTest() {
        val helper = SnailFishHelper()
        val num = "[[[[[4,3],4],4],[7,[[8,4],9]]],[1,1]]"
        val reduce = helper.reduce(num)
        assertEquals("[[[[0,7],4],[[7,8],[6,0]]],[8,1]]", reduce)
    }

    @Test
    fun reduce2Test() {
        val helper = SnailFishHelper()
        val num = "[[[[[4,3],4],4],[7,[[8,4],9]]],[1,1]]"
        val reduce = helper.reduce(num)
        assertEquals("[[[[0,7],4],[[7,8],[6,0]]],[8,1]]", reduce)
    }

    @Test
    fun addReduceTest() {
        val helper = SnailFishHelper()
        val inputs = arrayOf("[1,1]", "[2,2]", "[3,3]", "[4,4]", "[5,5]")
        val num = helper.addReduce(inputs)
        assertEquals("[[[[3,0],[5,3]],[4,4]],[5,5]]", num)
    }

    @Test
    fun addReduce2Test() {
        val helper = SnailFishHelper()
        val inputs = arrayOf("[1,1]", "[2,2]", "[3,3]", "[4,4]", "[5,5]", "[6,6]")
        val num = helper.addReduce(inputs)
        assertEquals("[[[[5,0],[7,4]],[5,5]],[6,6]]", num)
    }

    @Test
    fun addReduce3Test() {
        val helper = SnailFishHelper()
        val inputs = arrayOf(
            "[[[0,[4,5]],[0,0]],[[[4,5],[2,6]],[9,5]]]",
            "[7,[[[3,7],[4,3]],[[6,3],[8,8]]]]",
            "[[2,[[0,8],[3,4]]],[[[6,7],1],[7,[1,6]]]]",
            "[[[[2,4],7],[6,[0,5]]],[[[6,8],[2,8]],[[2,1],[4,5]]]]",
            "[7,[5,[[3,8],[1,4]]]]",
            "[[2,[2,2]],[8,[8,1]]]",
            "[2,9]",
            "[1,[[[9,3],9],[[9,0],[0,7]]]]",
            "[[[5,[7,4]],7],1]",
            "[[[[4,2],2],6],[8,7]]")
        val num = helper.addReduce(inputs)
        assertEquals("[[[[8,7],[7,7]],[[8,6],[7,7]]],[[[0,7],[6,6]],[8,7]]]", num)
    }

    @Test
    fun brokenAddReduceTest() {
        val inputs = arrayOf(
            "[[[[6,6],[6,6]],[[6,0],[6,7]]],[[[7,7],[8,9]],[8,[8,1]]]]",
            "[2,9]"
        )
        val helper = SnailFishHelper()
        val num = helper.addReduce(inputs)
        assertEquals("[[[[6,6],[7,7]],[[0,7],[7,7]]],[[[5,5],[5,6]],9]]", num)
    }

    @Test
    fun magTest() {
        val num = "[[9,1],[1,9]]"
        val helper = SnailFishHelper()
        val mag = helper.getMagnitude(num)
        assertEquals(129, mag)
    }
}