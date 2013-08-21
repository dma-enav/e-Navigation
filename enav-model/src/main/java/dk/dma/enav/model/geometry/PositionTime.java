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
}
