package com.santa.adventcalendar.day12

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day12UnitTests {

    @Test
    fun isBigCaveTest(){
        val caves = listOf("A", "b", "c", "d")
        val pathHelper = PathHelper(Node("a"))
        val bigCave = pathHelper.isBigCave(caves)
        assertEquals("A", bigCave)
    }

    @Test
    fun smallCaveListTest(){
        val caves = listOf("A", "b", "c", "d")
        val pathHelper = PathHelper(Node("a"))
        val smallCaves = pathHelper.smallCavesList(caves)
        val smallCavesSize = smallCaves.size
        assertEquals(3, smallCavesSize)
    }

    @Test
    fun smallCaveTest(){
        val node = Node("a")
        assertTrue(node.isSmallCave())
    }

    @Test
    fun largeCaveTest(){
        val node = Node("A")
        assertFalse(node.isSmallCave())
    }

    @Test
    fun isEndTest(){
        val node = Node("end")
        assertTrue(node.isEnd())
    }

    @Test
    fun isNotEndTest(){
        val node = Node("start")
        assertFalse(node.isEnd())
    }

    @Test
    fun hasVisitedSmallTest() {
        val node = Node("b")
        val nodeA = Node("A")
        val pathHelper = PathHelper(node)
        assertFalse(pathHelper.canVisit(node, Path(mutableListOf(node, nodeA))))
    }

    @Test
    fun hasVisitedBigTest() {
        val node = Node("A")
        val nodeA = Node("A")
        val pathHelper = PathHelper(node)
        assertTrue(pathHelper.canVisit(node, Path(mutableListOf(node, nodeA))))
    }

    @Test
    fun hasNotVisitedSmallTest() {
        val node = Node("b")
        val pathHelper = PathHelper(node)
        assertTrue(pathHelper.canVisit(node, Path(mutableListOf())))
    }

    @Test
    fun hasNotVisitedBigTest() {
        val node = Node("A")
        val nodeA = Node("A")
        val pathHelper = PathHelper(node)
        assertTrue(pathHelper.canVisit(node, Path(mutableListOf())))
    }

    @Test
    fun nodeSimpleConnectionsTest(){
        val nodeStart = Node("start")
        val nodeEnd = Node("end")
        val nodeA = Node("a")

        nodeStart.connections.add(nodeA)
        nodeEnd.connections.add(nodeA)
        nodeA.connections.add(nodeEnd)

        val pathHelper = PathHelper(nodeStart)
        val possiblePaths = pathHelper.getPossiblePaths()

        assertEquals(1, possiblePaths)

    }

    @Test
    fun nodeConnectionsTest(){
        val nodeStart = Node("start")
        val nodeEnd = Node("end")
        val nodeA = Node("A")
        val nodeB = Node("b")
        val nodeC = Node("c")
        val nodeD = Node("d")

        nodeStart.connections.add(nodeA)
        nodeStart.connections.add(nodeB)
        nodeEnd.connections.add(nodeA)
        nodeEnd.connections.add(nodeB)
        nodeA.connections.add(nodeC)
        nodeA.connections.add(nodeEnd)
        nodeC.connections.add(nodeA)
        nodeA.connections.add(nodeB)
        nodeB.connections.add(nodeA)
        nodeB.connections.add(nodeD)
        nodeB.connections.add(nodeEnd)
        nodeD.connections.add(nodeB)

        val pathHelper = PathHelper(nodeStart)
        val possiblePaths = pathHelper.getPossiblePaths()

        assertEquals(10, possiblePaths)

    }

    @Test
    fun nodeConnectionsMultiTest(){
        val nodeStart = Node("start")
        val nodeEnd = Node("end")
        val nodeA = Node("A")
        val nodeB = Node("b")
        val nodeC = Node("c")
        val nodeD = Node("d")

        nodeStart.connections.add(nodeA)
        nodeStart.connections.add(nodeB)
        nodeEnd.connections.add(nodeA)
        nodeEnd.connections.add(nodeB)
        nodeA.connections.add(nodeC)
        nodeA.connections.add(nodeEnd)
        nodeC.connections.add(nodeA)
        nodeA.connections.add(nodeB)
        nodeB.connections.add(nodeA)
        nodeB.connections.add(nodeD)
        nodeB.connections.add(nodeEnd)
        nodeD.connections.add(nodeB)

        val pathHelper = PathHelper(nodeStart, true)
        val possiblePaths = pathHelper.getPossiblePaths()

        assertEquals(36, possiblePaths)

    }

    @Test
    fun doubleDippedSimplerTest(){
        val nodeStart = Node("start")
        val nodeEnd = Node("end")
        val nodeA = Node("A")
        val nodeB = Node("b")

        nodeStart.connections.add(nodeA)
        nodeStart.connections.add(nodeB)
        nodeEnd.connections.add(nodeA)
        nodeEnd.connections.add(nodeB)
        nodeA.connections.add(nodeEnd)
        nodeA.connections.add(nodeB)
        nodeB.connections.add(nodeA)
        nodeB.connections.add(nodeEnd)

        val helper = PathHelper(nodeStart, true)


        assertEquals(9, helper.getPossiblePaths())

    }

    @Test
    fun doubleDippedSimplerCTest(){
        val nodeStart = Node("start")
        val nodeEnd = Node("end")
        val nodeA = Node("A")
        val nodeB = Node("b")
        val nodeC = Node("c")

        nodeStart.connections.add(nodeA)
        nodeStart.connections.add(nodeB)
        nodeEnd.connections.add(nodeA)
        nodeEnd.connections.add(nodeB)
        nodeA.connections.add(nodeEnd)
        nodeA.connections.add(nodeB)
        nodeA.connections.add(nodeC)
        nodeB.connections.add(nodeA)
        nodeB.connections.add(nodeEnd)
        nodeC.connections.add(nodeA)

        val helper = PathHelper(nodeStart, true)


        assertEquals(28, helper.getPossiblePaths())

    }


    @Test
    fun hasDoubleDippedTest(){
        val nodeStart = Node("start")
        val nodeEnd = Node("end")
        val nodeA = Node("A")
        val nodeB = Node("b")
        val nodeC = Node("c")
        val nodeD = Node("d")

        nodeStart.connections.add(nodeA)
        nodeStart.connections.add(nodeB)
        nodeEnd.connections.add(nodeA)
        nodeEnd.connections.add(nodeB)
        nodeA.connections.add(nodeC)
        nodeA.connections.add(nodeEnd)
        nodeC.connections.add(nodeA)
        nodeA.connections.add(nodeB)
        nodeB.connections.add(nodeA)
        nodeB.connections.add(nodeD)
        nodeB.connections.add(nodeEnd)
        nodeD.connections.add(nodeB)

        val path = Path(mutableListOf(nodeStart, nodeA, nodeC, nodeA, nodeC))


        assertTrue(path.hasDoubleDipped())

    }
}