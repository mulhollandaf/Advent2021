package com.santa.adventcalendar.day4

class BingoBoard(private val cells: Array<Array<Int>>) {
    private val size = cells.size
    private val isMarked = Array(size) { Array(size) { false } }

    fun cellCalled(x: Int, y: Int): Boolean {
        return isMarked[x][y]
    }

    fun didBoardWin(): Boolean {
        var didWin = false
        isMarked.forEachIndexed {index, row ->
            didWin = didWin || didRowWin(row) || didColumnWin(index)
        }
        return didWin
    }

    private fun didColumnWin(index: Int): Boolean {
        var allTrue = true
        isMarked.forEach { row ->
            allTrue = allTrue && row[index]
        }

        return allTrue
    }

    private fun didRowWin(row: Array<Boolean>): Boolean {
        var allTrue = true
        row.forEach { marked ->
            allTrue = allTrue && marked
        }

        return allTrue
    }

    fun callNumber(callNumber: Int) {
        cells.forEachIndexed { rowNumber, row ->
            row.forEachIndexed { columnNumber, cell ->
                if (callNumber == cell) {
                    isMarked[rowNumber][columnNumber] = true
                }
            }
        }
    }

    fun remainingUnmarked(): Int {
        var remainingTotal = 0
        cells.forEachIndexed { rowNumber, row ->
            row.forEachIndexed { columnNumber, cell ->
                if (!isMarked[rowNumber][columnNumber]) {
                    remainingTotal += cell
                }
            }
        }
        return remainingTotal
    }
}
