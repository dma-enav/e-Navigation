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
import java.util.Date;
import java.util.List;

import dk.dma.enav.model.dto.PositionDTO;


/**
 * The type Sar model dto.
 */
public class SARModelDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     * The Sar id.
     */
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
    
    private List<WeatherDataDTO> weatherData;

    /**
     * Instantiates a new Sar model dto.
     */
    public SARModelDTO(){
        super();
    }

    /**
     * Instantiates a new Sar model dto.
     *
     * @param sarID        the sar id
     * @param lKPDate      the l kp date
     * @param cSSDate      the c ss date
     * @param lKP          the l kp
     * @param cSP          the c sp
     * @param x            the x
     * @param y            the y
     * @param safetyFactor the safety factor
     * @param searchObject the search object
     * @param weatherData  the weather data
     */
    public SARModelDTO(String sarID, Date lKPDate, Date cSSDate, PositionDTO lKP,
            PositionDTO cSP, double x, double y, double safetyFactor,
            int searchObject, List<WeatherDataDTO> weatherData) {
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
        this.weatherData = weatherData;
    }

    /**
     * Gets sar id.
     *
     * @return the sarID
     */
    public String getSarID() {
        return sarID;
    }

    /**
     * Sets sar id.
     *
     * @param sarID the sarID to set
     */
    public void setSarID(String sarID) {
        this.sarID = sarID;
    }

    /**
     * Gets lkp date.
     *
     * @return the lKPDate
     */
    public Date getLKPDate() {
        return LKPDate;
    }

    /**
     * Sets lkp date.
     *
     * @param lKPDate the lKPDate to set
     */
    public void setLKPDate(Date lKPDate) {
        LKPDate = lKPDate;
    }

    /**
     * Gets css date.
     *
     * @return the cSSDate
     */
    public Date getCSSDate() {
        return CSSDate;
    }

    /**
     * Sets css date.
     *
     * @param cSSDate the cSSDate to set
     */
    public void setCSSDate(Date cSSDate) {
        CSSDate = cSSDate;
    }

    /**
     * Gets lkp.
     *
     * @return the lKP
     */
    public PositionDTO getLKP() {
        return LKP;
    }

    /**
     * Sets lkp.
     *
     * @param lKP the lKP to set
     */
    public void setLKP(PositionDTO lKP) {
        LKP = lKP;
    }

    /**
     * Gets csp.
     *
     * @return the cSP
     */
    public PositionDTO getCSP() {
        return CSP;
    }

    /**
     * Sets csp.
     *
     * @param cSP the cSP to set
     */
    public void setCSP(PositionDTO cSP) {
        CSP = cSP;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Gets safety factor.
     *
     * @return the safetyFactor
     */
    public double getSafetyFactor() {
        return safetyFactor;
    }

    /**
     * Sets safety factor.
     *
     * @param safetyFactor the safetyFactor to set
     */
    public void setSafetyFactor(double safetyFactor) {
        this.safetyFactor = safetyFactor;
    }

    /**
     * Gets search object.
     *
     * @return the searchObject
     */
    public int getSearchObject() {
        return searchObject;
    }

    /**
     * Sets search object.
     *
     * @param searchObject the searchObject to set
     */
    public void setSearchObject(int searchObject) {
        this.searchObject = searchObject;
    }

    /**
     * Gets weather data.
     *
     * @return the weatherData
     */
    public List<WeatherDataDTO> getWeatherData() {
        return weatherData;
    }

    /**
     * Sets weather data.
     *
     * @param weatherData the weatherData to set
     */
    public void setWeatherData(List<WeatherDataDTO> weatherData) {
        this.weatherData = weatherData;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SARModelDTO [sarID=" + sarID + ", LKPDate=" + LKPDate
                + ", CSSDate=" + CSSDate + ", LKP=" + LKP + ", CSP=" + CSP
                + ", x=" + x + ", y=" + y + ", safetyFactor=" + safetyFactor
                + ", searchObject=" + searchObject + ", weatherData="
                + weatherData + "]";
    }


    

    
}

