package dk.dma.enav.messaging;


/**
 * Handles an incoming message.
 * 
 * @param <T>
 *            the type of message
 */
public interface MessageHandler<T extends MaritimeMessage> {
    void process(T message, MessageMetadata properties);
}
