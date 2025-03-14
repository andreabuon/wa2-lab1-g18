package org.example

import org.example.model.Waypoint
import org.example.util.*

fun main() {

    // read the waypoints
    val waypointList = mutableListOf<Waypoint>()

    val csvLineList = readCsv("./evaluation/waypoints.csv")
    csvLineList.forEach { row: List<String> ->
        waypointList.add(Waypoint(row[0].toDouble().toInt(), row[1].toDouble(), row[2].toDouble()))
    }

    // read the parameters
    val parameterMap = readYaml("./evaluation/custom-parameters.yml")
    val geofenceWaypoint = Waypoint(
        0,
        parameterMap.getValue("geofenceCenterLatitude").toDouble(),
        parameterMap.getValue("geofenceCenterLongitude").toDouble()
    )
    val geofenceRadius = parameterMap.getValue("geofenceRadiusKm").toDouble()
    val earthRadius = parameterMap.getValue("earthRadiusKm").toDouble()

    val (farthestWaypoint, distanceFromStart) = findMaxDistanceFromStart(waypointList, earthRadius)

    val mostFrequentedAreaRadius = parameterMap.get("mostFrequentedAreaRadius")?.toDoubleOrNull()
    val (centralWaypoint, entriesCount) = findMostFrequentedArea(waypointList, mostFrequentedAreaRadius)

    val waypointsOutsideGeofence = findWaypointsOutsideGeofence(waypointList, geofenceWaypoint, geofenceRadius, earthRadius)

    // TODO create JSON output file
}





