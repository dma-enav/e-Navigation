package dk.dma.enav.model;

import dk.dma.enav.model.geometry.Position;

/**
 * An object that has a position.
 */
public interface PositionalObject {

    /**
     * Returns the current position of the object.
     * 
     * @return the current position of the object
     */
    Position getPosition();
}
