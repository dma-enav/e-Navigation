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


import java.util.Date;
import java.util.List;

import dk.dma.enav.model.dto.PositionDTO;


public class RapidResponseDTO extends SARModelDTO
{

    private static final long serialVersionUID = 1L;
    private List<PositionDTO> currentList;
    private List<PositionDTO> windList;
    
    private PositionDTO datum;

    private double radius;

    private double timeElasped;

    private double rdvDirection;
    private double rdvDistance;
    private double rdvSpeed;
    
    private double rdvDirectionLast;
    private double rdvSpeedLast;

    private PositionDTO A;
    private PositionDTO B;
    private PositionDTO C;
    private PositionDTO D;
    
    
    public RapidResponseDTO(){
        super();
    }
            
   
    
    
    public RapidResponseDTO(String sarID, Date lKPDate, Date cSSDate,
            PositionDTO lKP, PositionDTO cSP, double x, double y,
            double safetyFactor, int searchObject, List<PositionDTO> currentList,
            List<PositionDTO> windList, PositionDTO datum, double radius,
            double timeElasped, double rdvDirection, double rdvDistance,
            double rdvSpeed, double rdvDirectionLast, double rdvSpeedLast,
            PositionDTO a, PositionDTO b, PositionDTO c, PositionDTO d) {
        super(sarID, lKPDate, cSSDate, lKP, cSP, x, y, safetyFactor,
                searchObject);
        this.currentList = currentList;
        this.windList = windList;
        this.datum = datum;
        this.radius = radius;
        this.timeElasped = timeElasped;
        this.rdvDirection = rdvDirection;
        this.rdvDistance = rdvDistance;
        this.rdvSpeed = rdvSpeed;
        this.rdvDirectionLast = rdvDirectionLast;
        this.rdvSpeedLast = rdvSpeedLast;
        A = a;
        B = b;
        C = c;
        D = d;
    }
    
    /**
     * @return the currentList
     */
    public List<PositionDTO> getCurrentList() {
        return currentList;
    }
    /**
     * @param currentList the currentList to set
     */
    public void setCurrentList(List<PositionDTO> currentList) {
        this.currentList = currentList;
    }
    /**
     * @return the windList
     */
    public List<PositionDTO> getWindList() {
        return windList;
    }
    /**
     * @param windList the windList to set
     */
    public void setWindList(List<PositionDTO> windList) {
        this.windList = windList;
    }
    /**
     * @return the datum
     */
    public PositionDTO getDatum() {
        return datum;
    }
    /**
     * @param datum the datum to set
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
     * @param radius the radius to set
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
     * @param timeElasped the timeElasped to set
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
     * @param rdvDirection the rdvDirection to set
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
     * @param rdvDistance the rdvDistance to set
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
     * @param rdvSpeed the rdvSpeed to set
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
     * @param rdvDirectionLast the rdvDirectionLast to set
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
     * @param rdvSpeedLast the rdvSpeedLast to set
     */
    public void setRdvSpeedLast(double rdvSpeedLast) {
        this.rdvSpeedLast = rdvSpeedLast;
    }
    /**
     * @return the a
     */
    public PositionDTO getA() {
        return A;
    }
    /**
     * @param a the a to set
     */
    public void setA(PositionDTO a) {
        A = a;
    }
    /**
     * @return the b
     */
    public PositionDTO getB() {
        return B;
    }
    /**
     * @param b the b to set
     */
    public void setB(PositionDTO b) {
        B = b;
    }
    /**
     * @return the c
     */
    public PositionDTO getC() {
        return C;
    }
    /**
     * @param c the c to set
     */
    public void setC(PositionDTO c) {
        C = c;
    }
    /**
     * @return the d
     */
    public PositionDTO getD() {
        return D;
    }
    /**
     * @param d the d to set
     */
    public void setD(PositionDTO d) {
        D = d;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "RapidResponseModelData [currentList=" + currentList
                + ", windList=" + windList + ", datum=" + datum + ", radius="
                + radius + ", timeElasped=" + timeElasped + ", rdvDirection="
                + rdvDirection + ", rdvDistance=" + rdvDistance + ", rdvSpeed="
                + rdvSpeed + ", rdvDirectionLast=" + rdvDirectionLast
                + ", rdvSpeedLast=" + rdvSpeedLast + ", A=" + A + ", B=" + B
                + ", C=" + C + ", D=" + D + ", sarID=" + sarID
                + ", getSarID()=" + getSarID() + ", getLKPDate()="
                + getLKPDate() + ", getCSSDate()=" + getCSSDate()
                + ", getLKP()=" + getLKP() + ", getCSP()=" + getCSP()
                + ", getX()=" + getX() + ", getY()=" + getY()
                + ", getSafetyFactor()=" + getSafetyFactor()
                + ", getSearchObject()=" + getSearchObject() + ", toString()="
                + super.toString() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + "]";
    }


    
    
    
    
    
}

