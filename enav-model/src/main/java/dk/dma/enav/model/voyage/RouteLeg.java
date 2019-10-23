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

/**
 * The type Route leg.
 */
public class RouteLeg implements Serializable {

    private static final long serialVersionUID = 1L;

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

    /**
     * Instantiates a new Route leg.
     */
    public RouteLeg() {

    }

    /**
     * Instantiates a new Route leg.
     *
     * @param speed        the speed
     * @param heading      the heading
     * @param xtdPort      the xtd port
     * @param xtdStarboard the xtd starboard
     */
    public RouteLeg(Double speed, Heading heading, Double xtdPort, Double xtdStarboard) {
        super();
        this.speed = speed;
        this.heading = heading;
        this.xtdPort = xtdPort;
        this.xtdStarboard = xtdStarboard;
    }

    /**
     * Gets sf len.
     *
     * @return the sf len
     */
    public Double getSFLen() {
        return SFLen;
    }

    /**
     * Gets sf width.
     *
     * @return the sf width
     */
    public Double getSFWidth() {
        return SFWidth;
    }

    /**
     * Gets speed.
     *
     * @return the speed
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * Gets heading.
     *
     * @return the heading
     */
    public Heading getHeading() {
        return heading;
    }

    /**
     * Gets xtd port.
     *
     * @return the xtd port
     */
    public Double getXtdPort() {
        return xtdPort;
    }

    /**
     * Gets xtd starboard.
     *
     * @return the xtd starboard
     */
    public Double getXtdStarboard() {
        return xtdStarboard;
    }

    /**
     * Sets sf len.
     *
     * @param sFLen the s f len
     */
    public void setSFLen(Double sFLen) {
        SFLen = sFLen;
    }

    /**
     * Sets sf width.
     *
     * @param sFWidth the s f width
     */
    public void setSFWidth(Double sFWidth) {
        SFWidth = sFWidth;
    }

    /**
     * Sets speed.
     *
     * @param speed the speed
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * Sets xtd port.
     *
     * @param xtdPort the xtd port
     */
    public void setXtdPort(Double xtdPort) {
        this.xtdPort = xtdPort;
    }

    /**
     * Sets xtd starboard.
     *
     * @param xtdStarboard the xtd starboard
     */
    public void setXtdStarboard(Double xtdStarboard) {
        this.xtdStarboard = xtdStarboard;
    }

    /**
     * Sets heading.
     *
     * @param heading the heading
     */
    public void setHeading(Heading heading) {
        this.heading = heading;
    }

    /**
     * Enumeration for heading rhumb line or great circle
     */
    public static enum Heading {
        /**
         * Gc heading.
         */
        GC,
        /**
         * Rl heading.
         */
        RL;

        /**
         * Value of heading.
         *
         * @param serialNumber the serial number
         * @return the heading
         */
        public static Heading valueOf(int serialNumber){
            switch(serialNumber){
            case 0: return GC;
            case 1: return RL;
            default: throw new IllegalArgumentException("Unknown value: " + serialNumber);
            }
        }
    }

    @Override
    public String toString() {
        return "RouteLeg [speed=" + speed + ", xtdPort=" + xtdPort + ", heading=" + heading + ", xtdStarboard="
                + xtdStarboard + ", SFWidth=" + SFWidth + ", SFLen=" + SFLen + "]";
    };

    
}
