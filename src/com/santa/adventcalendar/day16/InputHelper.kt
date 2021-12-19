package com.santa.adventcalendar.day15

class InputHelper {
    fun parse(testData: Array<String>): Array<Array<Int>> {
        return testData.map { row ->
            row.map { cell ->
                val array = CharArray(1)
                array[0] = cell
                Integer.parseInt(String(array))
            }.toTypedArray()
        }.toTypedArray()
    }

}
