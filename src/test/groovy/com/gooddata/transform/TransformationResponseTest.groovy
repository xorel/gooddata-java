/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform

import spock.lang.Specification

import static com.gooddata.util.ResourceUtils.readObjectFromResource

class TransformationResponseTest extends Specification {

    // todo serialize

    def "should deserialize"() {
        when:
        TransformationResponse transformation = readObjectFromResource('/transform/transformationResponse.json', TransformationResponse)

        then:
        transformation.dimensions != null
    }

}
