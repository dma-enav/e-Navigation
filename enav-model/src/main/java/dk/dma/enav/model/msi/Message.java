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
 * InformationType
 */
public abstract class Message {

    private MessageSeriesIdentifier messageSeriesIdentifier;
    private String generalArea;
    private String locality;
    private List<String> specificLocation = new ArrayList<>();
    private List<String> chartNumber = new ArrayList<>();
    private List<Integer> internationalNumber = new ArrayList<>();

    /**
     * Instantiates a new Message.
     */
    public Message() {

    }

    /**
     * Gets message series identifier.
     *
     * @return the message series identifier
     */
    public MessageSeriesIdentifier getMessageSeriesIdentifier() {
        return messageSeriesIdentifier;
    }

    /**
     * Sets message series identifier.
     *
     * @param messageSeriesIdentifier the message series identifier
     */
    public void setMessageSeriesIdentifier(MessageSeriesIdentifier messageSeriesIdentifier) {
        this.messageSeriesIdentifier = messageSeriesIdentifier;
    }

    /**
     * Gets general area.
     *
     * @return the general area
     */
    public String getGeneralArea() {
        return generalArea;
    }

    /**
     * Sets general area.
     *
     * @param generalArea the general area
     */
    public void setGeneralArea(String generalArea) {
        this.generalArea = generalArea;
    }

    /**
     * Gets locality.
     *
     * @return the locality
     */
    public String getLocality() {
        return locality;
    }

    /**
     * Sets locality.
     *
     * @param locality the locality
     */
    public void setLocality(String locality) {
        this.locality = locality;
    }

    /**
     * Gets specific location.
     *
     * @return the specific location
     */
    public List<String> getSpecificLocation() {
        return specificLocation;
    }

    /**
     * Sets specific location.
     *
     * @param specificLocation the specific location
     */
    public void setSpecificLocation(List<String> specificLocation) {
        this.specificLocation = specificLocation;
    }

    /**
     * Gets chart number.
     *
     * @return the chart number
     */
    public List<String> getChartNumber() {
        return chartNumber;
    }

    /**
     * Sets chart number.
     *
     * @param chartNumber the chart number
     */
    public void setChartNumber(List<String> chartNumber) {
        this.chartNumber = chartNumber;
    }

    /**
     * Gets international number.
     *
     * @return the international number
     */
    public List<Integer> getInternationalNumber() {
        return internationalNumber;
    }

    /**
     * Sets international number.
     *
     * @param internationalNumber the international number
     */
    public void setInternationalNumber(List<Integer> internationalNumber) {
        this.internationalNumber = internationalNumber;
    }

}
