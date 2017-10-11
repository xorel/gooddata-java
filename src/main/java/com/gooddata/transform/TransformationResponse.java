/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.gooddata.util.GoodDataToStringBuilder;

import java.util.List;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.ArrayUtils.toObject;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("transformationResponse")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransformationResponse {
    private List<TransformedDimension> dimensions;
    private Object data;
    private List<Integer> size;
    private List<Integer> offset;
    private List<Integer> overallSize;

    public TransformationResponse() {
    }

    public TransformationResponse(List<TransformedDimension> dimensions, Object data, List<Integer> size,
                                  List<Integer> offset, List<Integer> overallSize) {
        this.dimensions = dimensions;
        this.data = data;
        this.size = size;
        this.offset = offset;
        this.overallSize = overallSize;
    }

    public List<TransformedDimension> getDimensions() {
        return dimensions;
    }

    public Object getData() {
        return data;
    }

    public List<Integer> getSize() {
        return size;
    }

    public List<Integer> getOffset() {
        return offset;
    }

    public List<Integer> getOverallSize() {
        return overallSize;
    }

    public void setDimensions(final List<TransformedDimension> dimensions) {
        this.dimensions = dimensions;
    }

    public void setData(final Object data) {
        this.data = data;
    }

    public void setSize(final List<Integer> size) {
        this.size = size;
    }

    public void setOffset(final List<Integer> offset) {
        this.offset = offset;
    }

    public void setOverallSize(final List<Integer> overallSize) {
        this.overallSize = overallSize;
    }

    public void dimensions(final TransformedDimension... dimensions) {
        this.dimensions = asList(dimensions);
    }

    public void size(final int... size) {
        this.size = asList(toObject(size));
    }

    public void overallSize(final int... overallSize) {
        this.overallSize = asList(toObject(overallSize));
    }

    public void offset(final int... offset) {
        this.offset = asList(toObject(offset));
    }

    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }

}
