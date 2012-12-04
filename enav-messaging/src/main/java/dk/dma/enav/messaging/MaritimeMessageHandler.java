package dk.dma.enav.messaging;

/**
 * Handles a maritime message.
 * 
 * @param <T>
 *            the type of message to handle
 */
public interface MaritimeMessageHandler<T extends MaritimeMessage> {

    /**
     * Handles a message.
     * 
     * @param message
     *            the message to handle
     */
    void handle(T message);
}
