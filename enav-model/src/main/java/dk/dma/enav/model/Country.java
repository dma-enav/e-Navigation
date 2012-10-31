/* Copyright (c) 2011 Danish Maritime Safety Administration
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
package dk.dma.enav.model;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;

/**
 * Class to represent a country by its assigned MID's (Maritime Identification Digits) in addition to its ISO 3166
 * identification.
 * 
 * See {@link http://en.wikipedia.org/wiki/Maritime_Mobile_Service_Identity}
 * 
 */
public class Country implements Serializable {
    private static final String LOCATION = Country.class.getPackage().getName().replace(".", "/")
            + "/country.properties";

    static HashMap<Integer, Country> midCountryMap = new HashMap<>();
    private static final long serialVersionUID = 1L;
    static HashMap<String, Country> threeLetterMap = new HashMap<>();

    static HashMap<String, Country> twoLetterMap = new HashMap<>();

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
                    midCountryMap.put(mid, country);
                }
            }
            twoLetterMap.put(country.getTwoLetter(), country);
            threeLetterMap.put(country.getThreeLetter(), country);
        }
    }

    private final HashSet<Integer> mids = new HashSet<>();

    protected String name;

    protected String number;
    protected String threeLetter;
    protected String twoLetter;

    protected Country(String name, String twoLetter, String threeLetter, String number) {
        this.name = name;
        this.twoLetter = twoLetter;
        this.threeLetter = threeLetter;
        this.number = number;
    }

    void addMid(int mid) {
        mids.add(mid);
    }

    @Override
    public boolean equals(Object obj) {
        return this.twoLetter.equals(((Country) obj).getTwoLetter());
    }

    public HashSet<Integer> getMids() {
        return mids;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getThreeLetter() {
        return threeLetter;
    }

    public String getTwoLetter() {
        return twoLetter;
    }

    @Override
    public int hashCode() {
        return twoLetter.hashCode();
    }

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
     * @param code
     * @return
     */
    public static Country getByCode(String code) {
        if (code.length() == 2) {
            return twoLetterMap.get(code);
        }
        return threeLetterMap.get(code);
    }

    /**
     * Get MidCountry by MID
     * 
     * @param mid
     * @return
     */
    public static Country getByMid(int mid) {
        Country country = midCountryMap.get(mid);
        if (country == null) {
            // LOG.debug("Unknown MID " + mid);
        }
        return country;
    }

    public static Country getCountryForMmsi(Long mmsi) {
        Country country = null;
        String str = Long.toString(mmsi);
        if (str.length() == 9) {
            str = str.substring(0, 3);
            country = getByMid(Integer.parseInt(str));
        }
        return country;
    }

}
