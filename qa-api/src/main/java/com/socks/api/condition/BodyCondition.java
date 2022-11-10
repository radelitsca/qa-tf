package com.socks.api.condition;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matcher;

@RequiredArgsConstructor
public class BodyCondition implements Condition {

    private final String jsonPath;
    private final Matcher<String> matcher;

    @Override
    public void check(Response response) {

        response.then().body(jsonPath, matcher);
    }

    @Override
    public String toString() {
        return "body field [" + jsonPath + "] " + matcher;
    }
}
