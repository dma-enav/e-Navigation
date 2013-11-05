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
package dk.dma.enav.serialization;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import dk.dma.enav.model.voyage.Route;
import dk.dma.enav.model.voyage.RouteLeg.Heading;
import dk.dma.enav.model.voyage.Waypoint;

/**
 * 
 * @author Jesper Tejlgaard
 */
public class Rt3RouteParserTest {

    @Test
    public void testParseValidStream() throws IOException {
        // SETUP DATA
        InputStream is = getClass().getResourceAsStream("/routes/Malmoe - Karlshavn.rt3");
        RouteParser parser = new Rt3RouteParser(is);

        // EXECUTE
        Route r = parser.parse();

        // TEST ASSERTIONS
        Assert.assertEquals("Malmoe - Karlshavn", r.getName());
        Assert.assertEquals(14, r.getWaypoints().size());

        // TEST FIRST WAYPOINT
        Waypoint waypoint = r.getWaypoints().get(0);
        Assert.assertEquals("WP_001", waypoint.getName());
        // Assert.assertEquals("55 42.510N", Position.create(waypoint.getLatitude(), 0).getLatitudeAsString());
        // Assert.assertEquals("012 36.724E", Position.create(0, waypoint.getLongitude()).getLongitudeAsString());
        Assert.assertEquals(0.300000011920929, waypoint.getTurnRad(), 0.0);
        Assert.assertEquals(10.00, waypoint.getRouteLeg().getSpeed(), 0.0);
        Assert.assertEquals(Heading.RL, waypoint.getRouteLeg().getHeading());
        Assert.assertEquals(0.100000001490116, waypoint.getRouteLeg().getXtdPort(), 0.0);
        Assert.assertEquals(0.100000001490116, waypoint.getRouteLeg().getXtdStarboard(), 0.0);

        // Checking second waypoint
        waypoint = r.getWaypoints().get(1);
        Assert.assertEquals("WP_002", waypoint.getName());
        // Assert.assertEquals("55 45.920N", Position.create(waypoint.getLatitude(), 0).getLatitudeAsString());
        // Assert.assertEquals("012 40.554E", Position.create(0, waypoint.getLongitude()).getLongitudeAsString());
        Assert.assertEquals(0.300000011920929, waypoint.getTurnRad(), 0.0);
        Assert.assertEquals(10.00, waypoint.getRouteLeg().getSpeed(), 0.0);
        Assert.assertEquals(Heading.RL, waypoint.getRouteLeg().getHeading());
        Assert.assertEquals(0.100000001490116, waypoint.getRouteLeg().getXtdPort(), 0.0);
        Assert.assertEquals(0.100000001490116, waypoint.getRouteLeg().getXtdStarboard(), 0.0);

        // Checking last waypoint
        waypoint = r.getWaypoints().get(r.getWaypoints().size() - 1);
        Assert.assertEquals("WP_014", waypoint.getName());
        // Assert.assertEquals("56 09.755N", Position.create(waypoint.getLatitude(), 0).getLatitudeAsString());
        // Assert.assertEquals("010 14.404E", Position.create(0, waypoint.getLongitude()).getLongitudeAsString());
        Assert.assertEquals(0.300000011920929, waypoint.getTurnRad(), 0.0);
        Assert.assertEquals(10.00, waypoint.getRouteLeg().getSpeed(), 0.0);
        Assert.assertEquals(Heading.RL, waypoint.getRouteLeg().getHeading());
        Assert.assertEquals(0.100000001490116, waypoint.getRouteLeg().getXtdPort(), 0.0);
        Assert.assertEquals(0.100000001490116, waypoint.getRouteLeg().getXtdStarboard(), 0.0);
    }

