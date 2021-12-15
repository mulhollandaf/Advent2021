package com.santa.adventcalendar.day13

class FoldGrid() {
    lateinit var dots: Array<Array<Boolean>>


    fun placeDots(dotsLocation: Array<Pair<Int, Int>>) {
        if (dotsLocation.isNotEmpty()) {
            val maxX = dotsLocation.maxOf { it.first } + 1
            val maxY = dotsLocation.maxOf { it.second } + 1
            createGrid(maxX, maxY)
            dotsLocation.forEach { point ->
                dots[point.first][point.second] = true
            }
        }
    }

    fun createGrid(x: Int, y: Int) {
        dots =  Array(x) {
            Array(y) { false }
        }
    }


}
