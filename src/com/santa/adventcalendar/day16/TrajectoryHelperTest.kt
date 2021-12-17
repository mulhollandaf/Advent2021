package com.santa.adventcalendar.day16

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TrajectoryHelperTest {
    @Test
    fun testTrajectoryTurn() {
        val helper = TrajectoryHelper()
        val probe = Probe()
        probe.xSpeed = 5
        probe.ySpeed = 3
        helper.takeTurn(probe)
        assertEquals(5, probe.x)
        assertEquals(3, probe.y)
        assertEquals(4, probe.xSpeed)
        assertEquals(2, probe.ySpeed)
    }
    @Test
    fun testProbeHitsTarget() {
        val helper = TrajectoryHelper()
        val probe = Probe()
        probe.xSpeed = 7
        probe.ySpeed = 2
        val hit = helper.doesHitTarget(probe, 20..30, -10..-5 )
        assertTrue(hit)
    }

    @Test
    fun testProbeHit2Target() {
        val helper = TrajectoryHelper()
        val probe = Probe()
        probe.xSpeed = 10
        probe.ySpeed = -2
        val hit = helper.doesHitTarget(probe, 20..30, -10..-5 )
        assertTrue(hit)
    }

    @Test
    fun testProbeNotHitTarget() {
        val helper = TrajectoryHelper()
        val probe = Probe()
        probe.xSpeed = 5
        probe.ySpeed = 3
        val hit = helper.doesHitTarget(probe, 20..30, -10..-5 )
        assertFalse(hit)
    }

    @Test
    fun testHighestYTarget() {
        val helper = TrajectoryHelper()
        val probe = Probe()
        probe.xSpeed = 7
        probe.ySpeed = 2
        val hit = helper.doesHitTarget(probe, 20..30, -10..-5 )
        assertEquals(3, probe.yMax)
    }

    @Test
    fun testHighestYHitTarget() {
        val helper = TrajectoryHelper()
        val max = helper.findHighestYHit(20..30, -10..-5 )
        assertEquals(45, max)
    }

    @Test
    fun testPart1() {
        val helper = TrajectoryHelper()
        val max = helper.findHighestYHit(288..330, -96..-50 )
        assertEquals(4560, max)
    }

    @Test
    fun testPossibleHitsTarget() {
        val helper = TrajectoryHelper()
        val possible = helper.findPossibleHits(20..30, -10..-5 )
        assertEquals(112, possible)
    }

    @Test
    fun testPart2() {
        val helper = TrajectoryHelper()
        val possible = helper.findPossibleHits(288..330, -96..-50 )
        assertEquals(3344, possible)
    }
}