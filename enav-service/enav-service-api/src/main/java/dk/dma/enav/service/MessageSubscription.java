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
package dk.dma.enav.service;

import dk.dma.enav.model.MaritimeId;
import dk.dma.enav.model.geometry.Area;


/**
 * Ide'en er at
 * 
 * @author Kasper Nielsen
 */
public class MessageSubscription {

    // Er det mon ikke en liste af services vi har behov for???
    // lige nu er det vel snare end en liste af messages
    private Class<?>[] messageTypes;

    // Think we will only circle shapes, or rectangles.
    // Otherwise where is the center
    private MaritimeId relativeTo;

    private Area shape;

    /**
     * @return the messageTypes
     */
    public Class<?>[] getMessageTypes() {
        return messageTypes;
    }

    /**
     * @return the relativeTo
     */
    public MaritimeId getRelativeTo() {
        return relativeTo;
    }

    /**
     * @return the shape
     */
    public Area getShape() {
        return shape;
    }

    /**
     * @param messageTypes
     *            the messageTypes to set
     */
    public void setMessageTypes(Class<?>[] messageTypes) {
        this.messageTypes = messageTypes;
    }

    /**
     * @param relativeTo
     *            the relativeTo to set
     */
    public void setRelativeTo(MaritimeId relativeTo) {
        this.relativeTo = relativeTo;
    }

    /**
     * @param shape
     *            the shape to set
     */
    public void setShape(Area shape) {
        this.shape = shape;
    }
}
