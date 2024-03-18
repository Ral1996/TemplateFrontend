package com.ral1996.sv.pages;

/*
    Developer: Mts. Ing. Raúl Mauricio Portillo Muñoz
    Description: Can you use this class for use a design pattern (POM) in Selenium
                 that creates an object repository for storing all web elements,
                 this example is for test a "Pokémon Info"
 */

import com.ral1996.sv.utilities.ProgramConstants;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.By;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class EndpointPage extends PageObject {

    private String pokemon;
    private Response response;

    @Step("Visit pokemon website")
    public void visitWebSite() { openUrl(ProgramConstants.BASE_URL_POKEMON); }

    @Step("Write name of the pokemon")
    public void writeNamePokemon(String pokemon) {
        WebElementFacade elementInputSeachPokemon = $(By.xpath("//*[@name='q'][1]"));
        elementInputSeachPokemon.sendKeys(pokemon);
        this.pokemon = pokemon;
    }

    @Step("Select pokemon from the list")
    public void selectPokemon() {
        String xpathPokemon = "//*[@data-entry='pokemon|" + this.pokemon + "'][1]";
        WebElementFacade elementRowPokemon = $(By.xpath(xpathPokemon));
        elementRowPokemon.click();
    }

    @Step("GET Request")
    public void getRequestWithParam() {
        String endpoint = ProgramConstants.API_GET_PARAMS_POKEMON + this.pokemon.toLowerCase() + "/";
        this.response = given().when().get(endpoint);
    }

    @Step("Validate status code")
    public void getResponseStatusCode() {
        this.response.then().statusCode(200);
    }

    @Step("Validate response body")
    public void getResponseBody() {
        String responseBody = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        String pokemonNameInResponse = jsonPath.getString("name");
        Assert.assertEquals(pokemonNameInResponse, this.pokemon.toLowerCase());

        System.out.println("Pokemon: " + pokemonNameInResponse);
    }

}
