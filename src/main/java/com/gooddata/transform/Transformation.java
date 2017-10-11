/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gooddata.util.GoodDataToStringBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.gooddata.util.Validate.notNull;

/**
 * Represents the transformation request of executed {@link ObjectAfm}
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transformation {
    private List<MeasureDescription> measures;
    private List<Dimension> dimensions;
    private List<SortItem> sorts;

    @JsonCreator
    public Transformation(
            @JsonProperty("measures") List<MeasureDescription> measures,
            @JsonProperty("dimensions") List<Dimension> dimensions,
            @JsonProperty("sorts") List<SortItem> sorts) {
        this.measures = measures;
        this.dimensions = dimensions;
        this.sorts = sorts;
    }

    public Transformation() {
    }

    public List<MeasureDescription> getMeasures() {
        return measures;
    }

    public List<Dimension> getDimensions() {
        return dimensions;
    }

    public List<SortItem> getSorts() {
        return sorts;
    }

    public void setMeasures(final List<MeasureDescription> measures) {
        this.measures = measures;
    }

    public void setDimensions(final List<Dimension> dimensions) {
        this.dimensions = dimensions;
    }

    public void setSorts(final List<SortItem> sorts) {
        this.sorts = sorts;
    }

    public Transformation addMeasure(final MeasureDescription measure) {
        if (measures == null) {
            measures = new ArrayList<>();
        }
        measures.add(notNull(measure, "measure"));
        return this;
    }

    public Transformation addDimension(final Dimension dimension) {
        if (dimensions == null) {
            dimensions = new ArrayList<>();
        }
        dimensions.add(notNull(dimension, "dimension"));
        return this;
    }

    public Transformation addSort(final SortItem sort) {
        if (sorts == null) {
            sorts = new ArrayList<>();
        }
        sorts.add(notNull(sort, "sort"));
        return this;
    }

    @Override
    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }

}
