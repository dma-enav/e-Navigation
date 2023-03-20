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
import java.util.List;

/**
 * FeatureType
 */
public class MessageItem {

    private String keySubject;
    private List<MessageLocation> location = new ArrayList<>();
    private MessageCategory messageCategory;
    private List<String> amplifyingRemarks = new ArrayList<>();

    /**
     * Instantiates a new Message item.
     */
    public MessageItem() {

    }

    /**
     * Gets key subject.
     *
     * @return the key subject
     */
    public String getKeySubject() {
        return keySubject;
    }

    /**
     * Sets key subject.
     *
     * @param keySubject the key subject
     */
    public void setKeySubject(String keySubject) {
        this.keySubject = keySubject;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public List<MessageLocation> getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(List<MessageLocation> location) {
        this.location = location;
    }

    /**
     * Gets message category.
     *
     * @return the message category
     */
    public MessageCategory getMessageCategory() {
        return messageCategory;
    }

    /**
     * Sets message category.
     *
     * @param messageCategory the message category
     */
    public void setMessageCategory(MessageCategory messageCategory) {
        this.messageCategory = messageCategory;
    }

    /**
     * Gets amplifying remarks.
     *
     * @return the amplifying remarks
     */
    public List<String> getAmplifyingRemarks() {
        return amplifyingRemarks;
    }

    /**
     * Sets amplifying remarks.
     *
     * @param amplifyingRemarks the amplifying remarks
     */
    public void setAmplifyingRemarks(List<String> amplifyingRemarks) {
        this.amplifyingRemarks = amplifyingRemarks;
    }

}
