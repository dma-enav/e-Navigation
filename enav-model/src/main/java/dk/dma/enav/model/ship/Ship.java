package dk.dma.enav.model.ship;

import dk.dma.enav.model.MaritimePeer;
import dk.dma.enav.model.geometry.Position;
import dk.dma.enav.model.voyage.Voyage;

public class Ship extends MaritimePeer {

    private Voyage current;

    private ShipId id;

    private Position latest;

    public Voyage getCurrent() {
        return current;
    }

    public ShipId getId() {
        return id;
    }

    public Position getLatest() {
        return latest;
    }

    public void setCurrent(Voyage current) {
        this.current = current;
    }

    public void setId(ShipId id) {
        this.id = id;
    }

    public void setLatest(Position latest) {
        this.latest = latest;
    }
}
