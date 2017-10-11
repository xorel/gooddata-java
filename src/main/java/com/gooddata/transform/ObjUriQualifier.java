/*
 * Copyright (C) 2017, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.gooddata.util.GoodDataToStringBuilder;

import java.util.Objects;

/**
 * Qualifies metadata {@link com.gooddata.md.Obj} using an URI
 */
@JsonRootName("uri")
public final class ObjUriQualifier implements ObjQualifier {
    private final String uri;

    public ObjUriQualifier(final String uri) {
        this.uri = uri;
    }

    @JsonValue
    public String getUri() {
        return uri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof ObjUriQualifier)) return false;

        final ObjUriQualifier that = (ObjUriQualifier) o;
        return Objects.equals(uri, that.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri);
    }

    @Override
    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }
}
