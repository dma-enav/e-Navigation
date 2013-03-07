/*
 * Copyright (c) 2008 Kasper Nielsen.
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
public class Grid {

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
