package dk.dma.enav.model.voyage;

import java.io.Serializable;
import java.util.Date;

import dk.dma.enav.model.geometry.Line;

public class Waypoint implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** ETA at waypoint . */
    private Date eta;

    /** Mandatory latitude. */
    private double latitude;

    Line line;
    // Waypoint related

    Leg leg;

    /** Mandatory longitude. */
    private double longitude;

    /** Rate of turn . */
    private Double rot;

    /** Speed in knots. */
    private Double speed;

    /** Waypoint turn radius in nautical miles. */
    private Double turnRad;

    /** Port XTD. */
    private Double xtdPort;

    /** Starboard XTD. */
    private Double xtdStarboard;

    public Date getEta() {
        return eta;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Double getRot() {
        return rot;
    }

    public Double getSpeed() {
        return speed;
    }

    public Double getTurnRad() {
        return turnRad;
    }

    public Double getXtdPort() {
        return xtdPort;
    }

    public Double getXtdStarboard() {
        return xtdStarboard;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setRot(Double rot) {
        this.rot = rot;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    // Leaving leg related

    public void setTurnRad(Double turnRad) {
        this.turnRad = turnRad;
    }

    public void setXtdPort(Double xtdPort) {
        this.xtdPort = xtdPort;
    }

    public void setXtdStarboard(Double xtdStarboard) {
        this.xtdStarboard = xtdStarboard;
    }

    public static class Leg {

    }
}