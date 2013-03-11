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
package dk.dma.enav.communication.service;

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
     */
    void process(E message, Context<T> context);

    interface Context<T> {

        /**
         * @param replyMessage
         *            the reply message to the caller, if T is Void null is the only valid parameter to this method
         */
        void complete(T replyMessage);

        void fail(FailureCode fc, String message);
    }

    enum FailureCode {
        IllegalAccess(1), InternalFailure(1);

        FailureCode(int code) {}
    }
}
