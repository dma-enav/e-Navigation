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

package dk.dma.enav.model.geometry;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EllipseTest {

    @Test
    public void testIntersectsSame() {
        Ellipse ellipse1 = new Ellipse(null, 0.0f, 0.0f, 5.0, 2.5f, 0.0f, CoordinateSystem.CARTESIAN);
        Ellipse ellipse2 = ellipse1;

        assertTrue(ellipse1.intersects(ellipse2));
        assertTrue(ellipse2.intersects(ellipse1));
    }

    @Test
    public void testIntersectsNot() {
        Ellipse ellipse1 = new Ellipse(null,  0.0f, 0.0f, 5.0, 2.5f, 0.0f, CoordinateSystem.CARTESIAN);
        Ellipse ellipse2 = new Ellipse(null, 10.0f, 0.0f, 4.0, 2.5f, 0.0f, CoordinateSystem.CARTESIAN);

        assertFalse(ellipse1.intersects(ellipse2));
        assertFalse(ellipse2.intersects(ellipse1));
    }

    @Test
    public void testIntersects() {
        Ellipse ellipse1 = new Ellipse(null,  2.0f, 0.0f, 5.0, 2.5f, 0.0f, CoordinateSystem.CARTESIAN);
        Ellipse ellipse2 = new Ellipse(null, 10.0f, 0.0f, 4.0, 2.5f, 0.0f, CoordinateSystem.CARTESIAN);

        assertTrue(ellipse1.intersects(ellipse2));
        assertTrue(ellipse2.intersects(ellipse1));
    }

    @Test
    public void testIntersectsExcel1() {
        Ellipse ellipse1 = new Ellipse(null,  0.0f,  0.0f, 100.0f,  40.0f,  45.0f, CoordinateSystem.CARTESIAN);
        Ellipse ellipse2 = new Ellipse(null, 90.0f, 30.0f,  50.0f,  25.0f, 150.0f, CoordinateSystem.CARTESIAN);

        assertTrue(ellipse1.intersects(ellipse2));
        assertTrue(ellipse2.intersects(ellipse1));
    }

    @Test
    public void testIntersectsExcel2() {
        Ellipse ellipse1 = new Ellipse(null,  0.0f,  0.0f, 100.0f,  40.0f,  45.0f, CoordinateSystem.CARTESIAN);
        Ellipse ellipse2 = new Ellipse(null, 80.0f, 30.0f,  50.0f,  25.0f, 150.0f, CoordinateSystem.CARTESIAN);

        assertTrue(ellipse1.intersects(ellipse2));
        assertTrue(ellipse2.intersects(ellipse1));
    }

    @Test
    public void testIntersectsExcel3() {
        Ellipse ellipse1 = new Ellipse(null,  0.0f,  0.0f, 100.0f,  40.0f,  62.0f, CoordinateSystem.CARTESIAN);
        Ellipse ellipse2 = new Ellipse(null, 118.0,  0.0f, 100.0f,  50.0f,  30.0f, CoordinateSystem.CARTESIAN);

        assertTrue(ellipse1.intersects(ellipse2));
        assertTrue(ellipse2.intersects(ellipse1));
    }

    @Test
    public void testIntersectsExcel1Not() {
        Ellipse ellipse1 = new Ellipse(null,   0.0f,  0.0f, 100.0f,  40.0f,  45.0f, CoordinateSystem.CARTESIAN);
        Ellipse ellipse2 = new Ellipse(null, 130.0f, 30.0f,  50.0f,  25.0f, 150.0f, CoordinateSystem.CARTESIAN);

        assertFalse(ellipse1.intersects(ellipse2));
        assertFalse(ellipse2.intersects(ellipse1));
    }

    @Test
    public void testContainsPosition() {
        Position position = Position.create(57.700633, 11.673650);

        Ellipse ellipse = new Ellipse(position, 0f, 0f, 100.0f, 40.0f, 0f, CoordinateSystem.CARTESIAN);
        System.out.println("ellipse: " + ellipse);
        assertTrue(ellipse.contains(position.positionAt(90, 99f)));
        assertFalse(ellipse.contains(position.positionAt(90, 101f)));
        assertTrue(ellipse.contains(position.positionAt(0, 39f)));
        assertFalse(ellipse.contains(position.positionAt(0, 41f)));
        ellipse = null;

        Ellipse rotatedEllipse = new Ellipse(position, 0f, 0f, 100.0f, 40f, 45f, CoordinateSystem.CARTESIAN);
        System.out.println("rotatedEllipse: " + rotatedEllipse);
        List<Position> positions = rotatedEllipse.samplePerimeter(32);
        for (Position pos : positions) {
            double v = pos.rhumbLineBearingTo(position);
            Position posInside = pos.positionAt(v, 1);
            Position posOutside = pos.positionAt(v+180, 1);
            System.out.println("pos: " + pos + ", v: " + v + ", posIn: " + posInside.getLatitude() + " " + posInside.getLongitude() + ", posOut: " + posOutside.getLatitude() + " " + posOutside.getLongitude());
            assertTrue(rotatedEllipse.contains(posInside));
            assertFalse(rotatedEllipse.contains(posOutside));
        }
    }

    
    // @Test
    public void testSamplePerimeter() {
        Ellipse ellipse = new Ellipse(Position.create(57.700633, 11.673650), -70.52481315529923, -54.37141463499117, 184.0, 40.0, 215.6999969482422, CoordinateSystem.CARTESIAN);

        List<Position> positions = ellipse.samplePerimeter(4);
        assertEquals(4, positions.size());
        assertEquals(Position.create(57.699175095853860, 11.669940032389967), positions.get(0));
        assertEquals(Position.create(57.699850143182594, 11.672854124920430), positions.get(1));
        assertEquals(Position.create(57.701110703232146, 11.674980889575464), positions.get(2));
        assertEquals(Position.create(57.700435704758796, 11.672066655989266), positions.get(3));
    }

}
