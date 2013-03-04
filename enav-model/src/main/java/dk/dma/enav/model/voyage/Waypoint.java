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
package dk.dma.enav.model.voyage;

import java.io.Serializable;
import java.util.Date;

public class Waypoint implements Serializable {

    
    public Waypoint(){
        
    }
    
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** ETA at waypoint. */
    private Date eta;

    /** Mandatory latitude. */
    private double latitude;

//    Leg leg;

//    Line line;
    // Waypoint related

    /** Mandatory longitude. */
    private double longitude;

    /** Rate of turn . */
    private Double rot;

    /** Speed in knots. */
    private Double speed;

    /** Waypoint turn radius in nautical miles. */
    private Double turnRad;

    /** Port XTD. */
    private Double xtdPort;

    /** Starboard XTD. */
    private Double xtdStarboard;

    public Date getEta() {
        return eta;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Double getRot() {
        return rot;
    }

    public Double getSpeed() {
        return speed;
    }

    public Double getTurnRad() {
        return turnRad;
    }

    public Double getXtdPort() {
        return xtdPort;
    }

    public Double getXtdStarboard() {
        return xtdStarboard;
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

    public void setRot(Double rot) {
        this.rot = rot;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    // Leaving leg related

    public void setTurnRad(Double turnRad) {
        this.turnRad = turnRad;
    }

    public void setXtdPort(Double xtdPort) {
        this.xtdPort = xtdPort;
    }

    public void setXtdStarboard(Double xtdStarboard) {
        this.xtdStarboard = xtdStarboard;
    }

    

//    public Line getLine() {
//        return line;
//    }
//
//    public void setLine(Line line) {
//        this.line = line;
//    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }


}
