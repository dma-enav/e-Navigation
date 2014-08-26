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
