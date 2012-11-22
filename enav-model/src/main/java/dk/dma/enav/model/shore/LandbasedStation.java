package dk.dma.enav.model.shore;

import dk.dma.enav.model.MaritimePeer;

public class LandbasedStation extends MaritimePeer {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** {@inheritDoc} */
    @Override
    public MaritimeAuthorityId getId() {
        return null;
    }

}
