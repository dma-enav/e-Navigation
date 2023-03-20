/* Copyright (c) 2011 Danish Maritime Authority.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dk.dma.enav.model.geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.dma.enav.model.dto.PositionDTO;
import dk.dma.enav.model.geometry.CoordinateSystem.VincentyCalculationType;

import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.asin;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.floor;
import static java.lang.Math.log;
import static java.lang.Math.round;
import static java.lang.Math.sin;
import static java.lang.Math.tan;
import static java.lang.Math.toDegrees;
import static java.lang.Math.toRadians;
import static java.util.Objects.requireNonNull;

/**
 * Representation of a WGS84 position and methods for calculating range and bearing between positions.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Position implements Element {

    /**
     * The mean radius of the earth in kilometers.
     */
    static final double EARTH_RADIUS = 6371;

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * The latitude part of the position.
     */
    final double latitude;

    /**
     * The longitude part of the position.
     */
    final double longitude;

    /**
     * Constructor given position and timezone
     *
     * @param latitude  Negative south of equator
     * @param longitude Negative east of Prime Meridian
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

    /**
     * Equals boolean.
     *
     * @param other the other
     * @return the boolean
     */
// We probably want another function that also takes a precision.
    public boolean equals(Position other) {
        // id longitude 180 == - 180???
        return other == this || other != null && latitude == other.latitude && longitude == other.longitude;
    }

    /**
     * Get great circle distance to location
     * 
     * @param other position.
     * @return distance in meters.
     */
    public double geodesicDistanceTo(Element other) {
        if (other instanceof Position) {
            return CoordinateSystem.GEODETIC.distanceBetween(this, (Position) other);
        }
        return other.geodesicDistanceTo(this);
    }

    /**
     * Calculate final bearing for great circle route to location using Thaddeus Vincenty's inverse formula.
     *
     * @param location second location
     * @return bearing in degrees
     */
    public double geodesicFinalBearingTo(Position location) {
        return CoordinateSystem.vincentyFormula(getLatitude(), getLongitude(), location.getLatitude(),
                location.getLongitude(), VincentyCalculationType.FINAL_BEARING);
    }

    /**
     * Calculate initial bearing for great circle route to location using Thaddeus Vincenty's inverse formula.
     *
     * @param location second location
     * @return bearing in degrees
     */
    public double geodesicInitialBearingTo(Position location) {
        return CoordinateSystem.vincentyFormula(getLatitude(), getLongitude(), location.getLatitude(),
                location.getLongitude(), VincentyCalculationType.INITIAL_BEARING);
    }

    /**
     * Gets cell.
     *
     * @param degress the degress
     * @return the cell
     */
    public long getCell(double degress) {
        if (degress < 0.0001) {
            throw new IllegalArgumentException("degress = " + degress);
        } else if (degress > 100) {
            throw new IllegalArgumentException("degress = " + degress);
        }
        return (long) (floor(getLatitude()/degress) * (360.0 / degress))
                + (long) ((360.0 + getLongitude()) / degress) - (long) (360L / degress);
    }

    /**
     * Gets cell int.
     *
     * @param degrees the degrees
     * @return the cell int
     */
    public int getCellInt(double degrees) {
        // bigger cellsize than 0.01 cannot be supported. unless we change the cellsize to long
        if (degrees < 0.01) {
            throw new IllegalArgumentException("degrees = " + degrees);
        }
        return (int) getCell(degrees);
    }

    /**
     * Returns the latitude part of this position.
     *
     * @return the latitude part of this position
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Gets latitude as string.
     *
     * @return the latitude as string
     */
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
        latitudeAsString.append(format000((int) round(1000*(lat - (int) lat))));
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

    /**
     * Gets longitude as string.
     *
     * @return the longitude as string
     */
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
        longitudeAsString.append(format000((int) round(1000*(lon - (int) lon))));
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
     * @param position the position
     * @return the rhumb line bearing in degrees
     */
    public double rhumbLineBearingTo(Position position) {
        double lat1 = toRadians(latitude);
        double lat2 = toRadians(position.latitude);
        double dPhi = log(tan(lat2/2 + PI/4)/tan(lat1/2 + PI/4));

        double dLon = toRadians(position.longitude - longitude);
        if (abs(dLon) > PI) {
            dLon = dLon > 0 ? -(2 * PI - dLon) : 2 * PI + dLon;
        }
        double brng = atan2(dLon, dPhi);
        return (toDegrees(brng) + 360) % 360;
    }

    public double rhumbLineDistanceTo(Element other) {
        if (other instanceof Position) {
            return CoordinateSystem.CARTESIAN.distanceBetween(this, (Position) other);
        }
        return other.rhumbLineDistanceTo(this);
    }

    /**
     * Calculates the position following a rhumb line with the given bearing for the specified distance.
     *
     * @param bearing  the bearing (in compass degrees)
     * @param distance the distance (in meters)
     * @return the position
     */
    public Position positionAt(double bearing, double distance) {
        final double d = distance / (EARTH_RADIUS*1e3);
        final double bearingRad = toRadians(bearing);
        final double lat1Rad = toRadians(this.latitude);
        final double lon1Rad = toRadians(this.longitude);

        final double lat2Rad = asin(sin(lat1Rad)*cos(d) + cos(lat1Rad)*sin(d)*cos(bearingRad));
        final double a = atan2(sin(bearingRad)*sin(d)*cos(lat1Rad), cos(d) - sin(lat1Rad)*sin(lat2Rad));
        final double lon2Rad = (lon1Rad + a + 3*PI) % (2*PI) - PI;

        final double lat2 = toDegrees(lat2Rad);
        final double lon2 = toDegrees(lon2Rad);

        return create(lat2, lon2);
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

    /**
     * With latitude position.
     *
     * @param latitude the latitude
     * @return the position
     */
    public Position withLatitude(double latitude) {
        return new Position(latitude, longitude);
    }

    // we lose some pression

    /**
     * With longitude position.
     *
     * @param longitude the longitude
     * @return the position
     */
    public Position withLongitude(double longitude) {
        return new Position(latitude, longitude);
    }

    /**
     * With time position time.
     *
     * @param time the time
     * @return the position time
     */
    public PositionTime withTime(long time) {
        return PositionTime.create(this, time);
    }

    /**
     * Creates a new position from the specified latitude and longitude.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     * @return the new position
     * @throws IllegalArgumentException if the
     */
    @JsonCreator
    public static Position create(@JsonProperty("latitude") double latitude, @JsonProperty("longitude") double longitude) {
        return new Position(latitude, longitude);
    }

    /**
     * From packed long position.
     *
     * @param l the l
     * @return the position
     */
    public static Position fromPackedLong(long l) {
        return new Position(Float.intBitsToFloat((int) (l >> 32)), Float.intBitsToFloat((int) l));
    }

    /**
     * Is valid boolean.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     * @return the boolean
     */
    public static boolean isValid(double latitude, double longitude) {
        return latitude <= 90 && latitude >= -90 && longitude <= 180 && longitude >= -180;
    }

    /**
     * Verify that latitude is within the interval [-90:90].
     *
     * @param latitude the latitude
     * @throws IllegalArgumentException When latitude is invalid
     */
    public static void verifyLatitude(double latitude) {
        if (latitude > 90 || latitude < -90) {
            throw new IllegalArgumentException("Illegal latitude must be between -90 and 90, was " + latitude);
        }
    }

    /**
     * Verify that longitude is within the interval [-180:180].
     *
     * @param longitude the longitude
     * @throws IllegalArgumentException When longitude is invalid
     */
    public static void verifyLongitude(double longitude) {
        if (longitude > 180 || longitude < -180) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180, was " + longitude);
        }
    }

    /**
     * Get dto position dto.
     *
     * @return the position dto
     */
    public PositionDTO getDTO(){
        return new PositionDTO(this.latitude, this.longitude);
    }
}
