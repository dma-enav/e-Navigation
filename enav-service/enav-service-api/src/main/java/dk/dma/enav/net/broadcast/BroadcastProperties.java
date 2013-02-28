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
package dk.dma.enav.net.broadcast;

import static java.util.Objects.requireNonNull;
import dk.dma.enav.model.MaritimeId;
import dk.dma.enav.model.geometry.PositionTime;

/**
 * 
 * @author Kasper Nielsen
 */
public class BroadcastProperties {

    private final MaritimeId id;

    private final PositionTime position;

    /**
     * @param position
     * @param id
     */
    public BroadcastProperties(MaritimeId id, PositionTime position) {
        this.position = requireNonNull(position);
        this.id = requireNonNull(id);
    }

    /**
     * @return the id
     */
    public MaritimeId getId() {
        return id;
    }

    /**
     * @return the position
     */
    public PositionTime getPosition() {
        return position;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "id=" + id + ", position=" + position;
    }
}
