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
public abstract class Function<T, R> {

    /**
     * Yield an appropriate result object for the input object.
     * 
     * @param t
     *            the input object
     * @return the function result
     */
    public abstract R apply(T t);

    /**
     * Combine with another function returning a function which preforms both functions.
     * 
     * @param <V>
     *            Type of output objects from the combined function. May be the same type as {@code <U>}.
     * @param after
     *            An additional function to be applied to the result of this function.
     * @return A function which performs both the original function followed by a second function.
     */
    public final <V> Function<T, V> compose(final Function<? super R, ? extends V> after) {
        requireNonNull(after);
        return new Function<T, V>() {
            public V apply(T t) {
                return after.apply(Function.this.apply(t));
            }
        };
    }
}
