package atqc.handlingExceptions.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class TestDisplayOfElementsGooglePage {
    public String driverPath = new File("src/test/resources/drivers/chromedriver.exe").getAbsolutePath();
    public String baseUrl = "https://www.google.com.ua";
    public WebDriver driver;
    public String userGoogleAccountButton = "//a[contains(@aria-label,'Google Account:')]";
    public String loginButton = "//a[contains(@href,'accounts.google')]";

    public boolean isElementDisplayed(String locator){
        try {
            return driver.findElement(By.xpath(locator)).isDisplayed();
        }catch(NoSuchElementException e){
            return false;
        }
    }

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    private final String STEP_1 = "testGoogleAccountButtonHidden";
    @Test
    public void testGoogleAccountButtonHidden() {
//        WebElement googleAccountButton = driver.findElement(By.xpath(userGoogleAccountButton));

        Assert.assertFalse(isElementDisplayed(userGoogleAccountButton), "Element hidden.");
    }

    @Test(dependsOnMethods = STEP_1)
    public void testLoginButtonShown(){
        WebElement googleAccountButton = driver.findElement(By.xpath(loginButton));

        Assert.assertTrue(googleAccountButton.isDisplayed(), "Element shown.");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.close();
    }
}
