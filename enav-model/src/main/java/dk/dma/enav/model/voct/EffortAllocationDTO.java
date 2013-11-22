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
package dk.dma.enav.model.voct;

import java.io.Serializable;

import dk.dma.enav.model.dto.PositionDTO;

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


    public EffortAllocationDTO() {
        super();
    }

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
     * @return the w
     */
    public double getW() {
        return w;
    }

    /**
     * @param w
     *            the w to set
     */
    public void setW(double w) {
        this.w = w;
    }

    /**
     * @return the groundSpeed
     */
    public double getGroundSpeed() {
        return groundSpeed;
    }

    /**
     * @param groundSpeed
     *            the groundSpeed to set
     */
    public void setGroundSpeed(double groundSpeed) {
        this.groundSpeed = groundSpeed;
    }

    /**
     * @return the pod
     */
    public double getPod() {
        return pod;
    }

    /**
     * @param pod
     *            the pod to set
     */
    public void setPod(double pod) {
        this.pod = pod;
    }

    /**
     * @return the trackSpacing
     */
    public double getTrackSpacing() {
        return trackSpacing;
    }

    /**
     * @param trackSpacing
     *            the trackSpacing to set
     */
    public void setTrackSpacing(double trackSpacing) {
        this.trackSpacing = trackSpacing;
    }

    /**
     * @return the searchTime
     */
    public int getSearchTime() {
        return searchTime;
    }

    /**
     * @param searchTime
     *            the searchTime to set
     */
    public void setSearchTime(int searchTime) {
        this.searchTime = searchTime;
    }

    /**
     * @return the effectiveAreaSize
     */
    public double getEffectiveAreaSize() {
        return effectiveAreaSize;
    }

    /**
     * @param effectiveAreaSize
     *            the effectiveAreaSize to set
     */
    public void setEffectiveAreaSize(double effectiveAreaSize) {
        this.effectiveAreaSize = effectiveAreaSize;
    }

    /**
     * @return the effectiveAreaA
     */
    public PositionDTO getEffectiveAreaA() {
        return effectiveAreaA;
    }

    /**
     * @param effectiveAreaA
     *            the effectiveAreaA to set
     */
    public void setEffectiveAreaA(PositionDTO effectiveAreaA) {
        this.effectiveAreaA = effectiveAreaA;
    }

    /**
     * @return the effectiveAreaB
     */
    public PositionDTO getEffectiveAreaB() {
        return effectiveAreaB;
    }

    /**
     * @param effectiveAreaB
     *            the effectiveAreaB to set
     */
    public void setEffectiveAreaB(PositionDTO effectiveAreaB) {
        this.effectiveAreaB = effectiveAreaB;
    }

    /**
     * @return the effectiveAreaC
     */
    public PositionDTO getEffectiveAreaC() {
        return effectiveAreaC;
    }

    /**
     * @param effectiveAreaC
     *            the effectiveAreaC to set
     */
    public void setEffectiveAreaC(PositionDTO effectiveAreaC) {
        this.effectiveAreaC = effectiveAreaC;
    }

    /**
     * @return the effectiveAreaD
     */
    public PositionDTO getEffectiveAreaD() {
        return effectiveAreaD;
    }

    /**
     * @param effectiveAreaD
     *            the effectiveAreaD to set
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
