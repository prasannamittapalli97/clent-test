package com.vending.common;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class API {

    static {
        SerenityRest.setUrlEncodingEnabled(false);
    }

    public RequestSpecification request  = SerenityRest.given().baseUri("http://api.citybik.es").log().all();
}
