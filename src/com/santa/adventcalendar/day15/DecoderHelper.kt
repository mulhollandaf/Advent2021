package com.santa.adventcalendar.day15

class DecoderHelper {
    fun hexToBinary(hex: String): Array<Int> {
        val hexValue="0123456789ABCDEF"
        val values = mutableListOf<Int>()
        hex.forEach {
            val dec = hexValue.indexOf(it)
            var bin = Integer.toBinaryString(dec)
            while (bin.length < 4) {
                bin = "0$bin"
            }
            val bits = bin.substring(0, 4).map { digit ->
                if (digit == '1') {
                    1
                } else {
                    0
                }
            }
            values.addAll(bits)
        }
        return values.toTypedArray()
    }

    fun parseBinary(s: String): Array<Int> {
        return s.map { digit ->
            if (digit == '1') {
                1
            } else {
                0
            }
        }.toTypedArray()
    }

    fun getPacket(bits: Array<Int>): Packet {
        val packet = Packet(bits)
        return if (packet.type == 4) {
            ValuePacket(bits)
        } else {
            OperatorPacket(bits)
        }
    }

    fun addVersions(packet: Packet): Int {
        var total = packet.version
        if (packet is OperatorPacket) {
            packet.subPackets.forEach {
                total += addVersions(it)
            }
        }
        return total
    }

    fun evaluate(packet: Packet): Long {
        if (packet is ValuePacket) {
            return packet.value.toLong()
        }
        packet as OperatorPacket
        when (packet.type) {
            0 -> return addPackets(packet.subPackets)
            1 -> return multiplyPackets(packet.subPackets)
            2 -> return minPackets(packet.subPackets)
            3 -> return maxPackets(packet.subPackets)
            5 -> return greaterPackets(packet.subPackets)
            6 -> return lesserPackets(packet.subPackets)
            7 -> return equalPackets(packet.subPackets)
        }
        return -1
    }

    private fun equalPackets(subPackets: List<Packet>): Long {
        return if (evaluate(subPackets[0]) == evaluate(subPackets[1])) 1 else 0
    }

    private fun greaterPackets(subPackets: List<Packet>): Long {
        return if (evaluate(subPackets[0]) > evaluate(subPackets[1])) 1 else 0
    }

    private fun lesserPackets(subPackets: List<Packet>): Long {
        return if (evaluate(subPackets[0]) < evaluate(subPackets[1])) 1 else 0
    }

    private fun minPackets(subPackets: List<Packet>): Long {
        return subPackets.map { evaluate(it) }.minOf { it }
    }

    private fun maxPackets(subPackets: List<Packet>): Long {
        return subPackets.map { evaluate(it) }.maxOf { it }
    }

    private fun multiplyPackets(subPackets: List<Packet>): Long {
        var total = 1L
        subPackets.forEach { packet ->
            total *= evaluate(packet)
        }
        return total
    }

    private fun addPackets(subPackets: List<Packet>): Long {
        return subPackets.sumOf { packet ->
            evaluate(packet)
        }
    }

    companion object {
        const val HEADER_VERSION_NUMBER_SIZE = 3
        const val HEADER_TYPE_SIZE = 3
        const val HEADER_A_SIZE = 5
        const val HEADER_B_SIZE = 5
        const val HEADER_C_SIZE = 5
        const val HEADER_EXTRA_ZERO_SIZE = 3
    }
}