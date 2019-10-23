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
package dk.dma.enav.model;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Class to represent a country by its assigned MID's (Maritime Identification Digits) in addition to its ISO 3166
 * identification.
 * <p>
 * @see  <a href="http://en.wikipedia.org/wiki/Maritime_Mobile_Service_Identity">http://en.wikipedia.org/wiki/Maritime_Mobile_Service_Identity</a>
 */
public final class Country implements Serializable, Comparable<Country> {

    private static final long serialVersionUID = 1L;

    private static final String LOCATION = Country.class.getPackage().getName().replace(".", "/")
            + "/country.properties";

    /**
     * The Mid country map.
     */
    static final HashMap<Integer, Country> MID_COUNTRY_MAP = new HashMap<>();
    /**
     * The Three letter map.
     */
    static final HashMap<String, Country> THREE_LETTER_MAP = new HashMap<>();
    /**
     * The Two letter map.
     */
    static final HashMap<String, Country> TWO_LETTER_MAP = new HashMap<>();

    static {
        Properties props = new Properties();
        URL url = ClassLoader.getSystemResource(LOCATION);
        if (url == null) {
            url = Thread.currentThread().getContextClassLoader().getResource(LOCATION);
        }
        if (url == null) {
            throw new Error("Could not locate " + LOCATION + " on classpath");
        }
        try {
            props.load(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new Error("Failed to load country.properties: " + e.getMessage());
        }

        for (Object key : props.keySet()) {
            String a2 = (String) key;
            String val = props.getProperty(a2);
            String[] elems = val.split("\\|");
            Country country = new Country(elems[0], a2, elems[1], elems[2]);
            if (elems.length > 3) {
                String[] strMids = elems[3].split(",");
                for (String strMid : strMids) {
                    Integer mid = Integer.parseInt(strMid);
                    country.addMid(mid);
                    MID_COUNTRY_MAP.put(mid, country);
                }
            }
            TWO_LETTER_MAP.put(country.getTwoLetter(), country);
            THREE_LETTER_MAP.put(country.getThreeLetter(), country);
        }
    }

    private final HashSet<Integer> mids = new HashSet<>();

    /**
     * The Name.
     */
    protected final String name;

    /**
     * The Number.
     */
    protected final String number;
    /**
     * The Three letter.
     */
    protected final String threeLetter;
    /**
     * The Two letter.
     */
    protected final String twoLetter;

    private Country(String name, String twoLetter, String threeLetter, String number) {
        this.name = name;
        this.twoLetter = twoLetter;
        this.threeLetter = threeLetter;
        this.number = number;
    }

    /**
     * Add mid.
     *
     * @param mid the mid
     */
    void addMid(int mid) {
        mids.add(mid);
    }

    @Override
    public boolean equals(Object obj) {
        return this.threeLetter.equals(((Country) obj).getThreeLetter());
    }

    /**
     * Gets mids.
     *
     * @return the mids
     */
    public HashSet<Integer> getMids() {
        return mids;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets number.
     *
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Gets three letter.
     *
     * @return the three letter
     */
    public String getThreeLetter() {
        return threeLetter;
    }

    /**
     * Gets two letter.
     *
     * @return the two letter
     */
    public String getTwoLetter() {
        return twoLetter;
    }

    @Override
    public int hashCode() {
        return twoLetter.hashCode();
    }

    /**
     * Match mid boolean.
     *
     * @param mid the mid
     * @return the boolean
     */
    public boolean matchMid(int mid) {
        return mids.contains(mid);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[name=");
        builder.append(name);
        builder.append(", number=");
        builder.append(number);
        builder.append(", threeLetter=");
        builder.append(threeLetter);
        builder.append(", twoLetter=");
        builder.append(twoLetter);
        builder.append(", mids=");
        builder.append(mids);
        builder.append("]");
        return builder.toString();
    }

    /**
     * Get MidCountry by ISO 3166 two or three letter code
     *
     * @param code the code
     * @return by code
     */
    public static Country getByCode(String code) {
        if (code.length() == 2) {
            return TWO_LETTER_MAP.get(code);
        }
        return THREE_LETTER_MAP.get(code);
    }

    /**
     * Get MidCountry by MID
     *
     * @param mid the mid
     * @return by mid
     */
    public static Country getByMid(int mid) {
        Country country = MID_COUNTRY_MAP.get(mid);
        if (country == null) {
            // LOG.debug("Unknown MID " + mid);
        }
        return country;
    }

    /**
     * Gets country for mmsi.
     *
     * @param mmsi the mmsi
     * @return the country for mmsi
     */
    public static Country getCountryForMmsi(Integer mmsi) {
        String str = Integer.toString(mmsi);
        if (str.length() == 9) {
            str = str.substring(0, 3);
            return getByMid(Integer.parseInt(str));
        }
        return null;
    }

    /**
     * Gets mid map.
     *
     * @return the mid map
     */
    public static Map<Integer, Country> getMidMap() {
        return Collections.unmodifiableMap(MID_COUNTRY_MAP);
    }

    /**
     * Find all by code list.
     *
     * @param countries the countries
     * @return the list
     */
    public static List<Country> findAllByCode(String... countries) {
        final List<Country> c = new ArrayList<>();
        for (String s : countries) {
            Country co = Country.getByCode(s);
            if (co == null) {
                throw new IllegalArgumentException("Unknown country: " + s);
            }
            c.add(co);
        }
        return c;
    }

    /** {@inheritDoc} */
    @Override
    public int compareTo(Country o) {
        return threeLetter.compareTo(o.threeLetter);
    }
}
