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
package dk.dma.enav.model.ship;

import dk.dma.enav.model.MaritimePeer;
import dk.dma.enav.model.geometry.Position;
import dk.dma.enav.model.voyage.Voyage;

/**
 * The type Ship.
 */
public class Ship extends MaritimePeer {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private Voyage current;

    private ShipId id;

    private Position latest;

    /**
     * Gets current.
     *
     * @return the current
     */
    public Voyage getCurrent() {
        return current;
    }

    public ShipId getId() {
        return id;
    }

    /**
     * Gets latest.
     *
     * @return the latest
     */
    public Position getLatest() {
        return latest;
    }

    /**
     * Sets current.
     *
     * @param current the current
     */
    public void setCurrent(Voyage current) {
        this.current = current;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(ShipId id) {
        this.id = id;
    }

    /**
     * Sets latest.
     *
     * @param latest the latest
     */
    public void setLatest(Position latest) {
        this.latest = latest;
    }
}
