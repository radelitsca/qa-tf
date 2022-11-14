package io.swagger.petstore.test.pet;

import io.swagger.petstore.conditions.Conditions;
import io.swagger.petstore.payloads.pet.PetRequest;
import org.testng.annotations.Test;

import static io.swagger.petstore.utils.TestDataProvider.getTestData;
import static org.apache.http.HttpStatus.SC_OK;

public class PostPetTest extends PetBaseTest {

    @Test
    public void testPostPet() {
        petApiService.postPet(getTestData(PostPetTest.class, PetRequest.class))
                .shouldHave(Conditions.statusCode(SC_OK));
    }
}
