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
package dk.dma.enav.model.voyage;

public enum NavigationalStatus {
    AGROUND, AIS_SART {
        public String toString() {
            return name().replace("_", "-");
        }
    }, AT_ANCHOR, CONSTRAINED_BY_HER_DRAUGHT, ENGAGED_IN_FISHING, MOORED, NOT_UNDER_COMMAND, RESTRICTED_MANOEUVRABILITY, SAILING, UNDEFINED, UNDER_WAY, UNDER_WAY_USING_ENGINE;

    public String toString() {
        String navStat = name().replace("_", " ");
        return navStat.substring(0, 1) + navStat.substring(1).toLowerCase();
    }

    /**
     * Returns a navigation status from an ais int on a best effort.
     * 
     * @return the navigation status.
     */
    public static NavigationalStatus fromAIS(int aisNavStatus) {
        switch (aisNavStatus) {
        case 0:
            return UNDER_WAY_USING_ENGINE;
        case 1:
            return AT_ANCHOR;
        case 2:
            return NOT_UNDER_COMMAND;
        case 3:
            return RESTRICTED_MANOEUVRABILITY;
        case 4:
            return CONSTRAINED_BY_HER_DRAUGHT;
        case 5:
            return MOORED;
        case 6:
            return AGROUND;
        case 7:
            return ENGAGED_IN_FISHING;
        case 8:
            return UNDER_WAY;
        case 14:
            return AIS_SART;
            // case 15:
            // return UNDEFINED;
        default:
            return UNDEFINED;
        }
    }

    public static void main(String[] args) {
        System.out.println(AIS_SART.toString());
        System.out.println(AT_ANCHOR.toString());
    }

}
