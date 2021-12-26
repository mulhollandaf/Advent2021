package day25

class CucumberHelper(input: List<CharArray>) {
    var state = input
    val xMax = state[0].size - 1
    val yMax = state.size - 1
    var hasChanged = false
    fun move(): List<CharArray> {
        hasChanged = false
        val first = turn(state, '>')
        state = turn(first, 'v')
        return state
    }

    private fun turn(map: List<CharArray>, which: Char): List<CharArray> {
        return map.mapIndexed { y, row ->
            row.mapIndexed { x, cell ->
                val new = determineByNeighbors(map, x, y, which)
                hasChanged = hasChanged || new != map[y][x]
                new
            }.toCharArray()
        }
    }

    private fun determineByNeighbors(map: List<CharArray>, x: Int, y: Int, which: Char): Char {
        return if (which == '>') {
            if (leftMoveIntoThis(map, x, y)) {
                '>'
            } else if (thisMoveIntoRight(map,x, y)) {
                '.'
            } else {
                map[y][x]
            }
        } else {
            if (topMoveIntoThis(map,x, y)) {
                'v'
            } else if (thisMoveIntoBottom(map,x, y)) {
                '.'
            } else {
                map[y][x]
            }
        }
    }

    private fun thisMoveIntoBottom(map: List<CharArray>, x: Int, y: Int): Boolean {
        val spaceToTheBottom = if (y == yMax) map[0][x] else map[y+1][x]

        return (map[y][x] == 'v' && spaceToTheBottom == '.')
    }

    private fun thisMoveIntoRight(map: List<CharArray>, x: Int, y: Int): Boolean {
        val spaceToTheRight = if (x == xMax) map[y][0] else map[y][x+1]

        return (map[y][x] == '>' && spaceToTheRight == '.')
    }

    private fun leftMoveIntoThis(map: List<CharArray>, x: Int, y: Int): Boolean {
        return (x > 0 && map[y][x - 1] == '>' && map[y][x] == '.') ||
                (x == 0 && map[y][xMax] == '>' && map[y][x] == '.')
    }

    private fun topMoveIntoThis(map: List<CharArray>, x: Int, y: Int): Boolean {
        return (y > 0 && map[y - 1][x] == 'v' && map[y][x] == '.') ||
                (y == 0 && map[yMax][x] == 'v' && map[y][x] == '.')
    }

    fun runUntilStop(): Int {
        var nTurns = 0
        while (nTurns < 10000) {
            val last = state
            if (nTurns == 54) {
                val oops = true
            }
            output(state)
            nTurns++
            move()
            if (!hasChanged) {
                return nTurns
            }
        }
        return 0
    }

    fun output(state: List<CharArray>) {
        state.forEach { println(String(it)) }
        println()
        println()
    }


}
