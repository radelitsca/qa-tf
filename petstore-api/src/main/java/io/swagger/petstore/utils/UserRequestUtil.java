package io.swagger.petstore.utils;

import com.github.javafaker.Faker;
import io.swagger.petstore.config.ProjectConfigImpl;
import io.swagger.petstore.payloads.user.UserRequest;

import java.util.Locale;

public class UserRequestUtil implements ProjectConfigImpl {

    private static final Faker faker = new Faker(new Locale(config.locale()));

    public static UserRequest getRandomUser() {
        UserRequest userRequest = new UserRequest();
        userRequest.setId(0);
        userRequest.setUsername(faker.name().username());
        userRequest.setFirstName(faker.name().firstName());
        userRequest.setLastName(faker.name().lastName());
        userRequest.setEmail(faker.internet().emailAddress());
        userRequest.setPassword(faker.internet().password());
        userRequest.setPhone(faker.phoneNumber().phoneNumber());
        userRequest.setUserStatus(0);
        return userRequest;
    }

}
