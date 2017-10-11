/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform.afm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.gooddata.transform.ObjQualifier;
import com.gooddata.transform.ObjUriQualifier;
import com.gooddata.util.GoodDataToStringBuilder;

import static com.gooddata.transform.afm.PopMeasureDefinition.NAME;

@JsonRootName(NAME)
public class PopMeasureDefinition implements MeasureDefinition {

    static final String NAME = "popMeasure";

    private final String measureIdentifier;

    private final ObjQualifier popAttribute;

    public PopMeasureDefinition(@JsonProperty("measureIdentifier") final String measureIdentifier,
                                @JsonProperty("popAttribute") final ObjQualifier popAttribute) {
        this.measureIdentifier = measureIdentifier;
        this.popAttribute = popAttribute;
    }

    @Override
    public MeasureDefinition withObjUriQualifier(final ObjUriQualifier qualifier) {
        return new PopMeasureDefinition(measureIdentifier, qualifier);
    }

    @Override
    public boolean isAdHoc() {
        return false; // todo
    }

    public String getMeasureIdentifier() {
        return measureIdentifier;
    }

    public ObjQualifier getPopAttribute() {
        return popAttribute;
    }

    @Override
    public ObjQualifier getObjQualifier() {
        return getPopAttribute();
    }

    @Override
    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }
}
