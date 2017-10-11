/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform.afm;

/**
 * Marker interface for all locally identifiable objects having local identifier in AFM
 */
interface LocallyIdentifiable {
    /**
     * @return Value of local identifier
     */
    String getLocalIdentifier();
}
