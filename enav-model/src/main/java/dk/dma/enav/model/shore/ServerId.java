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
package dk.dma.enav.model.shore;

import dk.dma.enav.model.MaritimeId;

/**
 * The type Server id.
 *
 * @author Kasper Nielsen
 */
public class ServerId extends MaritimeId {

    /**  */
    private static final long serialVersionUID = 1L;

    private final int id;

    /**
     * Instantiates a new Server id.
     *
     * @param id the id
     */
    public ServerId(int id) {
        super("server");
        this.id = id;
    }

    /**
     * Instantiates a new Server id.
     *
     * @param takeString the take string
     */
    public ServerId(String takeString) {
        this(4321);
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof ServerId && equals((ServerId) obj);
    }

    /**
     * {@inheritDoc} @param other the other
     *
     * @return the boolean
     */
    public boolean equals(ServerId other) {
        return id == other.id;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return id;
    }

    public String toString() {
        return "server://" + id;
    }
}
