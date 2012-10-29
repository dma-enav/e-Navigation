package dk.dma.enav.model.voyage;

public enum NavigationalStatus {
    UNDEFINED, UNDER_WAY_USING_ENGINE, AT_ANCHOR, NOT_UNDER_COMMAND, RESTRICTED_MANOEUVRABILITY, CONSTRAINED_BY_HER_DRAUGHT, MOORED, AGROUND, ENGAGED_IN_FISHING, UNDER_WAY, SAILING, AIS_SART {
        public String toString() {
            return name().replace("_", "-");
        }
    };

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
