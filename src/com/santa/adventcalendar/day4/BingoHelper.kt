package com.santa.adventcalendar.day4

class BingoHelper(val boards: Array<BingoBoard>, private val toWin: Boolean = true) {
    val remainingBoards = boards.toMutableList()

    fun callNumber(callNumber: Int) {
        remainingBoards.forEach { board ->
            board.callNumber(callNumber)
        }
        if (!toWin && remainingBoards.size > 1) {
            remainingBoards.removeAll { board ->
                board.didBoardWin()
            }
        }
    }
}
