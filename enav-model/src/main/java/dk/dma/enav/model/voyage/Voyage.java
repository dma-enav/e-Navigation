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
