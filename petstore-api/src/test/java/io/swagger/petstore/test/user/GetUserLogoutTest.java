package io.swagger.petstore.test.user;

import io.swagger.petstore.responses.GeneralResponse;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static io.swagger.petstore.conditions.Conditions.statusCode;
import static io.swagger.petstore.conditions.Conditions.generalResponse;
import static io.swagger.petstore.constants.GeneralConstants.MESSAGE_OK;
import static io.swagger.petstore.constants.GeneralConstants.TYPE_UNKNOWN;
import static org.apache.http.HttpStatus.SC_OK;

public class GetUserLogoutTest extends UserBaseTest {

    @Test
    public void testGetUserLogout() {
        GeneralResponse generalResponse = userApiService.getUserLogout()
                .shouldHave(statusCode(SC_OK))
                .asPojo(GeneralResponse.class);

        Assertions.assertThat(generalResponse.getCode()).isEqualTo(SC_OK);
        Assertions.assertThat(generalResponse.getType()).isEqualTo(TYPE_UNKNOWN);
        Assertions.assertThat(generalResponse.getMessage()).isEqualTo(MESSAGE_OK);
    }

    @Test
    public void testGetUserLogoutSimple() {
        GeneralResponse generalResponse = userApiService.getUserLogout()
                .shouldHave(statusCode(SC_OK))
                .shouldHave(generalResponse(SC_OK, TYPE_UNKNOWN))
                .asPojo(GeneralResponse.class);

        Assertions.assertThat(generalResponse.getCode()).isEqualTo(SC_OK);
        Assertions.assertThat(generalResponse.getType()).isEqualTo(TYPE_UNKNOWN);
        Assertions.assertThat(generalResponse.getMessage()).isEqualTo(MESSAGE_OK);
    }
}
