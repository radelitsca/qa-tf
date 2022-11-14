package io.swagger.petstore.test.store;

import io.swagger.petstore.conditions.Conditions;
import org.testng.annotations.Test;

import static io.swagger.petstore.constants.GeneralConstants.TYPE_UNKNOWN;
import static io.swagger.petstore.utils.StoreRequestUtil.getRandomOrder;
import static org.apache.http.HttpStatus.SC_OK;

public class PostStoreOrderTest extends StoreBaseTest {

    @Test
    public void testPostStoreOrder() {
        storeApiService.postStoreOrder(getRandomOrder())
                .shouldHave(Conditions.statusCode(SC_OK));
    }
}
