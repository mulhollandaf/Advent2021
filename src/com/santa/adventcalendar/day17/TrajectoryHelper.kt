package com.santa.adventcalendar.day17

class TrajectoryHelper {
    fun takeTurn(probe: Probe) {
        probe.x += probe.xSpeed
        probe.y += probe.ySpeed
        if (probe.xSpeed > 0) {
            probe.xSpeed--
        }
        probe.ySpeed--
        if (probe.ySpeed == 0) {
            probe.yMax = probe.y
        }
    }

    fun doesHitTarget(probe: Probe, xRange: IntRange, yRange: IntRange): Boolean {
        while (probe.y > yRange.first) {
            takeTurn(probe)
            if (probe.x in xRange && probe.y in yRange) {
                return true
            }
        }
        return false
    }

    fun findHighestYHit(xRange: IntRange, yRange: IntRange): Int {
        var maxY = 0
        for(x in 0.. xRange.last) {
            for (y in 0 .. 100) {
                val probe = Probe()
                probe.xSpeed = x
                probe.ySpeed = y
                if (doesHitTarget(probe, xRange, yRange)) {
                    if (probe.yMax > maxY) {
                        maxY = probe.yMax
                    }
                }
            }
        }
        return maxY
    }

    fun findPossibleHits(xRange: IntRange, yRange: IntRange): Int {
        var possible = mutableListOf<Pair<Int, Int>>()
        for(x in 0.. xRange.last) {
            for (y in -100 .. 100) {
                val probe = Probe()
                probe.xSpeed = x
                probe.ySpeed = y
                if (doesHitTarget(probe, xRange, yRange)) {
                    possible.add(Pair(x,y))
                }
            }
        }
        return possible.size
    }
}