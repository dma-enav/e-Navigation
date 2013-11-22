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
package dk.dma.enav.maritimecloud.service.invocation;

import dk.dma.enav.model.MaritimeId;

/**
 * 
 * @author Kasper Nielsen
 */
public interface InvocationCallback<E, T> {

    /**
     * Processes the specified event.
     * 
     * @param e
     *            the message that was received
     * @param context
     *            the context that should be used to provide the result of the operation
     */
    void process(E message, Context<T> context);

    interface Context<T> {

        /**
         * Returns the caller id.
         * 
         * @return the id of the caller
         */
        MaritimeId getCaller();

        /**
         * Invoked if the operation completed successfully.
         * 
         * @param replyMessage
         *            the reply message to the caller, if T is Void null is the only valid parameter to this method
         */
        void complete(T replyMessage);

        /**
         * The caller did not have sufficient permissions to invoke the specified service.
         * 
         * @param message
         *            a helper message that will be provided to the client
         */
        void failWithIllegalAccess(String message);

        void failWithIllegalInput(String message);

        void failWithInternalError(String message);
    }
}
