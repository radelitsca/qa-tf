package com.socks.api.condition;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StatusCode implements Condition {

    private final int statusCode;

    @Override
    public void check(Response response) {
        response.then().statusCode(statusCode);
    }

    @Override
    public String toString() {
        return "Status code is " + statusCode;
    }
}
