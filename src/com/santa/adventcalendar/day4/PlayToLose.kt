package com.santa.adventcalendar.day4

class PlayToLose {
    fun playToLose(numbers: Array<Int>, boards: Array<BingoBoard>) {
        val bingoHelper = BingoHelper(boards, false)
        numbers.forEach { number ->
            bingoHelper.callNumber(number)
            if (bingoHelper.remainingBoards.size == 1 && bingoHelper.remainingBoards[0].didBoardWin()) {
                val losingBoard = bingoHelper.remainingBoards[0]
                println("Loser loser not the chooser")
                val unmarked = losingBoard.remainingUnmarked()
                println("unmarked = $unmarked, lastCalled = $number, product = ${unmarked * number}")
                return
            }
        }
    }
}