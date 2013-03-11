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
package dk.dma.enav.service.ship;

import static java.util.Objects.requireNonNull;
import dk.dma.enav.communication.service.ServiceInitiationPoint;
import dk.dma.enav.communication.service.spi.MaritimeService;
import dk.dma.enav.communication.service.spi.MaritimeServiceMessage;

/**
 * 
 * @author Kasper Nielsen
 */
public class GetNameService extends MaritimeService {

    /** An initiation point */
    public static final ServiceInitiationPoint<GetName> GET_NAME = new ServiceInitiationPoint<>(GetName.class);

    public static final String NAME = "imo.ship.getname";

    public static class GetName extends MaritimeServiceMessage<Reply> {}

    public static class Reply extends MaritimeServiceMessage<Void> {

        /** The name of the ship. */
        private String name;

        public Reply() {}

        public Reply(String name) {
            this.name = requireNonNull(name);
        }

        /** @return the name of the service */
        public String getName() {
            return name;
        }

        /**
         * @param name
         *            the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /** {@inheritDoc} */
        public String toString() {
            return name;
        }
    }
}
