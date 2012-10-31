package dk.dma.enav.model.geometry;

import static java.util.Objects.requireNonNull;

/**
 * A circle
 * 
 */
public class Circle extends Shape {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The center of the circle. */
    private final Position center;

    /** The radius of the circle. */
    private final double radius;

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
    public boolean containedWithin(Element element) {
        if (element instanceof Position) {
            return center.distanceTo(element, cs) <= radius;
        } else if (element instanceof Circle) {
            Circle c = (Circle) element;
            if (c.cs != cs) {
                throw new IllegalArgumentException("Cannot compare circles in different coordinate systems");
            }
            return center.distanceTo(c.center, cs) <= radius + c.radius;
        }
        return super.containedWithin(element);
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
     * @param newCenter
     *            the new center of the circle
     * @return a new circle
     */
    public Circle withCenter(Position newCenter) {
        return new Circle(newCenter, radius, cs);
    }
}
