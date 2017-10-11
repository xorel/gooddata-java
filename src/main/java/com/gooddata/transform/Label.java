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

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Label {
    private final String id;
    private final String value;
    private final String type;

    @JsonCreator
    public Label(@JsonProperty("id") String id, @JsonProperty("value") String value, @JsonProperty("type") String type) {
        this.id = id;
        this.value = value;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }

    public static class ElementLabel extends Label {

        public ElementLabel(String id, String value) {
            super(id, value, "element");
        }
    }

    public static class MetricLabel extends Label {

        public MetricLabel(String id, String value) {
            super(id, value, "metric");
        }
    }

    public static class TotalLabel extends Label {

        public TotalLabel(String id) {
            super(id, null, "total");
        }
    }
}
