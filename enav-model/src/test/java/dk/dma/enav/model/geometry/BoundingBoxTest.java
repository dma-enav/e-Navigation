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

package dk.dma.enav.model.geometry;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoundingBoxTest {

    @Test
    public void getArea() {
        // http://www.movable-type.co.uk/scripts/latlong.html
        assertEquals(1919819.125 /* ~ 1.853*1.036*1e6 */, BoundingBox.create(Position.create(56.0, 10.0), Position.create(56.016667, 10.016667), CoordinateSystem.CARTESIAN).getArea(), 1e-3);
        assertEquals(3423583.500 /* ~ 1.853*1.848*1e6 */, BoundingBox.create(Position.create(56.0, 10.0), Position.create(56.016667, 10.029722), CoordinateSystem.CARTESIAN).getArea(), 1e-3);
    }

}
