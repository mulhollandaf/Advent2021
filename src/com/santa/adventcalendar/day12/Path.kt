package com.santa.adventcalendar.day12

class Path(val nodes: MutableList<Node>) {
    override fun toString(): String {
        val output = StringBuilder()
        nodes.forEach {
            output.append(it.name + ":")
        }
        return output.toString()
    }

    fun hasDoubleDipped(): Boolean {
        nodes.forEach { node ->
            if (node.isSmallCave() && nodes.filter { it == node }.size > 1) {
                return true
            }
        }
        return false
    }
}