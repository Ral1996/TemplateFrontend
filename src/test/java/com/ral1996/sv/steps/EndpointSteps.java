package com.ral1996.sv.steps;

/*
    Developer: Mts. Ing. Raúl Mauricio Portillo Muñoz
    Description: Can you use this class for defined steps to realize on automation test
 */

import com.ral1996.sv.pages.EndpointPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class EndpointSteps {

    @Steps
    EndpointPage endpointPage;

    @Given("User go to visit website")
    public void goToWebSite() {
        endpointPage.visitWebSite();
    }

    @When("The user writes the name of the pokemon {string} in the search bar")
    public void writeNameOfThePokemon(String pokemon) {
        endpointPage.writeNamePokemon(pokemon);
    }

    @When("The user selects pokemon from the list")
    public void selectPokemonOfTheList() {
        endpointPage.selectPokemon();
    }

    @Then("I make a GET request to the Pokémon API and valid if the pokemon name is the same")
    public void getRequestPokemonAPI() {
        endpointPage.getRequestWithParam();
    }

    @And("The response status code should be 200 and body should contain the name of pokemon")
    public void validateBodyAndStatusCode() {
        endpointPage.getResponseStatusCode();

        endpointPage.getResponseBody();
    }

}
