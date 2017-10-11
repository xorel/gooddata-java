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

@JsonRootName(PositiveAttributeFilter.NAME)
public class PositiveAttributeFilter extends AttributeFilter {
    static final String NAME = "positiveAttributeFilter";

    private final List<String> in;

    @JsonCreator
    public PositiveAttributeFilter(@JsonProperty("displayForm") ObjQualifier displayForm, @JsonProperty("in") List<String> in) {
        super(displayForm);
        this.in = in;
    }

    public PositiveAttributeFilter(final ObjQualifier displayForm, final String... in) {
        this(displayForm, asList(in));
    }

    @JsonProperty
    public List<String> getIn() {
        return in;
    }

    @Override
    public FilterItem withObjUriQualifier(final ObjUriQualifier qualifier) {
        return new PositiveAttributeFilter(qualifier, in);
    }

    @Override
    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }
}
