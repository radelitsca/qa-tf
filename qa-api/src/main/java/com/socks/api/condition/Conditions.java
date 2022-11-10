package com.socks.api.condition;

import lombok.experimental.UtilityClass;
import org.hamcrest.Matcher;


@UtilityClass
public class Conditions {
    public StatusCode statusCode(int code) {
        return new StatusCode(code);
    }
    public BodyCondition bodyCondition(String jsonPath, Matcher<String> matcher){
        return new BodyCondition(jsonPath, matcher);
    }
}
