package com.santa.adventcalendar.day16

class ValuePacket(bits: Array<Int>): Packet(bits) {
    val value = decodeBits(bits, 6)

    private fun decodeBits(bits: Array<Int>, start: Int): Long {
        val valBits = mutableListOf<Int>()
        var end = false
        var at = start
        while (!end) {
            if (bits[at] == 0) {
                end = true
            }
            valBits.addAll(bits.copyOfRange(at + 1, at + 5))
            at += 5
        }
        bitsUsed = at
        return bitsToLong(valBits)
    }

}