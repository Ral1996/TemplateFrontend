package com.ral1996.sv.steps;

/*
    Developer: Mts. Ing. Raúl Mauricio Portillo Muñoz
    Description: Can you use this class for defined steps to realize on automation test
 */

import com.ral1996.sv.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class LoginSteps {

    @Steps
    LoginPage loginPage;

    @Given("User navigate to website")
    public void openWebSite() {
        loginPage.visitURL();
    }

    @When("User enter username credentials {string} and {string}")
    public void enterUsernameCredential(String typeC, String user) {
        switch (typeC) {
            case "valid":
                loginPage.enterUsernameValid(user);
                break;
            case "invalid":
                loginPage.enterUsernameInvalid(user);
                break;
            default:
                System.out.println("Condición no definida");
                break;
        }
    }

    @When("User enter password credentials {string} and {string}")
    public void enterPasswordCredential(String typeC, String pass) {
        switch (typeC) {
            case "valid":
                loginPage.enterPasswordValid(pass);
                break;
            case "invalid":
                loginPage.enterPasswordInvalid(pass);
                break;
            default:
                System.out.println("Condición no definida");
                break;
        }
    }

    @When("User click button LogIn")
    public void clickOnButtonLogIn() { loginPage.clickButtonLogIn(); }

    @Then("User validate {string} and {string} and {string} session")
    public void validateStartSessionWithCredentials(String typeC, String user, String pass) {
        switch (typeC) {
            case "valid":
                loginPage.validateSuccessfulSession();
                break;
            case "invalid":
                loginPage.validateFailedSession(user, pass);
                break;
            default:
                System.out.println("Condición no definida");
                break;
        }
    }
}
