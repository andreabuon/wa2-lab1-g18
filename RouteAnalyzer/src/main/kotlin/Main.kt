package org.example

import org.example.models.Waypoint
import org.example.models.Parameters
import org.example.utils.*

fun main() {

    // read the waypoints
    val waypointList = mutableListOf<Waypoint>()

    val csvLineList = readCsv("./evaluation/waypoints.csv")
    csvLineList.forEach { row: List<String> ->
        waypointList.add(Waypoint(row[0].toDouble().toInt(), row[1].toDouble(), row[2].toDouble()))
    }

    val maxDistanceFromStart = findMaxDistanceFromStart(waypointList)
    val mostFrequentedArea = findMostFrequentedArea(waypointList)
    val waypointsOutsideGeofence = findWaypointsOutsideGeofence(waypointList)

    // TODO JSON output
}





