package io.swagger.petstore.test.store;

import io.swagger.petstore.conditions.Conditions;
import io.swagger.petstore.payloads.store.StoreRequest;
import org.testng.annotations.Test;

import static io.swagger.petstore.conditions.Conditions.generalResponse;

import static io.swagger.petstore.constants.GeneralConstants.TYPE_UNKNOWN;
import static io.swagger.petstore.utils.StoreRequestUtil.getRandomOrder;
import static org.apache.http.HttpStatus.SC_OK;

public class DeleteOrderByIdTest extends StoreBaseTest {

    @Test
    public void testDeleteOrderById() {
        StoreRequest storeRequest = getRandomOrder();
        storeApiService.postStoreOrder(storeRequest);

        storeApiService.deleteStoreOrderByID(storeRequest.getId())
                .shouldHave(Conditions.statusCode(SC_OK))
                .shouldHave(generalResponse(SC_OK, TYPE_UNKNOWN));
    }
}
