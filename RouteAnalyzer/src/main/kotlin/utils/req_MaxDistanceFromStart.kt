package org.example.util

import org.example.util.haversine
import org.example.model.Waypoint

/**
 * Returns the waypoint farthest from the initial one.
 * @param waypoints the list of waypoints
 * @return the farthest waypoint from the start and their distance
 */
fun findMaxDistanceFromStart(waypoints: List<Waypoint>, earthRadius: Double): Pair<Waypoint, Double> {
    val start = waypoints.first()
    var maxDistance = Double.MIN_VALUE
    var farthestWaypoints = waypoints.first()
    for (waypoint in waypoints.drop(1)) {
        val distance = haversine(start.latitude, start.longitude, waypoint.latitude, waypoint.latitude, earthRadius)
        if (distance > maxDistance) {
            maxDistance = distance
            farthestWaypoints = waypoint
        }
    }
    return Pair(farthestWaypoints, maxDistance)
}