package io.swagger.petstore.utils;

import com.github.javafaker.Faker;
import io.swagger.petstore.config.ProjectConfigImpl;
import io.swagger.petstore.payloads.store.StoreRequest;

import java.util.Locale;
import java.util.Random;

public class StoreRequestUtil implements ProjectConfigImpl {

    private static final Faker faker = new Faker(new Locale(config.locale()));

    public static StoreRequest getRandomOrder() {
        Random random = new Random();
        StoreRequest storeRequest = new StoreRequest();
        storeRequest.setId(3);
        storeRequest.setPetId(0);
        storeRequest.setQuantity(0);
        storeRequest.setShipDate("2022-11-14T16:17:53.526Z");
        storeRequest.setStatus(faker.country().name());
        storeRequest.setComplete(random.nextBoolean());
        return storeRequest;
    }

}
