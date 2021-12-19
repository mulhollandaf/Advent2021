package com.santa.adventcalendar.day15

import java.util.function.Consumer

class GridMap(cavern: Array<Array<Int>>) {
    private val nodes: MutableList<Node> = ArrayList()
    private val distance: MutableMap<Node, Int> = HashMap()
    private val pi: MutableMap<Node, Node?> = HashMap()


    val ySize = cavern.size
    val xSize = cavern[0].size

    init {
        cavern.forEachIndexed { y, column ->
            column.forEachIndexed { x, cell ->
                addNode(Node("$x-$y"))
            }
        }

        cavern.forEachIndexed { y, column ->
            column.forEachIndexed { x, cell ->
                val node = getNode(x,y)
                if (isValid(x+1, y)) {
                    node.addRoadConnection(Connection(getNode(x + 1, y), cavern[y][x+1]))
                }
                if (isValid(x-1, y)) {
                    node.addRoadConnection(Connection(getNode(x - 1, y), cavern[y][x-1]))
                }
                if (isValid(x, y+1)) {
                    node.addRoadConnection(Connection(getNode(x , y + 1), cavern[y+1][x]))
                }
                if (isValid(x, y-1)) {
                    node.addRoadConnection(Connection(getNode(x, y - 1), cavern[y-1][x]))
                }
            }
        }
    }

    fun isValid(x: Int, y: Int): Boolean {
        return !(x < 0 || y < 0 || x >= xSize || y >= ySize)
    }

    fun getNode(x: Int, y: Int): Node {
        return nodes[x + y * ySize]
    }

    fun addNode(Node: Node) {
        nodes.add(Node)
    }

    private fun distanceToEnd(end: Node): Int {
        var connection: String = end.name
        var p: Node? = pi[end]
        while (p != null) {
            connection = p.name + " -> " + connection
            p = pi[p]
        }
        return distance[end]!!

    }

    private fun extractMin(Q: List<Node>): Node {
        var min: Node = Q[0]
        for (c: Node in Q) {
            if (distance[c]!! < (distance[min])!!) {
                min = c
            }
        }
        return min
    }

    fun getShortestRouteCost(start: Node, end: Node): Int {
        // Initialize
        nodes.forEach(Consumer { c: Node ->
            distance[c] = INFINITE
            pi[c] = null
        })

        // Set distance from start node to 0
        distance[start] = 0
        val shortest: MutableList<Node> = ArrayList<Node>()
        val remaining: MutableList<Node> = ArrayList(nodes)

        var countToPrint = 0
        while (remaining.isNotEmpty()) {
            if (countToPrint == 10000) {
                countToPrint = 0
                println("Step")
            }
            countToPrint++
            val u: Node = extractMin(remaining)
            remaining.remove(u)
            shortest.add(u)
            for (v: Connection in u.getConnections()) {
                // Relaxation
                if (distance[v.toNode]!! > distance[u]!! + v.distance) {
                    distance[v.toNode] = distance[u]!! + v.distance
                    pi[v.toNode] = u
                }
            }
        }
        return distanceToEnd(end)
    }

    fun getStart(): Node {
        return nodes[0]
    }

    fun getEnd(): Node {
        return nodes.last()
    }

    companion object {
        private val INFINITE = Int.MAX_VALUE
    }
}