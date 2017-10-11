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

class SimpleMeasureDefinitionTest extends Specification {

    private static final ObjUriQualifier QUALIFIER = new ObjUriQualifier('/gdc/md/projectId/obj/1')

    def "should serialize full"() {
        expect:
        that new SimpleMeasureDefinition(QUALIFIER, Aggregation.AVG,
                true, new PositiveAttributeFilter(QUALIFIER,'foo')),
                jsonEquals(resource('transform/simpleMeasureDefinitionFull.json'))
    }

    def "should serialize"() {
        expect:
        that new SimpleMeasureDefinition(QUALIFIER),
                jsonEquals(resource('transform/simpleMeasureDefinition.json'))
    }

    def "should deserialize"() {
        when:
        SimpleMeasureDefinition definition = readObjectFromResource('/transform/simpleMeasureDefinition.json', SimpleMeasureDefinition)

        then:
        with(definition.item as ObjUriQualifier) {
            uri == QUALIFIER.uri
        }
    }

    def "should deserialize full"() {
        when:
        SimpleMeasureDefinition definition = readObjectFromResource('/transform/simpleMeasureDefinitionFull.json', SimpleMeasureDefinition)

        then:
        with(definition.item as ObjUriQualifier) {
            uri == QUALIFIER.uri
        }
        definition.aggregation == 'avg'
        definition.showInPercent == true
        with(definition.filters[0] as PositiveAttributeFilter) {
            (it.displayForm as ObjUriQualifier).uri == QUALIFIER.uri
            it.in == ['foo']
        }
    }
}
