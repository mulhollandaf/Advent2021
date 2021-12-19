package com.santa.adventcalendar.day15

class Node(val name: String) {
    private val roadConnections: MutableList<Connection> = ArrayList()
    fun addRoadConnection(to: Connection) {
        roadConnections.add(to)
    }

    fun getConnections(): List<Connection> {
        return roadConnections
    }
}

class Connection(val toNode: Node, val distance: Int)