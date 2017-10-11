/*
 * Copyright (C) 2017, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gooddata.md.report.Total;
import com.gooddata.util.GoodDataToStringBuilder;

import java.util.Objects;

import static com.gooddata.util.Validate.notEmpty;
import static com.gooddata.util.Validate.notNull;

/**
 * Total definition
 */
public class TotalItem {
    private final String measureIdentifier;
    private final String type;
    private final String attributeIdentifier;

    /**
     * Total definition
     * @param measureIdentifier measure on which is total defined
     * @param type total type
     * @param attributeIdentifier internal attribute identifier in AFM defining total placement
     */
    @JsonCreator
    public TotalItem(
            @JsonProperty("measureIdentifier") String measureIdentifier, @JsonProperty("type") String type,
            @JsonProperty("attributeIdentifier") String attributeIdentifier) {
        this.measureIdentifier = notEmpty(measureIdentifier, "measureIdentifier");
        this.type = type;
        this.attributeIdentifier = notEmpty(attributeIdentifier, "attributeIdentifier");
    }

    public TotalItem(String measureIdentifier, Total total, String attributeIdentifier) {
        this(measureIdentifier, notNull(total.toString(), "total"), attributeIdentifier);
    }

    /**
     * total type
     * @return total type
     */
    public String getType() {
        return type;
    }

    /**
     * internal measure identifier in AFM, on which is total defined
     * @return measure
     */
    public String getMeasureIdentifier() {
        return measureIdentifier;
    }

    /**
     * internal attribute identifier in AFM defining total placement
     * @return identifier (never null)
     */
    public String getAttributeIdentifier() {
        return attributeIdentifier;
    }

    @Override
    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalItem totalItem = (TotalItem) o;
        return Objects.equals(measureIdentifier, totalItem.measureIdentifier) &&
                Objects.equals(type, totalItem.type) &&
                Objects.equals(attributeIdentifier, totalItem.attributeIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(measureIdentifier, type, attributeIdentifier);
    }
}
