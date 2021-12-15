package com.santa.adventcalendar.day12

import readInput

fun main() {
    val startNode = readNodes()!!
    val pathHelper = PathHelper(startNode, true)
    val nValidPaths = pathHelper.getPossiblePaths()
    println("Paths = $nValidPaths")
}

val nodes = mutableListOf<Node>()

fun readNodes(): Node? {
    val lines = readInput("day12Paths")
    lines.forEach { line ->
        val parts = line.split("-")
        addConnection(parts[0], parts[1])
    }

    return nodes.find { node ->
        node.isStart()
    }
}

fun addConnection(name1: String, name2: String) {
    val node1 = findOrAddNode(name1)
    val node2 = findOrAddNode(name2)
    node1.connections.add(node2)
    node2.connections.add(node1)

}

fun findOrAddNode(name: String): Node {
    val node = nodes.find { node ->
        node.name == name
    }
    if (node != null) {
        return node
    }
    val newNode = Node(name)
    nodes.add(newNode)
    return newNode
}
