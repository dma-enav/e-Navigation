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

    public RouteSuggestionService() {
        super("imo.voyage.routesuggestion");
    }

    public static class RequestSuggestion extends MaritimeServiceMessage<SuggestRoute> implements InitiatingMessage {
        /** serialVersionUID. */
        private static final long serialVersionUID = 1L;
    }

    public static class RouteAcceptance extends MaritimeServiceMessage<Void> {
        /** serialVersionUID. */
        private static final long serialVersionUID = 1L;

        RouteSuggestionAcceptance result;
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
    }

}
