/*
 * Copyright (c) 2008 Kasper Nielsen.
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
package dk.dma.enav.service.spi;

import static java.util.Objects.requireNonNull;

import java.io.Serializable;

/**
 * 
 * @author Kasper Nielsen
 */
// Maaske skal den ikke vaere serializeable???
// Serveren skal ikke bruge den. kun nogle informationer derfra
public abstract class MaritimeService implements Serializable {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    private final String name;

    protected MaritimeService(String name) {
        this.name = requireNonNull(name);
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return "No Description";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}
