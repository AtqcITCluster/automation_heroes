package atqc.junit_testng;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import static java.lang.String.format;

public class JUnitTestNGHomeWork {
    public WebDriver driver;
    public Faker faker = new Faker();

    public static String baseUrl = "https://try.test.io/test-io-platform/";
    public String driverPath = new File("src/test/resources/drivers/chromedriver.exe").getAbsolutePath();

    private final String USER_FIRST_NAME = faker.name().firstName();
    private final String USER_LAST_NAME = faker.name().lastName();
    private final String USER_COMPANY = faker.company().name();
    private final String USER_MAILBOX = faker.internet().safeEmailAddress();
    private static final String POPUP_TEXT = "Thank You! We'll get back to you soon.";

    // locators
    public String inputFirstName = "//input[@id='first_name']";
    public String inputLastName = "//input[@id='last_name']";
    public String inputCompany = "//input[@id='company']";
    public String inputMailbox = "//input[@id='email']";
    public String submitButton = "//button[@id='lp-pom-button-10']";
    public String emailValid = "//div[@class='nb-feedback']";

    public String frameElement = format("//iframe[contains(@src,'%s')]", baseUrl);
    public String popupSuccessText = ".//div[@class='lp-positioned-content']";
    public String closeButton = "//button[contains(text(),'Close')]";

    @BeforeClass
    public void beforeJUnitTestNGHomeWork() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseUrl);
    }

    @Test
    public void submitFormAndCheckSuccessMessage(){
        driver.findElement(By.xpath(inputFirstName)).sendKeys(USER_FIRST_NAME);
        driver.findElement(By.xpath(inputLastName)).sendKeys(USER_LAST_NAME);
        driver.findElement(By.xpath(inputCompany)).sendKeys(USER_COMPANY);
        driver.findElement(By.xpath(inputMailbox)).sendKeys(USER_MAILBOX);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(isFormAvailableToSubmit());

        driver.findElement(By.xpath(submitButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(frameElement)));
        driver.switchTo().frame(driver.findElement(By.xpath(frameElement)));
        String successMessage = driver.findElement(By.xpath(popupSuccessText)).getText().replace("\n", " ");

        Assert.assertEquals(successMessage, POPUP_TEXT, "Text isn't equal.");
    }

    private Function<WebDriver, Boolean> isFormAvailableToSubmit(){
        return function -> {
            WebElement element = driver.findElement(By.xpath(emailValid));
            String displayState = element.getCssValue("display");

            return displayState.equals("none");
        };

    }

    @AfterClass(alwaysRun = true)
    public void afterJUnitTestNGHomeWork() {
        driver.switchTo().defaultContent();

        try{
            driver.findElement(By.xpath(closeButton)).click();
            driver.quit();
        }
        catch(NoSuchElementException e){
            driver.quit();
        }
    }

}
