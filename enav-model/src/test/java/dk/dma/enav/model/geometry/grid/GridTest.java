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
package dk.dma.enav.model.geometry.grid;

import dk.dma.enav.model.geometry.BoundingBox;
import dk.dma.enav.model.geometry.Position;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GridTest {

    static Grid grid;

    @BeforeClass
    public static void setup() {
        grid = Grid.createSize(200);
    }

    @Test
    public void testGetCellFromCellId() {
        Cell cell1 = grid.getCell(1L);
        assertEquals(1L, cell1.getCellId());
        Cell cell2 = grid.getCell(6034900978L);
        assertEquals(6034900978L, cell2.getCellId());
    }

    @Test
    public void testGetGeoPosOfCell() {
        Cell cell = grid.getCell(Position.create(56.0, 12.0));
        Position southWestCorner = grid.getGeoPosOfCell(cell);
        assertEquals(55.999201497192765d, southWestCorner.getLatitude(), 1e-10);
        assertEquals(11.999700561447286d, southWestCorner.getLongitude(), 1e-10);
    }

    @Test
    public void testGetBoundingBoxOfCell() {
        Cell cell1 = grid.getCell(Position.create(56.0, 12.0));
        assertEquals(6245495054L, cell1.getCellId());

        BoundingBox boundingBox1 = grid.getBoundingBoxOfCell(cell1);

        assertEquals(56.000998128509046d, boundingBox1.getMaxLat(), 1e-10);
        assertEquals(55.999201497192765d, boundingBox1.getMinLat(), 1e-10);
        assertEquals(12.001497192763567d, boundingBox1.getMaxLon(), 1e-10);
        assertEquals(11.999700561447286d, boundingBox1.getMinLon(), 1e-10);
    }

    @Test
    public void testGetCellEastOf() {
        final double commonLatitudeNorth = 56.000998128509046d;
        final double commonLatitudeSouth = 55.999201497192765d;

        Cell cell1 = grid.getCell(Position.create(56.0, 12.0));
        BoundingBox boundingBox1 = grid.getBoundingBoxOfCell(cell1);

        assertEquals(commonLatitudeNorth, boundingBox1.getMaxLat(), 1e-10);
        assertEquals(commonLatitudeSouth, boundingBox1.getMinLat(), 1e-10);
        assertEquals(12.001497192763567d, boundingBox1.getMaxLon(), 1e-10);
        assertEquals(11.999700561447286d, boundingBox1.getMinLon(), 1e-10);

        Cell cell2 = grid.getCellEastOf(cell1);
        BoundingBox boundingBox2 = grid.getBoundingBoxOfCell(cell2);

        assertEquals(cell1.getCellId() + 1, cell2.getCellId());
        assertEquals(commonLatitudeNorth, boundingBox2.getMaxLat(), 1e-10);
        assertEquals(commonLatitudeSouth, boundingBox2.getMinLat(), 1e-10);
        assertEquals(12.003293824079849d, boundingBox2.getMaxLon(), 1e-10);
        assertEquals(12.001497192763567d, boundingBox2.getMinLon(), 1e-10);
    }
}
