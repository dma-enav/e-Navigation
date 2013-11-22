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

import dk.dma.enav.maritimecloud.MaritimeCloudClient;

/**
 * Various options that can be used when broadcasting messages via
 * {@link MaritimeCloudClient#broadcast(BroadcastMessage, BroadcastOptions)}.
 * 
 * @author Kasper Nielsen
 */
public class BroadcastOptions {

    /** The distance in meters that the broadcast should be delivered. */
    private int distance = 10000;

    // boolean fastAck;

    // int keepAliveSeconds;

    // ack of id, time, position
    boolean receiverAck;

    public BroadcastOptions() {}

    BroadcastOptions(BroadcastOptions options) {
        this.distance = options.distance;
        this.receiverAck = options.receiverAck;
    }

    public final int getBroadcastRadius() {
        return distance;
    }

    public BroadcastOptions immutable() {
        return new Immutable(this);
    }

    // Targets
    // Actors within a defined area, for example, Denmark.
    // Actors within a defined group? For example, ships under danish flag
    // Specific type, for example, ships, VTS center

    // Broadcast policy.
    // VTS centers can only broadcast in the country they are registered
    //

    /**
     * @return the receiverAck
     */
    public final boolean isReceiverAckEnabled() {
        return receiverAck;
    }

    /**
     * Sets the radius (in meters) for which the broadcast will be visible to other actors.
     * 
     * @param radius
     *            the radius in meters
     * @return this option object
     */
    public BroadcastOptions setBroadcastRadius(int radius) {
        this.distance = radius;
        return this;
    }

    /**
     * Sets whether or not each actor that receives the broadcast will send an ack back to the broadcaster.
     * 
     * @param receiverAck
     *            the receiverAck to set
     */
    public BroadcastOptions setReceiverAckEnabled(boolean receiverAck) {
        this.receiverAck = receiverAck;
        return this;
    }

    static class Immutable extends BroadcastOptions {
        Immutable(BroadcastOptions options) {
            super(options);
        }

        /** {@inheritDoc} */
        @Override
        public BroadcastOptions immutable() {
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public BroadcastOptions setBroadcastRadius(int radius) {
            throw new UnsupportedOperationException("options are immutable");
        }

        /** {@inheritDoc} */
        @Override
        public BroadcastOptions setReceiverAckEnabled(boolean receiverAck) {
            throw new UnsupportedOperationException("options are immutable");
        }
    }
}
