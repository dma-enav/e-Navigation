/*
 * Copyright (c) 2008 Kasper Nielsen.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dk.dma.enav.service.voyage;

import dk.dma.enav.model.geometry.Position;
import dk.dma.enav.model.ship.ShipId;
import dk.dma.enav.service.spi.MaritimeInformationMessage;

/**
 * 
 * @author Kasper Nielsen
 */
public class CurrentPositionService {

    /**
     * Created by a ship to report its current position.
     * 
     */
    public static class CurrentPositionReportMessage extends MaritimeInformationMessage {

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
