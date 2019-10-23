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
 * The type Datum point sarisdto.
 */
public class DatumPointSARISDTO extends SARModelDTO {

    private static final long serialVersionUID = 1L;

    private PositionDTO datum;

    private double radius;

    private double timeElasped;

    private double rdvDirection;
    private double rdvDistance;
    private double rdvSpeed;

    private double rdvDirectionLast;
    private double rdvSpeedLast;

    private List<WeatherDataDTO> weatherData;
    private List<SARISTarget> sarisTarget;
    private List<SARAreaData> sarAreaDat;

    /**
     * Instantiates a new Datum point sarisdto.
     */
    public DatumPointSARISDTO() {
        super();
    }

    /**
     * Instantiates a new Datum point sarisdto.
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
     * @param datum            the datum
     * @param radius           the radius
     * @param timeElasped      the time elasped
     * @param rdvDirection     the rdv direction
     * @param rdvDistance      the rdv distance
     * @param rdvSpeed         the rdv speed
     * @param rdvDirectionLast the rdv direction last
     * @param rdvSpeedLast     the rdv speed last
     * @param weatherData      the weather data
     * @param sarisTarget      the saris target
     * @param sarAreaData      the sar area data
     */
    public DatumPointSARISDTO(String sarID, Date lKPDate, Date cSSDate, PositionDTO lKP, PositionDTO cSP, double x, double y,
            double safetyFactor, int searchObject, PositionDTO datum, double radius, double timeElasped, double rdvDirection,
            double rdvDistance, double rdvSpeed, double rdvDirectionLast, double rdvSpeedLast, List<WeatherDataDTO> weatherData,
            List<SARISTarget> sarisTarget, List<SARAreaData> sarAreaData) {
        super(sarID, lKPDate, cSSDate, lKP, cSP, x, y, safetyFactor, searchObject, weatherData);

        this.datum = datum;
        this.radius = radius;
        this.timeElasped = timeElasped;
        this.rdvDirection = rdvDirection;
        this.rdvDistance = rdvDistance;
        this.rdvSpeed = rdvSpeed;
        this.rdvDirectionLast = rdvDirectionLast;
        this.rdvSpeedLast = rdvSpeedLast;
        this.weatherData = weatherData;
        this.sarisTarget = sarisTarget;
        this.sarAreaDat = sarAreaData;

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
     * @return the weatherData
     */
    public List<WeatherDataDTO> getWeatherData() {
        return weatherData;
    }

    /**
     * @param weatherData
     *            the weatherData to set
     */
    public void setWeatherData(List<WeatherDataDTO> weatherData) {
        this.weatherData = weatherData;
    }

    /**
     * Gets saris target.
     *
     * @return the sarisTarget
     */
    public List<SARISTarget> getSarisTarget() {
        return sarisTarget;
    }

    /**
     * Sets saris target.
     *
     * @param sarisTarget the sarisTarget to set
     */
    public void setSarisTarget(List<SARISTarget> sarisTarget) {
        this.sarisTarget = sarisTarget;
    }

    /**
     * Gets sar area dat.
     *
     * @return the sarAreaDat
     */
    public List<SARAreaData> getSarAreaDat() {
        return sarAreaDat;
    }

    /**
     * Sets sar area dat.
     *
     * @param sarAreaDat the sarAreaDat to set
     */
    public void setSarAreaDat(List<SARAreaData> sarAreaDat) {
        this.sarAreaDat = sarAreaDat;
    }

}
