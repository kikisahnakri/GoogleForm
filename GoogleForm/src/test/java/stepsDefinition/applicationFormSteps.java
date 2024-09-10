package stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import stepsObject.formPage;
import utils.Hooks;

public class applicationFormSteps {

    final WebDriver driver;
    final formPage formPage;

    public applicationFormSteps(){
        this.driver = Hooks.driver;
        this.formPage = new formPage();
    }

    @Given("I am on the google form")
    public void iAmOnTheGoogleFormPage() {
        formPage.openLoginPage("https://docs.google.com/forms/d/e/1FAIpQLSd8kxrEBU0sgJujV7eYAO6exg_DX8MBOtrR-SkRBOhtM72Rjw/viewform?usp=sf_link");
    }

    @When("I input valid application name {string}")
    public void InputNameOfApplication(String nameApplication) {
        formPage.inputNameApplication(nameApplication);
    }
    @And("I select valid application user type {string}")
    public void SelectTypeOfApplication(String typeApplication) {
        formPage.selectApplicationType(typeApplication);
    }

    @And("I input valid number of Application users {string}")
    public void InputNumberOfApplicationUser(String user) {
        formPage.inputNumberOfUserApplication(user);
    }

    @And("I input invalid number of Application users {string}")
    public void InputInvalidNumberOfApplicationUser(String user) {
        formPage.inputNumberOfUserApplication(user);
    }


    @And("I click the send button")
    public void iClickSendButton() {
        formPage.clickSendBtn();
    }

    @Then("Successfully save data redirect to response page and show {string}")
    public void iShouldSeeMessage(String expectationMsg) {
        String actualMessage = formPage.getMessage();
        Assert.assertEquals(expectationMsg,actualMessage);
    }



    //
    @When("I Let empty on field application name {string}")
    public void LetEmptyNameOfApplication(String nameApplication) {
        formPage.inputNameApplication(nameApplication);
    }

    @And("I didn't select application user type {string}")
    public void emptyTypeOfApplication(String typeApplication) {
        formPage.selectApplicationType(typeApplication);
    }


    @Then("Unsuccessfully save data and show {string}")
    public void unsuccessfullySaveDataAndShow(String expetationMessage) {
        String actualMessage = formPage.getMessage();
        Assert.assertEquals(expetationMessage,actualMessage);
    }

    @And("I input valid {string}")
    public void iInputValid(String Date) {
        formPage.inputDate(Date);
    }
}
