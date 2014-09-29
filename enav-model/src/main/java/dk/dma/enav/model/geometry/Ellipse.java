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
import dk.dma.enav.util.geometry.Point;

import java.util.ArrayList;
import java.util.List;

import static dk.dma.enav.util.compass.CompassUtils.cartesian2compass;
import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sin;
import static java.lang.StrictMath.sqrt;
import static java.lang.StrictMath.toRadians;

/**
 * This class holds the defining parameters for en ellipse.
 *
 * The location of the ellipse can optionally be offset from the geodetic reference point by dx, dy meters.
 */
public final class Ellipse extends Area {
    /** The geodetic point on Earth corresponding to (dx,dy) = (0,0) */
    private final Position geodeticReference;

    /** Location offset of X coordinate from geodetic reference (in meters). */
    private final double dx;

    /** Location offset of Y coordinate from geodetic reference (in meters). */
    private final double dy;

    /** Length of half axis in direction theta (in meters) */
    private final double alpha;

    /** Length of half axis in direction orthogonal to theta (in meters) */
    private final double beta;

    /** Direction of half axis alpha measured in Cartesian degrees; 0 degrees is parallel with the increasing direction of the X axis. */
    private final double thetaDeg;

    private final CoordinateConverter coordinateConverter;

    /**
     * Create an ellipse with center in the geodetic reference point.
     *
     * @param geodeticReference The center point of the ellipse
     * @param alpha Length of half axis in direction theta (in meters)
     * @param beta Length of half axis in direction orthogonal to theta (in meters)
     * @param thetaDeg Direction of half axis alpha measured in degrees; 0 degrees is parallel with the increasing direction of the cartesian X axis.
     * @param cs
     */
    public Ellipse(Position geodeticReference, double alpha, double beta, double thetaDeg, CoordinateSystem cs) {
        super(cs);
        this.geodeticReference = geodeticReference;
        this.coordinateConverter = geodeticReference == null ? null : new CoordinateConverter(geodeticReference.longitude, geodeticReference.latitude);
        this.dx = 0.0;
        this.dy = 0.0;
        this.alpha = alpha;
        this.beta = beta;
        this.thetaDeg = thetaDeg;
    }

