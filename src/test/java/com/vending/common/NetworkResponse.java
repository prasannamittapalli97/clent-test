package com.vending.common;

import com.vending.model.NetworksModel;
import io.restassured.response.Response;

import java.util.function.Supplier;

public class NetworkResponse extends ApiResponse<NetworksModel> implements NetworkFilter{

    @Override
    public void execute(Supplier<Response> f) {
        response = f.get();
        statusCode = response.getStatusCode();

    }

    @Override
    public NetworksModel getResponse() {
        responseModel = response.as(NetworksModel.class);
        return responseModel;
    }
}
