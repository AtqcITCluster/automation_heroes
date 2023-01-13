package atqc.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import static java.lang.String.format;

public class GoogleSearchResultsTest {
    public String driverPath = new File("src/test/resources/drivers/chromedriver.exe").getAbsolutePath();
    public WebDriver driver;
    public String baseUrl = "https://www.google.com/?lang=en";

    private String results =  "//div[@lang='en']//ancestor::h3";
    private final String searchInput = "//input[@title]";
    private String onLoaded = "//a[@target=\"_top\"]";

    private static final String SEARCH_VALUE = "Ukraine";

    @BeforeClass
    public void beforeGoogleSearchResultsTest(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchInput)));
        driver.findElement(By.xpath(searchInput)).sendKeys(SEARCH_VALUE);

        driver.findElement(By.xpath(searchInput)).sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onLoaded)));
    }

    @Test
    public void testSearchValuePresentInEachResultTitle(){
        driver.findElements(By.xpath(results)).forEach(result ->
            Assert.assertTrue(result.getText().toLowerCase().contains(SEARCH_VALUE.toLowerCase()),
                    format("In result: %s search value - %s not found",result.getText(),SEARCH_VALUE)));
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.close();
    }

}
