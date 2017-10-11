/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.transform;

import com.gooddata.AbstractPollHandler;
import com.gooddata.AbstractService;
import com.gooddata.FutureResult;
import com.gooddata.GoodDataRestException;
import com.gooddata.PollResult;
import com.gooddata.gdc.UriResponse;
import com.gooddata.project.Project;
import org.springframework.web.client.RestTemplate;

import static com.gooddata.util.Validate.notNull;

public class TransformationService extends AbstractService {

    private static final String URI = "/gdc/app/projects/{projectId}/execute/transform";

    /**
     * Sets RESTful HTTP Spring template. Should be called from constructor of concrete service extending
     * this abstract one.
     *
     * @param restTemplate RESTful HTTP Spring template
     */
    public TransformationService(final RestTemplate restTemplate) {
        super(restTemplate);
    }

    public FutureResult<TransformationResponse> execute(final Project project, final AfmTransformation transformation) {
        notNull(project, "project");
        notNull(project.getId(), "project.id");
        notNull(transformation, "transformation");

        // todo handle exceptions
        final UriResponse uri = restTemplate.postForObject(URI, transformation, UriResponse.class, project.getId());

        return new PollResult<>(this, new AbstractPollHandler<UriResponse, TransformationResponse>(uri.getUri(), UriResponse.class, TransformationResponse.class) {
            @Override
            public void handlePollResult(final UriResponse pollResult) {
                final TransformationResponse response = restTemplate.getForObject(getPolling(), TransformationResponse.class);
                setResult(response);
            }

            @Override
            public void handlePollException(final GoodDataRestException e) {
                throw e;
            }
        });
    }
}
