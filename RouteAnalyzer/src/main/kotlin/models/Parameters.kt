package org.example.models

import org.example.utils.readYaml

object Parameters {
    private val yaml = readYaml("./evaluation/custom-parameters.yml")
    val earthRadiusKm: Double
    var mostFrequentedAreaRadius: Double?
    val geofenceWaypoint: Waypoint
    val geofenceRadiusKm: Double

    init {
        val initEarthRadiusKm = yaml["earthRadiusKm"]
        val lat = yaml["geofenceCenterLatitude"]
        val long = yaml["geofenceCenterLongitude"]
        val initGeoFenceRadiusKm = yaml["geofenceRadiusKm"]
        if (lat.isNullOrEmpty() || long.isNullOrEmpty() || initEarthRadiusKm.isNullOrEmpty() || initGeoFenceRadiusKm.isNullOrEmpty()) {
            throw Exception("Invalid custom-parameters.yml file.")
        } else {
            geofenceWaypoint = Waypoint(0.0, lat.toDouble(), long.toDouble())
            earthRadiusKm = initEarthRadiusKm.toDouble()
            geofenceRadiusKm = initGeoFenceRadiusKm.toDouble()
        }
        mostFrequentedAreaRadius = yaml["mostFrequentedAreaRadiusKm"]?.toDouble()

    }
}