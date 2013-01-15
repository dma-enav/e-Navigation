/*
 * Copyright (c) 2008 Kasper Nielsen.
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

import dk.dma.enav.model.shore.MaritimeAuthorityId;
import dk.dma.enav.model.voyage.Route;
import dk.dma.enav.service.spi.InitiatingMessage;
import dk.dma.enav.service.spi.MaritimeService;
import dk.dma.enav.service.spi.MaritimeServiceMessage;

/**
 * Utility classes used across multiple packages.
 * 
 * <img src="dk.dma.enav.model.geometry.png" height="900" width="1200"/>
 **/
public class RouteSuggestionService extends MaritimeService {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    public RouteSuggestionService() {
        super("imo.voyage.routesuggestion");
    }

    public static class RequestSuggestion extends MaritimeServiceMessage<SuggestRoute> implements InitiatingMessage {
        /** serialVersionUID. */
        private static final long serialVersionUID = 1L;

        /**
         * @param serviceType
         */
        public RequestSuggestion() {
            super(RouteSuggestionService.class);
        }
    }

    public static class RouteAcceptance extends MaritimeServiceMessage<Void> {
        /** serialVersionUID. */
        private static final long serialVersionUID = 1L;

        RouteSuggestionAcceptance result;

        /**
         * @param serviceType
         */
        public RouteAcceptance() {
            super(RouteSuggestionService.class);
        }
    }

    public enum RouteSuggestionAcceptance {
        NOT_A_CHANCE, OK_I_WILL_TAKE_IT;
    }

    public static class SuggestRoute extends MaritimeServiceMessage<RouteAcceptance> implements InitiatingMessage {
        /** serialVersionUID. */
        private static final long serialVersionUID = 1L;

        // Who suggested the route
        MaritimeAuthorityId authorityId;

        // Why should I take this route
        String message;

        // The route that is suggested
        Route route;

        /**
         * @param serviceType
         */
        public SuggestRoute() {
            super(RouteSuggestionService.class);
        }
    }

}
