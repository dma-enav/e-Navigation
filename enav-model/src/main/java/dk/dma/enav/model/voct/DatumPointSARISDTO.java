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

    public DatumPointSARISDTO() {
        super();
    }

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
     * @return the datum
     */
    public PositionDTO getDatum() {
        return datum;
    }

    /**
     * @param datum
     *            the datum to set
     */
    public void setDatum(PositionDTO datum) {
        this.datum = datum;
    }

    /**
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius
     *            the radius to set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * @return the timeElasped
     */
    public double getTimeElasped() {
        return timeElasped;
    }

    /**
     * @param timeElasped
     *            the timeElasped to set
     */
    public void setTimeElasped(double timeElasped) {
        this.timeElasped = timeElasped;
    }

    /**
     * @return the rdvDirection
     */
    public double getRdvDirection() {
        return rdvDirection;
    }

    /**
     * @param rdvDirection
     *            the rdvDirection to set
     */
    public void setRdvDirection(double rdvDirection) {
        this.rdvDirection = rdvDirection;
    }

    /**
     * @return the rdvDistance
     */
    public double getRdvDistance() {
        return rdvDistance;
    }

    /**
     * @param rdvDistance
     *            the rdvDistance to set
     */
    public void setRdvDistance(double rdvDistance) {
        this.rdvDistance = rdvDistance;
    }

    /**
     * @return the rdvSpeed
     */
    public double getRdvSpeed() {
        return rdvSpeed;
    }

    /**
     * @param rdvSpeed
     *            the rdvSpeed to set
     */
    public void setRdvSpeed(double rdvSpeed) {
        this.rdvSpeed = rdvSpeed;
    }

    /**
     * @return the rdvDirectionLast
     */
    public double getRdvDirectionLast() {
        return rdvDirectionLast;
    }

    /**
     * @param rdvDirectionLast
     *            the rdvDirectionLast to set
     */
    public void setRdvDirectionLast(double rdvDirectionLast) {
        this.rdvDirectionLast = rdvDirectionLast;
    }

    /**
     * @return the rdvSpeedLast
     */
    public double getRdvSpeedLast() {
        return rdvSpeedLast;
    }

    /**
     * @param rdvSpeedLast
     *            the rdvSpeedLast to set
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
     * @return the sarisTarget
     */
    public List<SARISTarget> getSarisTarget() {
        return sarisTarget;
    }

    /**
     * @param sarisTarget
     *            the sarisTarget to set
     */
    public void setSarisTarget(List<SARISTarget> sarisTarget) {
        this.sarisTarget = sarisTarget;
    }

    /**
     * @return the sarAreaDat
     */
    public List<SARAreaData> getSarAreaDat() {
        return sarAreaDat;
    }

    /**
     * @param sarAreaDat
     *            the sarAreaDat to set
     */
    public void setSarAreaDat(List<SARAreaData> sarAreaDat) {
        this.sarAreaDat = sarAreaDat;
    }

}
