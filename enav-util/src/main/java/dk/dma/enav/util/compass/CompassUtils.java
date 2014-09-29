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

/**
 * A collection of utility functions related to compass-based navigation.
 */
public final class CompassUtils {

    /**
     * Compute the absolute difference (in degrees) between two directions.
     * @param dir1 Direction no. 1 - measured in degrees [0; 360);
     * @param dir2 Direction no. 2 - measured in degrees [0; 360);
     * @return the absolute difference between dir1 and dir2 [0; 180).
     */
    @SuppressWarnings("unused")
    public static float absoluteDirectionalDifference(float dir1, float dir2) {
        dir1 = directionInCompassRange(dir1);
        dir2 = directionInCompassRange(dir2);

        float diff = dir1>dir2 ? dir1-dir2 : dir2-dir1;

        if (diff >= 180.0) {
            diff = 360.0f - diff;
        }

        return diff;
    }

    /**
     * Convert the input to a number of degrees lying inside the compass
     * circle. E.g. -45 -> 315 or 370 -> 10.
     *
     * Or: Map any float point number into the set [0; 360).
     *
     * @param degrees the no. degrees given as input
     * @return the corresponding no. of degrees inside the compass circle.
     */
    @SuppressWarnings("unused")
    public static float directionInCompassRange(float degrees) {
        degrees = degrees % 360.0f;
        if (degrees < 0.0) {
            degrees += 360.0f;
        }
        return degrees;
    }

    /**
     * Converts a compass heading (0-360 degrees, 0 north) to a
     * cartesian angle (0-360, 0 along x-axis).
     *
     * @param a
     * @return
     */
    public static double compass2cartesian(double a) {
        double cartesianAngle;

        if ((a >= 0.0) && (a <= 90.0)) {
            cartesianAngle = 90.0 - a;
        } else {
            cartesianAngle = 450.0 - a;
        }
        return cartesianAngle;
    }

    /**
     * The opposite transformation of compass2cartesian.
     *
     * @param a
     * @return
     */
    public static double cartesian2compass(double a) {
        return compass2cartesian(a);
    }

}
