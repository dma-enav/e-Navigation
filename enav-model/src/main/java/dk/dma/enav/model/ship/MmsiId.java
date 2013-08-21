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

import dk.dma.enav.model.MaritimeId;

/**
 * 
 * @author Kasper Nielsen
 */
public class MmsiId extends MaritimeId {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private final int mmsi;

    /**
     * @param scheme
     */
    public MmsiId(int mmsi) {
        super("mmsi");
        this.mmsi = mmsi;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return mmsi;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof MmsiId && equals((MmsiId) obj);
    }

    /** {@inheritDoc} */
    public boolean equals(MmsiId other) {
        return mmsi == other.mmsi;
    }

    public String toString() {
        return "mmsi://" + mmsi;
    }

    // mmsi://102323233

    // enid://

    // area://box/
}
