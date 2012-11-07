/*
 * Copyright (c) 2008 Kasper Nielsen.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dk.dma.enav.services;

import java.util.UUID;

import dk.dma.enav.messaging.MaritimeMessage;

/**
 * An e-Navigation service message.
 */
public class ServiceMessage extends MaritimeMessage {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    private final UUID id = UUID.randomUUID();

    static {
        // we want to use MAC based uuids not random
        // InetAddress ip = InetAddress.getLocalHost();

        // NetworkInterface network = NetworkInterface.getByInetAddress(ip);

        // byte[] mac = network.getHardwareAddress();
    }

    /**
     * Returns a unique id for the message. This id is typically used when replying to a message. Or when requesting
     * acks from the receiving end of message exchange.
     * 
     * @return a unique id for the message
     */
    public UUID getId() {
        return id;
    }

}
