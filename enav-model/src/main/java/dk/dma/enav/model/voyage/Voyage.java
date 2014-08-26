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

public class Voyage implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** The currently active route. */
    ActiveRoute activeRoute;

    Endpoint from;

    Route plannedRoute;

    Endpoint to;

    public ActiveRoute getActiveRoute() {
        return activeRoute;
    }

    public Endpoint getFrom() {
        return from;
    }

    public Route getPlannedRoute() {
        return plannedRoute;
    }

    public Endpoint getTo() {
        return to;
    }

    public void setActiveRoute(ActiveRoute activeRoute) {
        this.activeRoute = activeRoute;
    }

    public void setFrom(Endpoint from) {
        this.from = from;
    }

    public void setPlannedRoute(Route plannedRoute) {
        this.plannedRoute = plannedRoute;
    }

    public void setTo(Endpoint to) {
        this.to = to;
    }
}
