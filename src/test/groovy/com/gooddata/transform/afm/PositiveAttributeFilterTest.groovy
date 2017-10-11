/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform.afm

import com.gooddata.transform.ObjIdentifierQualifier
import spock.lang.Specification

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals
import static net.javacrumbs.jsonunit.core.util.ResourceUtils.resource
import static spock.util.matcher.HamcrestSupport.that

class PositiveAttributeFilterTest extends Specification {

    def "should serialize"() {
        expect:
        that new PositiveAttributeFilter(new ObjIdentifierQualifier('df.bum.bac'), 'a', 'b'),
                jsonEquals(resource("transform/afm/positiveAttributeFilter.json"))
    }

    // TODO deser
}
