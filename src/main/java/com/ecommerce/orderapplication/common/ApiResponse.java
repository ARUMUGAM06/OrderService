package com.ecommerce.orderapplication.common;

public class ApiResponse {
    public String message;
    public Object data;

    public ApiResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
