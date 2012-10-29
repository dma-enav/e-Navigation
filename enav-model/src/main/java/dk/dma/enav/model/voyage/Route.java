package dk.dma.enav.model.voyage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Route implements Iterable<Waypoint>, Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    private final ArrayList<Waypoint> waypoints = new ArrayList<>();

    // private Integer currentWaypoint;

    public int getNumberOfPoints() {
        return waypoints.size();
    }

    @Override
    public Iterator<Waypoint> iterator() {
        return waypoints.iterator();
    }
}
