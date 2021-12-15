package com.santa.adventcalendar.day12

class Node(val name: String) {
    fun isSmallCave(): Boolean {
        return (name[0] >= 'a')
    }

    fun isEnd(): Boolean {
        return name == "end"
    }

    fun isStart(): Boolean {
        return name == "start"
    }

    val connections = mutableListOf<Node>()
}