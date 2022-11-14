package io.swagger.petstore.services.store;

import io.qameta.allure.Step;
import io.swagger.petstore.assertions.AssertableResponse;
import io.swagger.petstore.payloads.store.StoreRequest;
import io.swagger.petstore.services.ApiService;

public class StoreApiService extends ApiService {

    @Step
    public AssertableResponse postStoreOrder(StoreRequest storeRequest) {
        return new AssertableResponse(request()
                .body(storeRequest)
                .when()
                .post("store/order"));
    }

    @Step
    public AssertableResponse getStoreOrderByID(int id) {
        return new AssertableResponse(request()
                .pathParam("id", id)
                .get("store/order/{id}"));
    }

    @Step
    public AssertableResponse deleteStoreOrderByID(int id) {
        return new AssertableResponse(request()
                .pathParam("id", id)
                .when()
                .delete("store/order/{id}"));
    }
}
