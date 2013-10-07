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
package dk.dma.enav.model.shore;

import dk.dma.enav.model.MaritimeId;

/**
 * 
 * @author Kasper Nielsen
 */
public class ServerId extends MaritimeId {

    /**  */
    private static final long serialVersionUID = 1L;

    private final int id;

    /**
     * @param scheme
     */
    public ServerId(int id) {
        super("server");
        this.id = id;
    }

    /**
     * @param takeString
     */
    public ServerId(String takeString) {
        this(4321);
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof ServerId && equals((ServerId) obj);
    }

    /** {@inheritDoc} */
    public boolean equals(ServerId other) {
        return id == other.id;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return id;
    }

    public String toString() {
        return "server://" + id;
    }
}
