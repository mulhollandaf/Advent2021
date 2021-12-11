package com.santa.adventcalendar.day4

import junit.framework.Assert.*
import org.junit.Test

internal class Day4UnitTest {
    class DayFourUnitTest {
        @Test
        fun testMarkBoard(){
            val board = BingoBoard(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
                arrayOf(7, 8, 9)
            ))
            val bingoHelper = BingoHelper(arrayOf(board))
            bingoHelper.callNumber(2)
            assertTrue(bingoHelper.boards[0].cellCalled(0, 1))
            assertFalse(bingoHelper.boards[0].didBoardWin())
        }

        @Test
        fun testMarkBoardRowWin(){
            val board = BingoBoard(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
                arrayOf(7, 8, 9)
            ))
            val bingoHelper = BingoHelper(arrayOf(board))
            bingoHelper.callNumber(2)
            bingoHelper.callNumber(1)
            bingoHelper.callNumber(3)
            assertTrue(bingoHelper.boards[0].cellCalled(0, 1))
            assertTrue(bingoHelper.boards[0].didBoardWin())
        }

        @Test
        fun testMarkBoardColumnWin(){
            val board = BingoBoard(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
                arrayOf(7, 8, 9)
            ))
            val bingoHelper = BingoHelper(arrayOf(board))
            bingoHelper.callNumber(2)
            bingoHelper.callNumber(8)
            bingoHelper.callNumber(5)
            assertTrue(bingoHelper.boards[0].cellCalled(0, 1))
            assertTrue(bingoHelper.boards[0].didBoardWin())
        }

        @Test
        fun testRowWinRemaining(){
            val board = BingoBoard(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
                arrayOf(7, 8, 9)
            ))
            val bingoHelper = BingoHelper(arrayOf(board))
            bingoHelper.callNumber(2)
            bingoHelper.callNumber(1)
            bingoHelper.callNumber(3)
            assertEquals(39, bingoHelper.boards[0].remainingUnmarked())
        }

        @Test
        fun testGetLastBoardToWin(){
            val board1 = BingoBoard(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
                arrayOf(7, 8, 9)
            ))

            val board2 = BingoBoard(arrayOf(
                arrayOf(11, 12, 13),
                arrayOf(14, 15, 16),
                arrayOf(17, 18, 19)
            ))

            val bingoHelper = BingoHelper(arrayOf(board1, board2), false)
            bingoHelper.callNumber(2)
            bingoHelper.callNumber(1)
            bingoHelper.callNumber(3)

            bingoHelper.callNumber(11)
            bingoHelper.callNumber(12)
            bingoHelper.callNumber(13)
            assertEquals(1, bingoHelper.remainingBoards.size)
            assertEquals(board2, bingoHelper.remainingBoards[0])
        }
    }
}