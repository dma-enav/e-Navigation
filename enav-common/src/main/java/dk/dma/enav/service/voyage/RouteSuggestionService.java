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
package dk.dma.enav.service.voyage;

import dk.dma.enav.maritimecloud.service.spi.Service;
import dk.dma.enav.maritimecloud.service.spi.ServiceInitiationPoint;
import dk.dma.enav.maritimecloud.service.spi.ServiceMessage;
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
