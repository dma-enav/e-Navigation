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

    public MessageSeriesIdentifier(MessageType messageType, int messageNumber, int messageYear, String messageAuthority) {
        super();
        this.messageType = messageType;
        this.messageNumber = messageNumber;
        this.messageYear = messageYear;
        this.messageAuthority = messageAuthority;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public int getMessageYear() {
        return messageYear;
    }

    public String getMessageAuthority() {
        return messageAuthority;
    }

}
