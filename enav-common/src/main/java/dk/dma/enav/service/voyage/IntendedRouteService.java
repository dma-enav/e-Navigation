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
package dk.dma.enav.service.voyage;

import dk.dma.enav.model.voyage.Route;

/**
 * 
 * @author Kasper Nielsen
 */
public class IntendedRouteService {

    public static class IntendedRouteMessage extends CurrentPositionService.CurrentPositionReportMessage {

        private Route route;

        private int activeWaypoint;

        public IntendedRouteMessage() {

        }

        public Route getRoute() {
            return route;
        }

        public void setRoute(Route route) {
            this.route = route;
        }

        public int getActiveWaypoint() {
            return activeWaypoint;
        }

        public void setActiveWaypoint(int activeWaypoint) {
            this.activeWaypoint = activeWaypoint;
        }

    }
}
