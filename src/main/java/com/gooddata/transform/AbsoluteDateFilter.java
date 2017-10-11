/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gooddata.util.GDDateDeserializer;
import com.gooddata.util.GDDateSerializer;
import com.gooddata.util.GoodDataToStringBuilder;
import org.joda.time.LocalDate;

import static com.gooddata.util.Validate.notNull;

@JsonRootName(AbsoluteDateFilter.NAME)
public class AbsoluteDateFilter extends DateFilter {
    static final String NAME = "absoluteDateFilter";
    private LocalDate from;
    private LocalDate to;

    @JsonCreator
    public AbsoluteDateFilter(@JsonProperty("dataSet") ObjQualifier dataSet,
                              @JsonProperty("from") @JsonDeserialize(using = GDDateDeserializer.class) LocalDate from,
                              @JsonProperty("to") @JsonDeserialize(using = GDDateDeserializer.class) LocalDate to) {
        super(dataSet);
        this.from = notNull(from, "from");
        this.to = notNull(to, "to");
    }

    @JsonProperty
    @JsonSerialize(using = GDDateSerializer.class)
    public LocalDate getFrom() {
        return from;
    }

    @JsonProperty
    @JsonSerialize(using = GDDateSerializer.class)
    public LocalDate getTo() {
        return to;
    }

    @Override
    public FilterItem withObjUriQualifier(final ObjUriQualifier qualifier) {
        return new AbsoluteDateFilter(qualifier, from, to);
    }

    @Override
    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }
}
