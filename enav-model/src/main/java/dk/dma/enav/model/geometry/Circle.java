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

import static java.util.Objects.requireNonNull;

/**
 * A circle
 * 
 */
public class Circle extends Area {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The center of the circle. */
    private final Position center;

    /** The radius of the circle. */
    private final double radius;

    public Circle(double latitude, double longitude, double radius, CoordinateSystem cs) {
        this(Position.create(latitude, longitude), radius, cs);
    }

    public Circle(Position center, double radius, CoordinateSystem cs) {
        super(cs);
        this.center = requireNonNull(center, "center is null");

        // circles with no radius??
        // check radious nan, we could use the radius of the earth
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive, was " + radius);
        }
        this.radius = radius;
    }

    @Override
    public boolean contains(Element element) {
        if (element instanceof Position) {
            return center.distanceTo(element, cs) <= radius;
        } else if (element instanceof Circle) {
            Circle c = (Circle) element;
            if (c.cs != cs) {
                throw new IllegalArgumentException("Cannot compare circles in different coordinate systems");
            }
            return center.distanceTo(c.center, cs) <= radius + c.radius;
        }
        return super.contains(element);
    }

    public boolean equals(Circle other) {
        return other == this || other != null && center.equals(other.center) && radius == other.radius;
    }

    /**
     * Equals method
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof Circle && equals((Circle) other);
    }

    @Override
    public double geodesicDistanceTo(Element other) {
        if (other instanceof Position) {
            return Math.max(0, center.geodesicDistanceTo(other) - radius);
        }
        return super.geodesicDistanceTo(other);
    }

    /**
     * Return the center of the circle.
     * 
     * @return the center of the circle
     */
    public Position getCenter() {
        return center;
    }

    /**
     * Returns the radius of the circle.
     * 
     * @return the radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return center.hashCode() ^ new Double(radius).hashCode();
    }

    @Override
    public double rhumbLineDistanceTo(Element other) {
        if (other instanceof Position) {
            return Math.max(0, center.rhumbLineDistanceTo(other) - radius);
        }
        return super.rhumbLineDistanceTo(other);
    }

    /**
     * Returns a new circle with the same radius as this circle but with the new position as the center
     * 
     * @param center
     *            the new center of the circle
     * @return a new circle
     */
    public Circle withCenter(Position center) {
        return new Circle(center, radius, cs);
    }

    /**
     * Returns a new circle with the same center as this circle but with the new radius.
     * 
     * @param radius
     *            the new radius of the circle
     * @return a new circle
     */
    public Circle withRadius(double radius) {
        return new Circle(center, radius, cs);
    }
}
