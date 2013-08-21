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
package dk.dma.enav.model;

import static java.util.Objects.requireNonNull;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import dk.dma.enav.model.ship.MmsiId;

/** The id of some kind of maritime object such as a ship, VTS station, voyage or an object on a map. */
public abstract class MaritimeId implements Serializable {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    final String scheme;

    protected MaritimeId(String scheme) {
        this.scheme = requireNonNull(scheme);
    }

    /**
     * Creates a id from the specified string based representation of the id.
     * 
     * @param id
     *            the string based representation to create the id from
     * @return the id
     * @throws NullPointerException
     *             if the specified id string is null
     * @throws IllegalArgumentException
     *             if the specified string is not a valid maritime id
     */
    public static MaritimeId create(String id) {
        requireNonNull(id, "id is null");
        final URI uri;
        try {
            uri = new URI(id);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
        String scheme = uri.getScheme();
        if (scheme == null) {
            throw new IllegalArgumentException("Illegal id, must start with 'some_scheme://', was " + id);
        }
        if (uri.getScheme().equals("mmsi")) {
            int mmsi = Integer.parseInt(uri.getHost());
            return new MmsiId(mmsi);
        }
        throw new IllegalArgumentException("Unknown schenme " + uri.getScheme());
    }
}
