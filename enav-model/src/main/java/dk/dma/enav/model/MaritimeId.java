package dk.dma.enav.model;

import java.io.Serializable;

/** The id of some kind of maritime object such as a ship, VTS station, voyage or an object on a map. */
public abstract class MaritimeId implements Serializable {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a id from the specified string based representation of the id.
     * 
     * @param id
     *            the string based representation to create the id from
     * @return the id
     * @throws NullPointerException
     *             if the specified id string is null
     * @throws IllegalArgumentException
     *             if the specified string is not a valid maritime id
     */
    public static MaritimeId from(String id) {
        throw new UnsupportedOperationException();
    }
}
