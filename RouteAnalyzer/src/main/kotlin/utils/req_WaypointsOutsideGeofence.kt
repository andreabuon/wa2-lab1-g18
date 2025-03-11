package org.example.util

import org.example.util.haversine
import org.example.model.Waypoint

/**
 * Returns the waypoints that are outside a geofence.
 * @param waypoints the list of waypoints
 * @param geofenceCenterLatitude the latitude of the geofence center
 * @param geofenceCenterLongitude the longitude of the geofence center
 * @param geofenceRadiusKm the radius of the geofence in kilometers
 * @param earthRadius the radius of the Earth
 * @return a pair containing the waypoints outside the geofence and the number of waypoints outside the geofence
 */
fun findWaypointsOutsideGeofence(
    waypoints: List<Waypoint>,
    geofenceWaypoint: Waypoint,
    geofenceRadiusKm: Double,
    earthRadius: Double
): List<Waypoint> {
    val outsideGeofence = mutableListOf<Waypoint>()
    for (waypoint in waypoints) {
        val distance = haversine(
            geofenceWaypoint.latitude,
            geofenceWaypoint.longitude,
            waypoint.latitude,
            waypoint.longitude,
            earthRadius
        )
        if (distance > geofenceRadiusKm) {
            outsideGeofence.add(waypoint)
        }
    }
    return outsideGeofence
}