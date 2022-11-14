package io.swagger.petstore.conditions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matcher;

@RequiredArgsConstructor
public class HeaderValueCondition implements Condition {

    private final String header;
    private final Matcher<String> matcher;

    @Override
    public void check(Response response) {
        response.then().and().header(header, matcher);
    }

    @Override
    public String toString() {
        return "header value [" + header + "] " + matcher;
    }
}

