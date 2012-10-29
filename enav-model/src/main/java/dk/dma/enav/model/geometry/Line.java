package dk.dma.enav.model.geometry;

import static java.util.Objects.requireNonNull;

/**
 * A line
 * 
 */
// TODO: Should it be called something else??

// Main issue is that a line normally just consists of two points.
// with no distiction between start and end.
public class Line implements Element {
    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The end of the line. */
    final Position end;

    /** The start of the line. */
    final Position start;

    Line(Position start, Position end, CoordinateSystem system) {
        this.start = requireNonNull(start, "start is null");
        this.end = requireNonNull(end, "end is null");
        this.cs = requireNonNull(system);
    }

    public boolean equals(Line other) {
        return other == this
                || (other != null && start.equals(other.start) && start.equals(other.start) && cs == other.cs);
    }

    final CoordinateSystem cs;

    @Override
    public double distanceTo(Element position, CoordinateSystem system) {
        throw new UnsupportedOperationException();
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

    /**
     * Equals method
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof Line && equals((Line) other);
    }

    /**
     * Returns the end position of the line.
     * 
     * @return the end position of the line
     */
    public Position getEnd() {
        return end;
    }

    /**
     * Returns the length of the line in meters.
     * 
     * @return the length of the line in meters
     */
    public double getLength() {
        return start.distanceTo(end, cs);
    }

    /**
     * Returns the start position of the line.
     * 
     * @return the start position of the line
     */
    public Position getStart() {
        return start;
    }
}
