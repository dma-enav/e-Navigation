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
package dk.dma.enav.communication.service.spi;


/**
 * 
 * @author Kasper Nielsen
 */
// Maaske skal den ikke vaere serializeable???
// Serveren skal ikke bruge den. kun nogle informationer derfra
public abstract class MaritimeService {

    private final String name;

    protected MaritimeService() {
        // try {
        // this.name = (String) getClass().getField("NAME").get(null);
        // } catch (ReflectiveOperationException e) {
        // throw new ServiceConfigurationError("oops", e);
        // }
        this.name = getClass().getCanonicalName();

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
