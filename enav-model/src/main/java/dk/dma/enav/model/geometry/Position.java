/* Copyright (c) 2011 Danish Maritime Safety Administration
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this library.  If not, see <http://www.gnu.org/licenses/>.
 */
package dk.dma.enav.model.geometry;

import static java.util.Objects.requireNonNull;

import java.io.Serializable;
import java.util.Locale;

import dk.dma.enav.model.geometry.CoordinateSystem.VincentyCalculationType;

/**
 * Representation of a WGS84 position and methods for calculating range and
 * bearing between positions.
 */
public class Position implements Serializable, Element {

    /** The mean radius of the earth in meters. */
    static final double EARTH_RADIUS = 6371;

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The latitude part of the position. */
    private final double latitude;

    /** The longitude part of the position. */
    private final double longitude;

    /**
     * Constructor given position and timezone
     * 
     * @param latitude
     *            Negative south of equator
     * @param longitude
     *            Negative east of Prime Meridian
     */

    private Position(double latitude, double longitude) {
        if (latitude > 90 || latitude < -90) {
            throw new IllegalArgumentException("Illegal latitude must be between -90 and 90, was " + latitude);
        } else if (longitude > 180 || longitude < -180) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180, was " + longitude);
        }
        // We want simple equals and hashCode implementation. So we make sure
        // that
        // positions are never constructed with -0.0 as latitude or longitude.
        // TODO Should we round in any way???
        // Could be useful in equals, 64 bit is a lot of digits
        // So, for example,
        this.latitude = latitude == -0.0 ? 0.0 : latitude;
        this.longitude = longitude == -0.0 ? 0.0 : longitude;
    }

    public double distanceTo(Element other, CoordinateSystem system) {
        return requireNonNull(system) == CoordinateSystem.CARTESIAN ? rhumbLineDistanceTo(other)
                : geodesicDistanceTo(other);
    }

    /**
     * Equals method
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof Position && equals((Position) other);
    }

    public boolean equals(Position other) {
        // id longitude 180 == - 180???
        return other == this || (other != null && latitude == other.latitude && longitude == other.longitude);
    }

    /**
     * Get great circle distance to location
     * 
     * @param location
     * @return distance in meters
     */
    public double geodesicDistanceTo(Element other) {
        if (other instanceof Position) {
            return CoordinateSystem.GEODETIC.distanceBetween(this, (Position) other);
        }
        return other.geodesicDistanceTo(this);
    }

    /**
     * Calculate final bearing for great circle route to location using Thaddeus
     * Vincenty's</a> inverse formula.
     * 
     * @param the
     *            second location
     * @return bearing in degrees
     */
    public double geodesicFinalBearingTo(Position location) {
        return CoordinateSystem.vincentyFormula(getLatitude(), getLongitude(), location.getLatitude(),
                location.getLongitude(), VincentyCalculationType.FINAL_BEARING);
    }

    /**
     * Calculate initial bearing for great circle route to location using
     * Thaddeus Vincenty's</a> inverse formula.
     * 
     * @param the
     *            second location
     * @return bearing in degrees
     */
    public double geodesicInitialBearingTo(Position location) {
        return CoordinateSystem.vincentyFormula(getLatitude(), getLongitude(), location.getLatitude(),
                location.getLongitude(), VincentyCalculationType.INITIAL_BEARING);
    }

    /**
     * Returns the latitude part of this position.
     * 
     * @return the latitude part of this position
     */
    public double getLatitude() {
        return latitude;
    }

    public String getLatitudeAsString() {
        double lat = latitude;
        String ns = "N";
        if (lat < 0) {
            ns = "S";
            lat *= -1;
        }
        int hours = (int) lat;
        lat -= hours;
        lat *= 60;
        String latStr = String.format(Locale.US, "%3.3f", lat);
        while (latStr.indexOf('.') < 2) {
            latStr = "0" + latStr;
        }
        return String.format(Locale.US, "%02d %s%s", hours, latStr, ns);
    }

    /**
     * Returns the longitude part of this position.
     * 
     * @return the longitude part of this position
     */
    public double getLongitude() {
        return longitude;
    }

    public String getLongitudeAsString() {
        double lon = longitude;
        String ns = "E";
        if (lon < 0) {
            ns = "W";
            lon *= -1;
        }
        int hours = (int) lon;
        lon -= hours;
        lon *= 60;
        String lonStr = String.format(Locale.US, "%3.3f", lon);
        while (lonStr.indexOf('.') < 2) {
            lonStr = "0" + lonStr;
        }
        return String.format(Locale.US, "%03d %s%s", hours, lonStr, ns);
    }

    /**
     * Hash code for the location
     */
    @Override
    public int hashCode() {
        // If we need to use this as a key somewhere we can use the same hash
        // code technique as java.lang.String
        long latLong = Double.doubleToLongBits(latitude);
        long lonLong = Double.doubleToLongBits(longitude);
        return ((int) (latLong ^ (latLong >>> 32))) ^ ((int) (lonLong ^ (lonLong >>> 32)));
    }

    /**
     * Calculates the rhumb line bearing to the specified position
     * 
     * @param position
     *            the position
     * @return the rhumb line bearing in degrees
     */
    public double rhumbLineBearingTo(Position position) {
        double lat1 = Math.toRadians(latitude);
        double lat2 = Math.toRadians(position.latitude);
        double dPhi = Math.log(Math.tan(lat2 / 2 + Math.PI / 4) / Math.tan(lat1 / 2 + Math.PI / 4));

        double dLon = Math.toRadians(position.longitude - longitude);
        if (Math.abs(dLon) > Math.PI) {
            dLon = dLon > 0 ? -(2 * Math.PI - dLon) : (2 * Math.PI + dLon);
        }
        double brng = Math.atan2(dLon, dPhi);
        return (Math.toDegrees(brng) + 360) % 360;
    }

    public double rhumbLineDistanceTo(Element other) {
        if (other instanceof Position) {
            return CoordinateSystem.CARTESIAN.distanceBetween(this, (Position) other);
        }
        return other.rhumbLineDistanceTo(this);
    }

    @Override
    public String toString() {
        return "(" + getLatitudeAsString() + ", " + getLongitudeAsString() + ")";
    }

    /**
     * Creates a new position from the specified latitude and longitude.
     * 
     * @param latitude
     *            the latitude
     * @param longitude
     *            the longitude
     * @return the new position
     * @throws IllegalArgumentException
     *             if the
     */
    public static Position create(double latitude, double longitude) {
        return new Position(latitude, longitude);
    }
}