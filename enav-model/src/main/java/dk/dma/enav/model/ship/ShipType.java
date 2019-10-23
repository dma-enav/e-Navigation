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
package dk.dma.enav.model.ship;

import java.util.ArrayList;
import java.util.List;

/**
 * The enum Ship type.
 */
public enum ShipType {

    /**
     * Anti pollution ship type.
     */
    ANTI_POLLUTION,
    /**
     * Cargo ship type.
     */
    CARGO,
    /**
     * Diving ship type.
     */
    DIVING,
    /**
     * Dredging ship type.
     */
    DREDGING,
    /**
     * Fishing ship type.
     */
    FISHING,
    /**
     * Hsc ship type.
     */
    HSC,
    /**
     * Law enforcement ship type.
     */
    LAW_ENFORCEMENT,
    /**
     * Medical ship type.
     */
    MEDICAL,
    /**
     * Military ship type.
     */
    MILITARY,
    /**
     * Passenger ship type.
     */
    PASSENGER,
    /**
     * Cruise ship ship type.
     */
    CRUISE_SHIP,
    /**
     * Pilot ship type.
     */
    PILOT,
    /**
     * Pleasure ship type.
     */
    PLEASURE,
    /**
     * Port tender ship type.
     */
    PORT_TENDER,
    /**
     * Sailing ship type.
     */
    SAILING,
    /**
     * Sar ship type.
     */
    SAR,
    /**
     * Tanker ship type.
     */
    TANKER,
    /**
     * Towing ship type.
     */
    TOWING,
    /**
     * Towing long wide ship type.
     */
    TOWING_LONG_WIDE,
    /**
     * Tug ship type.
     */
    TUG,
    /**
     * Undefined ship type.
     */
    UNDEFINED,
    /**
     * Unknown ship type.
     */
    UNKNOWN,
    /**
     * Wig ship type.
     */
    WIG;

    /**
     * Gets string list.
     *
     * @return the string list
     */
    public static List<String> getStringList() {
        List<String> list = new ArrayList<>();
        for (ShipType type : values()) {
            list.add(type.toString());
        }
        return list;
    }
}
