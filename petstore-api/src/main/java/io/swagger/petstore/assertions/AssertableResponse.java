package io.swagger.petstore.assertions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.petstore.conditions.Condition;
import io.qameta.allure.Step;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class AssertableResponse {
    private final Response response;

    @Step("then api response should have: {condition}")
    public AssertableResponse shouldHave(Condition condition) {
        log.info("About to check condition {}", condition);
        condition.check(response);
        return this;
    }

    public <T> T asPojo(Class<T> tClass) {
        if (response.getContentType().contains("text")) {
            return getModel(tClass);
        }
        return response.as(tClass);
    }

    public Headers headers() {
        return response.getHeaders();
    }

    public <T> T getModel(Class<T> tClass) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(response.asString(), tClass);
        } catch (JsonProcessingException e) {
            log.warn(e.getMessage());
        }
        return null;
    }
}