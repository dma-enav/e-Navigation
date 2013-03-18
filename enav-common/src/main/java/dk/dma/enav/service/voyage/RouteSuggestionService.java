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

import dk.dma.enav.communication.service.spi.Service;
import dk.dma.enav.communication.service.spi.ServiceMessage;
import dk.dma.enav.communication.service.spi.ServiceInitiationPoint;
import dk.dma.enav.model.voyage.Route;

/**
 * Utility classes used across multiple packages.
 * 
 * <img src="dk.dma.enav.model.geometry.png" height="900" width="1200"/>
 **/
public class RouteSuggestionService extends Service {

    /** An initiation point */
    public static final ServiceInitiationPoint<RequestSuggestion> SHIP_REQUESTS_ROUTE = new ServiceInitiationPoint<>(
            RequestSuggestion.class);

    public static final ServiceInitiationPoint<SuggestRoute> SHORES_SUGGESTS_ROUTE = new ServiceInitiationPoint<>(
            SuggestRoute.class);

    public static class RequestSuggestion extends ServiceMessage<SuggestRoute> {}

    public static class RouteAcceptance extends ServiceMessage<Void> {
        RouteSuggestionAcceptance result;
    }

    public enum RouteSuggestionAcceptance {
        NOT_A_CHANCE, OK_I_WILL_TAKE_IT;
    }

    public static class SuggestRoute extends ServiceMessage<RouteAcceptance> {

        /** An optional message for the suggestion */
        private String message;

        /** The suggested route. */
        private Route route;

        /**
         * @return the message
         */
        public String getMessage() {
            return message;
        }

        /**
         * @return the route
         */
        public Route getRoute() {
            return route;
        }

        /**
         * @param message
         *            the message to set
         */
        public void setMessage(String message) {
            this.message = message;
        }

        /**
         * @param route
         *            the route to set
         */
        public void setRoute(Route route) {
            this.route = route;
        }
    }
}
