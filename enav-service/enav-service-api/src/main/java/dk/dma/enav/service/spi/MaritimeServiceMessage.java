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

import java.util.ServiceConfigurationError;

import dk.dma.enav.messaging.MaritimeMessage;

/**
 * 
 * @author Kasper Nielsen
 */
public abstract class MaritimeServiceMessage<T> extends MaritimeMessage {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    private final transient Class<? extends MaritimeService> serviceType;

    @SuppressWarnings("unchecked")
    public MaritimeServiceMessage() {
        this.serviceType = (Class<? extends MaritimeService>) requireNonNull(getClass().getDeclaringClass());
    }

    public String messageName() {
        String name = getClass().getSimpleName();
        return name;
    }

    public String serviceName() {
        try {
            return (String) serviceType().getField("NAME").get(null);
        } catch (ReflectiveOperationException e) {
            throw new ServiceConfigurationError("oops", e);
        }
    }

    /**
     * @return the serviceType
     */
    public Class<? extends MaritimeService> serviceType() {
        return serviceType;
    }
}
