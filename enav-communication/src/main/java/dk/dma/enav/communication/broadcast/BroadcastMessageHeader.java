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
package dk.dma.enav.communication.broadcast;

import static java.util.Objects.requireNonNull;
import dk.dma.enav.model.MaritimeId;
import dk.dma.enav.model.geometry.PositionTime;

/**
 * Properties conveyed to receivers of broadcast messages.
 * 
 * @author Kasper Nielsen
 */
public class BroadcastMessageHeader {

    /** The id of the ship sending the broadcast. */
    private final MaritimeId id;

    /** The position and time of the ship sending the broadcast. */
    private final PositionTime position;

    /**
     * @param id
     *            the id of the ship sending the broadcast
     * @param position
     *            the position and time of the ship sending the broadcast.
     * @throws NullPointerException
     *             if the id or position is null
     */
    public BroadcastMessageHeader(MaritimeId id, PositionTime position) {
        this.position = requireNonNull(position);
        this.id = requireNonNull(id);
    }

    /**
     * Returns the id of the ship sending the broadcast.
     * 
     * @return the id of the ship sending the broadcast
     */
    public MaritimeId getId() {
        return id;
    }

    /**
     * Returns the position and time of the ship sending the broadcast.
     * 
     * @return the position and time of the ship sending the broadcast
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
