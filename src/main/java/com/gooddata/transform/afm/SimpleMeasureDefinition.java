/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform.afm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.gooddata.transform.ObjQualifier;
import com.gooddata.transform.ObjUriQualifier;
import com.gooddata.util.GoodDataToStringBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.gooddata.transform.afm.SimpleMeasureDefinition.NAME;
import static com.gooddata.util.Validate.notNull;
import static java.util.Arrays.asList;

/**
 * Definition of simple measure
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName(NAME)
public class SimpleMeasureDefinition implements MeasureDefinition {

    static final String NAME = "measure";

    private final ObjQualifier item;
    private String aggregation;
    private Boolean showInPercent;
    private List<FilterItem> filters;

    public SimpleMeasureDefinition(final ObjQualifier item) {
        this.item = item;
    }

    /**
     * Creates new definition
     * @param item item which is measured
     * @param aggregation additional aggregation applied
     * @param showInPercent whether should be shown in percent
     * @param filters additional filters applied
     */
    @JsonCreator
    public SimpleMeasureDefinition(@JsonProperty("item") final ObjQualifier item,
                                   @JsonProperty("aggregation") final String aggregation,
                                   @JsonProperty("showInPercent") final Boolean showInPercent,
                                   @JsonProperty("filters") final List<FilterItem> filters) {
        this.item = item;
        this.aggregation = aggregation;
        this.showInPercent = showInPercent;
        this.filters = filters;
    }

    public SimpleMeasureDefinition(final ObjQualifier item, final Aggregation aggregation, final Boolean showInPercent,
                                   final List<FilterItem> filters) {
        this(item, notNull(aggregation, "aggregation").toString(), showInPercent, filters);
    }

    public SimpleMeasureDefinition(final ObjQualifier item, final Aggregation aggregation, final Boolean showInPercent,
                                   final FilterItem... filters) {
        this(item, notNull(aggregation, "aggregation").toString(), showInPercent, asList(filters));
    }

    @Override
    public MeasureDefinition withObjUriQualifier(final ObjUriQualifier qualifier) {
        return new SimpleMeasureDefinition(qualifier, aggregation, showInPercent, filters);
    }

    @Override
    public boolean isAdHoc() {
        return hasAggregation() || hasShowInPercent() || hasFilters();
    }

    @Override
    public String getUri() {
        return getItem().getUri();
    }

    public ObjQualifier getItem() {
        return item;
    }

    @Override
    public ObjQualifier getObjQualifier() {
        return getItem();
    }

    public String getAggregation() {
        return aggregation;
    }

    public void setAggregation(final String aggregation) {
        this.aggregation = aggregation;
    }

    public void setAggregation(final Aggregation aggregation) {
        this.aggregation = notNull(aggregation, "aggregation").toString();
    }

    public Boolean getShowInPercent() {
        return showInPercent;
    }

    public void setShowInPercent(final Boolean showInPercent) {
        this.showInPercent = showInPercent;
    }

    public List<FilterItem> getFilters() {
        return filters;
    }

    public void setFilters(final List<FilterItem> filters) {
        this.filters = filters;
    }

    public void addFilter(final FilterItem filter) {
        if (filters == null) {
            filters = new ArrayList<>();
        }
        filters.add(notNull(filter, "filter"));
    }

    @Override
    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }

    public boolean hasFilters() {
        return filters != null && !filters.isEmpty();
    }

    public boolean hasShowInPercent() {
        return showInPercent != null && showInPercent;
    }

    public boolean hasAggregation() {
        return aggregation != null;
    }
}

