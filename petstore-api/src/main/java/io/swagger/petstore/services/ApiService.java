package io.swagger.petstore.services;

import io.swagger.petstore.config.ProjectConfigImpl;
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

    private RequestSpecification setRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(config.baseUrl() + config.version())
                .setRelaxedHTTPSValidation()
                .build();
    }

    protected RequestSpecification request() {
        return RestAssured
                .given(setRequestSpecification())
                .contentType(ContentType.JSON)
                .filters(getFilters());
    }

    protected RequestSpecification requestMultipart() {
        return RestAssured
                .given(setRequestSpecification())
                .accept(ContentType.JSON)
                .filters(getFilters());
    }

    private List<Filter> getFilters() {
        if (config.logging()) {
            return Arrays.asList(
                    new RequestLoggingFilter(),
                    new ResponseLoggingFilter(),
                    new AllureRestAssured()
            );
        } else {
            return Collections.singletonList(new AllureRestAssured());
        }
    }
}