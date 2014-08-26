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

package dk.dma.enav.safety;

import dk.dma.enav.model.geometry.Ellipse;
import dk.dma.enav.model.geometry.Position;
import org.junit.Ignore;
import org.junit.Test;

import static java.lang.Math.abs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SafetyZonesTest {

    private final Position position = Position.create(56, 12);

    @Test
    public void safetyZoneXYAreTranslatedForwardX() {
        Ellipse ellipse = SafetyZones.safetyZone(position, position, 90.0f, 0.0f, 100.0f, 15.0f, 33, 6);
        assertEquals(42.0, ellipse.getX(), 1e-6);
        assertEquals(-1.5, ellipse.getY(), 1e-6);
    }

    @Test
    public void safetyZoneXYAreTranslatedForwardY() {
        Ellipse ellipse = SafetyZones.safetyZone(position, position, 0.0f, 0.0f, 100.0f, 15.0f, 33, 6);
        assertEquals(1.5, ellipse.getX(), 1e-6);    // Small number
        assertEquals(42.0, ellipse.getY(), 1e-6);  // Large number
    }

    @Test @Ignore
    public void safetyZoneAtSpeedZeroIsSameSizeAsShip() {
        // TODO Make safety zone depend on sog
    }

    @Test @Ignore
    public void safetyZoneAtPositiveSpeedIsBiggerThanSizeAsShip() {
        // TODO Make safety zone depend on sog
    }

    @Test
    public void safetyZoneXYAreBigForDistantPositions() {
        Ellipse ellipse1 = SafetyZones.safetyZone(Position.create(57, 12), Position.create(56, 12), 90.0f, 0.0f, 100.0f, 15.0f, 65.0f, 5.5f);
        assertTrue(abs(ellipse1.getX()) < 1000);
        assertTrue(abs(ellipse1.getY()) > 10000);

        Ellipse ellipse2 = SafetyZones.safetyZone(Position.create(56, 13), Position.create(56, 12), 90.0f, 0.0f, 100.0f, 15.0f, 65.0f, 5.5f);
        assertTrue(abs(ellipse2.getX()) > 10000);
        assertTrue(abs(ellipse2.getY()) < 1000);
    }

    @Test
    public void testComputeSafetyZone() {
        Ellipse safetyEllipse = SafetyZones.safetyZone(position, position, 90.0f, 0.0f, 100.0f, 15.0f, 65.0f, 5.5f);

        assertEquals(10.0, safetyEllipse.getX(), 1e-6);
        assertEquals(-2.0, safetyEllipse.getY(), 1e-6);
        assertEquals(22.5, safetyEllipse.getBeta(), 1e-6);
        assertEquals(100.0, safetyEllipse.getAlpha(), 1e-6);
        assertEquals(0.0, safetyEllipse.getThetaDeg(), 1e-6);
    }

}
