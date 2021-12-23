package com.santa.adventcalendar.day22

class CuboidReader() {
    private val pattern =
        """^(on|off) x=(-?\d+)\.\.(-?\d+),y=(-?\d+)\.\.(-?\d+),z=(-?\d+)\.\.(-?\d+)$""".toRegex()

    fun readCuboid(line: String): Cuboid {
        val (s, x1, x2, y1, y2, z1, z2) = pattern.matchEntire(line)?.destructured
            ?: error("Cannot parse input: $line")
        return Cuboid(
            x1.toInt()..x2.toInt(),
            y1.toInt()..y2.toInt(),
            z1.toInt()..z2.toInt(),
            s == "on",
        )
    }
}
