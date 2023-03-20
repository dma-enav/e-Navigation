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
package dk.dma.enav.model.voyage;

import java.io.Serializable;
import java.util.Date;

/**
 * The type Waypoint.
 */
public class Waypoint implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * Gets serialversionuid.
     *
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /** Waypoint name */
    private String name;

    /** Out leg */
    private RouteLeg routeLeg;

    /** ETA at waypoint. */
    private Date eta;

    /** Mandatory latitude. */
    private double latitude;
    /** Mandatory longitude. */
    private double longitude;

    /** Rate of turn . */
    private Double rot;

    /** Waypoint turn radius in nautical miles. */
    private Double turnRad;

    /**
     * Instantiates a new Waypoint.
     */
    public Waypoint() {

    }

    /**
     * Instantiates a new Waypoint.
     *
     * @param name      the name
     * @param latitude  the latitude
     * @param longitude the longitude
     * @param rot       the rot
     * @param turnRad   the turn rad
     */
    public Waypoint(String name, double latitude, double longitude, Double rot, Double turnRad) {
        super();
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rot = rot;
        this.turnRad = turnRad;
    }

    /**
     * Gets eta.
     *
     * @return the eta
     */
    public Date getEta() {
        return eta;
    }

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Gets longitude.
     *
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets rot.
     *
     * @return the rot
     */
    public Double getRot() {
        return rot;
    }

    /**
     * Gets route leg.
     *
     * @return the route leg
     */
    public RouteLeg getRouteLeg() {
        return routeLeg;
    }

    /**
     * Gets turn rad.
     *
     * @return the turn rad
     */
    public Double getTurnRad() {
        return turnRad;
    }

    /**
     * Sets eta.
     *
     * @param eta the eta
     */
    public void setEta(Date eta) {
        this.eta = eta;
    }

    /**
     * Sets latitude.
     *
     * @param latitude the latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Sets longitude.
     *
     * @param longitude the longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets rot.
     *
     * @param rot the rot
     */
    public void setRot(Double rot) {
        this.rot = rot;
    }

    /**
     * Sets route leg.
     *
     * @param routeLeg the route leg
     */
    public void setRouteLeg(RouteLeg routeLeg) {
        this.routeLeg = routeLeg;
    }

    /**
     * Sets turn rad.
     *
     * @param turnRad the turn rad
     */
    public void setTurnRad(Double turnRad) {
        this.turnRad = turnRad;
    }

    @Override
    public String toString() {
        return "Waypoint [name=" + name + ", routeLeg=" + routeLeg + ", eta=" + eta + ", latitude=" + latitude
                + ", longitude=" + longitude + ", rot=" + rot + ", turnRad=" + turnRad + "]";
    }

    
}
