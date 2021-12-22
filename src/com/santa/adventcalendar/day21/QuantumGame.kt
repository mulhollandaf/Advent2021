package com.santa.adventcalendar.day21

private val frequency: Map<Int, Long> = mapOf(3 to 1, 4 to 3, 5 to 6, 6 to 7, 7 to 6, 8 to 3, 9 to 1)


data class QuantumState(val player1: PlayerState, val player2: PlayerState, val player1Turn: Boolean)

data class PlayerState(val currentSpace: Int, val totalScore: Int)

class QuantumGame(player1Start: Int, player2Start: Int) {
    val initialState = QuantumState(PlayerState(player1Start, 0), PlayerState(player2Start, 0), true)

    fun play(state: QuantumState): Pair<Long, Long> {
        return if (state.player1.totalScore >= 21 || state.player2.totalScore >= 21) {
            if (state.player1Turn) {
                Pair(0,1)
            } else Pair(1,0)
        } else {
            var sumPair = Pair(0L,0L)
            frequency.keys.forEach { key ->
                val frequency = frequency[key] ?: 0
                val result = play(updateState(state, key))
                sumPair = Pair(sumPair.first + result.first * frequency,
                    sumPair.second + result.second * frequency)
            }

            sumPair
        }
    }

    private fun updateState(state: QuantumState, roll: Int): QuantumState {
        val player1State = state.player1
        val player2State = state.player2
        val currentPlayer = if(state.player1Turn) player1State else player2State
        val newSquare = (currentPlayer.currentSpace + roll - 1) % 10 + 1
        val newScore = currentPlayer.totalScore + newSquare
        val newState = PlayerState(newSquare, newScore)

        return if (state.player1Turn) {
            QuantumState(newState, player2State, false)
        } else {
            QuantumState(player1State, newState, true)
        }
    }
}
