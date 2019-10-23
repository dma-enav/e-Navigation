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

import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Bounding box.
 */
public final class BoundingBox extends Polygon {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private final double maxLatitude;
    private final double maxLongitude;
    private final double minLatitude;
    private final double minLongitude;

    private BoundingBox(double minLatitude, double maxLatitude, double minLongitude, double maxLongitude,
            CoordinateSystem cs) {
        super(cs);
        this.minLatitude = minLatitude;
        this.maxLatitude = maxLatitude;
        this.minLongitude = minLongitude;
        this.maxLongitude = maxLongitude;
    }

    /**
     * Contains boolean.
     *
     * @param point the point
     * @return the boolean
     */
    public boolean contains(Position point) {
        return point.getLatitude() >= minLatitude && point.getLongitude() >= minLongitude
                && point.getLatitude() <= maxLatitude && point.getLongitude() <= maxLongitude;
    }
    
    @Override
    public boolean contains(Element element) {
        if (element instanceof Position) {
            return contains((Position)element);
        } else {
            return super.contains(element);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BoundingBox) {
            BoundingBox that = (BoundingBox) obj;
            return minLatitude == that.minLatitude && minLongitude == that.minLongitude
                    && maxLatitude == that.maxLatitude && maxLongitude == that.maxLongitude;
        } else {
            return false;
        }
    }

    /**
     * Returns a random position within the box.
     *
     * @return a random position within the box
     */
    public Position getRandom() {
        ThreadLocalRandom r = ThreadLocalRandom.current();
        return Position.create(r.nextDouble(minLatitude, maxLatitude), r.nextDouble(minLongitude, maxLongitude));
    }

    /**
     * Calculate the area size of this bounding box.
     *
     * @return Area size in square meters.
     */
    public float getArea() {
        final Position a = new Position(maxLatitude, minLongitude);
        final Position b = new Position(maxLatitude, maxLongitude);
        final Position c = new Position(minLatitude, minLongitude);
        final float ab = (float) a.rhumbLineDistanceTo(b); // meters
        final float ac = (float) a.rhumbLineDistanceTo(c); // meters
        return ab*ac;
    }

    /**
     * Gets center point.
     *
     * @return the center point
     */
    public Position getCenterPoint() {
        return Position.create((minLatitude + maxLatitude) / 2, (minLongitude + maxLongitude) / 2);
    }

    /**
     * Gets latitude size.
     *
     * @return the latitude size
     */
    public double getLatitudeSize() {
        return maxLatitude - minLatitude;
    }

    /**
     * Gets longitude size.
     *
     * @return the longitude size
     */
    public double getLongitudeSize() {
        return maxLongitude - minLongitude;
    }

    /**
     * Gets lower right.
     *
     * @return the lower right
     */
    public Position getLowerRight() {
        return Position.create(minLatitude, maxLongitude);
    }

    /**
     * Gets max lat.
     *
     * @return the max lat
     */
    public double getMaxLat() {
        return maxLatitude;
    }

    /**
     * Gets max lon.
     *
     * @return the max lon
     */
    public double getMaxLon() {
        return maxLongitude;
    }

    /**
     * Gets min lat.
     *
     * @return the min lat
     */
    public double getMinLat() {
        return minLatitude;
    }

    /**
     * Gets min lon.
     *
     * @return the min lon
     */
    public double getMinLon() {
        return minLongitude;
    }

    /**
     * Gets upper left.
     *
     * @return the upper left
     */
    public Position getUpperLeft() {
        return Position.create(maxLatitude, minLongitude);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + hashCode(minLatitude);
        result = 37 * result + hashCode(maxLatitude);
        result = 37 * result + hashCode(minLongitude);
        result = 37 * result + hashCode(maxLongitude);
        return result;
    }

    /**
     * Returns a new bounding box that includes the specified bounding box.
     *
     * @param other the bounding box to include
     * @return a bounding box
     */
    public BoundingBox include(BoundingBox other) {
        double minLon = this.minLongitude;
        double maxLon = this.maxLongitude;
        double minLat = this.minLatitude;
        double maxLat = this.maxLatitude;
        boolean changed = false;
        if (other.minLongitude < minLon) {
            minLon = other.minLongitude;
            changed = true;
        }
        if (other.maxLongitude > maxLon) {
            maxLon = other.maxLongitude;
            changed = true;
        }
        if (other.minLatitude < minLat) {
            minLat = other.minLatitude;
            changed = true;
        }
        if (other.maxLatitude > maxLat) {
            maxLat = other.maxLatitude;
            changed = true;
        }
        return changed ? new BoundingBox(minLat, maxLat, minLon, maxLon, cs) : this;
    }

    /**
     * Returns a new bounding box that includes the specified position.
     *
     * @param position the position to include
     * @return a bounding box
     */
    public BoundingBox include(Position position) {
        return include(BoundingBox.create(position, position, CoordinateSystem.CARTESIAN));
    }

    /**
     * Intersects boolean.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean intersects(BoundingBox other) {
        return !(other.minLongitude > maxLongitude || other.maxLongitude < minLongitude
                || other.minLatitude > maxLatitude || other.maxLatitude < minLatitude);
    }

    @Override
    public String toString() {
        return getUpperLeft() + " -> " + getLowerRight();
    }

    /**
     * Create bounding box.
     *
     * @param y1 the y 1
     * @param y2 the y 2
     * @param x1 the x 1
     * @param x2 the x 2
     * @param cs the cs
     * @return the bounding box
     */
    static BoundingBox create(double y1, double y2, double x1, double x2, CoordinateSystem cs) {
        return new BoundingBox(Math.min(y1, y2), Math.max(y1, y2), Math.min(x1, x2), Math.max(x1, x2), cs);
    }

    /**
     * Create bounding box.
     *
     * @param location the location
     * @param other    the other
     * @param cs       the cs
     * @return the bounding box
     */
    public static BoundingBox create(Position location, Position other, CoordinateSystem cs) {
        return create(location.getLatitude(), other.getLatitude(), location.getLongitude(), other.getLongitude(), cs);
    }

    private static int hashCode(double x) {
        long f = Double.doubleToLongBits(x);
        return (int) (f ^ f >>> 32);
    }
}
