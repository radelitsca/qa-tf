package com.socks.api.condition;


import io.restassured.response.Response;

public interface Condition {
    void check(Response response);
}
