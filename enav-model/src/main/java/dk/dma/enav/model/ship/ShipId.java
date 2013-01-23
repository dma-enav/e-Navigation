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
package dk.dma.enav.model.ship;

import static java.util.Objects.requireNonNull;
import dk.dma.enav.model.MaritimeId;

/**
 * Ideen er at kunne idenficere et skib paa en unik maade.
 */
public class ShipId extends MaritimeId {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id of the vessel */
    private final String id;

    private ShipId(String id) {
        super("ship");
        this.id = requireNonNull(id, "id is null");
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof ShipId && equals((ShipId) other);
    }

    public boolean equals(ShipId other) {
        return other == this || other != null && id.equals(other.id);
    }

    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public String toString() {
        return id;
    }

    public static ShipId create(String id) {
        return new ShipId(id);
    }

}
