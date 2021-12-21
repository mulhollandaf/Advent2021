package com.santa.adventcalendar.day20

import org.junit.Test
import kotlin.test.assertEquals

class Day20UnitTest {

    @Test
    fun readNeighborTest(){
        val trenchMap = arrayOf(
            arrayOf(0, 0, 0),
            arrayOf(0, 1, 0),
            arrayOf(0, 1, 0))
        val imageHelper = ImageHelper()
        val neighbors = imageHelper.getNeighbors(trenchMap, 1, 1).toString()
        assertEquals("[0, 0, 0, 0, 1, 0, 0, 1, 0]", neighbors)
    }

    @Test
    fun toDecimalTest(){
        val neighborsList = mutableListOf<Int>(0,0,0,0,1,0,0,1,0)
        val imageHelper = ImageHelper()
        val pixelIndex = imageHelper.getPixelIndex(neighborsList)
        assertEquals(18, pixelIndex)
    }

    @Test
    fun newPixelBrightnessTest(){
        val pixelIndex = 18
        val key = arrayOf(0,0,1,0,1,0,0,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,0,1,1,0,0,0,0,0,1,1,1,0,1,1,0,1,0,0,1,1,1,0,1,1,1,1,0,0,1,1,1,1,1,0,0,1,0,0,0,0,1,0,0,1,0,0,1,1,0,0,1,1,1,0,0,1,1,1,1,1,1,0,1,1,1,0,0,0,1,1,1,1,0,0,1,0,0,1,1,1,1,1,0,0,1,1,0,0,1,0,1,1,1,1,1,0,0,0,1,1,0,1,0,1,0,0,1,0,1,1,0,0,1,0,1,0,0,0,0,0,0,1,0,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,0,0,0,1,0,1,1,0,1,1,0,0,1,0,0,1,0,0,1,1,1,1,1,0,0,0,0,0,1,0,1,0,0,0,0,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,1,0,0,1,0,0,0,1,1,0,1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,1,0,1,0,0,0,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,0,1,0,0,0,1,1,0,1,0,1,1,0,0,1,0,0,0,1,1,0,1,0,1,1,0,0,1,1,1,0,1,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0,1,0,1,0,1,1,1,1,0,1,1,1,0,1,1,0,0,0,1,0,0,0,0,0,1,1,1,1,0,1,0,0,1,0,0,1,0,1,1,0,1,0,0,0,0,1,1,0,0,1,0,1,1,1,1,0,0,0,0,1,1,0,0,0,1,1,0,0,1,0,0,0,1,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,0,0,1,1,1,1,0,0,1,0,0,0,1,0,1,0,1,0,0,0,1,1,0,0,1,0,1,0,0,1,1,1,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,1,0,0,1,1,1,1,0,0,0,0,0,0,1,0,0,1)
        val imageHelper = ImageHelper()
        val pixelBrightness = imageHelper.getPixelBrightness(key, pixelIndex)
        assertEquals(0, pixelBrightness)
    }

    @Test
    fun readNeighborTopLeftTest(){
        val trenchMap = arrayOf(
            arrayOf(1, 0, 0),
            arrayOf(0, 1, 1),
            arrayOf(1, 1, 0))
        val imageHelper = ImageHelper()
        val neighbors = imageHelper.getNeighbors(trenchMap, 0, 0).toString()
        assertEquals("[0, 0, 0, 0, 1, 0, 0, 0, 1]", neighbors)
    }

    @Test
    fun readNeighborBottomRightTest(){
        val trenchMap = arrayOf(
            arrayOf(1, 0, 0),
            arrayOf(0, 1, 1),
            arrayOf(1, 1, 0))
        val imageHelper = ImageHelper()
        val neighbors = imageHelper.getNeighbors(trenchMap, 2, 2).toString()
        assertEquals("[1, 1, 0, 1, 0, 0, 0, 0, 0]", neighbors)
    }

    @Test
    fun addRingTest(){
        val trenchMap = arrayOf(
            arrayOf(1, 0, 0),
            arrayOf(0, 1, 1),
            arrayOf(1, 1, 0))
        val imageHelper = ImageHelper()
        val ring = imageHelper.addRing(trenchMap, 1)
        assertEquals(5, ring.size)
        assertEquals(5, ring[0].size)
        assertEquals(0, ring[0][0])
        assertEquals(1, ring[1][1])
    }

