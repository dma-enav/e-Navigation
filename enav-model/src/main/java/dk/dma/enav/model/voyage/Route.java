/* Copyright (c) 2011 Danish Maritime Authority.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
