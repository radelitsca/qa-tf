package io.swagger.petstore.responses;

import lombok.Data;

@Data
public class GeneralResponse {
    private int code;
    private String type;
    private String message;
}