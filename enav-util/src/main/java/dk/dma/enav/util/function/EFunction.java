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

import java.util.Objects;

/**
 * 
 * @author Kasper Nielsen
 */
public abstract class EFunction<T, R> {
    public abstract R apply(T t) throws Exception;

    public <V> EFunction<T, V> compose(final EFunction<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return new EFunction<T, V>() {
            public V apply(T t) throws Exception {
                return after.apply(EFunction.this.apply(t));
            }
        };
    }
}
