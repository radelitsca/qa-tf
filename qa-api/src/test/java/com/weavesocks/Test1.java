package com.weavesocks;

import com.socks.api.condition.Conditions;
import com.socks.api.models.UserModel;
import com.socks.api.response.UserRegistrationResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.text.IsEmptyString.emptyString;

public class Test1 extends BaseTest {

    @Test
    public void register() {
        UserModel user = new UserModel()
                .username(faker.name().username())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password());

        UserRegistrationResponse response = service.registerUser(user)
                .shouldHave(Conditions.statusCode(HttpStatus.SC_OK))
                .asPojo(UserRegistrationResponse.class);

        response.getId();
    }

    @Test
    public void registerSameUser() {
        UserModel user = new UserModel()
                .username(faker.name().username())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password());

        service.registerUser(user)
                .shouldHave(Conditions.statusCode(HttpStatus.SC_OK))
                .shouldHave(Conditions.bodyCondition("id", not(emptyString())));

        service.registerUser(user)
                .shouldHave(Conditions.statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR));
    }

}
