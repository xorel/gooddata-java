/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform.afm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.gooddata.transform.ObjQualifier;
import com.gooddata.transform.ObjUriQualifier;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SimpleMeasureDefinition.class, name = SimpleMeasureDefinition.NAME),
        @JsonSubTypes.Type(value = PopMeasureDefinition.class, name = PopMeasureDefinition.NAME)
})
public interface MeasureDefinition {

    /**
     * Returns the definition in the form of uri of {@link com.gooddata.md.Metric}.
     * Default implementation throws {@link UnsupportedOperationException}
     * @return uri of the measure
     */
    @JsonIgnore
    default String getUri() {
        throw new UnsupportedOperationException("This definition has no URI");
    }

    @JsonIgnore
    ObjQualifier getObjQualifier();

    MeasureDefinition withObjUriQualifier(ObjUriQualifier qualifier);

    @JsonIgnore
    boolean isAdHoc();
}
