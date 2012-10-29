package dk.dma.enav.services.routesuggestion;

import dk.dma.enav.messages.MaritimeMessage;
import dk.dma.enav.model.shore.MaritimeAuthorityId;
import dk.dma.enav.model.voyage.Route;

public class RouteSuggestionMessage extends MaritimeMessage {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    String routeSuggestionId;

    // Who suggested the route
    MaritimeAuthorityId authorityId;

    // Why should I take this route
    String message;

    // The route that is suggested
    Route route;

}
