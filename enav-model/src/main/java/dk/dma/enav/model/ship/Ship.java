package dk.dma.enav.model.ship;

import dk.dma.enav.model.MaritimePeer;
import dk.dma.enav.model.geometry.Position;
import dk.dma.enav.model.voyage.Voyage;

public class Ship extends MaritimePeer {

    private ShipId id;

    private Position latest;

    private Voyage current;

    public ShipId getId() {
        return id;
    }

    public void setId(ShipId id) {
        this.id = id;
    }

    public Position getLatest() {
        return latest;
    }

    public void setLatest(Position latest) {
        this.latest = latest;
    }

    public Voyage getCurrent() {
        return current;
    }

    public void setCurrent(Voyage current) {
        this.current = current;
    }
}
