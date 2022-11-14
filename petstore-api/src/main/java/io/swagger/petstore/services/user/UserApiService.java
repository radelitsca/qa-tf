package io.swagger.petstore.services.user;

import io.qameta.allure.Step;
import io.swagger.petstore.assertions.AssertableResponse;
import io.swagger.petstore.payloads.user.UserRequest;
import io.swagger.petstore.services.ApiService;

public class UserApiService extends ApiService {

    @Step
    public AssertableResponse getUserLogout() {
        return new AssertableResponse(request()
                .get("user/logout"));

    }

    @Step
    public AssertableResponse postUser(UserRequest userRequest) {
        return new AssertableResponse(request()
                .body(userRequest)
                .when()
                .post("user"));
    }

    @Step
    public AssertableResponse deleteUserUserName(String userName) {
        return new AssertableResponse(request()
                .pathParam("username", userName)
                .when()
                .delete("user/{username}"));
    }

    @Step
    public AssertableResponse postUserCreateWithArray(UserRequest... userRequests) {
        return new AssertableResponse(request()
                .body(userRequests)
                .when()
                .post("user/createWithArray"));
    }

    @Step
    public AssertableResponse getUserLogin(String username, String password) {
        return new AssertableResponse(request()
                .queryParam("username", username)
                .queryParam("password", password)
                .get("user/login"));
    }
}
