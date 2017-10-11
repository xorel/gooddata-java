/*
 * Copyright (C) 2017, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.gooddata.util.GoodDataToStringBuilder;

/**
 * Qualifies metadata {@link com.gooddata.md.Obj} using an identifier
 */
@JsonRootName("identifier")
public final class ObjIdentifierQualifier implements ObjQualifier {
    private final String identifier;

    public ObjIdentifierQualifier(String identifier) {
        this.identifier = identifier;
    }

    @JsonValue
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }
}
