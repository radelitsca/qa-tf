package io.swagger.petstore.conditions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matcher;

@RequiredArgsConstructor
public class BodyFieldCondition implements Condition {

    private final String jsonPath;
    private final Matcher<String> matcher;

    @Override
    public void check(Response response) {
        response.then().and().body(jsonPath, matcher);
    }

    @Override
    public String toString() {
        return "body field [" + jsonPath + "] " + matcher;
    }
}