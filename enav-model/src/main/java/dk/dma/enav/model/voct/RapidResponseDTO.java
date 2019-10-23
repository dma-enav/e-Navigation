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
 * The type Rapid response dto.
 */
public class RapidResponseDTO extends SARModelDTO {

    private static final long serialVersionUID = 1L;
    private List<PositionDTO> currentList;
    private List<PositionDTO> windList;

    private PositionDTO datum;

    private double radius;

    private double timeElasped;

    private double rdvDirection;
    private double rdvDistance;
    private double rdvSpeed;

    private double rdvDirectionLast;
    private double rdvSpeedLast;

    private PositionDTO A;
    private PositionDTO B;
    private PositionDTO C;
    private PositionDTO D;

    /**
     * Instantiates a new Rapid response dto.
     */
    public RapidResponseDTO() {
        super();
    }

    /**
     * Instantiates a new Rapid response dto.
     *
     * @param sarID            the sar id
     * @param lKPDate          the l kp date
     * @param cSSDate          the c ss date
     * @param lKP              the l kp
     * @param cSP              the c sp
     * @param x                the x
     * @param y                the y
     * @param safetyFactor     the safety factor
     * @param searchObject     the search object
     * @param currentList      the current list
     * @param windList         the wind list
     * @param datum            the datum
     * @param radius           the radius
     * @param timeElasped      the time elasped
     * @param rdvDirection     the rdv direction
     * @param rdvDistance      the rdv distance
     * @param rdvSpeed         the rdv speed
     * @param rdvDirectionLast the rdv direction last
     * @param rdvSpeedLast     the rdv speed last
     * @param a                the a
     * @param b                the b
     * @param c                the c
     * @param d                the d
     * @param weatherData      the weather data
     */
    public RapidResponseDTO(String sarID, Date lKPDate, Date cSSDate,
            PositionDTO lKP, PositionDTO cSP, double x, double y,
            double safetyFactor, int searchObject,
            List<PositionDTO> currentList, List<PositionDTO> windList,
            PositionDTO datum, double radius, double timeElasped,
            double rdvDirection, double rdvDistance, double rdvSpeed,
            double rdvDirectionLast, double rdvSpeedLast, PositionDTO a,
            PositionDTO b, PositionDTO c, PositionDTO d,
            List<WeatherDataDTO> weatherData) {
        super(sarID, lKPDate, cSSDate, lKP, cSP, x, y, safetyFactor,
                searchObject, weatherData);
        this.currentList = currentList;
        this.windList = windList;
        this.datum = datum;
        this.radius = radius;
        this.timeElasped = timeElasped;
        this.rdvDirection = rdvDirection;
        this.rdvDistance = rdvDistance;
        this.rdvSpeed = rdvSpeed;
        this.rdvDirectionLast = rdvDirectionLast;
        this.rdvSpeedLast = rdvSpeedLast;
        A = a;
        B = b;
        C = c;
        D = d;
    }

    /**
     * Gets current list.
     *
     * @return the currentList
     */
    public List<PositionDTO> getCurrentList() {
        return currentList;
    }

    /**
     * Sets current list.
     *
     * @param currentList the currentList to set
     */
    public void setCurrentList(List<PositionDTO> currentList) {
        this.currentList = currentList;
    }

    /**
     * Gets wind list.
     *
     * @return the windList
     */
    public List<PositionDTO> getWindList() {
        return windList;
    }

    /**
     * Sets wind list.
     *
     * @param windList the windList to set
     */
    public void setWindList(List<PositionDTO> windList) {
        this.windList = windList;
    }

    /**
     * Gets datum.
     *
     * @return the datum
     */
    public PositionDTO getDatum() {
        return datum;
    }

    /**
     * Sets datum.
     *
     * @param datum the datum to set
     */
    public void setDatum(PositionDTO datum) {
        this.datum = datum;
    }

    /**
     * Gets radius.
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets radius.
     *
     * @param radius the radius to set
     */
    public void setRadius(double radius) {
        this.radius = radius;
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
     * Gets rdv direction.
     *
     * @return the rdvDirection
     */
    public double getRdvDirection() {
        return rdvDirection;
    }

    /**
     * Sets rdv direction.
     *
     * @param rdvDirection the rdvDirection to set
     */
    public void setRdvDirection(double rdvDirection) {
        this.rdvDirection = rdvDirection;
    }

    /**
     * Gets rdv distance.
     *
     * @return the rdvDistance
     */
    public double getRdvDistance() {
        return rdvDistance;
    }

    /**
     * Sets rdv distance.
     *
     * @param rdvDistance the rdvDistance to set
     */
    public void setRdvDistance(double rdvDistance) {
        this.rdvDistance = rdvDistance;
    }

    /**
     * Gets rdv speed.
     *
     * @return the rdvSpeed
     */
    public double getRdvSpeed() {
        return rdvSpeed;
    }

    /**
     * Sets rdv speed.
     *
     * @param rdvSpeed the rdvSpeed to set
     */
    public void setRdvSpeed(double rdvSpeed) {
        this.rdvSpeed = rdvSpeed;
    }

    /**
     * Gets rdv direction last.
     *
     * @return the rdvDirectionLast
     */
    public double getRdvDirectionLast() {
        return rdvDirectionLast;
    }

    /**
     * Sets rdv direction last.
     *
     * @param rdvDirectionLast the rdvDirectionLast to set
     */
    public void setRdvDirectionLast(double rdvDirectionLast) {
        this.rdvDirectionLast = rdvDirectionLast;
    }

    /**
     * Gets rdv speed last.
     *
     * @return the rdvSpeedLast
     */
    public double getRdvSpeedLast() {
        return rdvSpeedLast;
    }

    /**
     * Sets rdv speed last.
     *
     * @param rdvSpeedLast the rdvSpeedLast to set
     */
    public void setRdvSpeedLast(double rdvSpeedLast) {
        this.rdvSpeedLast = rdvSpeedLast;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "RapidResponseDTO [currentList=" + currentList + ", windList="
                + windList + ", datum=" + datum + ", radius=" + radius
                + ", timeElasped=" + timeElasped + ", rdvDirection="
                + rdvDirection + ", rdvDistance=" + rdvDistance + ", rdvSpeed="
                + rdvSpeed + ", rdvDirectionLast=" + rdvDirectionLast
                + ", rdvSpeedLast=" + rdvSpeedLast + ", A=" + A + ", B=" + B
                + ", C=" + C + ", D=" + D + ", getSarID()=" + getSarID()
                + ", getLKPDate()=" + getLKPDate() + ", getCSSDate()="
                + getCSSDate() + ", getLKP()=" + getLKP() + ", getCSP()="
                + getCSP() + ", getX()=" + getX() + ", getY()=" + getY()
                + ", getSafetyFactor()=" + getSafetyFactor()
                + ", getSearchObject()=" + getSearchObject()
                + ", getWeatherData()=" + getWeatherData() + ", toString()="
                + super.toString() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + "]";
    }

}
