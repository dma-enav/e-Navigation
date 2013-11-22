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
package dk.dma.enav.maritimecloud;

import java.util.concurrent.TimeUnit;

/**
 * A connection to the cloud.
 * 
 * @author Kasper Nielsen
 */
public interface MaritimeCloudConnection {

    void addListener(Listener listener);

    boolean awaitConnected(long timeout, TimeUnit unit) throws InterruptedException;

    boolean awaitDisconnected(long timeout, TimeUnit unit) throws InterruptedException;

    /**
     * Connects to the cloud. If the client is already connected to the cloud this call is ignored.
     * 
     * @throws ConnectionClosedException
     *             if the client has been shutdown
     */
    void connect();

    /**
     * Disconnects from the cloud. Unlike {@link #close()} invoking this method allows for connecting again later via
     * {@link #connect()}.
     */
    void disconnect();

    // /**
    // * Returns an unique connection id after the connection has been made. Returns <code>null</code> until connected.
    // *
    // * @return an unique connection id
    // */
    // String getId();

    boolean isConnected();

    /** A listener that can used to listen for updates to the connection status to the maritime network. */
    abstract class Listener {

        /** Invoked when the client has fully connected to the server. */
        public void connected() {}

        public void disconnected(ClosingCode closeReason) {}
    }
}
