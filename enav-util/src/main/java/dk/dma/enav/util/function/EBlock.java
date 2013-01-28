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
 * A {@link Consumer} that can throw an exception.
 * 
 * @author Kasper Nielsen
 */
public abstract class EBlock<T> {

    public abstract void accept(T t) throws Exception;

    public EBlock<T> chain(final EBlock<? super T> other) {
        requireNonNull(other);
        return new EBlock<T>() {
            public void accept(T t) throws Exception {
                EBlock.this.accept(t);
                other.accept(t);
            }
        };
    }

    public EBlock<T> filter(final Predicate<T> filter) {
        requireNonNull(filter);
        return new EBlock<T>() {
            public void accept(T t) throws Exception {
                if (filter.test(t)) {
                    EBlock.this.accept(t);
                }
            }
        };
    }
}
