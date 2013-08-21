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
package dk.dma.enav.communication.service.exception;

/**
 * An error occurred while unregistering the service.
 * 
 * @author Kasper Nielsen
 */
public class ServiceUnregisterException extends ServiceException {

    /** The service that was unregistered was never registered. */
    public static final int SERVICE_NEVER_REGISTERED = 1;

    /** The error code. */
    private final int errorCode;

    // private final String service name???
    /**
     * Creates a new ServiceUnregisterException.
     * 
     * @param errorCode
     *            the error code
     */
    public ServiceUnregisterException(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Returns the error code.
     * 
     * @return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }
}
