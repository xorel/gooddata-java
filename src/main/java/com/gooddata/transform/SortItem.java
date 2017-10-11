/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Define sort in report, either attribute (sort headers) or metric (sort data)
 */
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AttributeSortItem.class, name = "attributeSortItem"),
        @JsonSubTypes.Type(value = MeasureSortItem.class, name = "measureSortItem")
})
public interface SortItem {
//
//    /**
//     * Transformation of sort item into {@link Sort.SortRule} with specified {@link Grid.Section}.
//     *
//     * @param columns                list of adfs in columns
//     * @param rows                   list of adfs in rows
//     * @param metrics                list of metrics
//     * @param defaultSectionSupplier in case of one dimensional execution (adding metric group as second dimension)
//     * @return tuple containing {@link Grid.Section} and {@link Sort.SortRule} specifieng which section/dimension
//     * should be sorted and how
//     */
//    Optional<Pair<Grid.Section, Sort.SortRule>> transformToSortRule(List<Grid.GridElement> columns,
//                                                                    List<Grid.GridElement> rows,
//                                                                    List<Grid.MetricElement> metrics,
//                                                                    Supplier<Grid.Section> defaultSectionSupplier);
}
