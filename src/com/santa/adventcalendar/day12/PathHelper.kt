package com.santa.adventcalendar.day12

class PathHelper(private val nodeStart: Node, val allowTwoVisits: Boolean = false) {
    private val possiblePaths = mutableListOf<Path>()

    fun isBigCave(caves: List<String>): String {
        var bigCave = " "
        caves.forEach { cave ->
            val upperCaseVersion = cave.uppercase()
            if (cave == upperCaseVersion) {
                bigCave = cave
            }
        }
        return bigCave
    }

    fun smallCavesList(caves: List<String>): MutableList<String> {
        val smallCaves = mutableListOf<String>()
        caves.forEach { cave ->
            val lowerCaseVersion = cave.lowercase()
            if (cave == lowerCaseVersion) {
                smallCaves.add(cave)
            }
        }
        return smallCaves
    }

    fun getPossiblePaths(): Int {
        possiblePaths.clear()
        visitRecursive(nodeStart, Path(mutableListOf()))
        return possiblePaths.size
    }

    private fun visitRecursive(node: Node, visited: Path) {
        visited.nodes.add(node)
        if (node.isEnd()) {
            possiblePaths.add(visited)
            return
        }

        if (node.connections.size == 0) {
            val deadEnd = true
        }

        node.connections.forEach { toNode ->
            if (!toNode.isStart()) {
                if (toNode.isSmallCave()) {
                    val nVisits = getNVisitsTo(toNode, visited)

                    if (nVisits == 0) {
                        visit(toNode, visited)
                    } else if (allowTwoVisits && nVisits == 1 && !visited.hasDoubleDipped()) {
                        visit(toNode, visited)
                    } else {
                        val invalid = true
                    }
                } else {
                    visit(toNode, visited)
                }

            }
        }
    }

    private fun getNVisitsTo(toNode: Node, visited: Path): Int {
        return visited.nodes.filter {
            it.name == toNode.name
        }.size
    }

    private fun visit(toNode: Node, visited: Path) {
        val list = ArrayList(visited.nodes)
        val path = Path(list)
        visitRecursive(toNode, path)
    }

    fun canVisit(node: Node, alreadyVisited: Path): Boolean {
        return !(node.isSmallCave() && alreadyVisited.nodes.contains(node))
    }
}
