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

import java.util.Objects;

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
     * Calculate - using linear interpolation - a position between two positions augmented with
     * timestamps. Assuming constant speed between the two positions.
     *
     * @param pt1 the earlier position to use in the interpolation.
     * @param pt2 the later position to use in the interpolation.
     * @param time the time at which the interpolated position should be calculated.
     * @return a new PositionTime instance containing the interpolated position at time t.
     */
    public static PositionTime createInterpolated(PositionTime pt1, PositionTime pt2, long time) {
        requireNonNull(pt1);
        requireNonNull(pt2);
        if (pt2.getTime() <= pt1.getTime()) {
            throw new IllegalArgumentException("Provided position 2 must be later than position 1.");
        }
        if (time < pt1.getTime()) {
            throw new IllegalArgumentException("time parameter must be later than position 1's.");
        }
        if (time > pt2.getTime()) {
            throw new IllegalArgumentException("time parameter must be earlier than position 2's.");
        }

        double interpolatedLatitude = linearInterpolation(pt1.getLatitude(), pt1.getTime(), pt2.getLatitude(), pt2.getTime(), time);
        double interpolatedLongitude = linearInterpolation(pt1.getLongitude(), pt1.getTime(), pt2.getLongitude(), pt2.getTime(), time);

        return PositionTime.create(interpolatedLatitude, interpolatedLongitude, time);
    }

    static final double linearInterpolation(double y1, long x1, double y2, long x2, long x) {
        return y1 + (y2 - y1) / (x2 - x1) * (x - x1);
    }
}
