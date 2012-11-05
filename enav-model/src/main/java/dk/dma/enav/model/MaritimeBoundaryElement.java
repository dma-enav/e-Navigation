package dk.dma.enav.model;

import dk.dma.enav.model.geometry.Element;

//A route, ship, warning area. Anything with a shape that
//can interact with others
public class MaritimeBoundaryElement {

    Element getBoundary() {
        return null;
    }

    // Har et id
    // Er shape element, enten en position eller
    MaritimeId getId() {
        return null;
    }
}
