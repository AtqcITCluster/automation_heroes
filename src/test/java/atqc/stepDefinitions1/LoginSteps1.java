package atqc.stepDefinitions1;

import atqc.stepDefinitions1.HomePage1;
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

import static atqc.stepDefinitions1.HomePage1.onLoaded;

public class LoginSteps1{
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 5) ;

    HomePage1 homePage = new HomePage1(driver);
    @Given("\"([^\"]*)\" is opened$")
    public void verifyPageIsOpened() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://speak-ukrainian.org.ua/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role=\"dialog\"]")));

        String titleFieldText=HomePage1.getHomePageTitleField();
        Assert.assertEquals(titleFieldText, HomePage1.PAGE_TITLE,"Page is not opened");
    }

    @When("user writes \"([^\"]*)\" and \"([^\"]*)\"")
    public void typeLoginCredentials(String login, String password) {

        homePage.typeLogin1();
        homePage.typePassword1();
    }

    @Then("verify user is logged in")
    public void verifyUserIsLoggedIn() {

        homePage.clickSubmitButton();
    //    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(//div[@class="ant-message"])));
    //    String loggingInMessageText=HomePage1.getLoggingInMessage();
        Assert.assertTrue(homePage.isWindowDisplayed,"The user is not logged in");
    }
}

