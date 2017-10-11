/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform

import spock.lang.Specification

import static com.gooddata.util.ResourceUtils.readObjectFromResource
import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals
import static net.javacrumbs.jsonunit.core.util.ResourceUtils.resource
import static spock.util.matcher.HamcrestSupport.that

class MeasureSortItemTest extends Specification {

    def "should serialize values"() {
        expect:
        that new MeasureSortItem('asc', [new MeasureLocatorItem("mId"), new AttributeLocatorItem("aId", "a1")]),
                jsonEquals(resource('transform/measureSortItem.json'))
    }

    def "should deserialize values"() {
        when:
        MeasureSortItem item = readObjectFromResource('/transform/measureSortItem.json', MeasureSortItem)

        then:
        item.direction == 'asc'
    }
}