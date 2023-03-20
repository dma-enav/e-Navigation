/* Copyright (c) 2011 Danish Maritime Authority.
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
package dk.dma.enav.model.ship;

import static java.util.Objects.requireNonNull;
import dk.dma.enav.model.MaritimeId;

/**
 * Ideen er at kunne idenficere et skib paa en unik maade.
 */
public final class ShipId extends MaritimeId {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id of the vessel */
    private final String id;

    private ShipId(String id) {
        super("ship");
        this.id = requireNonNull(id, "id is null");
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof ShipId && equals((ShipId) other);
    }

    /**
     * Equals boolean.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean equals(ShipId other) {
        return other == this || other != null && id.equals(other.id);
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public String toString() {
        return id;
    }

    /**
     * Create ship id.
     *
     * @param id the id
     * @return the ship id
     */
    public static ShipId create(String id) {
        return new ShipId(id);
    }

}
