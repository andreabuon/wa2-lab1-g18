package org.example.models

/**
 * Represents a waypoint with a timestamp, latitude, and longitude.
 * @property timestamp the timestamp of the waypoint
 * @property latitude the latitude of the waypoint
 * @property longitude the longitude of the waypoint
 */
data class Waypoint(val timestamp: Int, val latitude: Double, val longitude: Double)
