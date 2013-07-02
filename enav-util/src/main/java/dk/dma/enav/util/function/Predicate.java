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
package dk.dma.enav.util.function;

import static java.util.Objects.requireNonNull;

/**
 * 
 * @author Kasper Nielsen
 */
public abstract class Predicate<T> {

    /**
     * Returns {@code true} if the input object matches some criteria.
     * 
     * @param t
     *            the input object
     * @return {@code true} if the input object matches some criteria, otherwise {@code false}
     */
    public abstract boolean test(T element);

    /**
     * Returns a predicate which evaluates to {@code true} only if this predicate and the provided predicate both
     * evaluate to {@code true}. If this predicate returns {@code false} then the remaining predicate is not evaluated.
     * 
     * @return a new predicate which returns {@code true} only if both predicates return {@code true}.
     */
    public final Predicate<T> and(final Predicate<? super T> p) {
        requireNonNull(p);
        return new Predicate<T>() {
            @Override
            public boolean test(T element) {
                return Predicate.this.test(element) && p.test(element);
            }

            public String toString() {
                return Predicate.this + " && " + p;
            }
        };
    }

    /**
     * Returns a predicate which negates the result of this predicate.
     * 
     * @return a new predicate who's result is always the opposite of this predicate.
     */
    public final Predicate<T> negate() {
        return new Predicate<T>() {
            @Override
            public boolean test(T element) {
                return !Predicate.this.test(element);
            }

            public String toString() {
                return "!" + Predicate.this;
            }
        };
    }

    /**
     * Returns a predicate which evaluates to {@code true} if either this predicate or the provided predicate evaluates
     * to {@code true}. If this predicate returns {@code true} then the remaining predicate is not evaluated.
     * 
     * @return a new predicate which returns {@code true} if either predicate returns {@code true}.
     */
    public final Predicate<T> or(final Predicate<? super T> p) {
        requireNonNull(p);
        return new Predicate<T>() {
            @Override
            public boolean test(T element) {
                return Predicate.this.test(element) || p.test(element);
            }

            public String toString() {
                return Predicate.this + " || " + p;
            }
        };
    }

    /**
     * Returns a predicate that evaluates to {@code true} if all or none of the component predicates evaluate to
     * {@code true}.
     * 
     * @return a predicate that evaluates to {@code true} if all or none of the component predicates evaluate to
     *         {@code true}
     */
    public final Predicate<T> xor(final Predicate<? super T> p) {
        requireNonNull(p);
        return new Predicate<T>() {
            @Override
            public boolean test(T element) {
                return Predicate.this.test(element) ^ p.test(element);
            }

            public String toString() {
                return Predicate.this + " ^ " + p;
            }
        };
    }
}
