package io.swagger.petstore.services.pet;

import io.qameta.allure.Step;
import io.swagger.petstore.assertions.AssertableResponse;
import io.swagger.petstore.payloads.pet.PetRequest;
import io.swagger.petstore.services.ApiService;

import java.io.File;

public class PetApiService extends ApiService {

    @Step
    public AssertableResponse postPetIDUploadImage(int petId, String additionalMetadata, String filePath) {
        return new AssertableResponse(requestMultipart()
                .pathParam("petId", petId)
                .param("additionalMetadata", additionalMetadata)
                .multiPart("file", new File(filePath))
                .when()
                .post("pet/{petId}/uploadImage"));
    }

    @Step
    public AssertableResponse postPet(PetRequest petRequest) {
        return new AssertableResponse(request()
                .body(petRequest)
                .when()
                .post("pet"));
    }

    @Step
    public AssertableResponse putPet(PetRequest petRequest) {
        return new AssertableResponse(request()
                .body(petRequest)
                .when()
                .put("pet"));
    }

}
