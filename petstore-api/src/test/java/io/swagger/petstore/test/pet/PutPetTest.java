package io.swagger.petstore.test.pet;

import io.swagger.petstore.conditions.Conditions;
import io.swagger.petstore.payloads.pet.PetRequest;
import org.testng.annotations.Test;

import static io.swagger.petstore.utils.TestDataProvider.getTestData;
import static org.apache.http.HttpStatus.SC_OK;

public class PutPetTest extends PetBaseTest {
    @Test
    public void testPostPet() {
        petApiService.putPet(getTestData(PutPetTest.class, PetRequest.class))
                .shouldHave(Conditions.statusCode(SC_OK));
    }
}
