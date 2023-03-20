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

/**
 * The type Saris target.
 */
public class SARISTarget {

    private String name;
    private String formula;
    private double divergenceAngle;
    private String type;

    /**
     * Instantiates a new Saris target.
     */
    public SARISTarget() {

    }

    /**
     * Instantiates a new Saris target.
     *
     * @param name            the name
     * @param formula         the formula
     * @param divergenceAngle the divergence angle
     * @param type            the type
     */
    public SARISTarget(String name, String formula, double divergenceAngle, String type) {
        this.name = name;
        this.formula = formula;
        this.divergenceAngle = divergenceAngle;
        this.type = type;
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
     * Sets name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets formula.
     *
     * @return the formula
     */
    public String getFormula() {
        return formula;
    }

    /**
     * Sets formula.
     *
     * @param formula the formula to set
     */
    public void setFormula(String formula) {
        this.formula = formula;
    }

    /**
     * Gets divergence angle.
     *
     * @return the divergenceAngle
     */
    public double getDivergenceAngle() {
        return divergenceAngle;
    }

    /**
     * Sets divergence angle.
     *
     * @param divergenceAngle the divergenceAngle to set
     */
    public void setDivergenceAngle(double divergenceAngle) {
        this.divergenceAngle = divergenceAngle;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

}
