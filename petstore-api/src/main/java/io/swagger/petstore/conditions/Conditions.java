package io.swagger.petstore.conditions;

import lombok.experimental.UtilityClass;
import org.hamcrest.Matcher;

@UtilityClass
public class Conditions {

    public StatusCodeCondition statusCode(int code) {
        return new StatusCodeCondition(code);
    }

    public BodyFieldCondition bodyField(String jsonPath, Matcher<String> matcher) {
        return new BodyFieldCondition(jsonPath, matcher);
    }

    public GeneralResponseCondition generalResponse(int code, String type) {
        return new GeneralResponseCondition(code, type);
    }

    public static HeaderValueCondition headerValue(String header, Matcher<String> matcher) {
        return new HeaderValueCondition(header, matcher);
    }
}