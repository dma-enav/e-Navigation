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
package dk.dma.enav.communication;

import static java.util.Objects.requireNonNull;

/**
 * A enum
 * 
 * @author Kasper Nielsen
 */
public final class CloseReason {

    public static final CloseReason NORMAL = new CloseReason(1000, "Normal closure");

    /**
     * 1003 indicates that an endpoint is terminating the connection because it has received a type of data it cannot
     * accept (e.g., an endpoint that understands only text data MAY send this if it receives a binary message).
     * <p>
     * See <a href="https://tools.ietf.org/html/rfc6455#section-7.4.1">RFC 6455, Section 7.4.1 Defined Status Codes</a>.
     */
    public static final CloseReason BAD_DATA = new CloseReason(1003, "Bad data");

    /**
     * Another client connected with the same identify. Only one client can be connected with the same id. Whenever a
     * new client connects with the same identify as a client that is already connected. The connection to the existing
     * client is automatically closed with this reason.
     */
    public static final CloseReason DUPLICATE_CONNECT = new CloseReason(4012, "Duplicate connect");

    final int id;
    final String message;

    CloseReason(int id, String message) {
        this.id = id;
        this.message = requireNonNull(message);
    }

    /**
     * @return the id
     */
    public final int getId() {
        return id;
    }

}
