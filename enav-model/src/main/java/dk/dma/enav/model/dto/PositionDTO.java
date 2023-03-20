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
package dk.dma.enav.model.dto;

import java.io.Serializable;

/**
 * The type Position dto.
 */
public class PositionDTO implements Serializable{


    private static final long serialVersionUID = 1L;


    /**
     * The Latitude.
     */
    double latitude;
    /**
     * The Longitude.
     */
    double longitude;


    /**
     * Instantiates a new Position dto.
     */
    public PositionDTO(){
        super();
    }

    /**
     * Instantiates a new Position dto.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     */
    public PositionDTO(double latitude, double longitude) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets latitude.
     *
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets longitude.
     *
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets longitude.
     *
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PositionDTO [latitude=" + latitude + ", longitude=" + longitude
                + "]";
    }

 
    
    
}

