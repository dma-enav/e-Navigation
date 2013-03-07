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

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import dk.dma.enav.model.geometry.Area;
import dk.dma.enav.model.geometry.BoundingBox;
import dk.dma.enav.model.geometry.CoordinateSystem;
import dk.dma.enav.model.geometry.Line;
import dk.dma.enav.model.geometry.Position;

/**
 * 
 * @author Kasper Nielsen
 */
public final class Grid {

    public static final Grid CELL1 = new Grid();

    // Kan maaske have nogle statiske GRID_1 <-
    // Kan maaske have nogle statiske GRID_1 <-

    // Laver man et grid udfra et coordinat system?
    // Angiv f.eks. minSize, eller maxSize i x - DistanceUnit, bare meters syntes jeg
    // ahh det skal vel vaere kvadrat kilometere taenker jeg??
    private Grid() {}

    public Cell getCell(Position position) {
        throw new UnsupportedOperationException();
    }

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
        throw new UnsupportedOperationException();
    }

    Set<Cell> getCells(BoundingBox box) {
        Set<Long> cells = new TreeSet<>();
        for (int i = 0; i < 100000; i++) {
            cells.add(box.getRandom().getCell(1));
        }
        Set<Cell> result = new TreeSet<>();
        for (Long l : cells) {
            result.add(new Cell(l));
        }
        return result;
    }

    List<Cell> getCells(Line line) {
        throw new UnsupportedOperationException();
    }

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
