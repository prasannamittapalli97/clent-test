package com.vending.common;

import io.restassured.response.Response;

import java.util.function.Supplier;

public interface TypedApiResponse<T> {

    void execute(Supplier<Response> f);

    T getResponse();

    int getStatusCode();

    boolean hasResponse();

    String getHeader(String name);
}
