package dk.dma.enav.messaging;

import static dk.dma.enav.messaging.MetadataProperties.AUTHOR_ID;
import static dk.dma.enav.messaging.MetadataProperties.AUTHOR_POSITION;
import static dk.dma.enav.messaging.MetadataProperties.BROADCAST_AREA;
import static dk.dma.enav.messaging.MetadataProperties.CREATION_TIME;
import static java.util.Objects.requireNonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import dk.dma.enav.model.MaritimeId;
import dk.dma.enav.model.geometry.Position;
import dk.dma.enav.model.geometry.Shape;

/**
 * MaritimeMessageMetadata is metadata information that is being sent around with a message.
 * 
 * @author Kasper Nielsen
 */
public class MaritimeMessageMetadata implements Serializable {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    static {
        // we want to use MAC based uuids not random
        // InetAddress ip = InetAddress.getLocalHost();
        // NetworkInterface network = NetworkInterface.getByInetAddress(ip);
        // byte[] mac = network.getHardwareAddress();
    }

    /** The id of the ship or shore station that created the message. */
    private MaritimeId authorId;

    private Position authorPosition;

    private Shape broadcastArea;

    private BroadcastTTL broadcastTTL;

    // Er ikke sikker paa vi kan bruge denne til noget
    private final Date creationTime = new Date();

    /** The message id. */
    // boer den vaere paa beskeden??
    // eller boer man kunne identifiere de enkelte frames?
    // Det er primaert taenkt til at kunne reply paa en besked
    private final UUID id = UUID.randomUUID();

    private final MaritimeMessageMetadata previous;

    List<Recipiant> recipiants = new ArrayList<>();

    public MaritimeMessageMetadata() {
        this.previous = null;

    }

    public MaritimeMessageMetadata(MaritimeMessageMetadata previous) {
        this.previous = requireNonNull(previous);
    }

    public MaritimeMessageMetadata addRecipient(MaritimeId id) {
        return this;
    }

    // De her ting skal over i testbeden
    // Message metadata er udelukkende hvad der bliver sendt over wire.
    //
    public MaritimeMessageMetadata addRecipient(MaritimeId id, Runnable callback, long timeout, TimeUnit unit) {

        return this;
    }

    public SortedMap<String, String> asString() {
        TreeMap<String, String> result = new TreeMap<>();
        result.put(AUTHOR_ID, authorId.toString());
        if (authorPosition != null) {
            result.put(AUTHOR_POSITION, authorPosition.toString());
        }
        result.put(CREATION_TIME, creationTime.toString());// format time
        if (broadcastArea != null) {
            String b = broadcastArea.toString();
            b += "?broadcast-ttl=" + broadcastTTL.toString();
            result.put(BROADCAST_AREA, b);// format time
        }

        return result;
    }

    public MaritimeMessageMetadata broadcastTo(Shape broadcastArea) {
        return broadcastTo(broadcastArea, BroadcastTTL.INSTANT);
    }

    public MaritimeMessageMetadata broadcastTo(Shape broadcastArea, BroadcastTTL ttl) {
        this.broadcastArea = requireNonNull(broadcastArea);
        this.broadcastTTL = requireNonNull(ttl);
        return this;
    }

    public MaritimeId getAuthor() {
        return requireNonNull(authorId);
    }

    public Shape getBroadcastArea() {
        return broadcastArea;
    }

    public BroadcastTTL getBroadcastTTL() {
        return broadcastTTL;
    }

    public UUID getId() {
        return id;
    }

    public MaritimeMessageMetadata getPrevious() {
        return previous;
    }

    public MaritimeMessageMetadata getRoot() {
        MaritimeMessageMetadata root = this;
        while (root.previous != null) {
            root = root.previous;
        }
        return root;
    }

    public MaritimeMessageMetadata setAuthor(MaritimeId maritimeId) {
        this.authorId = requireNonNull(maritimeId);
        return this;
    }

    public abstract class Acknowledgement {

        public void acknowledged() {

        }
    }

    public static enum BroadcastTTL {
        COUPLE_OF_MINUTES, INSTANT;
    }

    // Metadata
    // Secure hash
    // Where did this message come from
    // who are we allowed to send the message to

    public static class Recipiant {
        Object callback;
        MaritimeId id;
        long timeout;
        TimeUnit unit;
    }

    //
    // @SuppressWarnings({ "unused", "rawtypes" })
    // public String toString() {
    // StringBuilder sb = new StringBuilder();
    // append(sb, AUTHOR_ID, authorId);
    // if (authorPosition != null) {
    // append(sb, AUTHOR_POSITION, authorPosition);
    // }
    // append(sb, CREATION_TIME, creationTime);// format time
    // if (broadcastArea != null) {
    // append(sb, BROADCAST_AREA, broadcastArea);// format time
    // }
    //
    // for (Map.Entry<String, Object> e : new TreeMap<>(properties).entrySet()) {// sort
    // sb.append(e.getKey()).append(": ");
    // Object v = e.getValue();
    // if (v instanceof List) {
    // for (Object o : (List) v) {
    //
    // }
    // } else {
    // sb.append(v);
    // }
    // sb.append(System.lineSeparator());
    // }
    // return sb.toString();
    // }

}
