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

/**
 * The type Datum point dto.
 */
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

    /**
     * Instantiates a new Datum point dto.
     */
    public DatumPointDTO() {
        super();
    }

    /**
     * Instantiates a new Datum point dto.
     *
     * @param sarID                the sar id
     * @param lKPDate              the l kp date
     * @param cSSDate              the c ss date
     * @param lKP                  the l kp
     * @param cSP                  the c sp
     * @param x                    the x
     * @param y                    the y
     * @param safetyFactor         the safety factor
     * @param searchObject         the search object
     * @param weatherData          the weather data
     * @param currentListDownWind  the current list down wind
     * @param currentListMax       the current list max
     * @param currentListMin       the current list min
     * @param windListDownWind     the wind list down wind
     * @param windListMax          the wind list max
     * @param windListMin          the wind list min
     * @param datumDownWind        the datum down wind
     * @param datumMax             the datum max
     * @param datumMin             the datum min
     * @param radiusDownWind       the radius down wind
     * @param radiusMax            the radius max
     * @param radiusMin            the radius min
     * @param timeElasped          the time elasped
     * @param rdvDirectionDownWind the rdv direction down wind
     * @param rdvDirectionMax      the rdv direction max
     * @param rdvDirectionMin      the rdv direction min
     * @param rdvDistanceDownWind  the rdv distance down wind
     * @param rdvDistanceMax       the rdv distance max
     * @param rdvDistanceMin       the rdv distance min
     * @param rdvSpeedDownWind     the rdv speed down wind
     * @param rdvSpeedMax          the rdv speed max
     * @param rdvSpeedMin          the rdv speed min
     * @param a                    the a
     * @param b                    the b
     * @param c                    the c
     * @param d                    the d
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
     * Gets current list down wind.
     *
     * @return the currentListDownWind
     */
    public List<PositionDTO> getCurrentListDownWind() {
        return currentListDownWind;
    }

    /**
     * Sets current list down wind.
     *
     * @param currentListDownWind the currentListDownWind to set
     */
    public void setCurrentListDownWind(List<PositionDTO> currentListDownWind) {
        this.currentListDownWind = currentListDownWind;
    }

    /**
     * Gets current list max.
     *
     * @return the currentListMax
     */
    public List<PositionDTO> getCurrentListMax() {
        return currentListMax;
    }

    /**
     * Sets current list max.
     *
     * @param currentListMax the currentListMax to set
     */
    public void setCurrentListMax(List<PositionDTO> currentListMax) {
        this.currentListMax = currentListMax;
    }

    /**
     * Gets current list min.
     *
     * @return the currentListMin
     */
    public List<PositionDTO> getCurrentListMin() {
        return currentListMin;
    }

    /**
     * Sets current list min.
     *
     * @param currentListMin the currentListMin to set
     */
    public void setCurrentListMin(List<PositionDTO> currentListMin) {
        this.currentListMin = currentListMin;
    }

    /**
     * Gets wind list down wind.
     *
     * @return the windListDownWind
     */
    public List<PositionDTO> getWindListDownWind() {
        return windListDownWind;
    }

    /**
     * Sets wind list down wind.
     *
     * @param windListDownWind the windListDownWind to set
     */
    public void setWindListDownWind(List<PositionDTO> windListDownWind) {
        this.windListDownWind = windListDownWind;
    }

    /**
     * Gets wind list max.
     *
     * @return the windListMax
     */
    public List<PositionDTO> getWindListMax() {
        return windListMax;
    }

    /**
     * Sets wind list max.
     *
     * @param windListMax the windListMax to set
     */
    public void setWindListMax(List<PositionDTO> windListMax) {
        this.windListMax = windListMax;
    }

    /**
     * Gets wind list min.
     *
     * @return the windListMin
     */
    public List<PositionDTO> getWindListMin() {
        return windListMin;
    }

    /**
     * Sets wind list min.
     *
     * @param windListMin the windListMin to set
     */
    public void setWindListMin(List<PositionDTO> windListMin) {
        this.windListMin = windListMin;
    }

    /**
     * Gets datum down wind.
     *
     * @return the datumDownWind
     */
    public PositionDTO getDatumDownWind() {
        return datumDownWind;
    }

    /**
     * Sets datum down wind.
     *
     * @param datumDownWind the datumDownWind to set
     */
    public void setDatumDownWind(PositionDTO datumDownWind) {
        this.datumDownWind = datumDownWind;
    }

    /**
     * Gets datum max.
     *
     * @return the datumMax
     */
    public PositionDTO getDatumMax() {
        return datumMax;
    }

    /**
     * Sets datum max.
     *
     * @param datumMax the datumMax to set
     */
    public void setDatumMax(PositionDTO datumMax) {
        this.datumMax = datumMax;
    }

    /**
     * Gets datum min.
     *
     * @return the datumMin
     */
    public PositionDTO getDatumMin() {
        return datumMin;
    }

    /**
     * Sets datum min.
     *
     * @param datumMin the datumMin to set
     */
    public void setDatumMin(PositionDTO datumMin) {
        this.datumMin = datumMin;
    }

    /**
     * Gets radius down wind.
     *
     * @return the radiusDownWind
     */
    public double getRadiusDownWind() {
        return radiusDownWind;
    }

    /**
     * Sets radius down wind.
     *
     * @param radiusDownWind the radiusDownWind to set
     */
    public void setRadiusDownWind(double radiusDownWind) {
        this.radiusDownWind = radiusDownWind;
    }

    /**
     * Gets radius max.
     *
     * @return the radiusMax
     */
    public double getRadiusMax() {
        return radiusMax;
    }

    /**
     * Sets radius max.
     *
     * @param radiusMax the radiusMax to set
     */
    public void setRadiusMax(double radiusMax) {
        this.radiusMax = radiusMax;
    }

    /**
     * Gets radius min.
     *
     * @return the radiusMin
     */
    public double getRadiusMin() {
        return radiusMin;
    }

    /**
     * Sets radius min.
     *
     * @param radiusMin the radiusMin to set
     */
    public void setRadiusMin(double radiusMin) {
        this.radiusMin = radiusMin;
    }

    /**
     * Gets time elasped.
     *
     * @return the timeElasped
     */
    public double getTimeElasped() {
        return timeElasped;
    }

    /**
     * Sets time elasped.
     *
     * @param timeElasped the timeElasped to set
     */
    public void setTimeElasped(double timeElasped) {
        this.timeElasped = timeElasped;
    }

    /**
     * Gets rdv direction down wind.
     *
     * @return the rdvDirectionDownWind
     */
    public double getRdvDirectionDownWind() {
        return rdvDirectionDownWind;
    }

    /**
     * Sets rdv direction down wind.
     *
     * @param rdvDirectionDownWind the rdvDirectionDownWind to set
     */
    public void setRdvDirectionDownWind(double rdvDirectionDownWind) {
        this.rdvDirectionDownWind = rdvDirectionDownWind;
    }

    /**
     * Gets rdv direction max.
     *
     * @return the rdvDirectionMax
     */
    public double getRdvDirectionMax() {
        return rdvDirectionMax;
    }

    /**
     * Sets rdv direction max.
     *
     * @param rdvDirectionMax the rdvDirectionMax to set
     */
    public void setRdvDirectionMax(double rdvDirectionMax) {
        this.rdvDirectionMax = rdvDirectionMax;
    }

    /**
     * Gets rdv direction min.
     *
     * @return the rdvDirectionMin
     */
    public double getRdvDirectionMin() {
        return rdvDirectionMin;
    }

    /**
     * Sets rdv direction min.
     *
     * @param rdvDirectionMin the rdvDirectionMin to set
     */
    public void setRdvDirectionMin(double rdvDirectionMin) {
        this.rdvDirectionMin = rdvDirectionMin;
    }

    /**
     * Gets rdv distance down wind.
     *
     * @return the rdvDistanceDownWind
     */
    public double getRdvDistanceDownWind() {
        return rdvDistanceDownWind;
    }

    /**
     * Sets rdv distance down wind.
     *
     * @param rdvDistanceDownWind the rdvDistanceDownWind to set
     */
    public void setRdvDistanceDownWind(double rdvDistanceDownWind) {
        this.rdvDistanceDownWind = rdvDistanceDownWind;
    }

    /**
     * Gets rdv distance max.
     *
     * @return the rdvDistanceMax
     */
    public double getRdvDistanceMax() {
        return rdvDistanceMax;
    }

    /**
     * Sets rdv distance max.
     *
     * @param rdvDistanceMax the rdvDistanceMax to set
     */
    public void setRdvDistanceMax(double rdvDistanceMax) {
        this.rdvDistanceMax = rdvDistanceMax;
    }

    /**
     * Gets rdv distance min.
     *
     * @return the rdvDistanceMin
     */
    public double getRdvDistanceMin() {
        return rdvDistanceMin;
    }

    /**
     * Sets rdv distance min.
     *
     * @param rdvDistanceMin the rdvDistanceMin to set
     */
    public void setRdvDistanceMin(double rdvDistanceMin) {
        this.rdvDistanceMin = rdvDistanceMin;
    }

    /**
     * Gets rdv speed down wind.
     *
     * @return the rdvSpeedDownWind
     */
    public double getRdvSpeedDownWind() {
        return rdvSpeedDownWind;
    }

    /**
     * Sets rdv speed down wind.
     *
     * @param rdvSpeedDownWind the rdvSpeedDownWind to set
     */
    public void setRdvSpeedDownWind(double rdvSpeedDownWind) {
        this.rdvSpeedDownWind = rdvSpeedDownWind;
    }

    /**
     * Gets rdv speed max.
     *
     * @return the rdvSpeedMax
     */
    public double getRdvSpeedMax() {
        return rdvSpeedMax;
    }

    /**
     * Sets rdv speed max.
     *
     * @param rdvSpeedMax the rdvSpeedMax to set
     */
    public void setRdvSpeedMax(double rdvSpeedMax) {
        this.rdvSpeedMax = rdvSpeedMax;
    }

    /**
     * Gets rdv speed min.
     *
     * @return the rdvSpeedMin
     */
    public double getRdvSpeedMin() {
        return rdvSpeedMin;
    }

    /**
     * Sets rdv speed min.
     *
     * @param rdvSpeedMin the rdvSpeedMin to set
     */
    public void setRdvSpeedMin(double rdvSpeedMin) {
        this.rdvSpeedMin = rdvSpeedMin;
    }

    /**
     * Gets a.
     *
     * @return the a
     */
    public PositionDTO getA() {
        return A;
    }

    /**
     * Sets a.
     *
     * @param a the a to set
     */
    public void setA(PositionDTO a) {
        A = a;
    }

    /**
     * Gets b.
     *
     * @return the b
     */
    public PositionDTO getB() {
        return B;
    }

    /**
     * Sets b.
     *
     * @param b the b to set
     */
    public void setB(PositionDTO b) {
        B = b;
    }

    /**
     * Gets c.
     *
     * @return the c
     */
    public PositionDTO getC() {
        return C;
    }

    /**
     * Sets c.
     *
     * @param c the c to set
     */
    public void setC(PositionDTO c) {
        C = c;
    }

    /**
     * Gets d.
     *
     * @return the d
     */
    public PositionDTO getD() {
        return D;
    }

    /**
     * Sets d.
     *
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
