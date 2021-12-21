package com.santa.adventcalendar.day20

import readInput

fun main() {
    val keyString = "#.#.##...###......#.##..#..##....#.#.##...#..###....##...#####.#...#.#.#...#..###..#...#......####..#.#..########.#.###......##.##...###.###..######.....####.#..#.#..##..###..####..#....####..######.###..###.........##.##.###......##...#####.######..#.....##..#..#...#.#...#..#..#.#..#..#.##..#####..##.###.####...#..#....##....####...#.#.#.#.#.###...##..#....##......####.##.###...#####..##..#.#...#..#.#..####.###..###..#..####....#.#.##.#..#...#.#...##...#..#.#.##...##..##.####..#...###.#...#####.######....."
    val helper = ImageHelper()
    val key = helper.createKey(keyString)
    val grid = readGrid()
    outputGrid(grid)
    var bigGrid = helper.addRing(grid, 120)
    val nTimes = 50
    var newGrid = bigGrid
    for (x in 0 until nTimes) {
        newGrid = helper.transform(newGrid, key)
    }

    outputGrid(newGrid)
    val lit = helper.getLit(newGrid, 52)
    println("So Lit!!! $lit")
}

fun outputGrid(grid: Array<Array<Int>>) {
    grid.forEach { column ->
        column.forEach { cell ->
            val letter = if (cell == 1) "#" else "."
            print(letter)
        }
        println()
    }

    println()
    println()
}

fun readGrid(): Array<Array<Int>> {
    val lines = readInput("day20Grid")
    val xSize = lines.size
    val ySize = lines[0].length
    return Array(xSize) { x ->
        Array(ySize) { y ->
            if (lines[x][y] == '#') 1 else 0
        }
    }
}
