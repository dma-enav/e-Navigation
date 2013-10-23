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

    public MessageItem() {

    }

    public String getKeySubject() {
        return keySubject;
    }

    public void setKeySubject(String keySubject) {
        this.keySubject = keySubject;
    }

    public List<MessageLocation> getLocation() {
        return location;
    }

    public void setLocation(List<MessageLocation> location) {
        this.location = location;
    }

    public MessageCategory getMessageCategory() {
        return messageCategory;
    }

    public void setMessageCategory(MessageCategory messageCategory) {
        this.messageCategory = messageCategory;
    }

    public List<String> getAmplifyingRemarks() {
        return amplifyingRemarks;
    }

    public void setAmplifyingRemarks(List<String> amplifyingRemarks) {
        this.amplifyingRemarks = amplifyingRemarks;
    }

}
