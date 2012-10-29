package dk.dma.enav.services.shore.areanotification;

import dk.dma.enav.messages.MaritimeMessage;
import dk.dma.enav.model.geometry.Shape;

public class AreaInformationMessage extends MaritimeMessage {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The area that is affected by this warning */
    Shape area;

    String message = "Uh-Oh, We're In Trouble, Something's Come Along And It's Burst Our Bubble";
}
