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
package dk.dma.enav.model.voct;

import java.util.Date;
import java.util.List;

import dk.dma.enav.model.dto.PositionDTO;

public class DatumPointDTO extends SARModelDTO {

    private static final long serialVersionUID = 1L;
    
    private List<PositionDTO> currentListDownWind;

    private List<PositionDTO> currentListMax;

    private List<PositionDTO> currentListMin;
    
    
    private List<PositionDTO> windListDownWind;

    private List<PositionDTO> windListMax;

    private List<PositionDTO> windListMin;

    private PositionDTO datumDownWind;
    private PositionDTO datumMax;
    private PositionDTO datumMin;

    private double radiusDownWind;
    private double radiusMax;
    private double radiusMin;

    private double timeElasped;

    private double rdvDirectionDownWind;
    private double rdvDirectionMax;
    private double rdvDirectionMin;

    private double rdvDistanceDownWind;
    private double rdvDistanceMax;
    private double rdvDistanceMin;

    private double rdvSpeedDownWind;
    private double rdvSpeedMax;
    private double rdvSpeedMin;

//    private double rdvDirectionLastDownWind;
//    private double rdvDirectionLastMax;
//    private double rdvDirectionLastMin;
//
//    private double rdvSpeedLastDownWind;
//    private double rdvSpeedLastMax;
//    private double rdvSpeedLastMin;

    private PositionDTO A;
    private PositionDTO B;
    private PositionDTO C;
    private PositionDTO D;

    public DatumPointDTO() {
        super();
    }

    /**
     * @param sarID
     * @param lKPDate
     * @param cSSDate
     * @param lKP
     * @param cSP
     * @param x
     * @param y
     * @param safetyFactor
     * @param searchObject
     * @param weatherData
     * @param currentListDownWind
     * @param currentListMax
     * @param currentListMin
     * @param windListDownWind
     * @param windListMax
     * @param windListMin
     * @param datumDownWind
     * @param datumMax
     * @param datumMin
     * @param radiusDownWind
     * @param radiusMax
     * @param radiusMin
     * @param timeElasped
     * @param rdvDirectionDownWind
     * @param rdvDirectionMax
     * @param rdvDirectionMin
     * @param rdvDistanceDownWind
     * @param rdvDistanceMax
     * @param rdvDistanceMin
     * @param rdvSpeedDownWind
     * @param rdvSpeedMax
     * @param rdvSpeedMin
     * @param a
     * @param b
     * @param c
     * @param d
     */
    public DatumPointDTO(String sarID, Date lKPDate, Date cSSDate,
            PositionDTO lKP, PositionDTO cSP, double x, double y,
            double safetyFactor, int searchObject,
            List<WeatherDataDTO> weatherData,
            List<PositionDTO> currentListDownWind,
            List<PositionDTO> currentListMax, List<PositionDTO> currentListMin,
            List<PositionDTO> windListDownWind, List<PositionDTO> windListMax,
            List<PositionDTO> windListMin, PositionDTO datumDownWind,
            PositionDTO datumMax, PositionDTO datumMin, double radiusDownWind,
            double radiusMax, double radiusMin, double timeElasped,
            double rdvDirectionDownWind, double rdvDirectionMax,
            double rdvDirectionMin, double rdvDistanceDownWind,
            double rdvDistanceMax, double rdvDistanceMin,
            double rdvSpeedDownWind, double rdvSpeedMax, double rdvSpeedMin,
            PositionDTO a, PositionDTO b, PositionDTO c, PositionDTO d) {
        super(sarID, lKPDate, cSSDate, lKP, cSP, x, y, safetyFactor,
                searchObject, weatherData);
        this.currentListDownWind = currentListDownWind;
        this.currentListMax = currentListMax;
        this.currentListMin = currentListMin;
        this.windListDownWind = windListDownWind;
        this.windListMax = windListMax;
        this.windListMin = windListMin;
        this.datumDownWind = datumDownWind;
        this.datumMax = datumMax;
        this.datumMin = datumMin;
        this.radiusDownWind = radiusDownWind;
        this.radiusMax = radiusMax;
        this.radiusMin = radiusMin;
        this.timeElasped = timeElasped;
        this.rdvDirectionDownWind = rdvDirectionDownWind;
        this.rdvDirectionMax = rdvDirectionMax;
        this.rdvDirectionMin = rdvDirectionMin;
        this.rdvDistanceDownWind = rdvDistanceDownWind;
        this.rdvDistanceMax = rdvDistanceMax;
        this.rdvDistanceMin = rdvDistanceMin;
        this.rdvSpeedDownWind = rdvSpeedDownWind;
        this.rdvSpeedMax = rdvSpeedMax;
        this.rdvSpeedMin = rdvSpeedMin;
        A = a;
        B = b;
        C = c;
        D = d;
    }


