package com.ral1996.sv.pages;

/*
    Developer: Mts. Ing. Raúl Mauricio Portillo Muñoz
    Description: Can you use this class for use a design pattern (POM) in Selenium
                 that creates an object repository for storing all web elements,
                 this example is for test a "Login"
 */

import com.ral1996.sv.asserts.WebAssert;
import com.ral1996.sv.utilities.ConfigReader;
import com.ral1996.sv.utilities.ProgramConstants;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    @Step("Visit Web Site")
    public void visitURL() { openUrl(ConfigReader.getProperty(ProgramConstants.BASE_URL)); }

    @Step("Enter username valid")
    public void enterUsernameValid(String username) {
        // Obtenemos el Xpath del elemento y digitamos usuario valido
        WebElementFacade elementUserInput = $(By.xpath("//*[@id='user-name']"));
        if (username.equals("admin")) {
            elementUserInput.sendKeys(ConfigReader.getProperty(ProgramConstants.USER_SITE));
        } else {
            elementUserInput.sendKeys(username);
        }

        WebAssert.getInstance().awaitForStep(2); // Espera de 2 seg, para siguiente paso
    }

    @Step("Enter username invalid")
    public void enterUsernameInvalid(String username) {
        // Obtenemos el Xpath del elemento y digitamos usuario invalido
        WebElementFacade elementUserInput = $(By.xpath("//*[@id='user-name']"));
        elementUserInput.sendKeys(username);

        WebAssert.getInstance().awaitForStep(2); // Espera de 2 seg, para siguiente paso
    }

    @Step("Enter password valid")
    public void enterPasswordValid(String password) {
        // Obtenemos el Xpath del elemento y digitamos usuario valido
        WebElementFacade elementPassInput = $(By.xpath("//*[@id='password']"));
        if (password.equals("admin")) {
            elementPassInput.sendKeys(ConfigReader.getProperty(ProgramConstants.PASS_SITE));
        } else {
            elementPassInput.sendKeys(password);
        }

        WebAssert.getInstance().awaitForStep(2); // Espera de 2 seg, para siguiente paso
    }

    @Step("Enter password invalid")
    public void enterPasswordInvalid(String password) {
        // Obtenemos el Xpath del elemento y digitamos usuario invalido
        WebElementFacade elementPassInput = $(By.xpath("//*[@id='password']"));
        elementPassInput.sendKeys(password);

        WebAssert.getInstance().awaitForStep(2); // Espera de 2 seg, para siguiente paso
    }

    @Step("Log In Site")
    public void clickButtonLogIn() {
        // Obtenemos el Xpath del elemento y hacemos click en el boton iniciar sesion
        WebElementFacade elementButtonLogIn = $(By.xpath("//*[@id='login-button']"));
        elementButtonLogIn.click();

        WebAssert.getInstance().awaitForStep(2); // Espera de 2 seg, para siguiente paso
    }

    @Step("Validate successful session")
    public void validateSuccessfulSession() {
        // Obtenemos el Xpath del elemento y validamos que el texto sea el mismo
        WebElementFacade elementLabelTitle = $(By.xpath("//*[@class='app_logo']"));
        String textElement = elementLabelTitle.getText();

        WebAssert.getInstance().AssertEqualForText("No contiene el mismo titulo", "Swag Labs", textElement);

        WebAssert.getInstance().awaitForStep(2); // Espera de 2 seg, para siguiente paso
    }

    @Step("Validate failed session")
    public void validateFailedSession(String username, String password) {
        if (username.isEmpty()) {
            String xpathElementUserEmpty = "//*[@data-test='error' and contains(text(), 'Epic sadface: Username is required')]";
            String expectedTextUserEmpty = "Epic sadface: Username is required";
            WebElementFacade elementUserEmptyLabelAlert = $(By.xpath(xpathElementUserEmpty));
            String textElement = elementUserEmptyLabelAlert.getText();

            WebAssert.getInstance().AssertEqualForText("No contiene el mismo titulo", expectedTextUserEmpty, textElement);
        } else if (password.isEmpty()) {
            String xpathElementPassEmpty = "//*[@data-test='error' and contains(text(), 'Epic sadface: Password is required')]";
            String expectedTextPassEmpty = "Epic sadface: Password is required";
            WebElementFacade elementPassEmptyLabelAlert = $(By.xpath(xpathElementPassEmpty));
            String textElement = elementPassEmptyLabelAlert.getText();

            WebAssert.getInstance().AssertEqualForText("No contiene el mismo titulo", expectedTextPassEmpty, textElement);
        } else {
            String xpathElementNotMatch = "//*[@data-test='error' and contains(text(), 'Epic sadface: Username and password do not match any user in this service')]";
            String expectedTextNotMatch = "Epic sadface: Username and password do not match any user in this service";
            WebElementFacade elementNotMatchLabelAlert = $(By.xpath(xpathElementNotMatch));
            String textElement = elementNotMatchLabelAlert.getText();

            WebAssert.getInstance().AssertEqualForText("No contiene el mismo titulo", expectedTextNotMatch, textElement);
        }

        WebAssert.getInstance().awaitForStep(2); // Espera de 2 seg, para siguiente paso
    }

}
