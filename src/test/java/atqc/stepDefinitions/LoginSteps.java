package atqc.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

public class LoginSteps{
    ChromeDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 5) ;
    @Given("\"([^\"]*)\" is opened$")
    public void verifyPageIsOpened(String pageName) {
        driver.manage().window().maximize();
        driver.get(pageName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onLoaded)));

        Assert.assertEquals(driver.findElement(By.xpath(homePageTitle)).getText(),pageName,"Page is not opened");

    }

    @When("user writes \"([^\"]*)\" and \"([^\"]*)\"")
    public void typeLoginCredentials(String login, String password) {
        driver.findElement(By.xpath(inputLogin)).sendKeys(login);
        driver.findElement(By.xpath(inputPassword)).sendKeys(password);

    }

    @Then("verify user is logged in")
    public void verifyUserIsLoggedIn() {
        driver.findElement(By.xpath(submitButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onloaded2)));
        Assert.assertEquals();
    }
}