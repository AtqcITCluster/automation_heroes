package atqc.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

import static atqc.stepDefinitions.HomePage.onLoaded;

public class LoginSteps{
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 5) ;

    HomePage homePage = new HomePage(driver);
    @Given("\"([^\"]*)\" is opened$")
    public void verifyPageIsOpened(String pageName) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(pageName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onLoaded)));

        String titleFieldText=homePage.getHomePageTitleField().getText();
        Assert.assertEquals(titleFieldText, HomePage.PAGE_TITLE,"Page is not opened");
    }

    @When("user writes \"([^\"]*)\" and \"([^\"]*)\"")
    public void typeLoginCredentials(String login, String password) {

      HomePage homePage = new HomePage(driver);
      homePage.typeLogin();
      homePage.typePassword();

    }

    @Then("verify user is logged in")
    public void verifyUserIsLoggedIn() {

        HomePage homePage = new HomePage(driver);
        homePage.clickSubmitButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomePage.onLoaded2)));
        Assert.assertEquals();
    }
}