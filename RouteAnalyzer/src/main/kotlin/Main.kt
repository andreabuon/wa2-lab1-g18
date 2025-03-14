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

    val mostFrequentedAreaRadiusTemp = parameterMap.get("mostFrequentedAreaRadius")

    // TODO understand what is meant by "maximum distance" in the lab assignment:
    //  "If mostFrequentedAreaRadiusKm is not provided, you should compute a
    //  default radius based on the farthest distance travelled (e.g., 0.1 km if the
    //  distance is under 1 km, or a fraction of the maximum distance if it’s larger e.g.,
    //  5.3 km if the distance is 53.67 km)."
    val mostFrequentedAreaRadius: Double = if (!mostFrequentedAreaRadiusTemp.isNullOrBlank()) mostFrequentedAreaRadiusTemp.toDouble() else 10.0

    val (farthestWaypoint, distanceFromStart) = findMaxDistanceFromStart(waypointList, earthRadius)
    val (centralWaypoint, entriesCount) = findMostFrequentedArea(waypointList, mostFrequentedAreaRadius)
    val waypointsOutsideGeofence = findWaypointsOutsideGeofence(waypointList, geofenceWaypoint, geofenceRadius, earthRadius)

    // TODO create JSON output file
}





