/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform.transformation

import com.gooddata.transform.Direction
import spock.lang.Specification

import static com.gooddata.util.ResourceUtils.readObjectFromResource
import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals
import static net.javacrumbs.jsonunit.core.util.ResourceUtils.resource
import static spock.util.matcher.HamcrestSupport.that

class AttributeSortItemTest extends Specification {

    def "should serialize values"() {
        expect:
        that new AttributeSortItem(Direction.ASC, 'aId'),
                jsonEquals(resource('transform/transformation/attributeSortItem.json'))
    }

    def "should deserialize values"() {
        when:
        AttributeSortItem item = readObjectFromResource('/transform/transformation/attributeSortItem.json', AttributeSortItem)

        then:
        item.attributeIdentifier == 'aId'
        item.direction == 'asc'
    }
}
