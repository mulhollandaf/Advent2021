package com.santa.adventcalendar.day8

import readInput

fun main() {
    val helper = DigitHelper()
    //val segments = readSegments()
    //val nSegmentsLeft = helper.filterSegments(segments)
    val allSegment = readAllSegments()
    var total = 0
    allSegment.forEach { segmentPair ->
        total += helper.findLastFour(segmentPair.first, segmentPair.second)
    }

    println("Segment total = $total")
    //println("Segments down to $nSegmentsLeft")
}

fun readAllSegments(): List<Pair<List<String>, List<String>>> {
    return readInput("day8segs").map { line ->
        parsePair(line)
    }
}

fun parsePair(line: String): Pair<List<String>, List<String>> {
    val parts = line.split("|")
    return Pair(parts[0].trim().split(" "), parts[1].trim().split(" "))
}

fun readSegments(): List<String> {
    val segs = readInput("day8segs")
    val afterSegs = segs.map {
        it.substringAfter("|").trim()
    }
    return toIndividualSegments(afterSegs)
}

fun toIndividualSegments(afterSegs: List<String>): List<String> {
    val individualSegments = mutableListOf<String>()
    afterSegs.forEach{
        individualSegments.addAll(it.split(" "))
    }
    return individualSegments
}
