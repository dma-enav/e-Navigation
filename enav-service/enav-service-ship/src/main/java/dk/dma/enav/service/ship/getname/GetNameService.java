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
package dk.dma.enav.service.ship.getname;

import static java.util.Objects.requireNonNull;
import dk.dma.enav.service.spi.InitiatingMessage;
import dk.dma.enav.service.spi.MaritimeService;
import dk.dma.enav.service.spi.MaritimeServiceMessage;

/**
 * 
 * @author Kasper Nielsen
 */
public class GetNameService extends MaritimeService {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    public GetNameService() {
        super("imo.ship.getname");
    }

    public static class GetName extends MaritimeServiceMessage<Reply> implements InitiatingMessage {
        /** serialVersionUID. */
        private static final long serialVersionUID = 1L;

        public GetName() {
            super(GetNameService.class);
        }
    }

    public static class Reply extends MaritimeServiceMessage<Void> {

        /** serialVersionUID. */
        private static final long serialVersionUID = 1L;

        /** The name of the ship. */
        private final String name;

        public Reply(String name) {
            super(GetNameService.class);
            this.name = requireNonNull(name);
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }
    }
}
