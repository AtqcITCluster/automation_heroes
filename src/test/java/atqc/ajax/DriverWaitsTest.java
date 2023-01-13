package atqc.ajax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;

public class DriverWaitsTest {
    public WebDriver driver;
    public static String baseUrl = new File("src/test/resources/appPhone/index_preloader.html").getAbsolutePath();
    public String driverPath = new File("src/test/resources/drivers/chromedriver.exe").getAbsolutePath();

    public String pageWelcomeText = "//section//h2";

    @BeforeClass
    public void beforeJUnitTestNGHomeWork() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseUrl);
    }

    @Test(enabled = false)
    public void testThreadSleepExample(){
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(driver.findElement(By.xpath("//h2")).isDisplayed(), "Page element isn't loaded");
    }

    @Test(enabled = false)
    public void testImplicitWaitExample(){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement elementPresent = wait.until(driver -> driver.findElement(By.xpath(pageWelcomeText)));

        Assert.assertTrue(elementPresent.isDisplayed(), "Page element isn't loaded");
    }

    @Test(enabled = false)
    public void testClickableElement(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(pageWelcomeText)));

        Assert.assertTrue(driver.findElement(By.xpath(pageWelcomeText)).isDisplayed(), "Page element isn't loaded");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.quit();
    }
}
