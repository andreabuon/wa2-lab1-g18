package org.example.utils

import org.example.models.Waypoint
import org.example.models.Parameters

/**
 * Returns the waypoints that are outside a geofence.
 * @param waypoints the list of waypoints
 * @return a pair containing the waypoints outside the geofence and the number of waypoints outside the geofence
 */
fun findWaypointsOutsideGeofence(
    waypoints: List<Waypoint>
): Map<String, Any> {
    val outsideGeofence = mutableListOf<Waypoint>()
    for (waypoint in waypoints) {
        val distance = haversine(
            Parameters.geofenceWaypoint.latitude,
            Parameters.geofenceWaypoint.longitude,
            waypoint.latitude,
            waypoint.longitude
        )
        if (distance > Parameters.geofenceRadiusKm) {
            outsideGeofence.add(waypoint)
        }
    }
    return mapOf(
        "centralWaypoint" to Parameters.geofenceWaypoint,
        "areaRadiusKm" to Parameters.geofenceRadiusKm,
        "count" to outsideGeofence.size,
        "waypoints" to outsideGeofence
    )
}