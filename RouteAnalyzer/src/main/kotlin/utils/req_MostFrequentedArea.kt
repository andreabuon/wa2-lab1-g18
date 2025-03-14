package org.example.util

import org.example.model.Waypoint

fun findMostFrequentedArea(waypointList: List<Waypoint>, areaRadiusKm: Double): Pair<Waypoint, Int> {
    if (waypointList.isEmpty()) {
        throw Exception("Waypoint list is empty.")
    }

    val earthRadius = 6371.0 //FIXME

    var center_waypoint = waypointList[0]
    var center_waypoint_neighbours_count = 0
    for (waypoint1 in waypointList) {
        var neighbours_count = 0

        for (waypoint2 in waypointList) {
            if (waypoint2.equals(waypoint1))
                continue

            if (haversine( waypoint1.latitude, waypoint1.longitude, waypoint2.latitude, waypoint2.longitude, earthRadius) < areaRadiusKm) {
                neighbours_count += 1
            }

        }
        if(neighbours_count > center_waypoint_neighbours_count) {
            center_waypoint = waypoint1
            center_waypoint_neighbours_count = neighbours_count
        }
    }

    return Pair(center_waypoint, center_waypoint_neighbours_count)
}