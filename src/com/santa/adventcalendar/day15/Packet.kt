package com.santa.adventcalendar.day15

open class Packet(protected val bits: Array<Int>) {
    val version = parseBits(0, 2)
    val type = parseBits(3, 5)
    var bitsUsed = 6

    protected fun parseBits(start: Int, end: Int): Int {
        var total = 0
        for(x in start .. end) {
            total = total * 2 + bits[x]
        }

        return total
    }

    protected fun bitsToLong(valBits: MutableList<Int>): Long {
        var total = 0L
        valBits.forEach {
            total = total * 2 + it
        }

        return total
    }
}
