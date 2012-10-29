package dk.dma.enav.services.navigationalstatus;

import dk.dma.enav.messages.MaritimeMessage;
import dk.dma.enav.model.geometry.Position;
import dk.dma.enav.model.ship.ShipId;

/**
 * Created by a ship to report its current position.
 * 
 */
public class CurrentPositionReportMessage extends MaritimeMessage {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The current course over ground. */
    // TODO unit???
    private Double courseOverGround;

    /** The angle of the vessel to true north. */
    private Double heading;

    /** The current position of the vessel. */
    private Position position;

    /** The current speed over ground. */
    // TODO unit???
    private Double speedOverGround;

    public CurrentPositionReportMessage() {

    }

    public CurrentPositionReportMessage(ShipId id, Position point) {
        setSource(id);
        setPosition(point);
    }

    // COG is the direction the GPS receiver is moving and corresponds to the
    // direction of the black Compass arrow.
    public Double getCourseOverGround() {
        return courseOverGround;
    }

    public Double getHeading() {
        return heading;
    }

    /**
     * Returns the current position of the vessel.
     * 
     * @return the current position of the vessel
     */
    public Position getPosition() {
        return position;
    }

    public Double getSpeedOverGround() {
        return speedOverGround;
    }

    public void setCourseOverGround(Double cog) {
        this.courseOverGround = cog;
    }

    /**
     * Sets the heading of the vessel. Which is defined as the direction to
     * which the bow is pointing relative to true north.
     * 
     * @param heading
     *            the heading of the vessel
     */
    public void setHeading(Double heading) {

        this.heading = heading;
    }

    /**
     * Sets the current position of the vessel.
     * 
     * @param position
     *            the position of the vessel
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Sets the speed over ground (SOG). SOG is the actual speed that the vessel
     * is moving over the ground.
     * 
     * @param speedOverGround
     *            speed over ground
     * @throws IllegalArgumentException
     *             if the speed is native
     */
    public void setSpeedOverGround(Double speedOverGround) {
        if (speedOverGround != null && speedOverGround < 0) {
            throw new IllegalArgumentException("Speed over ground (SOG) must be positive, was " + speedOverGround);
        }
        this.speedOverGround = speedOverGround;
    }

    // http://coaps.fsu.edu/woce/truewind/paper/
}
