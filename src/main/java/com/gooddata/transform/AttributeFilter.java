/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonProperty;

import static com.gooddata.util.Validate.notNull;

public abstract class AttributeFilter implements FilterItem {
    private final ObjQualifier displayForm;

    AttributeFilter(ObjQualifier displayForm) {
        this.displayForm = notNull(displayForm, "displayForm");
    }

    @JsonProperty
    public ObjQualifier getDisplayForm() {
        return displayForm;
    }

    @Override
    public ObjQualifier getObjQualifier() {
        return getDisplayForm();
    }
}
