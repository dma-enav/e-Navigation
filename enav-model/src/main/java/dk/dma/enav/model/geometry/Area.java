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
import dk.dma.enav.util.function.Predicate;

/**
 * A shape has an area
 **/
public abstract class Area implements Element {
    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    final CoordinateSystem cs;

    public Area(CoordinateSystem cs) {
        this.cs = requireNonNull(cs);
    }

    public final Predicate<Element> contains() {
        return new Predicate<Element>() {
            public boolean test(Element element) {
                return contains(element);
            }
        };
    }

    /**
     * Returns <tt>true</tt> if the specified element is fully contained in the shape, otherwise <tt>false</tt>.
     * 
     * @param element
     *            the element to test
     * @return true if the specified element is fully contained in the shape, otherwise false
     */
    public boolean contains(Element element) {
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
