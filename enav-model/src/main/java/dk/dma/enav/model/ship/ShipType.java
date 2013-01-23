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
package dk.dma.enav.model.ship;

import java.util.ArrayList;
import java.util.List;

public enum ShipType {

    ANTI_POLLUTION, CARGO, DIVING, DREDGING, FISHING, HSC, LAW_ENFORCEMENT, MEDICAL, MILITARY, PASSENGER, CRUISE_SHIP, PILOT, PLEASURE, PORT_TENDER, SAILING, SAR, TANKER, TOWING, TOWING_LONG_WIDE, TUG, UNDEFINED, UNKNOWN, WIG;

    public static List<String> getStringList() {
        List<String> list = new ArrayList<>();
        for (ShipType type : values()) {
            list.add(type.toString());
        }
        return list;
    }
}
