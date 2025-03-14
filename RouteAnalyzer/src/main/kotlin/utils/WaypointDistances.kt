package org.example.utils

import org.example.models.Parameters
import kotlin.math.*

/**
 * Calculates the distance between two points on the Earth's surface using the haversine formula.
 * @param lat1 the latitude of the first point
 * @param lon1 the longitude of the first point
 * @param lat2 the latitude of the second point
 * @param lon2 the longitude of the second point
 * @return the distance between the two points
 */
fun haversine(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
    val dLat = Math.toRadians(lat2 - lat1)
    val dLon = Math.toRadians(lon2 - lon1)
    val a = sin(dLat / 2).pow(2.0) + cos(Math.toRadians(lat1)) * cos(Math.toRadians(lat2)) * sin(dLon / 2).pow(2.0)
    val c = 2 * asin(sqrt(a))
    return Parameters.earthRadiusKm * c
}