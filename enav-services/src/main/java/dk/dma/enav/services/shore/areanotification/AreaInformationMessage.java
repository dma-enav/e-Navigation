package dk.dma.enav.services.shore.areanotification;

import dk.dma.enav.model.geometry.Shape;
import dk.dma.enav.services.ServiceMessage;

public class AreaInformationMessage extends ServiceMessage {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The area that is affected by this warning */
    Shape area;

    String message = "Uh-Oh, We're In Trouble, Something's Come Along And It's Burst Our Bubble";
}
