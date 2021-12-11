package com.santa.adventcalendar.day4

import readInput

fun main() {
    val numbers = readNumbersFromFile()
    val boards = readBoardsFromFile()
    //com.santa.adventcalendar.day5.PlayToWin().playToWin(numbers, boards)
    PlayToLose().playToLose(numbers, boards)
}

fun readBoardsFromFile(): Array<BingoBoard> {
    val data = readInput("day4Boards")
    val boards = mutableListOf<BingoBoard>()
    var currentBoard = mutableListOf<List<Int>>()
    data.forEach { line ->
        if (line.isEmpty()) {
            boards.add(createBoard(currentBoard))
            currentBoard = mutableListOf()
        } else {
            currentBoard.add(parseRow(line))
        }
    }
    boards.add(createBoard(currentBoard))
    return boards.toTypedArray()
}

fun createBoard(boardData: List<List<Int>>): BingoBoard {
    val listOfArrays = boardData.map {
        it.toTypedArray()
    }
    return BingoBoard(listOfArrays.toTypedArray())
}

fun readNumbersFromFile(): Array<Int> {
    val data = readInput("day4Numbers")
    val numbers = data[0].split(",")
    return numbers.mapNotNull {
        if (it.isEmpty()) {
            null
        } else {
            Integer.parseInt(it)
        }
    }.toTypedArray()
}

fun parseRow(line: String): List<Int> {
    return line.split(" ").mapNotNull {
        if (it.isEmpty()) {
            null
        } else {
            Integer.parseInt(it)
        }
    }
}

