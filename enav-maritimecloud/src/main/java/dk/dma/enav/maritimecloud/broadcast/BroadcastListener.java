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
package dk.dma.enav.maritimecloud.broadcast;

/**
 * A callback interface for receiving broadcast messages of a specific type.
 * 
 * @author Kasper Nielsen
 */
public interface BroadcastListener<T extends BroadcastMessage> {

    /**
     * Invoked whenever a broadcast message was received.
     * 
     * @param header
     *            header for the broadcast
     * @param broadcast
     *            the message that was received
     */
    void onMessage(BroadcastMessageHeader header, T broadcast);
}
