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
package dk.dma.enav.net;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import dk.dma.enav.model.MaritimeId;
import dk.dma.enav.model.geometry.Area;
import dk.dma.enav.model.geometry.PositionTime;
import dk.dma.enav.net.broadcast.BroadcastListener;
import dk.dma.enav.net.broadcast.BroadcastMessage;
import dk.dma.enav.net.broadcast.BroadcastSubscription;
import dk.dma.enav.service.spi.InitiatingMessage;
import dk.dma.enav.service.spi.MaritimeService;
import dk.dma.enav.service.spi.MaritimeServiceMessage;

/**
 * A connection to e-navigation network.
 * 
 * @author Kasper Nielsen
 */
public interface MaritimeNetworkConnection extends AutoCloseable {

    /**
     * Blocks until the connection has been fully closed, or the timeout occurs, or the current thread is interrupted,
     * whichever happens first.
     * 
     * @param timeout
     *            the maximum time to wait
     * @param unit
     *            the time unit of the timeout argument
     * @throws InterruptedException
     *             if interrupted while waiting
     */
    boolean awaitTerminated(long timeout, TimeUnit unit) throws InterruptedException;

    /**
     * Broadcasts the specified message. No guarantees are made to the delivery of the specified message.
     * <p>
     * NOTE: Currently the message is distributed to all clients that are connected to one server.
     * 
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

    /**
     * Asynchronously shutdowns this connection. use {@link #awaitTerminated(long, TimeUnit)} to await complete
     * termination.
     */
    void close();

    /**
     * Returns a future map with all id's within the specified shape.
     * 
     * @param shape
     *            the shape to look for id's within
     * @return a future map
     */
    NetworkFuture<Map<MaritimeId, PositionTime>> findAll(Area shape);

    NetworkFuture<Map<MaritimeId, String>> findServices(String name);

    /**
     * Invokes the specified service.
     * 
     * @param id
     *            the id of the owner of the service
     * @param initiatingServiceMessage
     *            the initiating service message
     * @return a future with the result
     */
    <T, S extends MaritimeServiceMessage<T> & InitiatingMessage> NetworkFuture<T> invokeService(MaritimeId id,
            S initiatingServiceMessage);

    /**
     * Returns true if {@link #close()} has been invoked, otherwise false.
     * 
     * @return true if {@link #close()} has been invoked, otherwise false
     */
    boolean isClosed();

    /**
     * Returns true the connection has been fully closed, following a call to {@link #close()}.
     * 
     * @return true the connection has been fully closed, following a call to {@link #close()}
     */
    boolean isTerminated();

    /**
     * Registers the specified service.
     * 
     * @param service
     *            the registered service
     * @param callback
     *            the callback
     * @return a service registration
     */
    <T extends MaritimeServiceMessage<?>, S extends MaritimeService, E extends MaritimeServiceMessage<T> & InitiatingMessage> ServiceRegistration registerService(
            S service, ServiceCallback<E, T> callback);

    /**
     * Subscribes to the specific type of information messages within the specified area.
     * 
     * @param informationType
     * @param area
     */
    // <T extends MaritimeInformationMessage> void subscribe(Class<T> messageType, Area area, Block<T> handler);

    // void send(Object o);
    // void broadcast(MaritimeInformationMessage message);

}

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
