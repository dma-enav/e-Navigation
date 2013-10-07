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

import java.io.Serializable;

public interface Element extends Serializable {
    // We should only need 1 or 2 of these

    double distanceTo(Element position, CoordinateSystem system);

    /**
     * Returns the geodetic (great circle) distance from this element to the specified element in meters.
     * 
     * @param other
     *            the other element
     * @return the distance in meters to the other element
     */
    double geodesicDistanceTo(Element other);

    double rhumbLineDistanceTo(Element other);

    /**
     * Describe the relationship between the two shapes. For example
     * <ul>
     * <li>this is WITHIN other</li>
     * <li>this CONTAINS other</li>
     * <li>this is DISJOINT other</li>
     * <li>this INTERSECTS other</li>
     * </ul>
     * Note that a Shape implementation may choose to return INTERSECTS when the true answer is WITHIN or CONTAINS for
     * performance reasons. If a shape does this then it <i>must</i> document when it does. Ideally the shape will not
     * do this approximation in all circumstances, just sometimes.
     * <p />
     * If the shapes are equal then the result is CONTAINS (preferred) or WITHIN.
     */
    // SpatialRelation relationTo(Element otherShape);
}
