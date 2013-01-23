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

import dk.dma.enav.model.MaritimePeer;
import dk.dma.enav.model.geometry.Position;
import dk.dma.enav.model.voyage.Voyage;

public class Ship extends MaritimePeer {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private Voyage current;

    private ShipId id;

    private Position latest;

    public Voyage getCurrent() {
        return current;
    }

    public ShipId getId() {
        return id;
    }

    public Position getLatest() {
        return latest;
    }

    public void setCurrent(Voyage current) {
        this.current = current;
    }

    public void setId(ShipId id) {
        this.id = id;
    }

    public void setLatest(Position latest) {
        this.latest = latest;
    }
}
