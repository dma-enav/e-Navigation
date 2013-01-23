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
package dk.dma.enav.model.voyage.endpoint;

import static java.util.Objects.requireNonNull;

import java.util.regex.Pattern;

public final class UnLocode {

    private static final Pattern PATTERN = Pattern.compile("[a-zA-Z]{2}[a-zA-z2-9]{3}");

    private final String unlocode;

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

    public boolean equals(UnLocode other) {
        return other == this || (other != null && unlocode.equals(other.unlocode));
    }

    @Override
    public int hashCode() {
        return unlocode.hashCode();
    }

}
