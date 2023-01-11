package atqc.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    @Given("\"([^\"]*)\" is opened$")
    public void verifyPageIsOpened(String pageName) {
    }

    @When("user writes \"([^\"]*)\" and \"([^\"]*)\"")
    public void typeLoginCredentials(String login, String password) {
    }

    @Then("verify user is logged in")
    public void verifyUserIsLoggedIn() {
    }
}