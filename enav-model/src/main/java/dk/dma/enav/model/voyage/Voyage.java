package dk.dma.enav.model.voyage;

import java.io.Serializable;

import dk.dma.enav.model.voyage.endpoint.Endpoint;

public class Voyage implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    Endpoint from;

    Endpoint to;

    ActiveRoute activeRoute;

    Route plannedRoute;

    public Endpoint getFrom() {
        return from;
    }

    public void setFrom(Endpoint from) {
        this.from = from;
    }

    public Endpoint getTo() {
        return to;
    }

    public void setTo(Endpoint to) {
        this.to = to;
    }

    public ActiveRoute getActiveRoute() {
        return activeRoute;
    }

    public void setActiveRoute(ActiveRoute activeRoute) {
        this.activeRoute = activeRoute;
    }

    public Route getPlannedRoute() {
        return plannedRoute;
    }

    public void setPlannedRoute(Route plannedRoute) {
        this.plannedRoute = plannedRoute;
    }
}
