/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform.afm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gooddata.transform.ObjQualifier;
import com.gooddata.util.GoodDataToStringBuilder;

/**
 * Represents attribute within {@link ObjectAfm}
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttributeItem implements LocallyIdentifiable {

    private String localIdentifier;
    private final ObjQualifier displayForm;

    /**
     * Creates new instance
     * @param displayForm qualifier of {@link com.gooddata.md.AttributeDisplayForm} representing the attribute
     * @param localIdentifier local identifier, unique within {@link ObjectAfm}
     */
    @JsonCreator
    public AttributeItem(@JsonProperty("displayForm") final ObjQualifier displayForm, @JsonProperty("localIdentifier") final String localIdentifier) {
        this.localIdentifier = localIdentifier;
        this.displayForm = displayForm;
    }

    /**
     * Creates new instance
     * @param displayForm qualifier of {@link com.gooddata.md.AttributeDisplayForm} representing the attribute
     */
    public AttributeItem(final ObjQualifier displayForm) {
        this.displayForm = displayForm;
    }

    /**
     * Sets local identifier, unique within {@link ObjectAfm}
     * @param localIdentifier local identifier
     */
    public void setLocalIdentifier(final String localIdentifier) {
        this.localIdentifier = localIdentifier;
    }

    /**
     * @return local identifier, unique within {@link ObjectAfm}
     */
    public String getLocalIdentifier() {
        return localIdentifier;
    }

    /**
     * @return qualifier of {@link com.gooddata.md.AttributeDisplayForm} representing the attribute
     */
    public ObjQualifier getDisplayForm() {
        return displayForm;
    }

    @Override
    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }
}

