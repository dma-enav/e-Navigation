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

import java.util.concurrent.TimeUnit;

import dk.dma.enav.communication.broadcast.BroadcastListener;
import dk.dma.enav.communication.broadcast.BroadcastMessage;
import dk.dma.enav.communication.broadcast.BroadcastSubscription;
import dk.dma.enav.communication.service.InvocationCallback;
import dk.dma.enav.communication.service.ServiceLocator;
import dk.dma.enav.communication.service.ServiceRegistration;
import dk.dma.enav.communication.service.spi.ServiceInitiationPoint;
import dk.dma.enav.communication.service.spi.ServiceMessage;
import dk.dma.enav.model.MaritimeId;

/**
 * A persistent connection to the e-navigation network.
 * 
 * @author Kasper Nielsen
 */
public interface PersistentConnection extends AutoCloseable {

    /**
     * Blocks until the connection has reached the specified state, or the timeout occurs, or the current thread is
     * interrupted, whichever happens first.
     * 
     * @param state
     *            the state to await on
     * @param timeout
     *            the maximum time to wait
     * @param unit
     *            the time unit of the timeout argument
     * @throws InterruptedException
     *             if interrupted while waiting
     */
    boolean awaitState(State state, long timeout, TimeUnit unit) throws InterruptedException;

    /**
     * Broadcasts the specified message. No guarantees are made to the delivery of the specified message.
     * <p>
     * NOTE: Currently the message is distributed to <tt>all</tt> clients that are connected to one server regardless of
     * proximity.
     * 
     * @param message
     *            the message to broadcast
     * @throws NullPointerException
     *             if the specified message is null
     */
    void broadcast(BroadcastMessage message);

    /**
     * Subscribes to the the specified type of broadcast messages.
     * 
     * @param messageType
     *            the type of message to listen for
     * @param consumer
     *            the consumer of messages
     * @return a subscription that can be used to cancel the subscription
     */
    <T extends BroadcastMessage> BroadcastSubscription broadcastListen(Class<T> messageType,
            BroadcastListener<T> consumer);

    /**
     * Asynchronously shutdowns this connection. use {@link #awaitState(State, long, TimeUnit)
     * awaitState(State.TERMINATED, 1, TimeUnit.HOURS)} to await complete termination (acknowledgment by the remote
     * side).
     */
    void close();

    /**
     * Returns the local id of this connection.
     * 
     * @return the local id of this connection
     */
    MaritimeId getLocalId();

    /**
     * Returns an unique connection id after the connection has been made. Returns <code>null</code> until connected.
     * 
     * @return an unique connection id
     */
    String getConnectionId();

    /**
     * Returns the current state of the connection.
     * 
     * @return the current state of the connection
     */
    State getState();

    /**
     * @param name
     * @return
     */
    <T, E extends ServiceMessage<T>> ServiceLocator<T, E> serviceFind(ServiceInitiationPoint<E> sip);

    /**
     * Invokes the specified service.
     * 
     * @param id
     *            the id of the owner of the service
     * @param initiatingServiceMessage
     *            the initiating service message
     * @return a future with the result
     */
    <T, S extends ServiceMessage<T>> ConnectionFuture<T> serviceInvoke(MaritimeId id, S initiatingServiceMessage);

    /**
     * Subscribes to the specific type of information messages within the specified area.
     * 
     * @param informationType
     * @param area
     */
    // <T extends MaritimeInformationMessage> void subscribe(Class<T> messageType, Area area, Block<T> handler);

    /**
     * Registers the specified service.
     * 
     * @param service
     *            the registered service
     * @param callback
     *            the callback
     * @return a service registration
     */
    <T, E extends ServiceMessage<T>> ServiceRegistration serviceRegister(ServiceInitiationPoint<E> sip,
            InvocationCallback<E, T> callback);

    /** The current state of the connection. */
    public static enum State {

        /** The initial state of the connection. Will lazy connect */
        INITIALIZED,

        /** Trying to connect or reconnect. */
        CONNECTING,

        /** The connection is in the normal state. */
        CONNECTED,

        /** The connection is being shutdown, has not yet been fully acknowledge by the remote end. */
        CLOSED,

        /** The connection has been fully closed by both ends. */
        TERMINATED;

        public boolean isEnded() {
            return this == State.TERMINATED || this == State.CLOSED;
        }
    }
}

// /**
// * Returns a map with all id's within the specified shape.
// *
// * @param shape
// * the shape to look for id's within
// * @return a future map
// */
// ConnectionFuture<Map<MaritimeId, PositionTime>> findAllPeers(Area shape);
//

// Close skal virke ordentligt

// Og saa automatisk reconnect
// Tror vi har 2 disconnect modes, plannen og unplanned
// Og det samme med reconnect (skal nok lige buffer nogle ting)
// og retry afsendelse

// TODO max en med samme navn connected af gangen
// Timeout, og removal af connection naar man disconnecter
// Overvaager constan connectionserne.

// Og close
// findServices

// /**
// * Identical to {@link #broadcastSubscribe(Class, BiConsumer)} except that it will propagate the broadcast
// messages
// * as the string that was received.
// *
// * @param channel
// * the channel (classname for now) to listen to
// * @param consumer
// * the consumer of messages
// * @return a subscription that can be used to cancel the subscription
// */
// <T extends BroadcastMessage> BroadcastSubscription broadcastSubscribe(String channel,
// BiConsumer<BroadcastProperties, String> consumer);
