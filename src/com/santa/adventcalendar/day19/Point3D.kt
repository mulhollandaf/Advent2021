package com.santa.adventcalendar.day19

data class Point3D(val x: Int, val y: Int, val z: Int) {
    fun face(side: Int): Point3D {
        return when (side) {
            0 -> this
            1 -> Point3D(x, -y, -z)
            2 -> Point3D(x, -z, y)
            3 -> Point3D(-y, -z, x)
            4 -> Point3D(y, -z, -x)
            5 -> Point3D(-x, -z, -y)
            else -> error("Invalid side")
        }
    }

    fun rotate(direction: Int): Point3D {
        return when (direction) {
            0 -> this
            1 -> Point3D(-y, x, z)
            2 -> Point3D(-x, -y, z)
            3 -> Point3D(y, -x, z)
            else -> error("Invalid direction")
        }
    }

    operator fun plus(b: Point3D): Point3D {
        return Point3D(x + b.x, y + b.y, z + b.z)
    }

    operator fun minus(b: Point3D): Point3D {
        return Point3D(x - b.x, y - b.y, z - b.z)
    }

    companion object {
        fun parse(value: String): Point3D =
            value.split(",").let { parts ->
                Point3D(parts[0].toInt(), parts[1].toInt(), parts[2].toInt())
            }
    }
}
