/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonProperty;

import static com.gooddata.util.Validate.notNull;

public abstract class DateFilter implements FilterItem {
    private final ObjQualifier dataSet;

    DateFilter(ObjQualifier dataSet) {
        this.dataSet = notNull(dataSet, "dataSet");
    }

    @JsonProperty
    public ObjQualifier getDataSet() {
        return dataSet;
    }

    @Override
    public ObjQualifier getObjQualifier() {
        return getDataSet();
    }
}
