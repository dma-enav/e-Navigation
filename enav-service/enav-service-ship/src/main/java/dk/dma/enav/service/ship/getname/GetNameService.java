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
