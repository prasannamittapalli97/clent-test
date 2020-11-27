package com.vending.apisteps;

import com.vending.common.API;
import com.vending.model.Network;
import com.vending.common.NetworkResponse;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;

import java.util.Map;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BikerSteps extends API {

    @Steps
    NetworkResponse networkResponse;

    private Optional<Network> countryNetwork;
    private Response response;
    private int totalNetworks = 0;

    @When("I call networks api")
    public void iCallNetworksApi() {
        networkResponse.execute(() -> request.when().get("/v2/networks"));
    }

    @Then("Api should return success status code {int}")
    public void apiShouldReturnSuccessStatusCode(int statusCode) {
        assertThat(networkResponse.getStatusCode(),equalTo(statusCode));
    }

    @Then("verify the response is returning city {string} in country code Germany {string}")
    public void verifyTheResponseIsReturningCityInCountryCodeGermany(String cityName, String countryCode) {
        countryNetwork  = networkResponse.getResponse().getNetworks().stream().filter(network ->
            network.getLocation().getCity().equals(cityName)).findFirst();
        assertThat(""+cityName+" doesn't exist in the list of networks",countryNetwork.isPresent(),is(true));
        assertThat(countryNetwork.get().getLocation().getCountry(),equalTo(countryCode));
    }

    @And("latitude and longitude should be below")
    public void latitudeAndLongitudeShouldBeBelow(Map<String,Double> values) {
        assertThat(countryNetwork.get().getLocation().getLatitude(),equalTo(values.get("latitude")));
        assertThat(countryNetwork.get().getLocation().getLongitude(),equalTo(values.get("longitude")));
    }

    @Given("I have total {int} networks")
    public void iHaveTotalNetworks(int networkLength) {
        totalNetworks = networkLength;
    }


    @And("verify the response is returning all networks")
    public void verifyTheResponseIsReturningNetworks() {
        assertThat(networkResponse.getResponse().getNetworks().size(),equalTo(totalNetworks));
    }


    @And("verify the response is returning correct city {string} and country {string} for network {string}")
    public void verifyTheResponseIsReturningCorrectCityAndCountryForNetwork(String city, String country, String networkName) {
        countryNetwork  = networkResponse.getNetwork(networkName);
        assertThat(""+networkName+" doesn't exist in the list of networks",countryNetwork.isPresent(),is(true));
        assertThat(countryNetwork.get().getLocation().getCity(),equalTo(city));
        assertThat(countryNetwork.get().getLocation().getCountry(),equalTo(country));
    }

    @And("verify the response is not returning network {string}")
    public void verifyTheResponseIsNotReturningNetwork(String netWorkName) {
        countryNetwork  = networkResponse.getNetwork(netWorkName);
        assertThat(""+netWorkName+" exist in the list of networks",countryNetwork.isPresent(),is(false));
    }
}
