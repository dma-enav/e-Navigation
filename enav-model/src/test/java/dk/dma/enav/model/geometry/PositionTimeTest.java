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

import static org.junit.Assert.assertEquals;

public class PositionTimeTest {

    @Test
    public void testLinearInterpolation() {
        assertEquals(1, PositionTime.linearInterpolation(1, 1, 3, 3, 1), 1e-16);
        assertEquals(3, PositionTime.linearInterpolation(1, 1, 3, 3, 3), 1e-16);

        assertEquals(2, PositionTime.linearInterpolation(1, 1, 3, 3, 2), 1e-16);
        assertEquals(10, PositionTime.linearInterpolation(1, 1, 3, 3, 10), 1e-16);

        assertEquals(2.5, PositionTime.linearInterpolation(0, 0, 5, 10, 5), 1e-16);
        assertEquals(4.5, PositionTime.linearInterpolation(0, 0, 5, 10, 9), 1e-16);
    }
}
