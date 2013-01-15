package dk.dma.enav.service.general.subscribe;

import dk.dma.enav.model.MaritimeId;
import dk.dma.enav.model.geometry.Shape;

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

    private Shape shape;

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
    public Shape getShape() {
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
    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
