/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform.transformation

import spock.lang.Specification

import static com.gooddata.util.ResourceUtils.readObjectFromResource
import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals
import static net.javacrumbs.jsonunit.core.util.ResourceUtils.resource
import static spock.util.matcher.HamcrestSupport.that

class MeasureDescriptionTest extends Specification {

    def "should serialize all values"() {
        expect:
        that new MeasureDescription('mId', 'als', 'fmt'),
                jsonEquals(resource('transform/transformation/measureDescriptionFull.json'))
    }

    def "should serialize required values"() {
        expect:
        that new MeasureDescription('mId'),
                jsonEquals(resource('transform/transformation/measureDescription.json'))
    }

    def "should deserialize all values"() {
        when:
        MeasureDescription measure = readObjectFromResource('/transform/transformation/measureDescriptionFull.json', MeasureDescription)

        then:
        measure.measureIdentifier == 'mId'
        measure.alias == 'als'
        measure.format == 'fmt'
    }

    def "should deserialize required values"() {
        when:
        MeasureDescription measure = readObjectFromResource('/transform/transformation/measureDescription.json', MeasureDescription)

        then:
        measure.measureIdentifier == 'mId'
    }

}
