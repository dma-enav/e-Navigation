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
import java.util.Date;

import dk.dma.enav.model.dto.PositionDTO;




public class SARModelDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    String sarID;
    private Date LKPDate;
    private Date CSSDate;

    
    private PositionDTO LKP;
    private PositionDTO CSP;
    
//    private double LKPLat;
//    private double LKPLon;
    
//    private double CSPLat;
//    private double CSPLon;
    
    private double x;
    private double y;
    private double safetyFactor;
    
    private int searchObject;

    public SARModelDTO(){
        super();
    }
    
    public SARModelDTO(String sarID, Date lKPDate, Date cSSDate, PositionDTO lKP,
            PositionDTO cSP, double x, double y, double safetyFactor,
            int searchObject) {
        super();
        this.sarID = sarID;
        LKPDate = lKPDate;
        CSSDate = cSSDate;
        LKP = lKP;
        CSP = cSP;
        this.x = x;
        this.y = y;
        this.safetyFactor = safetyFactor;
        this.searchObject = searchObject;
    }

    /**
     * @return the sarID
     */
    public String getSarID() {
        return sarID;
    }

    /**
     * @param sarID the sarID to set
     */
    public void setSarID(String sarID) {
        this.sarID = sarID;
    }

    /**
     * @return the lKPDate
     */
    public Date getLKPDate() {
        return LKPDate;
    }

    /**
     * @param lKPDate the lKPDate to set
     */
    public void setLKPDate(Date lKPDate) {
        LKPDate = lKPDate;
    }

    /**
     * @return the cSSDate
     */
    public Date getCSSDate() {
        return CSSDate;
    }

    /**
     * @param cSSDate the cSSDate to set
     */
    public void setCSSDate(Date cSSDate) {
        CSSDate = cSSDate;
    }

    /**
     * @return the lKP
     */
    public PositionDTO getLKP() {
        return LKP;
    }

    /**
     * @param lKP the lKP to set
     */
    public void setLKP(PositionDTO lKP) {
        LKP = lKP;
    }

    /**
     * @return the cSP
     */
    public PositionDTO getCSP() {
        return CSP;
    }

    /**
     * @param cSP the cSP to set
     */
    public void setCSP(PositionDTO cSP) {
        CSP = cSP;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the safetyFactor
     */
    public double getSafetyFactor() {
        return safetyFactor;
    }

    /**
     * @param safetyFactor the safetyFactor to set
     */
    public void setSafetyFactor(double safetyFactor) {
        this.safetyFactor = safetyFactor;
    }

    /**
     * @return the searchObject
     */
    public int getSearchObject() {
        return searchObject;
    }

    /**
     * @param searchObject the searchObject to set
     */
    public void setSearchObject(int searchObject) {
        this.searchObject = searchObject;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SARModelData [sarID=" + sarID + ", LKPDate=" + LKPDate
                + ", CSSDate=" + CSSDate + ", LKP=" + LKP + ", CSP=" + CSP
                + ", x=" + x + ", y=" + y + ", safetyFactor=" + safetyFactor
                + ", searchObject=" + searchObject + "]";
    }
    
    
    

    
}

