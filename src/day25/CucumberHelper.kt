package day25

class CucumberHelper(input: List<CharArray>) {
    val state = input
    fun move(): List<CharArray> {
        return state.mapIndexed {y, row ->
            row.mapIndexed {x, cell ->
                determineByNeighbors(x, y, state)
            }.toCharArray()
        }
    }

    private fun determineByNeighbors(x: Int, y: Int, map: List<CharArray>): Char {
        return if (map[y][x] != '.') {
            map[y][x]
        }
        else if (x > 0 && map[y][x - 1] == '>') {
            '>'
        } else {
            '.'
        }
    }

}
