package io.swagger.petstore.payloads.store;

import lombok.Data;

@Data
public class StoreRequest {
    private int petId;
    private int quantity;
    private int id;
    private String shipDate;
    private boolean complete;
    private String status;
}