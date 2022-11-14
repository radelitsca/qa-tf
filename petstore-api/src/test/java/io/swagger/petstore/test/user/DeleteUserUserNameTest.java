package io.swagger.petstore.test.user;

import io.swagger.petstore.conditions.Conditions;
import io.swagger.petstore.payloads.user.UserRequest;
import io.swagger.petstore.responses.GeneralResponse;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static io.swagger.petstore.constants.GeneralConstants.TYPE_UNKNOWN;
import static io.swagger.petstore.utils.UserRequestUtil.getRandomUser;
import static org.apache.http.HttpStatus.SC_OK;

public class DeleteUserUserNameTest extends UserBaseTest {

    @Test
    public void testDeleteUser() {
        UserRequest userRequest = getRandomUser();

        userApiService.postUser(userRequest);


        GeneralResponse generalResponse = userApiService.deleteUserUserName(userRequest.getUsername())
                .shouldHave(Conditions.statusCode(SC_OK))
                .shouldHave(Conditions.generalResponse(SC_OK, TYPE_UNKNOWN))
                .asPojo(GeneralResponse.class);

        Assertions.assertThat(generalResponse.getMessage())
                .isEqualTo(userRequest.getUsername());
    }
}
