/* Copyright (c) 2011 Danish Maritime Authority
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

import dk.dma.enav.model.dto.PositionDTO;
import dk.dma.enav.model.geometry.CoordinateSystem.VincentyCalculationType;

import static java.util.Objects.requireNonNull;

/**
 * Representation of a WGS84 position and methods for calculating range and bearing between positions.
 */
public class Position implements Element {

    /** The mean radius of the earth in meters. */
    static final double EARTH_RADIUS = 6371;

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The latitude part of the position. */
    final double latitude;

    /** The longitude part of the position. */
    final double longitude;

    /**
     * Constructor given position and timezone
     * 
     * @param latitude
     *            Negative south of equator
     * @param longitude
     *            Negative east of Prime Meridian
     */

    Position(double latitude, double longitude) {
        verifyLatitude(latitude);
        verifyLongitude(longitude);
        // We want simple equals and hashCode implementation. So we make sure
        // that
        // positions are never constructed with -0.0 as latitude or longitude.
        this.latitude = latitude == -0.0 ? 0.0 : latitude;
        this.longitude = longitude == -0.0 ? 0.0 : longitude;
    }

    /**
     * Distance in meters
     */
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

    // We probably want another function that also takes a precision.
    public boolean equals(Position other) {
        // id longitude 180 == - 180???
        return other == this || other != null && latitude == other.latitude && longitude == other.longitude;
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
     * Calculate final bearing for great circle route to location using Thaddeus Vincenty's</a> inverse formula.
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
     * Calculate initial bearing for great circle route to location using Thaddeus Vincenty's</a> inverse formula.
     * 
     * @param the
     *            second location
     * @return bearing in degrees
     */
    public double geodesicInitialBearingTo(Position location) {
        return CoordinateSystem.vincentyFormula(getLatitude(), getLongitude(), location.getLatitude(),
                location.getLongitude(), VincentyCalculationType.INITIAL_BEARING);
    }

    public long getCell(double degress) {
        if (degress < 0.0001) {
            throw new IllegalArgumentException("degress = " + degress);
        } else if (degress > 100) {
            throw new IllegalArgumentException("degress = " + degress);
        }
        return (long) (Math.floor(getLatitude() / degress) * (360.0 / degress))
                + (long) ((360.0 + getLongitude()) / degress) - (long) (360L / degress);
    }

    public int getCellInt(double degress) {
        // bigger cellsize than 0.01 cannot be supported. unless we change the cellsize to long
        if (degress < 0.01) {
            throw new IllegalArgumentException("degress = " + degress);
        }
        return (int) getCell(degress);
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
        if (lat < 0) {
            lat *= -1;
        }
        int hours = (int) lat;
        lat -= hours;
        lat *= 60;

        StringBuilder latitudeAsString = new StringBuilder(16);
        latitudeAsString.append(format00(hours));
        latitudeAsString.append(" ");
        latitudeAsString.append(format00((int) lat));
        latitudeAsString.append(".");
        latitudeAsString.append(format000((int) Math.round(1000 * (lat - (int) lat))));
        latitudeAsString.append(latitude < 0 ? "S": "N");
        return latitudeAsString.toString();
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
        if (lon < 0) {
            lon *= -1;
        }
        int hours = (int) lon;
        lon -= hours;
        lon *= 60;

        StringBuilder longitudeAsString = new StringBuilder(16);
        longitudeAsString.append(format000(hours));
        longitudeAsString.append(" ");
        longitudeAsString.append(format00((int) lon));
        longitudeAsString.append(".");
        longitudeAsString.append(format000((int) Math.round(1000 * (lon - (int) lon))));
        longitudeAsString.append(longitude < 0 ? "W" : "E");
        return longitudeAsString.toString();
    }

    /**
     * Format the given integer value as a String of length 3 with leading zeros.
     * @param value
     * @return
     */
    private static String format000(int value) {
        if (value < 10) {
            return "00" + value;
        } else if (value < 100) {
            return "0" + value;
        }
        return Integer.toString(value);
    }

    /**
     * Format the given integer value as a String of length 2 with leading zeros.
     * @param value
     * @return
     */
    private static String format00(int value) {
        if (value < 10) {
            return "0" + value;
        }
        return Integer.toString(value);
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
        return (int) (latLong ^ latLong >>> 32) ^ (int) (lonLong ^ lonLong >>> 32);
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
            dLon = dLon > 0 ? -(2 * Math.PI - dLon) : 2 * Math.PI + dLon;
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

    /**
     * Packs the position into a long (losing some precision). Can be read later by {@link #fromPackedLong(long)}
     * 
     * @return the packet long
     */
    public long toPackedLong() {
        float lat = (float) getLatitude();
        float lon = (float) getLongitude();
        return ((long) Float.floatToRawIntBits(lat) << 32) + Float.floatToRawIntBits(lon);
    }

    @Override
    public String toString() {
        return "(" + getLatitudeAsString() + ", " + getLongitudeAsString() + ")";
    }

    public Position withLatitude(double latitude) {
        return new Position(latitude, longitude);
    }

    // we lose some pression

    public Position withLongitude(double longitude) {
        return new Position(latitude, longitude);
    }

    public PositionTime withTime(long time) {
        return PositionTime.create(this, time);
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

    public static Position fromPackedLong(long l) {
        return new Position(Float.intBitsToFloat((int) (l >> 32)), Float.intBitsToFloat((int) l));
    }

    public static boolean isValid(double latitude, double longitude) {
        return latitude <= 90 && latitude >= -90 && longitude <= 180 && longitude >= -180;
    }

    /**
     * Verify that latitude is within the interval [-90:90].
     * 
     * @param latitude
     * @throws IllegalArgumentException
     *             When latitude is invalid
     */
    public static void verifyLatitude(double latitude) {
        if (latitude > 90 || latitude < -90) {
            throw new IllegalArgumentException("Illegal latitude must be between -90 and 90, was " + latitude);
        }
    }

    /**
     * Verify that longitude is within the interval [-180:180].
     * 
     * @param longitude
     * @throws IllegalArgumentException
     *             When longitude is invalid
     */
    public static void verifyLongitude(double longitude) {
        if (longitude > 180 || longitude < -180) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180, was " + longitude);
        }
    }
    
    public PositionDTO getDTO(){
        return new PositionDTO(this.latitude, this.longitude);
    }
}
