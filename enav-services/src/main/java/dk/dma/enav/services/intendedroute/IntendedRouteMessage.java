package dk.dma.enav.services.intendedroute;

import dk.dma.enav.model.voyage.Route;
import dk.dma.enav.services.navigationalstatus.CurrentPositionReportMessage;

public class IntendedRouteMessage extends CurrentPositionReportMessage {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	Route route;

	int activeWaypoint;
}
