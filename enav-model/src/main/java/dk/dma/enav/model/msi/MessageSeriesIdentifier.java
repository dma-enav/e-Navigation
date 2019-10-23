/* Copyright (c) 2011 Danish Maritime Authority.
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
package dk.dma.enav.model.msi;

import java.io.Serializable;

/**
 * ComplexType
 */
public class MessageSeriesIdentifier implements Serializable {

    private static final long serialVersionUID = 1L;

    private final MessageType messageType;
    private final int messageNumber;
    private final int messageYear;
    private final String messageAuthority;

    /**
     * Instantiates a new Message series identifier.
     *
     * @param messageType      the message type
     * @param messageNumber    the message number
     * @param messageYear      the message year
     * @param messageAuthority the message authority
     */
    public MessageSeriesIdentifier(MessageType messageType, int messageNumber, int messageYear, String messageAuthority) {
        super();
        this.messageType = messageType;
        this.messageNumber = messageNumber;
        this.messageYear = messageYear;
        this.messageAuthority = messageAuthority;
    }

    /**
     * Gets message type.
     *
     * @return the message type
     */
    public MessageType getMessageType() {
        return messageType;
    }

    /**
     * Gets message number.
     *
     * @return the message number
     */
    public int getMessageNumber() {
        return messageNumber;
    }

    /**
     * Gets message year.
     *
     * @return the message year
     */
    public int getMessageYear() {
        return messageYear;
    }

    /**
     * Gets message authority.
     *
     * @return the message authority
     */
    public String getMessageAuthority() {
        return messageAuthority;
    }

}
