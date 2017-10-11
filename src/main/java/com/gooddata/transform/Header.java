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

import static com.gooddata.transform.transformation.Dimension.METRIC_GROUP;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Header {
    private final String type;
    private final String uri;
    private final String name;
    private final List<Label> labels;

    @JsonCreator
    public Header(@JsonProperty("type") String type, @JsonProperty("uri") String uri,
                  @JsonProperty("name") String name, @JsonProperty("labels") List<Label> labels) {
        this.type = type;
        this.uri = uri;
        this.name = name;
        this.labels = labels;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }

    public String getName() {
        return name;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }

    public static class MetricHeader extends Header {

        public MetricHeader(String name, List<Label> labels) {
            super("metric", METRIC_GROUP, name, labels);
        }
    }

    public static class AttributeHeader extends Header {

        public AttributeHeader(String uri, String name, List<Label> labels) {
            super("attribute", uri, name, labels);
        }
    }
}
