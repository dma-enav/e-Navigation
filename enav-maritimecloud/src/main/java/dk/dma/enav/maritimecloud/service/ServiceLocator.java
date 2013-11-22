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
package dk.dma.enav.maritimecloud.service;

import java.util.List;

import dk.dma.enav.maritimecloud.ConnectionFuture;
import dk.dma.enav.maritimecloud.service.spi.ServiceMessage;

/**
 * 
 * @author Kasper Nielsen
 */
public interface ServiceLocator<T, E extends ServiceMessage<T>> {

    /**
     * Limits the result to services with the specified distance
     * 
     * @param meters
     *            the distance in meters
     * @return a new service locator
     */
    ServiceLocator<T, E> withinDistanceOf(int meters);

    /**
     * Returns the nearest service end point to the clients current position.
     * 
     * @return the nearest service end point to the clients current position
     */
    ConnectionFuture<ServiceEndpoint<E, T>> nearest();

    /**
     * Returns a list of multiple service end points to the clients current position.
     * 
     * @param limit
     *            the maximum number of service end points to return
     * @return a list of multiple service end points to the clients current position
     */
    ConnectionFuture<List<ServiceEndpoint<E, T>>> nearest(int limit);

}
