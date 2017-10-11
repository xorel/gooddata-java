/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform.afm

import com.gooddata.transform.ObjIdentifierQualifier
import org.joda.time.LocalDate
import spock.lang.Specification

import static com.gooddata.util.ResourceUtils.readObjectFromResource
import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals
import static net.javacrumbs.jsonunit.core.util.ResourceUtils.resource
import static spock.util.matcher.HamcrestSupport.that

class AbsoluteDateFilterTest extends Specification {

    private static final LocalDate FROM = new LocalDate(2017, 9, 25)
    private static final LocalDate TO = new LocalDate(2017, 9, 30)

    def "should serialize"() {
        expect:
        that new AbsoluteDateFilter(new ObjIdentifierQualifier('date.attr'), FROM, TO),
                jsonEquals(resource("transform/afm/absoluteDateFilter.json"))
    }

    def "should deserialize"() {
        when:
        AbsoluteDateFilter filter = readObjectFromResource('/transform/afm/absoluteDateFilter.json', AbsoluteDateFilter)

        then:
        with(filter) {
            (dataSet as ObjIdentifierQualifier).identifier == 'date.attr'
            from == FROM
            to == TO
        }
    }
}
