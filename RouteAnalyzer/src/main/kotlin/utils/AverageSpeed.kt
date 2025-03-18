package org.example.utils

import org.example.models.Waypoint

/**
 * Returns the average speed of a list of waypoints.
 * @param waypointList the list of waypoints
 * @return a triple containing the distance, time and speed
 */
fun averageSpeed(waypointList: List<Waypoint>): Triple<Double, Double, Double> {
    val time = (waypointList.last().timestamp - waypointList.first().timestamp) / 3600
    val distance =
        waypointList.zipWithNext().fold(0.0) { acc, (waypoint1, waypoint2) -> acc + haversine(waypoint1, waypoint2) }
    val speed = distance / time
    return Triple(distance, time, speed)
}



