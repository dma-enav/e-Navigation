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

import dk.dma.enav.model.MaritimeId;

/**
 * The type Mmsi id.
 *
 * @author Kasper Nielsen
 */
public class MmsiId extends MaritimeId {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private final int mmsi;

    /**
     * Instantiates a new Mmsi id.
     *
     * @param mmsi the mmsi
     */
    public MmsiId(int mmsi) {
        super("mmsi");
        this.mmsi = mmsi;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return mmsi;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof MmsiId && equals((MmsiId) obj);
    }

    /**
     * {@inheritDoc} @param other the other
     *
     * @return the boolean
     */
    public boolean equals(MmsiId other) {
        return mmsi == other.mmsi;
    }

    public String toString() {
        return "mmsi://" + mmsi;
    }

    // mmsi://102323233

    // enid://

    // area://box/
}
