/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform

import com.gooddata.md.report.Total
import com.gooddata.transform.afm.*
import com.gooddata.transform.transformation.*
import spock.lang.Specification

import static com.gooddata.util.ResourceUtils.readObjectFromResource
import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals
import static net.javacrumbs.jsonunit.core.util.ResourceUtils.resource
import static spock.util.matcher.HamcrestSupport.that

class AfmTransformationTest extends Specification {

    private static final ObjUriQualifier QUALIFIER = new ObjUriQualifier('/gdc/md/projectId/obj/1')

    def "should serialize"() {
        expect:
        that new AfmTransformation(
                new ObjectAfm(
                        [new AttributeItem(QUALIFIER)],
                        [new ExpressionFilter('some expression')],
                        [new MeasureItem(new SimpleMeasureDefinition(QUALIFIER))],
                        [new NativeTotalItem('mId', 'a1', 'a2')]
                )
        ),
                jsonEquals(resource('transform/afmTransformation.json'))
    }

    def "should serialize full"() {
        expect:
        that new AfmTransformation(
                new ObjectAfm(
                        [new AttributeItem(QUALIFIER)],
                        [new ExpressionFilter('some expression')],
                        [new MeasureItem(new SimpleMeasureDefinition(QUALIFIER))],
                        [new NativeTotalItem('mId', 'a1', 'a2')]
                ),
                new Transformation(
                        [new MeasureDescription("mId")],
                        [new Dimension("dId", ["i1"], [new TotalItem("mId", Total.AVG, "a1")] as Set)],
                        [
                                new AttributeSortItem(Direction.ASC, "aId"),
                                new MeasureSortItem(Direction.ASC,
                                        new MeasureLocatorItem("mId"),
                                        new AttributeLocatorItem("aId", "a1"))
                        ]
                )
        ),
                jsonEquals(resource('transform/afmTransformationFull.json'))
    }

    def "should deserialize"() {
        when:
        AfmTransformation transformation = readObjectFromResource('/transform/afmTransformation.json', AfmTransformation)

        then:
        transformation.afm != null
        transformation.transformation == null
    }

    def "should deserialize full"() {
        when:
        AfmTransformation transformation = readObjectFromResource('/transform/afmTransformationFull.json', AfmTransformation)

        then:
        transformation.afm != null
        transformation.transformation != null
    }
}
