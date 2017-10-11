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

class RelativeDateFilterTest extends Specification {

    def "should serialize"() {
        expect:
        that new RelativeDateFilter(new ObjIdentifierQualifier('date.attr'), 'week', 1, 2),
                jsonEquals(resource("transform/afm/relativeDateFilter.json"))
    }

    // TODO deser
}
