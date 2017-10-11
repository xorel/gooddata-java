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

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransformedDimension {
    private final String name;
    private final List<Header> headers;

    @JsonCreator
    public TransformedDimension(@JsonProperty("name") final String name, @JsonProperty("headers") final List<Header> headers) {
        this.name = name;
        this.headers = headers;
    }

    public String getName() {
        return name;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }
}
