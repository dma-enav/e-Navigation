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
