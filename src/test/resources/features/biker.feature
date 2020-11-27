Feature: As a biker I would like to know the exact location of city bikes around the world in a given application

  Scenario: As a user I want to verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude
    When I call networks api
    Then Api should return success status code 200
    * verify the response is returning city "Frankfurt" in country code Germany "DE"
    And latitude and longitude should be below
    |latitude|50.1072|
    |longitude|8.66375|

  Scenario: As a user I want to verify that the all networks are returning in the response
    Given I have total 645 networks
    When I call networks api
    Then Api should return success status code 200
    And verify the response is returning all networks

  Scenario Outline: As a user I want to verify that the networks response is returning correctly
    When I call networks api
    Then Api should return success status code 200
    And verify the response is returning correct city "<city>" and country "<country>" for network "<name>"
    Examples:
    |name     |city       |country|
    |Velobike |Moscow     |RU     |
    |Bycyklen |Copenhagen |DK     |
    |ARbike   |Arezzo     |IT     |

  Scenario: As a user I want to verify that the network doesn't exist in the response
    When I call networks api
    Then Api should return success status code 200
    And verify the response is not returning network "bhaskar"