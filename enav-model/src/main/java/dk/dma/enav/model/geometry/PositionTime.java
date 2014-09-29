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

import dk.dma.enav.util.CoordinateConverter;

import static dk.dma.enav.util.compass.CompassUtils.compass2cartesian;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.util.Objects.requireNonNull;

/**
 * 
 * @author Kasper Nielsen
 */
public class PositionTime extends Position {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private final long time;

    /**
     * @param latitude
     * @param longitude
     * @param time
     */
    public PositionTime(double latitude, double longitude, long time) {
        super(latitude, longitude);
        this.time = time;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object other) {
        return other instanceof PositionTime && equals((PositionTime) other);
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Position other) {
        return other instanceof PositionTime && equals((PositionTime) other);
    }

    public boolean positionEquals(Position other) {
        return super.equals(other);
    }

    // We probably want another function that also takes a precision.
    public boolean equals(PositionTime other) {
        return super.equals(other) && time == other.time;
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
        return (int) (time ^ latLong ^ latLong >>> 32) ^ (int) (time ^ lonLong ^ lonLong >>> 32);
    }

    public long getTime() {
        return time;
    }

    public static PositionTime create(Position position, long time) {
        return create(position.latitude, position.longitude, time);
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
    public static PositionTime create(double latitude, double longitude, long time) {
        return new PositionTime(latitude, longitude, time);
    }

    /**
     * Calculate - using linear extrapolation (or dead reckoning) - a position based on known speed
     * and course from the given position.
     *
     * @see <a href="http://en.wikipedia.org/wiki/Dead_reckoning">Dead reckoning</a>
     *
     * @param pt1 the position to extrapolate from.
     * @param cog is the course over ground.
     * @param sog is the speed over ground in knots.
     * @param time the absolute time (in millis since Epoch) to extrapolate to.
     * @return a new PositionTime instance containing the dead reckoned position at time t.
     */
    public static PositionTime createExtrapolated(PositionTime pt1, float cog, float sog, long time) {
        requireNonNull(pt1);
        if (time < pt1.getTime()) {
            throw new IllegalArgumentException("'time' arguments cannot be earlier than 'pt1'. " + time + " " + pt1.getTime());
        }

        final CoordinateConverter coordinateConverter = new CoordinateConverter(pt1.getLongitude(), pt1.getLatitude());
        final double x0 = coordinateConverter.lon2x(pt1.getLongitude(), pt1.getLatitude());
        final double y0 = coordinateConverter.lat2y(pt1.getLongitude(), pt1.getLatitude());
        final int dt = (int) ((time - pt1.getTime()) / 1000);  //dt the time sailed in seconds
        final double dist = dt * sog * 0.5144;                 // The distance sailed in dt seconds
        final double angle = compass2cartesian(cog);           // COG converted to cartesian angle
        final double dx = cos(angle / 180 * Math.PI) * dist;   // Distance sailed horisontal
        final double dy = sin(angle / 180 * Math.PI) * dist;   // Distance sailed vertical
        final double x1 = x0 + dx;
        final double y1 = y0 + dy;
        final double lon1 = coordinateConverter.x2Lon(x1, y1); // The new longitude
        final double lat1 = coordinateConverter.y2Lat(x1, y1); // The new latitude

        return PositionTime.create(lat1, lon1, time);
    }

    /**
     * Calculate - using linear interpolation - a position between two positions augmented with
     * timestamps. Assuming constant speed between the two positions.
     *
     * @param pt1 the earlier position to use in the interpolation.
     * @param pt2 the later position to use in the interpolation.
     * @param time the time at which the interpolated position should be calculated.
     * @return a new PositionTime instance containing the interpolated position at absolute time t.
     */
    public static PositionTime createInterpolated(PositionTime pt1, PositionTime pt2, long time) {
        requireNonNull(pt1);
        requireNonNull(pt2);
        if (pt2.getTime() < pt1.getTime()) {
            throw new IllegalArgumentException("Provided position 1 must be earlier than position 2." + pt1.getTime() + " " + pt2.getTime());
        }
        if (time < pt1.getTime()) {
            throw new IllegalArgumentException("time parameter must be later than position 1's. " + time + " " + pt1.getTime());
        }
        if (time > pt2.getTime()) {
            throw new IllegalArgumentException("time parameter must be earlier than position 2's. " + time + " " + pt2.getTime());
        }

        double interpolatedLatitude = linearInterpolation(pt1.getLatitude(), pt1.getTime(), pt2.getLatitude(), pt2.getTime(), time);
        double interpolatedLongitude = linearInterpolation(pt1.getLongitude(), pt1.getTime(), pt2.getLongitude(), pt2.getTime(), time);

        return PositionTime.create(interpolatedLatitude, interpolatedLongitude, time);
    }

    static final double linearInterpolation(double y1, long x1, double y2, long x2, long x) {
        return y1 + (y2 - y1) / (x2 - x1) * (x - x1);
    }
}
