/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.gooddata.util.GoodDataToStringBuilder;

import java.util.List;

import static java.util.Arrays.asList;

@JsonRootName(NegativeAttributeFilter.NAME)
public class NegativeAttributeFilter extends AttributeFilter {
    static final String NAME = "negativeAttributeFilter";
    private List<String> notIn;

    @JsonCreator
    public NegativeAttributeFilter(@JsonProperty("displayForm") ObjQualifier displayForm, @JsonProperty("notIn") List<String> notIn) {
        super(displayForm);
        this.notIn = notIn;
    }

    public NegativeAttributeFilter(final ObjQualifier displayForm, String... notIn) {
        this(displayForm, asList(notIn));
    }

    @JsonProperty
    public List<String> getNotIn() {
        return notIn;
    }

    @Override
    public FilterItem withObjUriQualifier(final ObjUriQualifier qualifier) {
        return new NegativeAttributeFilter(qualifier, notIn);
    }

    @Override
    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }
}
