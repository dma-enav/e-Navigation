package dk.dma.enav.model.ship;

import static java.util.Objects.requireNonNull;
import dk.dma.enav.model.MaritimeId;

/**
 * Ideen er at kunne idenficere et skib paa en unik maade.
 */
public class ShipId extends MaritimeId {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id of the vessel */
    private final String id;

    private ShipId(String id) {
        this.id = requireNonNull(id, "id is null");
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof ShipId && equals((ShipId) other);
    }

    public boolean equals(ShipId other) {
        return other == this || (other != null && id.equals(other.id));
    }

    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public String toString() {
        return id;
    }

    public static ShipId create(String id) {
        return new ShipId(id);
    }
}
