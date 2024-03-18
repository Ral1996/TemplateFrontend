# Developer: Mts. Ing. Raúl Mauricio Portillo Muñoz
# Scenarios for test case, test GET endpoint with parameters

@Endpoints
Feature: CP02 - Testing API Endpoints

  Background: Validate endpoints type (GET)

  @EndpointGETWithParameter
  Scenario: Test GET endpoint with parameters
    Given User go to visit website
    When The user writes the name of the pokemon "Pikachu" in the search bar
    When The user selects pokemon from the list
    Then I make a GET request to the Pokémon API and valid if the pokemon name is the same
    And The response status code should be 200 and body should contain the name of pokemon
    #Given I have the ID or name "pikachu"
    #When I make a GET request to the Pokemon API
    #Then The response status code should be 200
    #And The response body should contain the name "pikachu"