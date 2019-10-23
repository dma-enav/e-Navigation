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

import java.io.Serializable;

import dk.dma.enav.model.dto.PositionDTO;

/**
 * The type Effort allocation dto.
 */
public class EffortAllocationDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private double w;

    private double groundSpeed;

    private double pod;

    private double trackSpacing;

    private int searchTime;

    private double effectiveAreaSize;

    // private double effectiveAreaWidth;
    // private double effectiveAreaHeight;

    private PositionDTO effectiveAreaA;

    private PositionDTO effectiveAreaB;

    private PositionDTO effectiveAreaC;

    private PositionDTO effectiveAreaD;


    /**
     * Instantiates a new Effort allocation dto.
     */
    public EffortAllocationDTO() {
        super();
    }

    /**
     * Instantiates a new Effort allocation dto.
     *
     * @param w                 the w
     * @param groundSpeed       the ground speed
     * @param pod               the pod
     * @param trackSpacing      the track spacing
     * @param searchTime        the search time
     * @param effectiveAreaSize the effective area size
     * @param effectiveAreaA    the effective area a
     * @param effectiveAreaB    the effective area b
     * @param effectiveAreaC    the effective area c
     * @param effectiveAreaD    the effective area d
     */
    public EffortAllocationDTO(double w, double groundSpeed, double pod, double trackSpacing, int searchTime,
            double effectiveAreaSize, PositionDTO effectiveAreaA, PositionDTO effectiveAreaB,
            PositionDTO effectiveAreaC, PositionDTO effectiveAreaD) {
        super();
        this.w = w;
        this.groundSpeed = groundSpeed;
        this.pod = pod;
        this.trackSpacing = trackSpacing;
        this.searchTime = searchTime;
        this.effectiveAreaSize = effectiveAreaSize;
        this.effectiveAreaA = effectiveAreaA;
        this.effectiveAreaB = effectiveAreaB;
        this.effectiveAreaC = effectiveAreaC;
        this.effectiveAreaD = effectiveAreaD;
    }

    /**
     * Gets w.
     *
     * @return the w
     */
    public double getW() {
        return w;
    }

    /**
     * Sets w.
     *
     * @param w the w to set
     */
    public void setW(double w) {
        this.w = w;
    }

    /**
     * Gets ground speed.
     *
     * @return the groundSpeed
     */
    public double getGroundSpeed() {
        return groundSpeed;
    }

    /**
     * Sets ground speed.
     *
     * @param groundSpeed the groundSpeed to set
     */
    public void setGroundSpeed(double groundSpeed) {
        this.groundSpeed = groundSpeed;
    }

    /**
     * Gets pod.
     *
     * @return the pod
     */
    public double getPod() {
        return pod;
    }

    /**
     * Sets pod.
     *
     * @param pod the pod to set
     */
    public void setPod(double pod) {
        this.pod = pod;
    }

    /**
     * Gets track spacing.
     *
     * @return the trackSpacing
     */
    public double getTrackSpacing() {
        return trackSpacing;
    }

    /**
     * Sets track spacing.
     *
     * @param trackSpacing the trackSpacing to set
     */
    public void setTrackSpacing(double trackSpacing) {
        this.trackSpacing = trackSpacing;
    }

    /**
     * Gets search time.
     *
     * @return the searchTime
     */
    public int getSearchTime() {
        return searchTime;
    }

    /**
     * Sets search time.
     *
     * @param searchTime the searchTime to set
     */
    public void setSearchTime(int searchTime) {
        this.searchTime = searchTime;
    }

    /**
     * Gets effective area size.
     *
     * @return the effectiveAreaSize
     */
    public double getEffectiveAreaSize() {
        return effectiveAreaSize;
    }

    /**
     * Sets effective area size.
     *
     * @param effectiveAreaSize the effectiveAreaSize to set
     */
    public void setEffectiveAreaSize(double effectiveAreaSize) {
        this.effectiveAreaSize = effectiveAreaSize;
    }

    /**
     * Gets effective area a.
     *
     * @return the effectiveAreaA
     */
    public PositionDTO getEffectiveAreaA() {
        return effectiveAreaA;
    }

    /**
     * Sets effective area a.
     *
     * @param effectiveAreaA the effectiveAreaA to set
     */
    public void setEffectiveAreaA(PositionDTO effectiveAreaA) {
        this.effectiveAreaA = effectiveAreaA;
    }

    /**
     * Gets effective area b.
     *
     * @return the effectiveAreaB
     */
    public PositionDTO getEffectiveAreaB() {
        return effectiveAreaB;
    }

    /**
     * Sets effective area b.
     *
     * @param effectiveAreaB the effectiveAreaB to set
     */
    public void setEffectiveAreaB(PositionDTO effectiveAreaB) {
        this.effectiveAreaB = effectiveAreaB;
    }

    /**
     * Gets effective area c.
     *
     * @return the effectiveAreaC
     */
    public PositionDTO getEffectiveAreaC() {
        return effectiveAreaC;
    }

    /**
     * Sets effective area c.
     *
     * @param effectiveAreaC the effectiveAreaC to set
     */
    public void setEffectiveAreaC(PositionDTO effectiveAreaC) {
        this.effectiveAreaC = effectiveAreaC;
    }

    /**
     * Gets effective area d.
     *
     * @return the effectiveAreaD
     */
    public PositionDTO getEffectiveAreaD() {
        return effectiveAreaD;
    }

    /**
     * Sets effective area d.
     *
     * @param effectiveAreaD the effectiveAreaD to set
     */
    public void setEffectiveAreaD(PositionDTO effectiveAreaD) {
        this.effectiveAreaD = effectiveAreaD;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "EffortAllocationModelData [w=" + w + ", groundSpeed=" + groundSpeed + ", pod=" + pod
                + ", trackSpacing=" + trackSpacing + ", searchTime=" + searchTime + ", effectiveAreaSize="
                + effectiveAreaSize + ", effectiveAreaA=" + effectiveAreaA + ", effectiveAreaB=" + effectiveAreaB
                + ", effectiveAreaC=" + effectiveAreaC + ", effectiveAreaD=" + effectiveAreaD + "]";
    }


}
