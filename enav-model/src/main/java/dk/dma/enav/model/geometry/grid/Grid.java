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

import java.util.Set;
import java.util.TreeSet;

import dk.dma.enav.model.geometry.Area;
import dk.dma.enav.model.geometry.BoundingBox;
import dk.dma.enav.model.geometry.CoordinateSystem;
import dk.dma.enav.model.geometry.Position;

/**
 * 
 * @author Kasper Nielsen
 */
public final class Grid {

    /** A grid where each cell have a radius of 1 degree. */
    public static final Grid GRID_1_DEGREE = new Grid(1);

    /** A grid where each cell have a radius of 10 degrees. */
    public static final Grid GRID_10_DEGREES = new Grid(10);

    // Laver man et grid udfra et coordinat system?
    // Angiv f.eks. minSize, eller maxSize i x - DistanceUnit, bare meters syntes jeg
    // ahh det skal vel vaere kvadrat kilometere taenker jeg??

    private final double resolution;

    private Grid(double resolution) {
        this.resolution = resolution;
    }

    //
    // public Cell getCell(Position position) {
    // throw new UnsupportedOperationException();
    // }
    //
    // /**
    // * Returns a map of all cells, where the key is the id of the cell, and the value is the actual cell.
    // *
    // * @return all cells
    // */
    // public Map<Integer, Cell> getCells() {
    // return null;
    // }

    /**
     * Returns a list of cells that the specified area is contained in.
     * 
     * @param area
     * @return
     */
    public Set<Cell> getCells(Area area) {
        if (area instanceof BoundingBox) {
            return getCells((BoundingBox) area);
        }
        throw new UnsupportedOperationException("Only bounding boxes are supported");
    }

    Set<Cell> getCells(BoundingBox box) {
        Set<Long> cells = new TreeSet<>();
        int steps = 64;
        int prev = 0;
        // TODO fix it to be fast
        for (;;) {
            for (int i = 0; i < steps; i++) {
                cells.add(box.getRandom().getCell(resolution));
            }
            if (cells.size() == prev) {
                break;
            }
            prev = cells.size();
            steps *= 2;
        }
        Set<Cell> result = new TreeSet<>();
        for (Long l : cells) {
            result.add(new Cell(l));
        }
        return result;
    }

    //
    // List<Cell> getCells(Line line) {
    // throw new UnsupportedOperationException();
    // }

    public static void main(String[] args) {
        BoundingBox bb = BoundingBox.create(Position.create(-40, 15), Position.create(12, 77),
                CoordinateSystem.CARTESIAN);
        Set<Long> cells = new TreeSet<>();
        for (int i = 0; i < 100000; i++) {
            cells.add(bb.getRandom().getCell(1));
        }
        System.out.println(cells.size());
        System.out.println(cells);
    }
}
