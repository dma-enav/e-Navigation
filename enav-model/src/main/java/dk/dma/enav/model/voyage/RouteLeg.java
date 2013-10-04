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

public class RouteLeg {

    /** Speed in knots. */
    private Double speed;

    /** Port XTD. */
    private Double xtdPort;

    /** Sail heading rhumb line or great circle */
    private Heading heading;

    /** Starboard XTD. */
    private Double xtdStarboard;

    /** Safe Haven Width */
    private Double SFWidth;

    /** Safe Haven Length */
    private Double SFLen;

    public RouteLeg() {

    }

    public RouteLeg(Double speed, Heading heading, Double xtdPort, Double xtdStarboard) {
        super();
        this.speed = speed;
        this.heading = heading;
        this.xtdPort = xtdPort;
        this.xtdStarboard = xtdStarboard;
    }

    public Double getSFLen() {
        return SFLen;
    }

    public Double getSFWidth() {
        return SFWidth;
    }

    public Double getSpeed() {
        return speed;
    }

    public Heading getHeading() {
        return heading;
    }

    public Double getXtdPort() {
        return xtdPort;
    }

    public Double getXtdStarboard() {
        return xtdStarboard;
    }

    public void setSFLen(Double sFLen) {
        SFLen = sFLen;
    }

    public void setSFWidth(Double sFWidth) {
        SFWidth = sFWidth;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public void setXtdPort(Double xtdPort) {
        this.xtdPort = xtdPort;
    }

    public void setXtdStarboard(Double xtdStarboard) {
        this.xtdStarboard = xtdStarboard;
    }
    
    public void setHeading(Heading heading) {
        this.heading = heading;
    }

    /**
     * Enumeration for heading rhumb line or great circle
     */
    public static enum Heading {
        GC, RL;

        public static Heading valueOf(int serialNumber){
            switch(serialNumber){
            case 0: return GC;
            case 1: return RL;
            default: throw new IllegalArgumentException("Unknown value: " + serialNumber);
            }
        }
    };

}
