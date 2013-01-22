package dk.dma.enav.service.shore.areanotification;

import dk.dma.enav.model.geometry.Area;
import dk.dma.enav.service.general.notification.NotificationMessage;
import dk.dma.enav.service.spi.MaritimeInformationMessage;

/**
 * @deprecated use {@link NotificationMessage} instead.
 */
@Deprecated
public class AreaInformationMessage extends MaritimeInformationMessage {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The area that is affected by this warning */
    Area area;

    String message = "Uh-Oh, We're In Trouble, Something's Come Along And It's Burst Our Bubble";
}
