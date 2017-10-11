/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform.afm

import com.gooddata.transform.ObjUriQualifier
import spock.lang.Specification

import static com.gooddata.util.ResourceUtils.readObjectFromResource
import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals
import static net.javacrumbs.jsonunit.core.util.ResourceUtils.resource
import static spock.util.matcher.HamcrestSupport.that

class MeasureItemTest extends Specification {

    private static final ObjUriQualifier QUALIFIER = new ObjUriQualifier('/gdc/md/projectId/obj/1')

    def "should serialize full"() {
        expect:
        that new MeasureItem(new SimpleMeasureDefinition(QUALIFIER), "lId", "alias"),
                jsonEquals(resource('transform/afm/measureItemFull.json'))
    }

    def "should serialize"() {
        expect:
        that new MeasureItem(new SimpleMeasureDefinition(QUALIFIER)),
                jsonEquals(resource('transform/afm/measureItem.json'))
    }

    def "should deserialize"() {
        when:
        MeasureItem measureItem = readObjectFromResource('/transform/afm/measureItem.json', MeasureItem)

        then:
        with(measureItem.definition as SimpleMeasureDefinition) {
            (item as ObjUriQualifier).uri == QUALIFIER.uri
        }
    }

    def "should deserialize full"() {
        when:
        MeasureItem measureItem = readObjectFromResource('/transform/afm/measureItemFull.json', MeasureItem)

        then:
        with(measureItem.definition as SimpleMeasureDefinition) {
            (item as ObjUriQualifier).uri == QUALIFIER.uri
        }
        measureItem.localIdentifier == 'lId'
        measureItem.alias == 'alias'
    }

}
