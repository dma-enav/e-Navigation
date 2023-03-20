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

/**
 * The type Sar area data.
 */
public class SARAreaData {

    /**
     * The A.
     */
    Position A;
    /**
     * The B.
     */
    Position B;
    /**
     * The C.
     */
    Position C;
    /**
     * The D.
     */
    Position D;
    /**
     * The Centre.
     */
    Position centre;
    /**
     * The Breadth.
     */
    double breadth;
    /**
     * The Length.
     */
    double length;

    /**
     * Instantiates a new Sar area data.
     */
    public SARAreaData() {

    }

    /**
     * Instantiates a new Sar area data.
     *
     * @param a       the a
     * @param b       the b
     * @param c       the c
     * @param d       the d
     * @param centre  the centre
     * @param breadth the breadth
     * @param length  the length
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
     * Gets a.
     *
     * @return the a
     */
    public Position getA() {
        return A;
    }

    /**
     * Sets a.
     *
     * @param a the a to set
     */
    public void setA(Position a) {
        A = a;
    }

    /**
     * Gets b.
     *
     * @return the b
     */
    public Position getB() {
        return B;
    }

    /**
     * Sets b.
     *
     * @param b the b to set
     */
    public void setB(Position b) {
        B = b;
    }

    /**
     * Gets c.
     *
     * @return the c
     */
    public Position getC() {
        return C;
    }

    /**
     * Sets c.
     *
     * @param c the c to set
     */
    public void setC(Position c) {
        C = c;
    }

    /**
     * Gets d.
     *
     * @return the d
     */
    public Position getD() {
        return D;
    }

    /**
     * Sets d.
     *
     * @param d the d to set
     */
    public void setD(Position d) {
        D = d;
    }

    /**
     * Gets centre.
     *
     * @return the centre
     */
    public Position getCentre() {
        return centre;
    }

    /**
     * Sets centre.
     *
     * @param centre the centre to set
     */
    public void setCentre(Position centre) {
        this.centre = centre;
    }

    /**
     * Gets breadth.
     *
     * @return the breadth
     */
    public double getBreadth() {
        return breadth;
    }

    /**
     * Sets breadth.
     *
     * @param breadth the breadth to set
     */
    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }

    /**
     * Gets length.
     *
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets length.
     *
     * @param length the length to set
     */
    public void setLength(double length) {
        this.length = length;
    }

}