    /**
     * Create an ellipse offset dx, dy meters from the geodetic reference point.
     *
     * @param geodeticReference The position, from which the center of the ellipse is offset by (dx, dy) meters.
     * @param dx
     * @param dy
     * @param alpha Length of half axis in direction theta (in meters)
     * @param beta Length of half axis in direction orthogonal to theta (in meters)
     * @param thetaDeg Direction of half axis alpha measured in degrees; 0 degrees is parallel with the increasing direction of the cartesian X axis.
     * @param cs
     */
    public Ellipse(Position geodeticReference, double dx, double dy, double alpha, double beta, double thetaDeg, CoordinateSystem cs) {
        super(cs);
        this.geodeticReference = geodeticReference;
        this.coordinateConverter = geodeticReference == null ? null : new CoordinateConverter(geodeticReference.longitude, geodeticReference.latitude);
        this.dx = dx;
        this.dy = dy;
        this.alpha = alpha;
        this.beta = beta;
        this.thetaDeg = thetaDeg;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ellipse{");
        sb.append("geodeticReference=").append(geodeticReference);
        sb.append(", dx=").append(dx);
        sb.append(", dy=").append(dy);
        sb.append(", alpha=").append(alpha);
        sb.append(", beta=").append(beta);
        sb.append(", thetaDeg=").append(thetaDeg);
        sb.append('}');
        return sb.toString();
    }

    public Position getGeodeticReference() {
        return geodeticReference;
    }

    public double getX() {
        return dx;
    }

    public double getY() {
        return dy;
    }

    public double getAlpha() {
        return alpha;
    }

    public double getBeta() {
        return beta;
    }

    public double getThetaDeg() {
        return thetaDeg;
    }

    /**
     * Returns true if another element intersects this ellipse.
     *
     * @param otherElement the other safety zone.
     * @return
     */
    @Override
    public boolean intersects(Element otherElement) {
        if (otherElement instanceof Ellipse) {
            return intersects((Ellipse) otherElement);
        } else {
            throw new UnsupportedOperationException("Can not compute intersection between ellipse and " + otherElement.getClass().getSimpleName() + ".");
        }
    }

    private boolean intersects(Ellipse otherEllipse) {
        // TODO must have equal geodeticReference to compare

        final double h1x = cos(toRadians(thetaDeg));
        final double h1y = sin(toRadians(thetaDeg));

        final double h2x = cos(toRadians(otherEllipse.thetaDeg));
        final double h2y = sin(toRadians(otherEllipse.thetaDeg));

        final double vx = otherEllipse.dx - dx;
        final double vy = otherEllipse.dy - dy;

        final double d = sqrt(vx*vx + vy*vy);

        boolean intersects = true;

        final double SMALL_NUM = 0.1;

        if (d > SMALL_NUM) {
            final double cosb1 = (h1x*vx + h1y*vy)/(sqrt(h1x*h1x + h1y*h1y)*d);
            final double sinb1 = (h1x*vy - h1y*vx)/(sqrt(h1x*h1x + h1y*h1y)*d);
            final double d1 = sqrt((alpha*alpha*beta*beta)/(alpha*alpha*sinb1*sinb1 + beta*beta*cosb1*cosb1));
            final double cosb2 = (h2x*vx + h2y*vy)/(sqrt(h2x*h2x + h2y*h2y)*d);
            final double sinb2 = (h2x*vy - h2y*vx)/(sqrt(h2x*h2x + h2y*h2y)*d);
            final double d2 = sqrt((otherEllipse.alpha*otherEllipse.alpha*otherEllipse.beta*otherEllipse.beta)/(otherEllipse.alpha*otherEllipse.alpha*sinb2*sinb2 + otherEllipse.beta*otherEllipse.beta*cosb2*cosb2));
            if (d - d1 - d2 < 0.0) {
                intersects = true;
            } else {
                intersects = false;
            }
        }

        return intersects;
    }

    /**
     * Returns true if another element is contained in this ellipse.
     *
     * @param otherElement the other element.
     * @return
     */
    @Override
    public boolean contains(Element otherElement) {
        if (otherElement instanceof Position) {
            return contains((Position) otherElement);
        } else {
            throw new UnsupportedOperationException("Can not compute whether ellipse contains a " + otherElement.getClass().getSimpleName() + ".");
        }
    }

    private boolean contains(Position position) {
        // Convert position to cartesian
        final double x = coordinateConverter.lon2x(position.getLongitude(), position.getLatitude());
        final double y = coordinateConverter.lat2y(position.getLongitude(), position.getLatitude());

        return pow(x, 2.0)/pow(alpha, 2) + pow(y, 2.0)/pow(beta, 2.0) <= 1.0;
    }

    /**
     * Sample the perimeter along the ellipse in 'n' points, and return a list of positions all located and evenly
     * distributed on the perimeter. This is useful e.g. to draw the perimeter on a chart using geodetic coordinates.
     *
     * @param n the number of perimeter samples to return.
     * @return a list of positions on the perimeter.
     */
    public List<Position> samplePerimeter(int n) {
        // Sample ellipse scaled to meters
        List<Point> unitPerimeter = new ArrayList<>(n);
        double pi2 = 2*Math.PI;
        double dtheta = pi2 / n;
        double theta = 0.0;
        do {
            unitPerimeter.add(new Point(alpha*cos(theta), beta*sin(theta)));
            theta += dtheta;
        } while(theta < pi2);

        // Rotate ellipse to thetaDeg
        List<Point> rotatedPerimeter = new ArrayList<>(n);
        for (Point point : unitPerimeter) {
            Point pr = point.rotate(Point.ORIGIN, thetaDeg).translate(dx, dy);
            rotatedPerimeter.add(pr);
        }

        // Convert to geodetic
        List<Position> perimeter = new ArrayList<>(n);
        for (Point point : rotatedPerimeter) {
            double lon = coordinateConverter.x2Lon(point.getX(), point.getY());
            double lat = coordinateConverter.y2Lat(point.getX(), point.getY());
            perimeter.add(Position.create(lat, lon));
        }

        return perimeter;
    }

    public double getMajorAxisGeodeticHeading() {
        return cartesian2compass(thetaDeg);
    }
}
