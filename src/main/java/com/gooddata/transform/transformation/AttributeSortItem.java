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

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import static com.gooddata.util.Validate.notNull;

/**
 * Define sort by specific attribute
 */
@JsonTypeInfo(include = As.WRAPPER_OBJECT, use = Id.NAME)
@JsonTypeName("attributeSortItem")
public class AttributeSortItem implements SortItem {

    private final String direction;

    private final String attributeIdentifier;

    @JsonCreator
    public AttributeSortItem(@JsonProperty("direction") String direction,
                             @JsonProperty("attributeIdentifier") String attributeIdentifier) {
        this.attributeIdentifier = attributeIdentifier;
        this.direction = direction;
    }

    public AttributeSortItem(Direction direction, String attributeIdentifier) {
        this(notNull(direction, "direction").toString(), attributeIdentifier);
    }

    public String getDirection() {
        return direction;
    }

    public String getAttributeIdentifier() {
        return attributeIdentifier;
    }

    @Override
    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }

//    @Override
//    public Optional<Pair<Grid.Section, Sort.SortRule>> transformToSortRule(List<Grid.GridElement> columns,
//                                                                           List<Grid.GridElement> rows,
//                                                                           List<Grid.MetricElement> metrics,
//                                                                           Supplier<Grid.Section> defaultSectionSupplier) {
//        if (attributeIdentifier instanceof ObjUriQualifier) {
//            ObjUriQualifier storedItemDescription = (ObjUriQualifier) attributeIdentifier;
//            if (findMatch(columns, storedItemDescription)) {
//                return Optional.of(new Pair<>(Grid.Section.COLUMNS, new Sort.AttributeSort(new Reference(storedItemDescription.getUri()), direction)));
//            } else if (findMatch(rows, storedItemDescription)) {
//                return Optional.of(new Pair<>(Grid.Section.ROWS, new Sort.AttributeSort(new Reference(storedItemDescription.getUri()), direction)));
//            } else {
//                return Optional.empty();
//            }
//        } else {
//            throw new IllegalStateException("Item should be already transformed to uri based request");
//        }
//    }
//
//    private boolean findMatch(List<Grid.GridElement> elements, ObjUriQualifier _item) {
//        return elements.stream()
//                .anyMatch(gridElement -> gridElement.getUri().getTargetUriAsString().equalsIgnoreCase(_item.getUri()));
//    }
}
