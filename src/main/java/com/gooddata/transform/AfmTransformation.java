/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.gooddata.transform.afm.ObjectAfm;
import com.gooddata.transform.transformation.Transformation;
import com.gooddata.util.GoodDataToStringBuilder;

/**
 * Represents structure for triggering AFM (Attributes Filters Metrics) transformation.
 */
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("afmTransformation")
public class AfmTransformation {

    private final ObjectAfm afm;
    private Transformation transformation;

    @JsonCreator
    public AfmTransformation(@JsonProperty("afm") final ObjectAfm afm,
                             @JsonProperty("transformation") final Transformation transformation) {
        this.afm = afm;
        this.transformation = transformation;
    }

    public AfmTransformation(final ObjectAfm afm) {
        this.afm = afm;
    }

    public ObjectAfm getAfm() {
        return afm;
    }

    public Transformation getTransformation() {
        return transformation;
    }

    public void setTransformation(final Transformation transformation) {
        this.transformation = transformation;
    }

    @Override
    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }
}
