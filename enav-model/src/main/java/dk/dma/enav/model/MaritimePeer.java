package dk.dma.enav.model;

import java.io.Serializable;

/**
 * 
 * @author Kasper Nielsen
 */
public abstract class MaritimePeer implements Serializable {

    /**  */
    private static final long serialVersionUID = 1L;

    public abstract MaritimeId getId();

}
