package dk.dma.enav.services.voyage.routesuggestion;

import dk.dma.enav.messaging.MaritimeMessage;
import dk.dma.enav.model.shore.MaritimeAuthorityId;
import dk.dma.enav.model.voyage.Route;

public class RouteSuggestionMessage extends MaritimeMessage {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    // Who suggested the route
    MaritimeAuthorityId authorityId;

    // Why should I take this route
    String message;

    // The route that is suggested
    Route route;

    String routeSuggestionId;

}
