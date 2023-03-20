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

import dk.dma.enav.model.voyage.endpoint.Endpoint;

/**
 * The type Voyage.
 */
public class Voyage implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * The currently active route.
     */
    ActiveRoute activeRoute;

    /**
     * The From.
     */
    Endpoint from;

    /**
     * The Planned route.
     */
    Route plannedRoute;

    /**
     * The To.
     */
    Endpoint to;

    /**
     * Gets active route.
     *
     * @return the active route
     */
    public ActiveRoute getActiveRoute() {
        return activeRoute;
    }

    /**
     * Gets from.
     *
     * @return the from
     */
    public Endpoint getFrom() {
        return from;
    }

    /**
     * Gets planned route.
     *
     * @return the planned route
     */
    public Route getPlannedRoute() {
        return plannedRoute;
    }

    /**
     * Gets to.
     *
     * @return the to
     */
    public Endpoint getTo() {
        return to;
    }

    /**
     * Sets active route.
     *
     * @param activeRoute the active route
     */
    public void setActiveRoute(ActiveRoute activeRoute) {
        this.activeRoute = activeRoute;
    }

    /**
     * Sets from.
     *
     * @param from the from
     */
    public void setFrom(Endpoint from) {
        this.from = from;
    }

    /**
     * Sets planned route.
     *
     * @param plannedRoute the planned route
     */
    public void setPlannedRoute(Route plannedRoute) {
        this.plannedRoute = plannedRoute;
    }

    /**
     * Sets to.
     *
     * @param to the to
     */
    public void setTo(Endpoint to) {
        this.to = to;
    }
}
