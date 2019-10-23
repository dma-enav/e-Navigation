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
package dk.dma.enav.model.operator;

import dk.dma.enav.model.MaritimeId;

/**
 * The id of an {@link Operator}.
 */
public class OperatorId extends MaritimeId {

    /**
     * Instantiates a new Operator id.
     *
     */
    public OperatorId() {
        super("operator");
    }

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

}
