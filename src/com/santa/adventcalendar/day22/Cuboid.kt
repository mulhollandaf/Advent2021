package com.santa.adventcalendar.day22

data class Cuboid(val xRange: IntRange, val yRange: IntRange, val zRange: IntRange, val on: Boolean) {
    fun volume(): Long {
        return (xRange.size().toLong() * yRange.size().toLong() * zRange.size().toLong()) * if(on) 1 else -1
    }

    private fun intersects(other: Cuboid): Boolean =
        xRange.intersects(other.xRange) && yRange.intersects(other.yRange) && zRange.intersects(other.zRange)

    fun intersect(other: Cuboid): Cuboid? =
        if (!intersects(other)) null
        else Cuboid(xRange intersect other.xRange, yRange intersect other.yRange, zRange intersect other.zRange, !on)
}

fun IntRange.size(): Int =
    last - first + 1

infix fun IntRange.intersects(other: IntRange): Boolean =
    first <= other.last && last >= other.first

infix fun IntRange.intersect(other: IntRange): IntRange =
    maxOf(first, other.first)..minOf(last, other.last)

