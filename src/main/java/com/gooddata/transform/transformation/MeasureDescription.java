/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform.transformation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gooddata.util.GoodDataToStringBuilder;

// TODO could be package private?
// todo name?
/**
 * Measure in transformation and its overrides
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MeasureDescription { // MeasureDescription

    private String measureIdentifier;
    private String alias;
    private String format;

    /**
     * Measure in transformation and its overrides
     * @param measureIdentifier internal link to measure in AFM
     * @param alias Overrides alias from AFM, if not specified identifier is used
     * @param format Overrides format from AFM
     */
    @JsonCreator
    public MeasureDescription(@JsonProperty("measureIdentifier") final String measureIdentifier,
                              @JsonProperty("alias") final String alias,
                              @JsonProperty("format") final String format) {
        this.measureIdentifier = measureIdentifier;
        this.alias = alias;
        this.format = format;
    }

    /**
     * Measure in transformation and its overrides, default alias and format
     * @param measureIdentifier internal link to measure in AFM
     */
    public MeasureDescription(final String measureIdentifier) {
        this.measureIdentifier = measureIdentifier;
    }

    /**
     * internal link to measure in AFM
     * @return link to measure
     */
    public String getMeasureIdentifier() {
        return measureIdentifier;
    }

    public void setMeasureIdentifier(final String measureIdentifier) {
        this.measureIdentifier = measureIdentifier;
    }

    /**
     * Overrides alias from AFM, if not specified identifier is used
     * @return alias
     */
    public String getAlias() {
        return alias;
    }

    public void setAlias(final String alias) {
        this.alias = alias;
    }

    /**
     * Overrides format from AFM
     * @return format
     */
    public String getFormat() {
        return format;
    }

    public void setFormat(final String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }
}
