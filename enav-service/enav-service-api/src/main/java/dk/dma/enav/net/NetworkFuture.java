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
package dk.dma.enav.net;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author Kasper Nielsen
 */
public interface NetworkFuture<T> {

    /**
     * Returns {@code true} if completed in any fashion: normally, exceptionally, or via cancellation.
     * 
     * @return {@code true} if completed
     */
    boolean isDone();

    /**
     * Waits if necessary for the computation to complete, and then retrieves its result.
     * 
     * @return the computed result
     * @throws CancellationException
     *             if the computation was cancelled
     * @throws ExecutionException
     *             if the computation threw an exception
     * @throws InterruptedException
     *             if the current thread was interrupted while waiting
     */
    T get() throws InterruptedException, ExecutionException;

    /**
     * Waits if necessary for at most the given time for completion, and then retrieves its result, if available.
     * 
     * @param timeout
     *            the maximum time to wait
     * @param unit
     *            the time unit of the timeout argument
     * @return the computed result
     * @throws CancellationException
     *             if the computation was cancelled
     * @throws ExecutionException
     *             if the computation threw an exception
     * @throws InterruptedException
     *             if the current thread was interrupted while waiting
     * @throws TimeoutException
     *             if the wait timed out
     */
    T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;

    /**
     * Returns the result value (or throws any encountered exception) if completed, else returns the given
     * valueIfAbsent.
     * 
     * @param valueIfAbsent
     *            the value to return if not completed
     * @return the result value, if completed, else the given valueIfAbsent
     * @throws CancellationException
     *             if the computation was cancelled
     * @throws CompletionException
     *             if a completion computation threw an exception
     */
    T getNow(T valueIfAbsent);

    // Returns how long time this have been running
    // long getLatency(TimeUnit unit);
}
