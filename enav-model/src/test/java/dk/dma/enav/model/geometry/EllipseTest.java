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

package dk.dma.enav.model.geometry;

import org.junit.Test;

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

}
