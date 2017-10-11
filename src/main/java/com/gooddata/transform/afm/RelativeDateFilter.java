/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform.afm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.gooddata.transform.ObjQualifier;
import com.gooddata.transform.ObjUriQualifier;
import com.gooddata.util.GoodDataToStringBuilder;

import static com.gooddata.util.Validate.notEmpty;
import static com.gooddata.util.Validate.notNull;

@JsonRootName(RelativeDateFilter.NAME)
public class RelativeDateFilter extends DateFilter {
    static final String NAME = "relativeDateFilter";
    private final String granularity; // TODO some enum? day | week | etc...
    private final Integer from;
    private final Integer to;

    @JsonCreator
    public RelativeDateFilter(@JsonProperty("dataSet") ObjQualifier dataSet, @JsonProperty("granularity") String granularity,
                              @JsonProperty("from") Integer from, @JsonProperty("to") Integer to) {
        super(dataSet);
        this.granularity = notEmpty(granularity, "granularity");
        this.from = notNull(from, "from");
        this.to = notNull(to, "to");
    }

    @JsonProperty
    public String getGranularity() {
        return granularity;
    }

    @JsonProperty
    public Integer getFrom() {
        return from;
    }

    @JsonProperty
    public Integer getTo() {
        return to;
    }

    @Override
    public FilterItem withObjUriQualifier(final ObjUriQualifier qualifier) {
        return new RelativeDateFilter(qualifier, granularity, from, to);
    }

    @Override
    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }
}
