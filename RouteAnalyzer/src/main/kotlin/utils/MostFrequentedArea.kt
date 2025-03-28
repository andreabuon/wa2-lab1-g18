package org.example.utils

import org.example.models.Waypoint
import org.example.models.Parameters

/**
 * Returns the most frequented area.
 * @param waypointList the list of waypoints
 * @return a pair containing the central waypoint of the most frequented area and the number of entries in the area
 */
fun findMostFrequentedArea(waypointList: List<Waypoint>): Pair<Waypoint, Int> {
    if (waypointList.isEmpty()) {
        throw Exception("Waypoint list is empty.")
    }

    var areaRadiusKm = Parameters.mostFrequentedAreaRadius
    if (areaRadiusKm == null) {
        val maxDistance = findMaxDistanceFromStart(waypointList).second
        areaRadiusKm = maxDistance/10
        Parameters.mostFrequentedAreaRadius = areaRadiusKm
    }
    var centerWaypoint = waypointList[0]
    var centerWaypointNeighboursCount = 0
    for (waypoint1 in waypointList) {
        var neighboursCount = 0

        for (waypoint2 in waypointList) {
            if (waypoint2 == waypoint1)
                continue

            if (haversine(waypoint1, waypoint2) < areaRadiusKm) {
                neighboursCount++
            }

        }
        if (neighboursCount > centerWaypointNeighboursCount) {
            centerWaypoint = waypoint1
            centerWaypointNeighboursCount = neighboursCount
        }
    }

    return Pair(centerWaypoint, centerWaypointNeighboursCount)
}