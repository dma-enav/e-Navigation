package dk.dma.enav.model.ship;

import java.io.Serializable;

import dk.dma.enav.model.Country;

public class ShipInformation implements Serializable {
    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
