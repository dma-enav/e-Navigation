/* Copyright (c) 2011 Danish Maritime Authority.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dk.dma.enav.model.voyage.endpoint;

import static java.util.Objects.requireNonNull;

import java.util.regex.Pattern;

/**
 * The type Un locode.
 */
public final class UnLocode {

    private static final Pattern PATTERN = Pattern.compile("[a-zA-Z]{2}[a-zA-z2-9]{3}");

    private final String unlocode;

    /**
     * Instantiates a new Un locode.
     *
     * @param unlocode the unlocode
     */
    public UnLocode(String unlocode) {
        this.unlocode = requireNonNull(unlocode, "unlocode is null").toUpperCase();
        if (!PATTERN.matcher(unlocode).matches()) {
            throw new IllegalArgumentException(unlocode + " is not a valid UN/LOCODE (does not match pattern)");
        }
    }

    /**
     * Equals method
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof UnLocode && equals((UnLocode) other);
    }

    /**
     * Equals boolean.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean equals(UnLocode other) {
        return other == this || (other != null && unlocode.equals(other.unlocode));
    }

    @Override
    public int hashCode() {
        return unlocode.hashCode();
    }

}
