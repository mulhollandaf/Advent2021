package com.santa.adventcalendar.day22

class CuboidHelper(private val cuboids: Array<Cuboid>) {
    fun findVolume(): Long {
        val volumes = mutableListOf<Cuboid>()

        cuboids.forEach { cuboid ->
            volumes.addAll(volumes.mapNotNull {
                it.intersect(cuboid)
            })
            if (cuboid.on)
                volumes.add(cuboid)
        }

        return volumes.sumOf {
            it.volume()
        }
    }

}

private fun Array<Cuboid>.volume(): Long {
    return this.sumOf {
        if (it.on) it.volume() else 0
    }
}