    /**
     * @return the currentListDownWind
     */
    public List<PositionDTO> getCurrentListDownWind() {
        return currentListDownWind;
    }

    /**
     * @param currentListDownWind the currentListDownWind to set
     */
    public void setCurrentListDownWind(List<PositionDTO> currentListDownWind) {
        this.currentListDownWind = currentListDownWind;
    }

    /**
     * @return the currentListMax
     */
    public List<PositionDTO> getCurrentListMax() {
        return currentListMax;
    }

    /**
     * @param currentListMax the currentListMax to set
     */
    public void setCurrentListMax(List<PositionDTO> currentListMax) {
        this.currentListMax = currentListMax;
    }

    /**
     * @return the currentListMin
     */
    public List<PositionDTO> getCurrentListMin() {
        return currentListMin;
    }

    /**
     * @param currentListMin the currentListMin to set
     */
    public void setCurrentListMin(List<PositionDTO> currentListMin) {
        this.currentListMin = currentListMin;
    }

    /**
     * @return the windListDownWind
     */
    public List<PositionDTO> getWindListDownWind() {
        return windListDownWind;
    }

    /**
     * @param windListDownWind the windListDownWind to set
     */
    public void setWindListDownWind(List<PositionDTO> windListDownWind) {
        this.windListDownWind = windListDownWind;
    }

    /**
     * @return the windListMax
     */
    public List<PositionDTO> getWindListMax() {
        return windListMax;
    }

    /**
     * @param windListMax the windListMax to set
     */
    public void setWindListMax(List<PositionDTO> windListMax) {
        this.windListMax = windListMax;
    }

    /**
     * @return the windListMin
     */
    public List<PositionDTO> getWindListMin() {
        return windListMin;
    }

    /**
     * @param windListMin the windListMin to set
     */
    public void setWindListMin(List<PositionDTO> windListMin) {
        this.windListMin = windListMin;
    }

    /**
     * @return the datumDownWind
     */
    public PositionDTO getDatumDownWind() {
        return datumDownWind;
    }

    /**
     * @param datumDownWind the datumDownWind to set
     */
    public void setDatumDownWind(PositionDTO datumDownWind) {
        this.datumDownWind = datumDownWind;
    }

    /**
     * @return the datumMax
     */
    public PositionDTO getDatumMax() {
        return datumMax;
    }

    /**
     * @param datumMax the datumMax to set
     */
    public void setDatumMax(PositionDTO datumMax) {
        this.datumMax = datumMax;
    }

    /**
     * @return the datumMin
     */
    public PositionDTO getDatumMin() {
        return datumMin;
    }

    /**
     * @param datumMin the datumMin to set
     */
    public void setDatumMin(PositionDTO datumMin) {
        this.datumMin = datumMin;
    }

    /**
     * @return the radiusDownWind
     */
    public double getRadiusDownWind() {
        return radiusDownWind;
    }

    /**
     * @param radiusDownWind the radiusDownWind to set
     */
    public void setRadiusDownWind(double radiusDownWind) {
        this.radiusDownWind = radiusDownWind;
    }

    /**
     * @return the radiusMax
     */
    public double getRadiusMax() {
        return radiusMax;
    }

    /**
     * @param radiusMax the radiusMax to set
     */
    public void setRadiusMax(double radiusMax) {
        this.radiusMax = radiusMax;
    }

    /**
     * @return the radiusMin
     */
    public double getRadiusMin() {
        return radiusMin;
    }

    /**
     * @param radiusMin the radiusMin to set
     */
    public void setRadiusMin(double radiusMin) {
        this.radiusMin = radiusMin;
    }

    /**
     * @return the timeElasped
     */
    public double getTimeElasped() {
        return timeElasped;
    }

    /**
     * @param timeElasped the timeElasped to set
     */
    public void setTimeElasped(double timeElasped) {
        this.timeElasped = timeElasped;
    }

    /**
     * @return the rdvDirectionDownWind
     */
    public double getRdvDirectionDownWind() {
        return rdvDirectionDownWind;
    }

    /**
     * @param rdvDirectionDownWind the rdvDirectionDownWind to set
     */
    public void setRdvDirectionDownWind(double rdvDirectionDownWind) {
        this.rdvDirectionDownWind = rdvDirectionDownWind;
    }

    /**
     * @return the rdvDirectionMax
     */
    public double getRdvDirectionMax() {
        return rdvDirectionMax;
    }

    /**
     * @param rdvDirectionMax the rdvDirectionMax to set
     */
    public void setRdvDirectionMax(double rdvDirectionMax) {
        this.rdvDirectionMax = rdvDirectionMax;
    }

    /**
     * @return the rdvDirectionMin
     */
    public double getRdvDirectionMin() {
        return rdvDirectionMin;
    }

    /**
     * @param rdvDirectionMin the rdvDirectionMin to set
     */
    public void setRdvDirectionMin(double rdvDirectionMin) {
        this.rdvDirectionMin = rdvDirectionMin;
    }

