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

import dk.dma.enav.util.CoordinateConverter;

import static java.lang.StrictMath.cos;
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

    /** Direction of half axis alpha measured in degrees; 0 degrees is parallel with the increasing direction of the X axis. */
    private final double thetaDeg;

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
        this.dx = dx;
        this.dy = dy;
        this.alpha = alpha;
        this.beta = beta;
        this.thetaDeg = thetaDeg;
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
     * Returns true if two safety zones intersect.
     *
     * @param otherEllipse the other safety zone.
     * @return
     */
    public boolean intersects(Ellipse otherEllipse) {
        // TODO must have equal geodeticReference to compare

        final double h1x = cos(toRadians(thetaDeg));
        final double h1y = sin(toRadians(thetaDeg));

        final double h2x = cos(toRadians(otherEllipse.thetaDeg));
        final double h2y = sin(toRadians(otherEllipse.thetaDeg));

        final double vx = otherEllipse.dx - dx;
        final double vy = otherEllipse.dy - dy;

        final double d = sqrt(vx * vx + vy * vy);

        boolean intersects = true;

        final double SMALL_NUM = 0.1;

        if (d > SMALL_NUM) {
            final double cosb1 = (h1x * vx + h1y * vy) / (sqrt(h1x * h1x + h1y * h1y) * d);
            final double sinb1 = (h1x * vy - h1y * vx) / (sqrt(h1x * h1x + h1y * h1y) * d);
            final double d1 = sqrt((alpha * alpha * beta * beta) / (alpha * alpha * sinb1 * sinb1 + beta * beta * cosb1 * cosb1));
            final double cosb2 = (h2x * vx + h2y * vy) / (sqrt(h2x * h2x + h2y * h2y) * d);
            final double sinb2 = (h2x * vy - h2y * vx) / (sqrt(h2x * h2x + h2y * h2y) * d);
            final double d2 = sqrt((otherEllipse.alpha * otherEllipse.alpha * otherEllipse.beta * otherEllipse.beta) / (otherEllipse.alpha * otherEllipse.alpha * sinb2 * sinb2 + otherEllipse.beta * otherEllipse.beta * cosb2 * cosb2));
            if (d - d1 - d2 < 0.0) {
                intersects = true;
            } else {
                intersects = false;
            }
        }

        return intersects;
    }

    public double getMajorAxisGeodeticHeading() {
        return CoordinateConverter.cartesian2compass(thetaDeg);
    }
}
