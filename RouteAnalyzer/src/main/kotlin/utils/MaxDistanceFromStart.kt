package org.example.utils

import org.example.models.Waypoint


/**
 * Returns the waypoint farthest from the initial one.
 * @param waypoints the list of waypoints
 * @return the farthest waypoint from the start and their distance
 */
fun findMaxDistanceFromStart(waypoints: List<Waypoint>): Pair<Waypoint, Double> {
    val start = waypoints.first()
    var maxDistance = Double.MIN_VALUE
    var farthestWaypoints = waypoints.first()
    for (waypoint in waypoints.drop(1)) {
        val distance =
            haversine(start.latitude, start.longitude, waypoint.latitude, waypoint.latitude)
        if (distance > maxDistance) {
            maxDistance = distance
            farthestWaypoints = waypoint
        }
    }
    return Pair(farthestWaypoints, maxDistance)
}