/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */

package com.gooddata.transform.transformation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.gooddata.util.GoodDataToStringBuilder;
import org.springframework.web.util.UriTemplate;

import java.util.regex.Pattern;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Holds attribute including it's specific element
 */
@JsonTypeInfo(include = As.WRAPPER_OBJECT, use = Id.NAME)
@JsonTypeName("attributeLocatorItem")
public class AttributeLocatorItem implements LocatorItem {
    private final String attributeIdentifier;
    private final String element;

    private static final Pattern ELEMENT_IDENTIFIER_PATTERN = Pattern.compile("^\\{([a-zA-Z0-9_.]+)\\?(\\d+)\\}$");
    private static final String ELEMENTS_TEMPLATE = "{attributeUri}/elements?id={elementId}";
    private static final UriTemplate ELEMENTS_URI_TEMPLATE = new UriTemplate("/gdc/md/{projectId}/obj/{objectId}/elements?id={elementId}");

    @JsonCreator
    public AttributeLocatorItem(
            @JsonProperty("attributeIdentifier") String attributeIdentifier,
            @JsonProperty("element") String element) {
        this.attributeIdentifier = attributeIdentifier;
        this.element = element;
    }

    public String getAttributeIdentifier() {
        return attributeIdentifier;
    }

    public String getElement() {
        return element;
    }

    @Override
    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }

//    public AttributeLocatorItem replaceIdentifiers(Map<String, String> identifiers) {
//        return new AttributeLocatorItem(
//                attributeIdentifier.cloneToStoredItem(identifiers),
//                replaceElementIdentifier(identifiers)
//        );
//    }
//
//    String replaceElementIdentifier(Map<String, String> identifiers) {
//        Matcher matcher = ELEMENT_IDENTIFIER_PATTERN.matcher(element);
//        if (!matcher.matches()) {
//            return element;
//        }
//
//        String identifier = matcher.group(1);
//        String elementId = matcher.group(2);
//
//        String attributeUri = identifiers.get(identifier);
//        if (attributeUri == null) {
//            throw new NotFoundException("Identifier: " + identifier + " not found.");
//        }
//
//        return UriUtils.expandUriTemplate(ELEMENTS_TEMPLATE, attributeUri, elementId).getTargetUriAsString();
//    }
//
//    @Override
//    public Locator toLocator(List<Grid.MetricElement> metrics) {
//        if (isFromTransformedRequest()) {
//            ObjUriQualifier storedItemDescription = (ObjUriQualifier) attributeIdentifier;
//            return new Locator.AttributeLocator2(new Reference(storedItemDescription.getUri()), new Reference(element));
//        } else {
//            throw new IllegalStateException("Item should be already transformed to uri based request");
//        }
//    }
//
//    private boolean isFromTransformedRequest() {
//        return attributeIdentifier instanceof ObjUriQualifier && ELEMENTS_URI_TEMPLATE.matches(element);
//    }
}
