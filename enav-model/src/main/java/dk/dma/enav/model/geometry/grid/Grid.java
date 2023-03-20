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
package dk.dma.enav.model.geometry.grid;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import dk.dma.enav.model.geometry.Area;
import dk.dma.enav.model.geometry.BoundingBox;
import dk.dma.enav.model.geometry.CoordinateSystem;
import dk.dma.enav.model.geometry.Position;

/**
 * The type Grid.
 *
 * @author Kasper Nielsen
 */
public final class Grid {

    /**
     * A grid where each cell have a radius of 1 degree.
     */
    public static final Grid GRID_1_DEGREE = new Grid(1);

    /**
     * A grid where each cell have a radius of 10 degrees.
     */
    public static final Grid GRID_10_DEGREES = new Grid(10);

    // Laver man et grid udfra et coordinat system?
    // Angiv f.eks. minSize, eller maxSize i x - DistanceUnit, bare meters syntes jeg
    // ahh det skal vel vaere kvadrat kilometere taenker jeg??

    private final double resolution;

    /**
     * The Multiplier.
     */
    final double multiplier;

    private Grid(double resolution) {
        this.resolution = resolution;
        this.multiplier = 360.0 / resolution;
    }

    /**
     * Gets resolution.
     *
     * @return the resolution
     */
    public double getResolution() {
        return resolution;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public double getSize() {
        return 40075000.0 * resolution / 360.0;
    }

    /**
     * Gets cell.
     *
     * @param cellId the cell id
     * @return the cell
     */
    public Cell getCell(long cellId) {
        return new Cell(cellId);
    }

    /**
     * Gets cell.
     *
     * @param pos the pos
     * @return the cell
     */
    public Cell getCell(Position pos) {
        return getCell(pos.getLatitude(), pos.getLongitude());
    }

    /**
     * Gets cell.
     *
     * @param lat the lat
     * @param lon the lon
     * @return the cell
     */
    public Cell getCell(double lat, double lon) {
        // We use floor(), not truncation (cast) to handle negative latitudes correctly.
        // Negative longitudes are handled by adding 360 (for backwards compatibility).
        //
        // floor(_lat / GEO_CELL_SIZE) Range -1800..1800, span 3600
        // static_cast<long>((360.0 + _lon)/GEO_CELL_SIZE) Range 3600..10800, span 7200
        // static_cast<long>(360.0 / GEO_CELL_SIZE) Constant = 7200
        // Result of last two lines Range -3600..3600, span 7200

        return new Cell((long) (Math.floor(lat / resolution) * multiplier) + (long) ((360.0 + lon) / resolution)
                - (long) (360.0 / resolution));
    }

    /**
     * Compute south-west corner of cell.
     *
     * @param cell the cell.
     * @return Position of south-west corner of cell.
     */
    public Position getGeoPosOfCell(Cell cell) {
        // Make lonPart range be 0..7200
        long id = cell.getCellId();
        id += (long) (360 / resolution / 2);
        // Cut off lonPart
        long latPart = (long) Math.floor(id / multiplier);
        // Move lonPart range back again
        id -= (long) (360 / resolution / 2);
        long lonPart = (long) (id - latPart * multiplier);

        return Position.create(resolution * latPart, resolution * lonPart);
    }

    /**
     * Gets cell north of.
     *
     * @param cell the cell
     * @return the cell north of
     */
    public Cell getCellNorthOf(Cell cell) {
        return new Cell((long) (cell.getCellId() + multiplier));
    }

    /**
     * Gets cell south of.
     *
     * @param cell the cell
     * @return the cell south of
     */
    public Cell getCellSouthOf(Cell cell) {
        return new Cell((long) (cell.getCellId() - multiplier));
    }

    /**
     * Gets cell west of.
     *
     * @param cell the cell
     * @return the cell west of
     */
    public Cell getCellWestOf(Cell cell) {
        if (cell.getCellId() % multiplier == 0) {
            return new Cell((long) (cell.getCellId() + multiplier - 1));
        }
        return new Cell(cell.getCellId() - 1);
    }

    /**
     * Gets cell east of.
     *
     * @param cell the cell
     * @return the cell east of
     */
    public Cell getCellEastOf(Cell cell) {
        if (cell.getCellId() % multiplier == multiplier-1) {
            return new Cell((long) (cell.getCellId() - multiplier + 1));
        }
        return new Cell(cell.getCellId() + 1);
    }

    /**
     * Compute the geographical bounding box of a cell.
     *
     * @param cell the cell to have its bounding box computed.
     * @return the bounding box of the given cell.
     */
    public BoundingBox getBoundingBoxOfCell(Cell cell) {
        final Position southWestCorner = getGeoPosOfCell(cell);
        final Position northEastCorner = Position.create(southWestCorner.getLatitude() + resolution, southWestCorner.getLongitude() + resolution);
        return BoundingBox.create(southWestCorner, northEastCorner, CoordinateSystem.GEODETIC);
    }

    /**
     * Gets nearby cells.
     *
     * @param position the position
     * @param radius   the radius
     * @return the nearby cells
     */
    public Set<Cell> getNearbyCells(Position position, double radius) {
        Set<Cell> cells = new HashSet<>();

        double latN = position.getLatitude() + radius;
        double latS = position.getLatitude() - radius;
        double lonW = position.getLongitude() - radius;
        double lonE = position.getLongitude() + radius;

        Long cellIdNW = getCell(latN, lonW).id;
        Long cellIdNE = getCell(latN, lonE).id;
        Long cellIdSE = getCell(latS, lonE).id;

        Long firstCellId = cellIdNW;
        Long iteratorCellId = cellIdNW;
        Long lastCellId = cellIdNE;

        while (iteratorCellId <= lastCellId) {
            iteratorCellId = firstCellId;

            cells.add(new Cell(firstCellId));

            while (iteratorCellId <= lastCellId) {
                iteratorCellId = getCellEastOf(new Cell(iteratorCellId)).id;

                cells.add(new Cell(iteratorCellId));
            }

            firstCellId = getCellSouthOf(new Cell(firstCellId)).id;
            lastCellId = getCellSouthOf(new Cell(lastCellId)).id;
        }

        if (cellIdNW == cellIdSE) {
            cells.add(new Cell(cellIdNW));
        }

        return cells;
    }

    /**
     * Returns a list of cells that the specified area is contained in.
     *
     * @param area the area
     * @return cells
     */
    public Set<Cell> getCells(Area area) {
        if (area instanceof BoundingBox) {
            return getCells((BoundingBox) area);
        }
        throw new UnsupportedOperationException("Only bounding boxes are supported");
    }

    /**
     * Gets cells.
     *
     * @param box the box
     * @return the cells
     */
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

    /**
     * Create Grid with degrees size E.g. using 0.0045: 40.075.000 m / (360 / 0.0045) = 500 m cell size E.g. using
     * 0.0008983: 100 m cell size
     *
     * @param resolution in degrees
     * @return grid
     */
    public static Grid create(double resolution) {
        return new Grid(resolution);
    }

    /**
     * Create a grid with approximately cell size in meters
     *
     * @param approxSize cell size in meters
     * @return grid
     */
    public static Grid createSize(double approxSize) {
        return create(360.0 * approxSize / 40075000.0);
    }

    //
    // List<Cell> getCells(Line line) {
    // throw new UnsupportedOperationException();
    // }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
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