    @Test
    fun transform1Test() {
        val keyString = "..#.#..#####.#.#.#.###.##.....###.##.#..###.####..#####..#....#..#..##..##" +
                "#..######.###...####..#..#####..##..#.#####...##.#.#..#.##..#.#......#.###" +
                ".######.###.####...#.##.##..#..#..#####.....#.#....###..#.##......#.....#." +
                ".#..#..##..#...##.######.####.####.#.#...#.......#..#.#.#...####.##.#....." +
                ".#..#...##.#.##..#...##.#.##..###.#......#.#.......#.#.#.####.###.##...#.." +
                "...####.#..#..#.##.#....##..#.####....##...##..#...#......#.#.......#....." +
                "..##..####..#...#.#.#...##..#.#..###..#####........#..####......#..#"
        val helper = ImageHelper()
        val grid = arrayOf(
            arrayOf(1,0,0,1,0),
            arrayOf(1,0,0,0,0),
            arrayOf(1,1,0,0,1),
            arrayOf(0,0,1,0,0),
            arrayOf(0,0,1,1,1),
        )
        val key = helper.createKey(keyString)
        val transformed = helper.transform(grid, key)
        assertEquals(7, transformed.size)
        assertEquals(7, transformed[0].size)
        assertEquals(0, transformed[0][0])
        assertEquals(1, transformed[1][0])
        assertEquals(1, transformed[2][0])
        assertEquals(1, transformed[3][0])
        assertEquals(0, transformed[4][0])
        assertEquals(0, transformed[5][0])
        assertEquals(0, transformed[6][0])
    }

    @Test
    fun doubleTransformTest() {
        val keyString = "..#.#..#####.#.#.#.###.##.....###.##.#..###.####..#####..#....#..#..##..##" +
                "#..######.###...####..#..#####..##..#.#####...##.#.#..#.##..#.#......#.###" +
                ".######.###.####...#.##.##..#..#..#####.....#.#....###..#.##......#.....#." +
                ".#..#..##..#...##.######.####.####.#.#...#.......#..#.#.#...####.##.#....." +
                ".#..#...##.#.##..#...##.#.##..###.#......#.#.......#.#.#.####.###.##...#.." +
                "...####.#..#..#.##.#....##..#.####....##...##..#...#......#.#.......#....." +
                "..##..####..#...#.#.#...##..#.#..###..#####........#..####......#..#"
        val helper = ImageHelper()
        val grid = arrayOf(
            arrayOf(1,0,0,1,0),
            arrayOf(1,0,0,0,0),
            arrayOf(1,1,0,0,1),
            arrayOf(0,0,1,0,0),
            arrayOf(0,0,1,1,1),
        )
        val key = helper.createKey(keyString)
        var transformed = helper.transform(grid, key)
        transformed = helper.transform(transformed, key)
        assertEquals(9, transformed.size)
        assertEquals(9, transformed[0].size)
        assertEquals(0, transformed[0][0])
        assertEquals(0, transformed[1][0])
        assertEquals(1, transformed[2][0])
        assertEquals(1, transformed[3][0])
        assertEquals(1, transformed[4][0])
        assertEquals(0, transformed[5][0])
        assertEquals(0, transformed[6][0])
        assertEquals(0, transformed[7][0])
        assertEquals(0, transformed[8][0])
    }

    @Test
    fun litTest() {
        val keyString = "..#.#..#####.#.#.#.###.##.....###.##.#..###.####..#####..#....#..#..##..##" +
                "#..######.###...####..#..#####..##..#.#####...##.#.#..#.##..#.#......#.###" +
                ".######.###.####...#.##.##..#..#..#####.....#.#....###..#.##......#.....#." +
                ".#..#..##..#...##.######.####.####.#.#...#.......#..#.#.#...####.##.#....." +
                ".#..#...##.#.##..#...##.#.##..###.#......#.#.......#.#.#.####.###.##...#.." +
                "...####.#..#..#.##.#....##..#.####....##...##..#...#......#.#.......#....." +
                "..##..####..#...#.#.#...##..#.#..###..#####........#..####......#..#"
        val helper = ImageHelper()
        val grid = arrayOf(
            arrayOf(1,0,0,1,0),
            arrayOf(1,0,0,0,0),
            arrayOf(1,1,0,0,1),
            arrayOf(0,0,1,0,0),
            arrayOf(0,0,1,1,1),
        )
        val key = helper.createKey(keyString)
        var transformed = helper.transform(grid, key)
        transformed = helper.transform(transformed, key)
        val lit = helper.getLit(transformed, 16)
        assertEquals(35, lit)
    }


}