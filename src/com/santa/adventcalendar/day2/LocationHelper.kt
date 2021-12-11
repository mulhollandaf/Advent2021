package com.santa.adventcalendar.day2

class LocationHelper(private val useAim: Boolean) {
    private val location = Location(0,0, 0)
    fun move(inputs: Array<String>): Location {
        inputs.forEach { move ->
            processMove(move)
        }
        return location
    }

    private fun processMove(move: String) {
        val parts = move.split(" ")
        val direction = parts[0]
        val quantity = Integer.parseInt(parts[1])
        when(direction) {
            "up" -> {
                if (useAim) {
                    location.aim -= quantity
                } else {
                    location.depth -= quantity
                }
            }
            "down" -> {
                if (useAim) {
                    location.aim += quantity
                } else {
                    location.depth += quantity
                }
            }
            "forward" -> {
                location.position += quantity
                if (useAim) {
                    location.depth += quantity * location.aim
                }
            }
        }
    }
}

data class Location (var depth: Int, var position: Int, var aim: Int)