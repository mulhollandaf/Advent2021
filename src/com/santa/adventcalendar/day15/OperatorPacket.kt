package com.santa.adventcalendar.day15

class OperatorPacket(bits: Array<Int>): Packet(bits) {
    val subPacketEnd: Int = getSubPacketLength(bits)
    val subPackets = parseSubPackets()
    var subPacketIndex = 0
    var usePacketsLeft = false

    private fun getSubPacketLength(bits: Array<Int>): Int {
        val lengthType = bits[6]
        return if (lengthType == 0) {
            subPacketIndex = 22
            bitsUsed += 16
            subPacketIndex + parseBits(7, 21)
        } else {
            subPacketIndex = 18
            bitsUsed += 12
            usePacketsLeft = true
            parseBits(7, 17)
        }
    }


    private fun parseSubPackets(): List<Packet> {
        val packets = mutableListOf<Packet>()
        var bitsLeft = bits.copyOfRange(subPacketIndex, bits.size)
        while (
            (!usePacketsLeft && subPacketIndex < subPacketEnd) ||
            (usePacketsLeft && packets.size < subPacketEnd)
        ) {
            val packet = Packet(bitsLeft)
            val newPacket = if (packet.type == 4) {
                ValuePacket(bitsLeft)
            } else {
                OperatorPacket(bitsLeft)
            }
            bitsUsed += newPacket.bitsUsed

            packets.add(newPacket)
            subPacketIndex += newPacket.bitsUsed
            bitsLeft = bitsLeft.copyOfRange(newPacket.bitsUsed, bitsLeft.size)
        }

        return packets
    }
}