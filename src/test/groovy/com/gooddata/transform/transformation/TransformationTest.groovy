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

class TransformationTest extends Specification {

    def "should serialize full"() {
        expect:
        that new Transformation(
                [new MeasureDescription("mId")],
                [new Dimension("dId", "i1")],
                [
                        new AttributeSortItem(Direction.ASC, "aId"),
                        new MeasureSortItem(Direction.ASC,
                                new MeasureLocatorItem("mId"),
                                new AttributeLocatorItem("aId", "a1"))
                ]
        ),
                jsonEquals(resource('transform/transformation/transformation.json'))
    }

    def "should serialize"() {
        expect:
        that new Transformation(),
                jsonEquals(resource('transform/empty.json'))
    }

    def "should deserialize"() {
        when:
        Transformation transformation = readObjectFromResource('/transform/empty.json', Transformation)

        then:
        transformation.measures == null
        transformation.dimensions == null
        transformation.sorts == null
    }

    def "should deserialize full"() {
        when:
        Transformation transformation = readObjectFromResource('/transform/transformation/transformation.json', Transformation)

        then:

        with(transformation) {
            measures[0].measureIdentifier == 'mId'

            dimensions[0].identifier == 'dId'
            dimensions[0].itemIdentifiers == ['i1']
        }

        with(transformation.sorts[0] as AttributeSortItem) {
            attributeIdentifier == 'aId'
            direction == 'asc'
        }

        with(transformation.sorts[1] as MeasureSortItem) {
            direction == 'asc'
        }
        with((transformation.sorts[1] as MeasureSortItem).locators[0] as MeasureLocatorItem) {
            measureIdentifier == 'mId'
        }
        with((transformation.sorts[1] as MeasureSortItem).locators[1] as AttributeLocatorItem) {
            attributeIdentifier == 'aId'
            element == 'a1'
        }
    }
}
