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

    public Message() {

    }

    public MessageSeriesIdentifier getMessageSeriesIdentifier() {
        return messageSeriesIdentifier;
    }

    public void setMessageSeriesIdentifier(MessageSeriesIdentifier messageSeriesIdentifier) {
        this.messageSeriesIdentifier = messageSeriesIdentifier;
    }

    public String getGeneralArea() {
        return generalArea;
    }

    public void setGeneralArea(String generalArea) {
        this.generalArea = generalArea;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public List<String> getSpecificLocation() {
        return specificLocation;
    }

    public void setSpecificLocation(List<String> specificLocation) {
        this.specificLocation = specificLocation;
    }

    public List<String> getChartNumber() {
        return chartNumber;
    }

    public void setChartNumber(List<String> chartNumber) {
        this.chartNumber = chartNumber;
    }

    public List<Integer> getInternationalNumber() {
        return internationalNumber;
    }

    public void setInternationalNumber(List<Integer> internationalNumber) {
        this.internationalNumber = internationalNumber;
    }

}
