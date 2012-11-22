package dk.dma.enav.model.geometry;

/**
 * An object that has a boundary such as a route or a warning area.
 */
public interface GeometryBoundedObject {

    /**
     * Returns the boundary.
     * 
     * @return the boundary
     */
    Element getBoundary();
}
