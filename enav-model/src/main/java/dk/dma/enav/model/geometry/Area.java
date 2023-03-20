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

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

/**
 * A shape has an area
 */
public abstract class Area implements Element {
    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * The Cs.
     */
    final CoordinateSystem cs;

    /**
     * Instantiates a new Area.
     *
     * @param cs the cs
     */
    public Area(CoordinateSystem cs) {
        this.cs = requireNonNull(cs);
    }

    /**
     * Contains predicate.
     *
     * @return the predicate
     */
    public final Predicate<Element> contains() {
        return new Predicate<Element>() {
            public boolean test(Element element) {
                return contains(element);
            }
        };
    }

    /**
     * Intersects predicate.
     *
     * @return the predicate
     */
    public final Predicate<Element> intersects() {
        return new Predicate<Element>() {
            public boolean test(Element element) {
                return intersects(element);
            }
        };
    }

    /**
     * Returns <tt>true</tt> if the specified element is fully contained in the shape, otherwise <tt>false</tt>.
     *
     * @param element the element to test
     * @return true if the specified element is fully contained in the shape, otherwise false
     */
    public boolean contains(Element element) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns <tt>true</tt> if the specified element is fully or partially contained in the shape, otherwise <tt>false</tt>.
     *
     * @param element the element to test
     * @return true if the specified element is fully or partially contained in the shape, otherwise false
     */
    public boolean intersects(Element element) { throw new UnsupportedOperationException(); }

    @Override
    public final double distanceTo(Element other, CoordinateSystem system) {
        return requireNonNull(system) == CoordinateSystem.CARTESIAN ? rhumbLineDistanceTo(other)
                : geodesicDistanceTo(other);
    }

    @Override
    public double geodesicDistanceTo(Element other) {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets coordinate system.
     *
     * @return the coordinate system
     */
    public final CoordinateSystem getCoordinateSystem() {
        return cs;
    }

    @Override
    public double rhumbLineDistanceTo(Element other) {
        throw new UnsupportedOperationException();
    }
}
