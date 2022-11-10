package com.socks.api.services;

import com.socks.api.assertions.Assertions;
import com.socks.api.models.UserModel;
import io.restassured.response.Response;

public class UserService extends ApiService {

    public Assertions registerUser(UserModel user) {
        return new Assertions(request()
                .body(user)
                .when()
                .post("register"));
    }
}
