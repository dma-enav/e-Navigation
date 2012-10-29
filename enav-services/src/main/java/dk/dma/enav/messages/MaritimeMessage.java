package dk.dma.enav.messages;

import java.io.Serializable;

import dk.dma.enav.model.MaritimeId;

/**
 * The basic entity for all maritime messages send around in the system.
 **/
public abstract class MaritimeMessage implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** The id of the message source. (not any relays) */
    private MaritimeId sourceId;

    /**
     * Returns the id of the source of this message.
     * 
     * @return the id of the source of this message
     */
    public MaritimeId getSource() {
        return sourceId;
    }

    public void setSource(MaritimeId id) {
        this.sourceId = id;
    }

    // Are we only using messages with services??
    // If we are only using it with services me might just move it to the
    // service packages

    // Perhaps a MaritimeServiceMessage
    // getServiceID()
}
