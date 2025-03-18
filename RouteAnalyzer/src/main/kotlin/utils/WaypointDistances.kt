package org.example.utils

import org.example.models.Parameters
import org.example.models.Waypoint
import kotlin.math.*

/**
 * Returns the distance between two waypoints using the Haversine formula.
 * @param waypint1 the first waypoint
 * @param waypoint2 the second waypoint
 * @return the distance between the two waypoints
 */
fun haversine(waypint1: Waypoint, waypoint2: Waypoint): Double {
    val dLat = Math.toRadians(waypoint2.latitude - waypint1.latitude)
    val dLon = Math.toRadians(waypoint2.longitude - waypint1.longitude)
    val a =
        sin(dLat / 2).pow(2.0) + cos(Math.toRadians(waypint1.latitude)) * cos(Math.toRadians(waypoint2.latitude)) * sin(
            dLon / 2
        ).pow(2.0)
    val c = 2 * asin(sqrt(a))
    return Parameters.earthRadiusKm * c
}