    @Test
    public void testParseWithNames() throws IOException {
        // SETUP DATA
        InputStream is = getClass().getResourceAsStream("/routes/Nuuk-Paamiut 008.rt3");
        RouteParser parser = new Rt3RouteParser(is);

        // EXECUTE
        Route r = parser.parse();
        
        // TEST ASSERTIONS
        Assert.assertEquals("Nuuk-Paamiut 008", r.getName());
        Assert.assertEquals(20, r.getWaypoints().size());

        // TEST FIRST WAYPOINT
        Waypoint waypoint = r.getWaypoints().get(0);
        Assert.assertEquals("Nuuk Havn", waypoint.getName());
        // Assert.assertEquals("55 42.510N", Position.create(waypoint.getLatitude(), 0).getLatitudeAsString());
        // Assert.assertEquals("012 36.724E", Position.create(0, waypoint.getLongitude()).getLongitudeAsString());
        Assert.assertEquals(0.0, waypoint.getTurnRad(), 0.0);
        Assert.assertEquals(10.00, waypoint.getRouteLeg().getSpeed(), 0.0);
        Assert.assertEquals(Heading.RL, waypoint.getRouteLeg().getHeading());
        Assert.assertEquals(0.100000, waypoint.getRouteLeg().getXtdPort(), 0.0);
        Assert.assertEquals(0.100000, waypoint.getRouteLeg().getXtdStarboard(), 0.0);

        // TEST SECOND WAYPOINT
        waypoint = r.getWaypoints().get(1);
        Assert.assertEquals("Anduvning Nuuk", waypoint.getName());
        // Assert.assertEquals("55 42.510N", Position.create(waypoint.getLatitude(), 0).getLatitudeAsString());
        // Assert.assertEquals("012 36.724E", Position.create(0, waypoint.getLongitude()).getLongitudeAsString());
        Assert.assertEquals(0.0, waypoint.getTurnRad(), 0.0);
        Assert.assertEquals(10.00, waypoint.getRouteLeg().getSpeed(), 0.0);
        Assert.assertEquals(Heading.RL, waypoint.getRouteLeg().getHeading());
        Assert.assertEquals(0.100000, waypoint.getRouteLeg().getXtdPort(), 0.0);
        Assert.assertEquals(0.100000, waypoint.getRouteLeg().getXtdStarboard(), 0.0);

        // TEST SIXTH WAYPOINT (without name)
        waypoint = r.getWaypoints().get(5);
        Assert.assertEquals("WP_006", waypoint.getName());
        // Assert.assertEquals("55 42.510N", Position.create(waypoint.getLatitude(), 0).getLatitudeAsString());
        // Assert.assertEquals("012 36.724E", Position.create(0, waypoint.getLongitude()).getLongitudeAsString());
        Assert.assertEquals(0.0, waypoint.getTurnRad(), 0.0);
        Assert.assertEquals(10.00, waypoint.getRouteLeg().getSpeed(), 0.0);
        Assert.assertEquals(Heading.RL, waypoint.getRouteLeg().getHeading());
        Assert.assertEquals(0.100000, waypoint.getRouteLeg().getXtdPort(), 0.0);
        Assert.assertEquals(0.100000, waypoint.getRouteLeg().getXtdStarboard(), 0.0);

        // TEST LAST WAYPOINT 
        waypoint = r.getWaypoints().get(r.getWaypoints().size() - 1);
        Assert.assertEquals("Paamiut havn", waypoint.getName());
        // Assert.assertEquals("55 42.510N", Position.create(waypoint.getLatitude(), 0).getLatitudeAsString());
        // Assert.assertEquals("012 36.724E", Position.create(0, waypoint.getLongitude()).getLongitudeAsString());
        Assert.assertEquals(0.0, waypoint.getTurnRad(), 0.0);
        Assert.assertEquals(10.00, waypoint.getRouteLeg().getSpeed(), 0.0);
        Assert.assertEquals(Heading.RL, waypoint.getRouteLeg().getHeading());
        Assert.assertEquals(0.100000, waypoint.getRouteLeg().getXtdPort(), 0.0);
        Assert.assertEquals(0.100000, waypoint.getRouteLeg().getXtdStarboard(), 0.0);
    }

}
