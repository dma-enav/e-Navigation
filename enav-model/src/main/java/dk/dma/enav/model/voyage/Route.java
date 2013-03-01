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
package dk.dma.enav.model.voyage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Route implements Iterable<Waypoint>, Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private final ArrayList<Waypoint> waypoints = new ArrayList<>();

    
    public Route(){
        
    }
    
    // private Integer currentWaypoint;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public ArrayList<Waypoint> getWaypoints() {
        return waypoints;
    }

    public int getNumberOfPoints() {
        return waypoints.size();
    }

    @Override
    public Iterator<Waypoint> iterator() {
        return waypoints.iterator();
    }
    
    
}
