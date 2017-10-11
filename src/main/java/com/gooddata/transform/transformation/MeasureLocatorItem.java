/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform.transformation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Holds metric position
 */
@JsonTypeInfo(include = As.WRAPPER_OBJECT, use = Id.NAME)
@JsonTypeName("measureLocatorItem") // todo metric?
public class MeasureLocatorItem implements LocatorItem {
    private final String measureIdentifier;

    @JsonCreator
    public MeasureLocatorItem(
            @JsonProperty("measureIdentifier") final String measureIdentifier) {
        this.measureIdentifier = measureIdentifier;
    }

    public String getMeasureIdentifier() {
        return measureIdentifier;
    }

    @Override
    public String toString() {
        return measureIdentifier;
    }
//    @Override
//    public Locator toLocator(List<Grid.MetricElement> metrics) {
//        if (measureIdentifier + 1 > metrics.size() || measureIdentifier < 0) {
//            throw new IllegalStateException("Invalid measureIdentifier");
//        }
//        return new Locator.MetricLocator(metrics.get(measureIdentifier).getUri());
//    }
}
