/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform.afm;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Aggregation {

    SUM, COUNT, AVG, MIN, MAX, MEDIAN, RUNSUM;

    @JsonValue
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
