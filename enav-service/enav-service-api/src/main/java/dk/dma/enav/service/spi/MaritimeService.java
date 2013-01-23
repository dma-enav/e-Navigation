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
package dk.dma.enav.service.spi;

import static java.util.Objects.requireNonNull;

import java.io.Serializable;

/**
 * 
 * @author Kasper Nielsen
 */
// Maaske skal den ikke vaere serializeable???
// Serveren skal ikke bruge den. kun nogle informationer derfra
public abstract class MaritimeService implements Serializable {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    private final String name;

    protected MaritimeService(String name) {
        this.name = requireNonNull(name);
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return "No Description";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}
