/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform

import spock.lang.Specification
import spock.lang.Unroll

import static com.gooddata.util.ResourceUtils.readObjectFromResource


class ObjQualifierTest extends Specification {

    @Unroll
    def "should deserialize as #type"() {
        when:
        ObjQualifier qualifier = readObjectFromResource("/transform/${type}.json", ObjQualifier)

        then:
        typeClass.isInstance(qualifier)

        where:
        type                     | typeClass
        'objIdentifierQualifier' | ObjIdentifierQualifier
        'objUriQualifier'        | ObjUriQualifier
    }
}