    /**
     * @return the rdvDistanceDownWind
     */
    public double getRdvDistanceDownWind() {
        return rdvDistanceDownWind;
    }

    /**
     * @param rdvDistanceDownWind the rdvDistanceDownWind to set
     */
    public void setRdvDistanceDownWind(double rdvDistanceDownWind) {
        this.rdvDistanceDownWind = rdvDistanceDownWind;
    }

    /**
     * @return the rdvDistanceMax
     */
    public double getRdvDistanceMax() {
        return rdvDistanceMax;
    }

    /**
     * @param rdvDistanceMax the rdvDistanceMax to set
     */
    public void setRdvDistanceMax(double rdvDistanceMax) {
        this.rdvDistanceMax = rdvDistanceMax;
    }

    /**
     * @return the rdvDistanceMin
     */
    public double getRdvDistanceMin() {
        return rdvDistanceMin;
    }

    /**
     * @param rdvDistanceMin the rdvDistanceMin to set
     */
    public void setRdvDistanceMin(double rdvDistanceMin) {
        this.rdvDistanceMin = rdvDistanceMin;
    }

    /**
     * @return the rdvSpeedDownWind
     */
    public double getRdvSpeedDownWind() {
        return rdvSpeedDownWind;
    }

    /**
     * @param rdvSpeedDownWind the rdvSpeedDownWind to set
     */
    public void setRdvSpeedDownWind(double rdvSpeedDownWind) {
        this.rdvSpeedDownWind = rdvSpeedDownWind;
    }

    /**
     * @return the rdvSpeedMax
     */
    public double getRdvSpeedMax() {
        return rdvSpeedMax;
    }

    /**
     * @param rdvSpeedMax the rdvSpeedMax to set
     */
    public void setRdvSpeedMax(double rdvSpeedMax) {
        this.rdvSpeedMax = rdvSpeedMax;
    }

    /**
     * @return the rdvSpeedMin
     */
    public double getRdvSpeedMin() {
        return rdvSpeedMin;
    }

    /**
     * @param rdvSpeedMin the rdvSpeedMin to set
     */
    public void setRdvSpeedMin(double rdvSpeedMin) {
        this.rdvSpeedMin = rdvSpeedMin;
    }

    /**
     * @return the a
     */
    public PositionDTO getA() {
        return A;
    }

    /**
     * @param a the a to set
     */
    public void setA(PositionDTO a) {
        A = a;
    }

    /**
     * @return the b
     */
    public PositionDTO getB() {
        return B;
    }

    /**
     * @param b the b to set
     */
    public void setB(PositionDTO b) {
        B = b;
    }

    /**
     * @return the c
     */
    public PositionDTO getC() {
        return C;
    }

    /**
     * @param c the c to set
     */
    public void setC(PositionDTO c) {
        C = c;
    }

    /**
     * @return the d
     */
    public PositionDTO getD() {
        return D;
    }

    /**
     * @param d the d to set
     */
    public void setD(PositionDTO d) {
        D = d;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DatumPointDTO [currentListDownWind=" + currentListDownWind
                + ", currentListMax=" + currentListMax + ", currentListMin="
                + currentListMin + ", windListDownWind=" + windListDownWind
                + ", windListMax=" + windListMax + ", windListMin="
                + windListMin + ", datumDownWind=" + datumDownWind
                + ", datumMax=" + datumMax + ", datumMin=" + datumMin
                + ", radiusDownWind=" + radiusDownWind + ", radiusMax="
                + radiusMax + ", radiusMin=" + radiusMin + ", timeElasped="
                + timeElasped + ", rdvDirectionDownWind="
                + rdvDirectionDownWind + ", rdvDirectionMax=" + rdvDirectionMax
                + ", rdvDirectionMin=" + rdvDirectionMin
                + ", rdvDistanceDownWind=" + rdvDistanceDownWind
                + ", rdvDistanceMax=" + rdvDistanceMax + ", rdvDistanceMin="
                + rdvDistanceMin + ", rdvSpeedDownWind=" + rdvSpeedDownWind
                + ", rdvSpeedMax=" + rdvSpeedMax + ", rdvSpeedMin="
                + rdvSpeedMin + ", A=" + A + ", B=" + B + ", C=" + C + ", D="
                + D + ", getSarID()=" + getSarID() + ", getLKPDate()="
                + getLKPDate() + ", getCSSDate()=" + getCSSDate()
                + ", getLKP()=" + getLKP() + ", getCSP()=" + getCSP()
                + ", getX()=" + getX() + ", getY()=" + getY()
                + ", getSafetyFactor()=" + getSafetyFactor()
                + ", getSearchObject()=" + getSearchObject()
                + ", getWeatherData()=" + getWeatherData() + ", toString()="
                + super.toString() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + "]";
    }

    
    
    
    
}
