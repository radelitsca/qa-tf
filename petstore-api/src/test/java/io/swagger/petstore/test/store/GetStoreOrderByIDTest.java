package io.swagger.petstore.test.store;

import io.swagger.petstore.conditions.Conditions;
import io.swagger.petstore.payloads.store.StoreRequest;
import org.testng.annotations.Test;

import static io.swagger.petstore.utils.StoreRequestUtil.getRandomOrder;
import static org.apache.http.HttpStatus.SC_OK;

public class GetStoreOrderByIDTest extends StoreBaseTest {

    @Test
    public void testGetOrderByID() {
        StoreRequest storeRequest = getRandomOrder();
        storeApiService.postStoreOrder(storeRequest);

        storeApiService.getStoreOrderByID(storeRequest.getId())
                .shouldHave(Conditions.statusCode(SC_OK));
    }
}
