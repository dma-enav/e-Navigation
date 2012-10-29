package dk.dma.enav.model.voyage.cargo;

public enum CargoType {
    UNDEFINED, A, B, C, D;

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

    public String toString() {
        return this == UNDEFINED ? "Undefined" : "Category " + name();
    }
}