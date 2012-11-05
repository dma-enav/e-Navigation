package dk.dma.enav.messaging;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import dk.dma.enav.model.MaritimeId;
import dk.dma.enav.model.geometry.Position;
import dk.dma.enav.model.geometry.Shape;

public class MaritimeMessageMetadata {

    private static final String AUTHOR_ID = "author-id";

    /** The id of the ship or shore station that created the message. */
    private MaritimeId authorId;

    private Position authorPosition;

    /** The position of ship or shore station that created the message. */
    private static final String AUTHOR_POSITION = "author-position";

    private static final String CREATION_TIME = "creation-time";

    private Date creationTime = new Date();
    private static final String BROADCAST_AREA = "broadcast-area";

    private Shape broadcastArea;

    private BroadcastTTL broadcastTTL;

    @SuppressWarnings("unused")
    private static final String RECIPIENT_LIST = "recipient-list";

    List<Recipiant> recipiants = new ArrayList<>();

    private final Map<String, Object> properties;

    public MaritimeMessageMetadata() {
        properties = new HashMap<>();
    }

    MaritimeMessageMetadata(Map<String, Object> properties) {
        this.properties = requireNonNull(properties);
    }

    public MaritimeMessageMetadata clone() {
        return new MaritimeMessageMetadata(properties);
    }

    String getNonNull(String key) {
        return getNonNull(key, String.class);
    }

    @SuppressWarnings("unchecked")
    <T> T getNonNull(String key, Class<T> type) {
        return (T) properties.get(key);
    }

    public MaritimeId getAuthor() {
        return requireNonNull(authorId);
    }

    public MaritimeMessageMetadata broadcastTo(Shape shape) {
        return broadcastTo(shape, BroadcastTTL.INSTANT);
    }

    public MaritimeMessageMetadata broadcastTo(Shape shape, BroadcastTTL ttl) {
        return this;
    }

    public MaritimeMessageMetadata setAuthor(MaritimeId maritimeId) {
        this.authorId = requireNonNull(maritimeId);
        return this;
    }

    public MaritimeMessageMetadata addRecipient(MaritimeId id) {

        return this;
    }

    public MaritimeMessageMetadata addRecipient(MaritimeId id, Runnable callback, long timeout, TimeUnit unit) {

        return this;
    }

    MaritimeMessageMetadata with(String key, String value) {
        HashMap<String, Object> map = new HashMap<>(properties);
        map.put(requireNonNull(key, "key is null"), requireNonNull(value, "value is null"));
        return new MaritimeMessageMetadata(map);
    }

    @SuppressWarnings({ "unused", "rawtypes" })
    public String toString() {
        StringBuilder sb = new StringBuilder();
        append(sb, AUTHOR_ID, authorId);
        if (authorPosition != null) {
            append(sb, AUTHOR_POSITION, authorPosition);
        }
        append(sb, CREATION_TIME, creationTime);// format time
        if (broadcastArea != null) {
            append(sb, BROADCAST_AREA, broadcastArea);// format time
        }

        for (Map.Entry<String, Object> e : new TreeMap<>(properties).entrySet()) {// sort
            sb.append(e.getKey()).append(": ");
            Object v = e.getValue();
            if (v instanceof List) {
                for (Object o : (List) v) {

                }
            } else {
                sb.append(v);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
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
            if (broadcastTTL != null) {
                b += "?broadcast-ttl=" + broadcastTTL.toString();
            }
            result.put(BROADCAST_AREA, b);// format time
        }

        return result;
    }

    private static void append(StringBuilder sb, String key, Object o) {
        sb.append(key).append(": ").append(o).append(System.lineSeparator());
    }

    public abstract class Acknowledgement {

        public void acknowledged() {

        }
    }

    public static enum BroadcastTTL {
        INSTANT, COUPLE_OF_MINUTES;
    }

    // Metadata
    // Secure hash
    // Where did this message come from
    // who are we allowed to send the message to

    public static class Recipiant {
        MaritimeId id;
        Object callback;
        long timeout;
        TimeUnit unit;
    }
}
