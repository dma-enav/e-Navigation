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

/**
 * A subscription is created every time a {@link BroadcastListener} is registered.
 * 
 * @author Kasper Nielsen
 */
public interface BroadcastSubscription {

    /**
     * Returns the number of messages received for the registered listener.
     * 
     * @return the number of messages received
     */
    long getNumberOfReceivedMessages();

    /** Stops receiving messages on the listener. */
    void cancel();
}
