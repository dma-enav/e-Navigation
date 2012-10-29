package dk.dma.enav.model.voyage.endpoint;

import static java.util.Objects.requireNonNull;

import java.util.regex.Pattern;

public final class UnLocode {

    private final String unlocode;

    private static final Pattern PATTERN = Pattern.compile("[a-zA-Z]{2}[a-zA-z2-9]{3}");

    public UnLocode(String unlocode) {
        this.unlocode = requireNonNull(unlocode, "unlocode is null").toUpperCase();
        if (!PATTERN.matcher(unlocode).matches()) {
            throw new IllegalArgumentException(unlocode + " is not a valid UN/LOCODE (does not match pattern)");
        }
    }

    @Override
    public int hashCode() {
        return unlocode.hashCode();
    }

    /**
     * Equals method
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof UnLocode && equals((UnLocode) other);
    }

    public boolean equals(UnLocode other) {
        return other == this || (other != null && unlocode.equals(other.unlocode));
    }

}