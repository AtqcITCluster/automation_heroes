package homeWorks.thotsuliak;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;
import static java.lang.String.format;

public class JUnitTestNGHomeWorkTest {

    public WebDriver driver;
    public Faker faker = new Faker();
    public String driverPath = new File("C:\\chromedriver_win321\\chromedriver.exe").getAbsolutePath();
    public String baseURL = "https://try.test.io/test-io-platform/";
    private final String USER_FIRST_NAME = faker.name().firstName();
    private final String USER_LAST_NAME = faker.name().lastName();
    private final String COMPANY_NAME = faker.company().name();
    private final String USER_EMAIL = faker.internet().safeEmailAddress();
    private static final String LOGIN_PAGE_TITLE_TEXT = "Thank You!We'll get back to you soon.";
    public String firstNameField = "//input[@id='first_name']";
    public String lastNameField = "//input[@id='last_name']";
    public String companyNameField = "//input[@id='company']";
    public String emailField = "//input[@id='email']";
    public String tryTestIOButton = "//button[@id='lp-pom-button-10']";
    public String emailValid = "//div[@class='nb-feedback']";
    public String frameElement = format("//iframe[contains(@src,'%s')]", baseURL);
    public String popupSuccessText = ".//div[@class='lp-positioned-content']";
    public String closeButton = "//button[contains(text(),'Close')]";

    @BeforeClass
    public void beforeJUnitTestNGHomeWork() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @Test
    public void testOpenLoginPage() {
        driver.findElement(By.xpath(firstNameField)).sendKeys(USER_FIRST_NAME);
        driver.findElement(By.xpath(lastNameField)).sendKeys(USER_LAST_NAME);
        driver.findElement(By.xpath(companyNameField)).sendKeys(COMPANY_NAME);
        driver.findElement(By.xpath(emailField)).sendKeys(USER_EMAIL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(isFormAvailableToSubmit());

        driver.findElement(By.xpath(tryTestIOButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(frameElement)));
        driver.switchTo().frame(driver.findElement(By.xpath(frameElement)));
        String successMassage = driver.findElement(By.xpath(popupSuccessText)).getText().replace("\n", "");

        Assert.assertEquals(successMassage, LOGIN_PAGE_TITLE_TEXT, "Text isn't equal");
    }

    @AfterTest(alwaysRun = true)
    public void afterJUnitTestNGHomeWork() {
        driver.switchTo().defaultContent();

        try{
            driver.findElement(By.xpath(closeButton)).click();
            driver.quit();
        }
        catch(NoSuchElementException e) {
            driver.quit();
        }
    }

    private Function<WebDriver, Boolean> isFormAvailableToSubmit() {
        return function -> {
            WebElement element = driver.findElement(By.xpath(emailValid));
            String displayState = element.getCssValue("display");

            return displayState.equals("none");
        };
    }
}
