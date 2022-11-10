package com.socks.api.services;

import com.socks.api.config.ProjectConfigImpl;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApiService implements ProjectConfigImpl {

public RequestSpecification getSpecification() {
    return new RequestSpecBuilder()
            .setBaseUri(config.baseUrl())
            .setRelaxedHTTPSValidation()
            .build();
}

    public RequestSpecification request() {
        return  RestAssured
                .given(getSpecification())
                .contentType(ContentType.JSON)
                .filters(Arrays.asList(
                        new RequestLoggingFilter(),
                        new ResponseLoggingFilter(),
                        new AllureRestAssured()
                ));

    }

    public List<Filter> getFilters() {
    if (config.logging()) {
        return Arrays.asList(
                new RequestLoggingFilter(),
                new ResponseLoggingFilter()
        );
    } else {
        return Collections.singletonList(new AllureRestAssured());
    }
    }
}
