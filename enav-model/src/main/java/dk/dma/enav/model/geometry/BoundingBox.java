package dk.dma.enav.model.geometry;

import java.io.Serializable;

public class BoundingBox extends Polygon implements Serializable {
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

    public boolean contains(Position point) {
        return (point.getLatitude() >= minLatitude) && (point.getLongitude() >= minLongitude)
                && (point.getLatitude() <= maxLatitude) && (point.getLongitude() <= maxLongitude);
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

    public Position getCenterPoint() {
        return Position.create((minLatitude + maxLatitude) / 2, (minLongitude + maxLongitude) / 2);
    }

    public double getLatitudeSize() {
        return maxLatitude - minLatitude;
    }

    public double getLongitudeSize() {
        return maxLongitude - minLongitude;
    }

    public Position getLowerRight() {
        return Position.create(minLatitude, maxLongitude);
    }

    public double getMaxLat() {
        return maxLatitude;
    }

    public double getMaxLon() {
        return maxLongitude;
    }

    public double getMinLat() {
        return minLatitude;
    }

    public double getMinLon() {
        return minLongitude;
    }

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
     * @param other
     *            the bounding box to include
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

    public boolean intersects(BoundingBox other) {
        return !(other.minLongitude > maxLongitude || other.maxLongitude < minLongitude
                || other.minLatitude > maxLatitude || other.maxLatitude < minLatitude);
    }

    @Override
    public String toString() {
        return getUpperLeft() + " -> " + getLowerRight();
    }

    static BoundingBox create(double y1, double y2, double x1, double x2, CoordinateSystem cs) {
        return new BoundingBox(Math.min(y1, y2), Math.max(y1, y2), Math.min(x1, x2), Math.max(x1, x2), cs);
    }

    public static BoundingBox create(Position... locations) {
        // check minimum size = 2
        return null;
    }

    public static BoundingBox create(Position location, Position other, CoordinateSystem cs) {
        return create(location.getLatitude(), other.getLatitude(), location.getLongitude(), other.getLongitude(), cs);
    }

    private static int hashCode(double x) {
        long f = Double.doubleToLongBits(x);
        return (int) (f ^ (f >>> 32));
    }
}