package org.example

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.example.models.Parameters
import org.example.models.Waypoint
import org.example.utils.*
import java.io.File

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


    val mapper = jacksonObjectMapper()
    mapper.enable(SerializationFeature.INDENT_OUTPUT)

    val outputJSON = mapOf(
        "maxDistanceFromStart" to mapOf(
            "waypoint" to maxDistanceFromStart.first,
            "distanceKm" to maxDistanceFromStart.second
        ),
        "mostFrequentedArea" to mapOf(
            "centralWaypoint" to mostFrequentedArea.first,
            "areaRadiusKm" to Parameters.mostFrequentedAreaRadius,
            "entriesCount" to mostFrequentedArea.second
        ),
        "waypointsOutsideGeofence" to mapOf(
            "centralWaypoint" to Parameters.geofenceWaypoint,
            "areaRadiusKm" to Parameters.geofenceRadiusKm,
            "count" to waypointsOutsideGeofence.size,
            "waypoints" to waypointsOutsideGeofence
        )
    )

    mapper.writer().writeValue(File("./evaluation/output.json"), outputJSON)
}





