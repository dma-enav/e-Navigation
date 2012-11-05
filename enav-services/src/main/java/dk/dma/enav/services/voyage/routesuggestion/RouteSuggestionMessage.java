package dk.dma.enav.services.voyage.routesuggestion;

import dk.dma.enav.model.shore.MaritimeAuthorityId;
import dk.dma.enav.model.voyage.Route;
import dk.dma.enav.services.ServiceMessage;

public class RouteSuggestionMessage extends ServiceMessage {

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
