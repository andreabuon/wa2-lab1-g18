package org.example.utils

import org.example.models.Waypoint
import org.example.models.Parameters


fun findMostFrequentedArea(waypointList: List<Waypoint>): Pair<Waypoint, Int> {
    if (waypointList.isEmpty()) {
        throw Exception("Waypoint list is empty.")
    }

    var areaRadiusKm = Parameters.mostFrequentedAreaRadius
    if (areaRadiusKm == null) {
        val max_distance = findMaxDistanceFromStart(waypointList).second
        areaRadiusKm = when {
            (max_distance < 1.0) -> 0.1
            else -> max_distance / 10
        }
    }

    var center_waypoint = waypointList[0]
    var center_waypoint_neighbours_count = 0
    for (waypoint1 in waypointList) {
        var neighbours_count = 0

        for (waypoint2 in waypointList) {
            if (waypoint2.equals(waypoint1))
                continue

            if (haversine(
                    waypoint1.latitude,
                    waypoint1.longitude,
                    waypoint2.latitude,
                    waypoint2.longitude
                ) < areaRadiusKm
            ) {
                neighbours_count += 1
            }

        }
        if (neighbours_count > center_waypoint_neighbours_count) {
            center_waypoint = waypoint1
            center_waypoint_neighbours_count = neighbours_count
        }
    }

    return Pair(center_waypoint, center_waypoint_neighbours_count)
}