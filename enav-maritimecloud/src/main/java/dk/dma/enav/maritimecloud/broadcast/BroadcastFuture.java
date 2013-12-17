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

import dk.dma.enav.maritimecloud.ConnectionClosedException;
import dk.dma.enav.maritimecloud.ConnectionFuture;
import dk.dma.enav.maritimecloud.MaritimeCloudClient;
import dk.dma.enav.util.function.Consumer;

/**
 * A broad future is created every time a broadcast is sent via {@link MaritimeCloudClient#broadcast(BroadcastMessage)}
 * or {@link MaritimeCloudClient#broadcast(BroadcastMessage, BroadcastOptions)}.
 * 
 * @author Kasper Nielsen
 */
public interface BroadcastFuture {

    /**
     * A future that can be used to determine when the messages has been received by the server. The future will return
     * with {@link ConnectionClosedException} if the broadcast is not received by the server.
     * 
     * @return a future that can be used to determine when the messages has been received by the server
     */
    ConnectionFuture<Void> receivedOnServer();

    /**
     * If {@link BroadcastOptions#isReceiverAckEnabled()} is enabled. The specified consumer will be invoked every time
     * a remote actor has received the broadcast message.
     * 
     * @param consumer
     *            the consumer of each acknowledgment
     * @throws UnsupportedOperationException
     *             if the messages has not been sent with receiver acknowledgment enabled
     */
    void onAck(Consumer<? super BroadcastMessage.Ack> consumer);

    /**
     * Invoked whenever the broadcast has finished being delivered to remote parties. Either because the broadcast has
     * been delivered to all available parties. Or because a timeout occurred.
     * <p>
     * {@link #onAck(Consumer)} will not be invoked anymore after this method has been invoked.
     */
    void onFinish();
}
