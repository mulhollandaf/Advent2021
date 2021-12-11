package com.santa.adventcalendar.day4

class PlayToWin() {
    fun playToWin(numbers: Array<Int>, boards: Array<BingoBoard>) {
        val bingoHelper = BingoHelper(boards)
        numbers.forEach { number ->
            bingoHelper.callNumber(number)
            boards.forEach { board ->
                if (board.didBoardWin()) {
                    println("Winner winner Chicken Dinner")
                    val unmarked = board.remainingUnmarked()
                    println("unmarked = $unmarked, lastCalled = $number, product = ${unmarked * number}")
                    return
                }
            }
        }
    }
}