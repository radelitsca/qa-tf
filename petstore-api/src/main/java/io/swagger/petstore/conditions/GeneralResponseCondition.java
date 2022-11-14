package io.swagger.petstore.conditions;

import io.restassured.response.Response;
import io.swagger.petstore.responses.GeneralResponse;
import lombok.RequiredArgsConstructor;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class GeneralResponseCondition implements Condition {

    private final int code;
    private final String type;

    @Override
    public void check(Response response) {
        GeneralResponse generalResponse = response.as(GeneralResponse.class);

        assertThat(generalResponse.getCode()).isEqualTo(code);
        assertThat(generalResponse.getType()).isEqualTo(type);
        assertThat(generalResponse.getMessage()).isNotBlank();
    }

    @Override
    public String toString() {
        return "GeneralResponse: [code - " + code + "; type - " + type + "]";
    }
}
