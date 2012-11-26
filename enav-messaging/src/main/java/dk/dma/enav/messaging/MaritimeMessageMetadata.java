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
import dk.dma.enav.model.operator.OperatorId;

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
        // boer den vaere paa beskeden??
        // eller boer man kunne identifiere de enkelte frames?
        // Det er primaert taenkt til at kunne reply paa en besked
        // http://www.eaipatterns.com/RequestReplyJmsExample.html
        // http://docs.oracle.com/cd/E13171_01/alsb/docs25/interopjms/MsgIDPatternforJMS.html

    }

    /** The id of the ship or shore station that created the message. */

    // The person

    private Position authorPosition;

    private Shape broadcastArea;

    private BroadcastTTL broadcastTTL;

    // Er ikke sikker paa vi kan bruge denne til noget
    private final Date creationTime = new Date();

    /** The message id. */
    private final UUID id = UUID.randomUUID();

    /** An optional operator id (person authorizing the message) for the message. */
    private OperatorId operatorId;

    private final MaritimeMessageMetadata previous;

    List<Recipiant> recipiants = new ArrayList<>();

    /** The id of the ship or organization that created the message */
    private MaritimeId sourceId;

    // If broadcast will attempt to deliver it to new clients??
    // For how long time to try and deliver a message before failling
    private long timeToLive;

    // MS

    public MaritimeId getSourceId() {
        return sourceId;
    }

    public long getTimeToLive() {
        return timeToLive;
    }

    public MaritimeMessageMetadata() {
        this.previous = null;

    }

    public MaritimeMessageMetadata(MaritimeMessageMetadata previous) {
        this.previous = requireNonNull(previous);
    }

    public SortedMap<String, String> asString() {
        TreeMap<String, String> result = new TreeMap<>();
        result.put(AUTHOR_ID, operatorId.toString());
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

    public MaritimeId getAuthor() {
        return requireNonNull(operatorId);
    }

    // De her ting skal over i testbeden
    // Message metadata er udelukkende hvad der bliver sendt over wire.
    //
    // public MaritimeMessageMetadata addRecipient(MaritimeId id, Runnable callback, long timeout, TimeUnit unit) {
    //
    // return this;
    // }

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

    /**
     * Sets the id of the operator.
     * 
     * @param operatorId
     *            the id of the operator
     * @return this
     */
    public MaritimeMessageMetadata setOperatorId(OperatorId operatorId) {
        this.operatorId = requireNonNull(operatorId);
        return this;
    }

    public MaritimeMessageMetadata setRecipient(MaritimeId id) {
        return this;
    }

    public MaritimeMessageMetadata setRecipient(Shape broadcastArea) {
        return setRecipient(broadcastArea, BroadcastTTL.INSTANT);
    }

    public MaritimeMessageMetadata setRecipient(Shape broadcastArea, BroadcastTTL ttl) {
        this.broadcastArea = requireNonNull(broadcastArea);
        this.broadcastTTL = requireNonNull(ttl);
        return this;
    }

    public MaritimeMessageMetadata setSourceId(MaritimeId sourceId) {
        this.sourceId = sourceId;
        return this;
    }

    public static void main(String[] args) {
        double m = Integer.MAX_VALUE;
        System.out.println(m);
        System.out.println(TimeUnit.DAYS.convert((long) m, TimeUnit.MILLISECONDS));
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
