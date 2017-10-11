/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform

import spock.lang.Specification
import spock.lang.Unroll

import static com.gooddata.util.ResourceUtils.readObjectFromResource

class MeasureDefinitionTest extends Specification {

    @Unroll
    def "should deserialize as #typeClass"() {
        when:
        MeasureDefinition instance = readObjectFromResource("/transform/${type}.json", MeasureDefinition)

        then:
        typeClass.isInstance(instance)

        where:
        type                      | typeClass
        'popMeasureDefinition'    | PopMeasureDefinition
        'simpleMeasureDefinition' | SimpleMeasureDefinition
    }

}
