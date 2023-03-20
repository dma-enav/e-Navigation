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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * InformationType
 * <p>
 * Navigational warning message
 */
public class NavwarnMessage extends Message {

    private Date cancellationDate;
    private List<MessageSeriesIdentifier> cancelMessage = new ArrayList<>();
    private List<MessageItem> messageItem = new ArrayList<>();

    /**
     * Instantiates a new Navwarn message.
     */
    public NavwarnMessage() {

    }

    /**
     * Gets cancellation date.
     *
     * @return the cancellation date
     */
    public Date getCancellationDate() {
        return cancellationDate;
    }

    /**
     * Sets cancellation date.
     *
     * @param cancellationDate the cancellation date
     */
    public void setCancellationDate(Date cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    /**
     * Gets cancel message.
     *
     * @return the cancel message
     */
    public List<MessageSeriesIdentifier> getCancelMessage() {
        return cancelMessage;
    }

    /**
     * Sets cancel message.
     *
     * @param cancelMessage the cancel message
     */
    public void setCancelMessage(List<MessageSeriesIdentifier> cancelMessage) {
        this.cancelMessage = cancelMessage;
    }

    /**
     * Gets message item.
     *
     * @return the message item
     */
    public List<MessageItem> getMessageItem() {
        return messageItem;
    }

    /**
     * Sets message item.
     *
     * @param messageItem the message item
     */
    public void setMessageItem(List<MessageItem> messageItem) {
        this.messageItem = messageItem;
    }

}
