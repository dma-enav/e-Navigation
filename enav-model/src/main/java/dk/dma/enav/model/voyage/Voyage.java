package dk.dma.enav.model.voyage;

import java.io.Serializable;

import dk.dma.enav.model.voyage.endpoint.Endpoint;

public class Voyage implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

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
