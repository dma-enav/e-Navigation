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

package dk.dma.enav.util.compass;

import org.junit.Test;

import static dk.dma.enav.util.compass.CompassUtils.absoluteDirectionalDifference;
import static dk.dma.enav.util.compass.CompassUtils.cartesian2compass;
import static dk.dma.enav.util.compass.CompassUtils.compass2cartesian;
import static dk.dma.enav.util.compass.CompassUtils.directionInCompassRange;
import static org.junit.Assert.assertEquals;

public class CompassUtilsTest {

    @Test
    public void testAbsoluteDirectionalDifference() {
        assertEquals(0f, absoluteDirectionalDifference(0f, 0f), 1e-16);
        assertEquals(45f, absoluteDirectionalDifference(0f, 45f), 1e-16);
        assertEquals(45f, absoluteDirectionalDifference(45f, 0f), 1e-16);
        assertEquals(180f, absoluteDirectionalDifference(180f, 0f), 1e-16);
        assertEquals(180f, absoluteDirectionalDifference(0f, 180f), 1e-16);
        assertEquals(90f, absoluteDirectionalDifference(0f, 270f), 1e-16);
        assertEquals(90f, absoluteDirectionalDifference(270f, 0f), 1e-16);
        assertEquals(1f, absoluteDirectionalDifference(0f, 359f), 1e-16);
        assertEquals(1f, absoluteDirectionalDifference(359f, 0f), 1e-16);
        assertEquals(2f, absoluteDirectionalDifference(1f, 359f), 1e-16);
        assertEquals(2f, absoluteDirectionalDifference(359f, 1f), 1e-16);
    }

    @Test
    public void testDirectionInCompassRange() {
        assertEquals(0f, directionInCompassRange(0f), 1e-16);
        assertEquals(90f, directionInCompassRange(90f), 1e-16);
        assertEquals(180f, directionInCompassRange(180f), 1e-16);
        assertEquals(270f, directionInCompassRange(270f), 1e-16);
        assertEquals(0f, directionInCompassRange(360f), 1e-16);
        assertEquals(0f, directionInCompassRange(720f), 1e-16);
        assertEquals(315f, directionInCompassRange(-45f), 1e-16);
        assertEquals(270f, directionInCompassRange(-90f), 1e-16);
    }

    @Test
    public void testCompass2cartesianAndCartesian2compass() {
        assertEquals(90.0, compass2cartesian(0.0), 1e-10);
        assertEquals(0.0, compass2cartesian( 90.0), 1e-10);
        assertEquals(270.0, compass2cartesian(180.0), 1e-10);
        assertEquals(180.0, compass2cartesian(270.0), 1e-10);

        assertEquals(90.0, cartesian2compass(  0.0), 1e-10);
        assertEquals(0.0, cartesian2compass( 90.0), 1e-10);
        assertEquals(270.0, cartesian2compass(180.0), 1e-10);
        assertEquals(180.0, cartesian2compass(270.0), 1e-10);

        assertEquals(37.0, compass2cartesian(cartesian2compass(37.0)), 1e-10);
        assertEquals(117.0, compass2cartesian(cartesian2compass(117.0)), 1e-10);
        assertEquals(273.0, compass2cartesian(cartesian2compass(273.0)), 1e-10);
        assertEquals(92.0, compass2cartesian(cartesian2compass(92.0)), 1e-10);
        assertEquals(359.0, compass2cartesian(cartesian2compass(359.0)), 1e-10);
    }

}
