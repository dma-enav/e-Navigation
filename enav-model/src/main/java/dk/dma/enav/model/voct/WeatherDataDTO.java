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

/**
 * The type Weather data dto.
 */
public class WeatherDataDTO implements Serializable {

  
    private static final long serialVersionUID = 1L;
    private double TWCHeading;
    private double TWCknots;

    private double LWknots;
    private double LWHeading;
    private double downWind;
    private Date date;

    /**
     * Instantiates a new Weather data dto.
     */
    public WeatherDataDTO(){
        
    }

    /**
     * Instantiates a new Weather data dto.
     *
     * @param tWCHeading the t wc heading
     * @param tWCknots   the t w cknots
     * @param lWknots    the l wknots
     * @param lWHeading  the l w heading
     * @param downWind   the down wind
     * @param date       the date
     */
    public WeatherDataDTO(double tWCHeading, double tWCknots, double lWknots,
            double lWHeading, double downWind, Date date) {
        super();
        TWCHeading = tWCHeading;
        TWCknots = tWCknots;
        LWknots = lWknots;
        LWHeading = lWHeading;
        this.downWind = downWind;
        this.date = date;
    }

    /**
     * Gets twc heading.
     *
     * @return the tWCHeading
     */
    public double getTWCHeading() {
        return TWCHeading;
    }

    /**
     * Sets twc heading.
     *
     * @param tWCHeading the tWCHeading to set
     */
    public void setTWCHeading(double tWCHeading) {
        TWCHeading = tWCHeading;
    }

    /**
     * Gets tw cknots.
     *
     * @return the tWCknots
     */
    public double getTWCknots() {
        return TWCknots;
    }

    /**
     * Sets tw cknots.
     *
     * @param tWCknots the tWCknots to set
     */
    public void setTWCknots(double tWCknots) {
        TWCknots = tWCknots;
    }

    /**
     * Gets l wknots.
     *
     * @return the lWknots
     */
    public double getLWknots() {
        return LWknots;
    }

    /**
     * Sets l wknots.
     *
     * @param lWknots the lWknots to set
     */
    public void setLWknots(double lWknots) {
        LWknots = lWknots;
    }

    /**
     * Gets lw heading.
     *
     * @return the lWHeading
     */
    public double getLWHeading() {
        return LWHeading;
    }

    /**
     * Sets lw heading.
     *
     * @param lWHeading the lWHeading to set
     */
    public void setLWHeading(double lWHeading) {
        LWHeading = lWHeading;
    }

    /**
     * Gets down wind.
     *
     * @return the downWind
     */
    public double getDownWind() {
        return downWind;
    }

    /**
     * Sets down wind.
     *
     * @param downWind the downWind to set
     */
    public void setDownWind(double downWind) {
        this.downWind = downWind;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "WeatherDataDTO [TWCHeading=" + TWCHeading + ", TWCknots="
                + TWCknots + ", LWknots=" + LWknots + ", LWHeading="
                + LWHeading + ", downWind=" + downWind + ", date=" + date + "]";
    }
    
    
    
}
