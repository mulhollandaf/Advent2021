package com.santa.adventcalendar.day19

class ScannerHelper(input: String) {

    private val scanners: List<Set<Point3D>> = parseInput(input)

    private fun parseInput(input: String): List<Set<Point3D>> {
        return input.split("\r\n\r\n").map { singleScanner ->
            singleScanner
                .lines()
                .drop(1)
                .map {
                    Point3D.parse(it)
                }
                .toSet()
        }
    }

    fun solve(): Solution {
        val baseSector = scanners.first().toMutableSet()
        val foundScanners = mutableSetOf(Point3D(0,0,0))
        val unmappedSectors = ArrayDeque<Set<Point3D>>().apply { addAll(scanners.drop(1)) }
        while(unmappedSectors.isNotEmpty()) {
            val thisSector = unmappedSectors.removeFirst()
            when (val transform = findTransformIfIntersects(baseSector, thisSector)) {
                null -> unmappedSectors.add(thisSector)
                else -> {
                    baseSector.addAll(transform.beacons)
                    foundScanners.add(transform.scanner)
                }
            }
        }
        return Solution(foundScanners, baseSector)
    }

    private fun findTransformIfIntersects(left: Set<Point3D>, right: Set<Point3D>): Transform? =
        (0 until 6).firstNotNullOfOrNull { face ->
            (0 until 4).firstNotNullOfOrNull { rotation ->
                val rightReoriented = right.map { it.face(face).rotate(rotation) }.toSet()
                left.firstNotNullOfOrNull { s1 ->
                    rightReoriented.firstNotNullOfOrNull { s2 ->
                        val difference = s1 - s2
                        val moved = rightReoriented.map { it + difference }.toSet()
                        if (moved.intersect(left).size >= 12) {
                            Transform(difference, moved)
                        } else null
                    }
                }
            }
        }


    private class Transform(val scanner: Point3D, val beacons: Set<Point3D>)
    class Solution(val scanners: Set<Point3D>, val beacons: Set<Point3D>)


}
