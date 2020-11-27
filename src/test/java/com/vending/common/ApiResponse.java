package com.vending.common;

import io.restassured.response.Response;

public abstract class ApiResponse<T> implements TypedApiResponse<T> {

    protected int statusCode;
    protected Response response;
    protected T responseModel;

    public int getStatusCode(){
        return statusCode;
    }

    public boolean hasResponse(){
        return response != null;
    }

    public String getHeader(String name){
        return response.getHeader(name);
    }
}
