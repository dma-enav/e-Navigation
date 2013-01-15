package dk.dma.enav.service.voyage.intendedroute;

import dk.dma.enav.model.voyage.Route;
import dk.dma.enav.service.voyage.navigationalstatus.CurrentPositionReportMessage;

public class IntendedRouteMessage extends CurrentPositionReportMessage {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

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
