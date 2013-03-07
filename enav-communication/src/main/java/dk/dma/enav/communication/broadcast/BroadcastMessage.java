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

/**
 * Abstract class for a message that can be broadcast.
 * 
 * @author Kasper Nielsen
 */
public abstract class BroadcastMessage {

    /**
     * Returns the broadcast channel on which the broadcast is sent. Defaults (for now) to the name of the class.
     * 
     * @return the broadcast channel on which the message should be sent
     */
    public final String channel() {
        return getClass().getCanonicalName();
    }
}
