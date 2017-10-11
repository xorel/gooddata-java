/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * Covers all the filters which can be used within AFM or Transformation
 */
@JsonSubTypes({
        @JsonSubTypes.Type(value = PositiveAttributeFilter.class, name = PositiveAttributeFilter.NAME),
        @JsonSubTypes.Type(value = NegativeAttributeFilter.class, name = NegativeAttributeFilter.NAME),
        @JsonSubTypes.Type(value = AbsoluteDateFilter.class, name = AbsoluteDateFilter.NAME),
        @JsonSubTypes.Type(value = RelativeDateFilter.class, name = RelativeDateFilter.NAME)
})
public interface FilterItem extends CompatibilityFilter {


    @JsonIgnore
    ObjQualifier getObjQualifier();

    FilterItem withObjUriQualifier(ObjUriQualifier qualifier);
}
