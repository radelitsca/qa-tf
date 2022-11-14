package io.swagger.petstore.test.user;

import io.swagger.petstore.responses.GeneralResponse;
import org.testng.annotations.Test;

import static io.swagger.petstore.conditions.Conditions.generalResponse;
import static io.swagger.petstore.conditions.Conditions.statusCode;
import static io.swagger.petstore.constants.GeneralConstants.TYPE_UNKNOWN;
import static io.swagger.petstore.utils.UserRequestUtil.getRandomUser;
import static org.apache.http.HttpStatus.SC_OK;

public class PostuserCreateWithArrayTest extends UserBaseTest {

    @Test
    public void postUserCreateWithArray() {
        userApiService.postUserCreateWithArray(
                        getRandomUser(),
                        getRandomUser(),
                        getRandomUser())
                .shouldHave(statusCode(SC_OK))
                .shouldHave(generalResponse(SC_OK, TYPE_UNKNOWN))
                .asPojo(GeneralResponse.class);
        ;
    }
}
