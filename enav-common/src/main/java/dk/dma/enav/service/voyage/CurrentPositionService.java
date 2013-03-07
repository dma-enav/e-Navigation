/* Copyright (c) 2011 Danish Maritime Authority
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this library.  If not, see <http://www.gnu.org/licenses/>.
 */
package dk.dma.enav.service.voyage;

import dk.dma.enav.communication.broadcast.BroadcastMessage;
import dk.dma.enav.model.geometry.Position;

/**
 * 
 * @author Kasper Nielsen
 */
public class CurrentPositionService {

    /**
     * Created by a ship to report its current position.
     * 
     */
    public static class CurrentPositionReportMessage extends BroadcastMessage {

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
         * Sets the heading of the vessel. Which is defined as the direction to which the bow is pointing relative to
         * true north.
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
         * Sets the speed over ground (SOG). SOG is the actual speed that the vessel is moving over the ground.
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
}
