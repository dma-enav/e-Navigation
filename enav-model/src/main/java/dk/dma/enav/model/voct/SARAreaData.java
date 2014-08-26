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
package dk.dma.enav.model.voct;

import dk.dma.enav.model.geometry.Position;

public class SARAreaData {

    Position A;
    Position B;
    Position C;
    Position D;
    Position centre;
    double breadth;
    double length;

    public SARAreaData() {

    }

    /**
     * @param a
     * @param b
     * @param c
     * @param d
     * @param centre
     * @param breadth
     * @param length
     */
    public SARAreaData(Position a, Position b, Position c, Position d, Position centre, double breadth, double length) {
        A = a;
        B = b;
        C = c;
        D = d;
        this.centre = centre;
        this.breadth = breadth;
        this.length = length;
    }

    /**
     * @return the a
     */
    public Position getA() {
        return A;
    }

    /**
     * @param a
     *            the a to set
     */
    public void setA(Position a) {
        A = a;
    }

    /**
     * @return the b
     */
    public Position getB() {
        return B;
    }

    /**
     * @param b
     *            the b to set
     */
    public void setB(Position b) {
        B = b;
    }

    /**
     * @return the c
     */
    public Position getC() {
        return C;
    }

    /**
     * @param c
     *            the c to set
     */
    public void setC(Position c) {
        C = c;
    }

    /**
     * @return the d
     */
    public Position getD() {
        return D;
    }

    /**
     * @param d
     *            the d to set
     */
    public void setD(Position d) {
        D = d;
    }

    /**
     * @return the centre
     */
    public Position getCentre() {
        return centre;
    }

    /**
     * @param centre
     *            the centre to set
     */
    public void setCentre(Position centre) {
        this.centre = centre;
    }

    /**
     * @return the breadth
     */
    public double getBreadth() {
        return breadth;
    }

    /**
     * @param breadth
     *            the breadth to set
     */
    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }

    /**
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * @param length
     *            the length to set
     */
    public void setLength(double length) {
        this.length = length;
    }

}
