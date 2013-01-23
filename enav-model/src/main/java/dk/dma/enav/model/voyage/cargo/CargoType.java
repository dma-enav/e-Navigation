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
package dk.dma.enav.model.voyage.cargo;

public enum CargoType {
    A, B, C, D, UNDEFINED;

    public String toString() {
        return this == UNDEFINED ? "Undefined" : "Category " + name();
    }

    /**
     * Returns a navigation status from an ais int on a best effort.
     * 
     * @return the navigation status.
     */
    public static CargoType fromAIS(int aisNavStatus) {
        switch (aisNavStatus) {
        case 1:
            return A;
        case 2:
            return B;
        case 3:
            return C;
        case 4:
            return D;
        default:
            return UNDEFINED;
        }
    }
}
