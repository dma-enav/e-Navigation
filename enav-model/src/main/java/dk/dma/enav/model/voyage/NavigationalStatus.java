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
package dk.dma.enav.model.voyage;

/**
 * The enum Navigational status.
 */
public enum NavigationalStatus {
    /**
     * Aground navigational status.
     */
    AGROUND,
    /**
     * The Ais sart.
     */
    AIS_SART {
        public String toString() {
            return name().replace("_", "-");
        }
    },
    /**
     * At anchor navigational status.
     */
    AT_ANCHOR,
    /**
     * Constrained by her draught navigational status.
     */
    CONSTRAINED_BY_HER_DRAUGHT,
    /**
     * Engaged in fishing navigational status.
     */
    ENGAGED_IN_FISHING,
    /**
     * Moored navigational status.
     */
    MOORED,
    /**
     * Not under command navigational status.
     */
    NOT_UNDER_COMMAND,
    /**
     * Restricted manoeuvrability navigational status.
     */
    RESTRICTED_MANOEUVRABILITY,
    /**
     * Sailing navigational status.
     */
    SAILING,
    /**
     * Undefined navigational status.
     */
    UNDEFINED,
    /**
     * Under way navigational status.
     */
    UNDER_WAY,
    /**
     * Under way using engine navigational status.
     */
    UNDER_WAY_USING_ENGINE;

    public String toString() {
        String navStat = name().replace("_", " ");
        return navStat.substring(0, 1) + navStat.substring(1).toLowerCase();
    }

    /**
     * Returns a navigation status from an ais int on a best effort.
     *
     * @param aisNavStatus the ais nav status
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

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println(AIS_SART.toString());
        System.out.println(AT_ANCHOR.toString());
    }

}
