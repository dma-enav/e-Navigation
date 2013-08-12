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

import dk.dma.enav.model.MaritimeId;

public class Route implements Iterable<Waypoint>, Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    private final ArrayList<Waypoint> waypoints = new ArrayList<>();
    private String name;
    private String destination;
    private String departure;
    
    /** Should this be implemented as a {@link MaritimeId} ? */
    private String id;

    public Route(){
    }

    public Route(String id){
        this.id = id;
    }
    
    /**
     * Constructor generating an id
     * 
     * @param name
     * @param departure
     * @param destination
     */
    public Route(String name, String departure, String destination) {
        super();
        // TODO generate id
        this.name = name;
        this.destination = destination;
        this.departure = departure;
    }

    public Route(String id, String name, String departure, String destination) {
        super();
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.departure = departure;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Waypoint> getWaypoints() {
        return waypoints;
    }

    @Override
    public Iterator<Waypoint> iterator() {
        return waypoints.iterator();
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Route [waypoints=" + waypoints + ", id=" + id + ", name=" + name + ", destination=" + destination + ", departure="
                + departure + "]";
    }
    
}
