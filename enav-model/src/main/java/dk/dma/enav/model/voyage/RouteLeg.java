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
    }

    @Override
    public String toString() {
        return "RouteLeg [speed=" + speed + ", xtdPort=" + xtdPort + ", heading=" + heading + ", xtdStarboard="
                + xtdStarboard + ", SFWidth=" + SFWidth + ", SFLen=" + SFLen + "]";
    };

    
}
