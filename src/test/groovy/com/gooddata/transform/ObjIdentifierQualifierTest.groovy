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


class ObjIdentifierQualifierTest extends Specification {

    def "should serialize"() {
        expect:
        that new ObjIdentifierQualifier('df.id'), jsonEquals(resource('transform/objIdentifierQualifier.json'))
    }

    def "should deserialize"() {
        when:
        ObjIdentifierQualifier identifierQualifier = readObjectFromResource('/transform/objIdentifierQualifier.json', ObjIdentifierQualifier)

        then:
        identifierQualifier.identifier == 'df.id'
    }
}
