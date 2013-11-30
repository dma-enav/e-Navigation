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
        Position geoPosOfCell = grid.getGeoPosOfCell(cell);
        assertEquals(56.0, geoPosOfCell.getLatitude(), 1e-3);
        assertEquals(12.0, geoPosOfCell.getLongitude(), 1e-3);
    }

    @Test
    public void testGetBoundingBoxOfCell() {
        Cell cell1 = grid.getCell(Position.create(56.0, 12.0));
        assertEquals(6245495054L, cell1.getCellId());

        BoundingBox boundingBox1 = grid.getBoundingBoxOfCell(cell1);

        assertEquals(56.001001497192824, boundingBox1.getMaxLat(), 1e-3);
        assertEquals(55.999101497192760, boundingBox1.getMinLat(), 1e-3);
        assertEquals(12.001500561447282, boundingBox1.getMaxLon(), 1e-3);
        assertEquals(11.999600561447286, boundingBox1.getMinLon(), 1e-3);
    }

    @Test
    public void testGetCellEastOf() {
        final double commonLatitudeNorth = 56.001001497192824;
        final double commonLatitudeSouth = 55.999101497192760;

        Cell cell1 = grid.getCell(Position.create(56.0, 12.0));
        BoundingBox boundingBox1 = grid.getBoundingBoxOfCell(cell1);

        assertEquals(commonLatitudeNorth, boundingBox1.getMaxLat(), 1e-3);
        assertEquals(commonLatitudeSouth, boundingBox1.getMinLat(), 1e-3);
        assertEquals(12.001500561447282, boundingBox1.getMaxLon(), 1e-3);
        assertEquals(11.999600561447286, boundingBox1.getMinLon(), 1e-3);

        Cell cell2 = grid.getCellEastOf(cell1);
        BoundingBox boundingBox2 = grid.getBoundingBoxOfCell(cell2);

        assertEquals(cell1.getCellId() + 1, cell2.getCellId());
        assertEquals(commonLatitudeNorth, boundingBox2.getMaxLat(), 1e-3);
        assertEquals(commonLatitudeSouth, boundingBox2.getMinLat(), 1e-3);
        assertEquals(12.003297192763563, boundingBox2.getMaxLon(), 1e-3);
        assertEquals(12.001397192763568, boundingBox2.getMinLon(), 1e-3);
    }
}
