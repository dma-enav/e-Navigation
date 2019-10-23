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

package dk.dma.enav.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateConverterTest {

    CoordinateConverter transformer;

    @Before
    public void setUp() {
        transformer = new CoordinateConverter(12, 56);
    }

    @Test
    public void testLon2x() throws Exception {
        assertEquals(0.0, transformer.lon2x(12, 56), 1e-10);
        assertEquals(6204.034306340757, transformer.lon2x(12.1, 56), 1e-10); // 
        assertEquals(0.0, transformer.lon2x(12, 56.1), 1e-10);
        assertEquals(-6204.034306340658, transformer.lon2x(11.9, 56), 1e-10);
        assertEquals(0.0, transformer.lon2x(12, 55.9), 1e-10);
    }

    @Test
    public void testLat2y() throws Exception {
        assertEquals(0.0, transformer.lat2y(12, 56), 1e-10);
        assertEquals(4.4884447780805115, transformer.lat2y(12.1, 56), 1e-10);
        assertEquals(11094.62855321888, transformer.lat2y(12, 56.1), 1e-10); // 
        assertEquals(4.4884447780805115, transformer.lat2y(11.9, 56), 1e-10);
        assertEquals(-11094.628553220642, transformer.lat2y(12, 55.9), 1e-10);
    }

    @Test
    public void testX2Lon() throws Exception {
        assertEquals(12.0, transformer.x2Lon(0.0, 0.0), 1e-10);
        assertEquals(12.1, transformer.x2Lon(6204.034306340757, 4.4884447780805115), 1e-10);
        assertEquals(12.0, transformer.x2Lon(0.0, 11094.62855321888), 1e-10);
        assertEquals(11.9, transformer.x2Lon(-6204.034306340658, 4.4884447780805115), 1e-10);
        assertEquals(12.0, transformer.x2Lon(0.0, -11094.628553220642), 1e-10);
    }

    @Test
    public void testY2Lat() throws Exception {
        assertEquals(56.0, transformer.y2Lat(0.0, 0.0), 1e-10);
        assertEquals(56.0, transformer.y2Lat(6204.034306340757, 4.4884447780805115), 1e-10);
        assertEquals(56.1, transformer.y2Lat(0.0, 11094.62855321888), 1e-10);
        assertEquals(56.0, transformer.y2Lat(-6204.034306340658, 4.4884447780805115), 1e-10);
        assertEquals(55.9, transformer.y2Lat(0.0, -11094.628553220642), 1e-10);
    }

}
