/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */

package com.gooddata.transform.transformation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.gooddata.transform.Direction;
import com.gooddata.util.GoodDataToStringBuilder;

import java.util.List;

import static com.gooddata.util.Validate.notNull;
import static java.util.Arrays.asList;

/**
 * Define metric sort
 */
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("measureSortItem")
public class MeasureSortItem implements SortItem {
    private final String direction;
    private final List<LocatorItem> locators;

    @JsonCreator
    public MeasureSortItem(
            @JsonProperty("direction") final String direction,
            @JsonProperty("locators") final List<LocatorItem> locators) {
        this.direction = direction;
        this.locators = locators;
    }

    public MeasureSortItem(final Direction direction, final List<LocatorItem> locators) {
        this(notNull(direction, "direction").toString(), locators);
    }

    public MeasureSortItem(final Direction direction, final LocatorItem... locators) {
        this(direction, asList(locators));
    }

    public String getDirection() {
        return direction;
    }

    public List<LocatorItem> getLocators() {
        return locators;
    }

    @Override
    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }

//    public SortItem replaceLocatorIdentifiers(Map<String, String> identifiers) {
//        return new MeasureSortItem(
//                direction,
//                locators.stream()
//                        .map(locatorItem -> {
//                            if (locatorItem instanceof AttributeLocatorItem) {
//                                return ((AttributeLocatorItem) locatorItem).replaceIdentifiers(identifiers);
//                            }
//                            return locatorItem;
//                        })
//                        .collect(toList())
//
//        );
//    }

//    /**
//     * Metric group sorts across the dimension, metric group in column sorts rows and vice versa.
//     */
//    @Override
//    public Optional<Pair<Grid.Section, Sort.SortRule>> transformToSortRule(
//            List<Grid.GridElement> columns,
//            List<Grid.GridElement> rows,
//            List<Grid.MetricElement> metrics,
//            Supplier<Grid.Section> defaultSectionSupplier) {
//        // delegating transformation to each locator
//        List<Locator> transformedLocators = locators.stream()
//                .map(locatorItem -> locatorItem.toLocator(metrics))
//                .collect(toList());
//
//        if (findMatch(columns, transformedLocators)) {
//            return Optional.of(new Pair<>(Grid.Section.ROWS, new Sort.MetricSort(direction, transformedLocators)));
//        } else if (findMatch(rows, transformedLocators)) {
//            return Optional.of(new Pair<>(Grid.Section.COLUMNS, new Sort.MetricSort(direction, transformedLocators)));
//        } else {
//            if (transformedLocators.isEmpty()) {
//                return Optional.empty();
//            } else {
//                // in case of one dimensional execution, use default section(ROWS - metric group is added to COLUMNS)
//                return Optional.of(new Pair<>(defaultSectionSupplier.get(), new Sort.MetricSort(direction, transformedLocators)));
//            }
//        }
//    }
//
//    private boolean findMatch(List<Grid.GridElement> elements, List<Locator> locators) {
//        return locators
//                .stream()
//                .anyMatch(locator -> elements.stream()
//                        .anyMatch(gridElement -> locator.getUri().equals(gridElement.getUri())));
//    }
}
