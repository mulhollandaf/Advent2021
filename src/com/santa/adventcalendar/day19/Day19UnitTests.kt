package com.santa.adventcalendar.day19

import org.junit.Test
import kotlin.test.assertEquals

class Day19UnitTests {
    @Test
    fun point3DTest() {
        val point = Point3D.parse("5,4,3")
        assertEquals(5, point.x)
        assertEquals(4, point.y)
        assertEquals(3, point.z)
    }

    @Test
    fun plusPoint() {
        var point = Point3D.parse("5,4,3")
        point += Point3D(1, 2, -3)
        assertEquals(6, point.x)
        assertEquals(6, point.y)
        assertEquals(0, point.z)
    }

    @Test
    fun minusPoint() {
        var point = Point3D.parse("5,4,3")
        point -= Point3D(1, 2, -3)
        assertEquals(4, point.x)
        assertEquals(2, point.y)
        assertEquals(6, point.z)
    }

    @Test
    fun facePoint() {
        var point = Point3D.parse("5,4,3")
        point = point.face(0)
        assertEquals(5, point.x)
        assertEquals(4, point.y)
        assertEquals(3, point.z)
    }

    @Test
    fun face1Point() {
        var point = Point3D.parse("5,4,3")
        point = point.face(1)
        assertEquals(5, point.x)
        assertEquals(-4, point.y)
        assertEquals(-3, point.z)
    }

    @Test
    fun face2Point() {
        var point = Point3D.parse("5,4,3")
        point = point.face(2)
        assertEquals(5, point.x)
        assertEquals(-3, point.y)
        assertEquals(4, point.z)
    }

    @Test
    fun face3Point() {
        var point = Point3D.parse("5,4,3")
        point = point.face(3)
        assertEquals(-4, point.x)
        assertEquals(-3, point.y)
        assertEquals(5, point.z)
    }

    @Test
    fun face4Point() {
        var point = Point3D.parse("5,4,3")
        point = point.face(4)
        assertEquals(4, point.x)
        assertEquals(-3, point.y)
        assertEquals(-5, point.z)
    }

    @Test
    fun face5Point() {
        var point = Point3D.parse("5,4,3")
        point = point.face(5)
        assertEquals(-5, point.x)
        assertEquals(-3, point.y)
        assertEquals(-4, point.z)
    }

    @Test
    fun rotatePoint() {
        var point = Point3D.parse("5,4,3")
        point = point.rotate(0)
        assertEquals(5, point.x)
        assertEquals(4, point.y)
        assertEquals(3, point.z)
    }

    @Test
    fun rotate1Point() {
        var point = Point3D.parse("5,4,3")
        point = point.rotate(1)
        assertEquals(-4, point.x)
        assertEquals(5, point.y)
        assertEquals(3, point.z)
    }

    @Test
    fun rotate2Point() {
        var point = Point3D.parse("5,4,3")
        point = point.rotate(2)
        assertEquals(-5, point.x)
        assertEquals(-4, point.y)
        assertEquals(3, point.z)
    }

    @Test
    fun rotate3Point() {
        var point = Point3D.parse("5,4,3")
        point = point.rotate(3)
        assertEquals(4, point.x)
        assertEquals(-5, point.y)
        assertEquals(3, point.z)
    }
}