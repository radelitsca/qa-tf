package io.swagger.petstore.test.user;

import io.swagger.petstore.conditions.Conditions;
import io.swagger.petstore.constants.HeaderConstants;
import io.swagger.petstore.payloads.user.UserRequest;
import io.swagger.petstore.responses.GeneralResponse;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.swagger.petstore.conditions.Conditions.generalResponse;
import static io.swagger.petstore.conditions.Conditions.statusCode;
import static io.swagger.petstore.constants.GeneralConstants.TYPE_UNKNOWN;
import static io.swagger.petstore.utils.UserRequestUtil.getRandomUser;
import static org.apache.http.HttpStatus.SC_OK;

public class GetUserLoginTest extends UserBaseTest {

    @Test
    public void testGetUserLogin() {
        UserRequest userRequest = getRandomUser();

        userApiService.postUser(userRequest)
                .shouldHave(Conditions.statusCode(SC_OK));

        userApiService.getUserLogin(userRequest.getUsername(), userRequest.getPassword())
                .shouldHave(statusCode(SC_OK))
                .shouldHave(Conditions.headerValue(HeaderConstants.X_RATE_LIMIT, Matchers.equalTo("5000")))
                .shouldHave(generalResponse(SC_OK, TYPE_UNKNOWN));
    }
}
