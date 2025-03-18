package org.example.utils

import org.example.models.Waypoint
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin


/**
 * Returns the cardinal direction from a start waypoint to an end waypoint.
 * @param start the start waypoint
 * @param end the end waypoint
 * @return the cardinal direction
 */
fun getCardinalDirection(start: Waypoint, end: Waypoint): String {
    val dLon = end.longitude - start.longitude
    val y = sin(dLon) * cos(end.latitude)
    val x = cos(start.latitude) * sin(end.latitude) - sin(start.latitude) * cos(end.latitude) * cos(dLon)
    val bearing = (Math.toDegrees(atan2(y, x)) + 360) % 360
    return when (bearing) {
        in 0.0..22.5 -> "N"
        in 22.5..67.5 -> "NE"
        in 67.5..112.5 -> "E"
        in 112.5..157.5 -> "SE"
        in 157.5..202.5 -> "S"
        in 202.5..247.5 -> "SW"
        in 247.5..292.5 -> "W"
        in 292.5..337.5 -> "NW"
        in 337.5..360.0 -> "N"
        else -> "Unknown"
    }
}