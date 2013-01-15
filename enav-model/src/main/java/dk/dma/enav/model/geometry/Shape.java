package dk.dma.enav.model.geometry;

import static java.util.Objects.requireNonNull;

/**
 * A shape has an area
 **/
// TODO rename to area
public abstract class Shape implements Element {
    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    final CoordinateSystem cs;

    public Shape(CoordinateSystem cs) {
        this.cs = requireNonNull(cs);
    }

    /**
     * Returns <tt>true</tt> if the specified element is fully contained in the shape, otherwise <tt>false</tt>.
     * 
     * @param element
     *            the element to test
     * @return true if the specified element is fully contained in the shape, otherwise false
     */
    public boolean containedWithin(Element element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final double distanceTo(Element other, CoordinateSystem system) {
        return requireNonNull(system) == CoordinateSystem.CARTESIAN ? rhumbLineDistanceTo(other)
                : geodesicDistanceTo(other);
    }

    @Override
    public double geodesicDistanceTo(Element other) {
        throw new UnsupportedOperationException();
    }

    public final CoordinateSystem getCoordinateSystem() {
        return cs;
    }

    @Override
    public double rhumbLineDistanceTo(Element other) {
        throw new UnsupportedOperationException();
    }
}
