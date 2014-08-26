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

public class Waypoint implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

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

    public Waypoint() {

    }

    public Waypoint(String name, double latitude, double longitude, Double rot, Double turnRad) {
        super();
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rot = rot;
        this.turnRad = turnRad;
    }

    public Date getEta() {
        return eta;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public Double getRot() {
        return rot;
    }

    public RouteLeg getRouteLeg() {
        return routeLeg;
    }

    public Double getTurnRad() {
        return turnRad;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRot(Double rot) {
        this.rot = rot;
    }

    public void setRouteLeg(RouteLeg routeLeg) {
        this.routeLeg = routeLeg;
    }

    public void setTurnRad(Double turnRad) {
        this.turnRad = turnRad;
    }

    @Override
    public String toString() {
        return "Waypoint [name=" + name + ", routeLeg=" + routeLeg + ", eta=" + eta + ", latitude=" + latitude
                + ", longitude=" + longitude + ", rot=" + rot + ", turnRad=" + turnRad + "]";
    }

    
}
