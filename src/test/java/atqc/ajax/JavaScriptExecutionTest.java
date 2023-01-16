package atqc.ajax;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.time.Duration;
import java.util.logging.Level;
import static java.lang.String.format;

public class JavaScriptExecutionTest {
    public static final String BASE_URL = "https://itca.if.ua/";
    public String driverPath = new File("src/test/resources/drivers/chromedriver.exe").getAbsolutePath();
    public WebDriver driver;
    public JavascriptExecutor runJs;
    public WebDriverWait driverWait;

    public String headerLogo = "//img[contains(@src,'/IT Cluster Academy_files/Academy_white_horizo.svg')]";
    public String footerLogo = "//img[contains(@src,'/IT Cluster Academy_files/Frame_2(1).svg')]";
    public String mentors = "//div[@id='rec97046478']//div[@data-original]";
    public String mentorName = "./parent::div//div[contains(@class,'t-name')]";

    public static final String ALERT_TEXT = "Just test text for alert.";
    public static final String CONSOLE_TEXT = "console log test message";

    @BeforeClass
    public void beforeJUnitTestNGHomeWork() {
        ChromeOptions options = new ChromeOptions();

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        runJs = (JavascriptExecutor) driver;

        driver.get(BASE_URL);
    }

    @Test(enabled = false)
    public void tesShowAlert(){
        runJs.executeScript(format("alert('%s')", ALERT_TEXT));

        Assert.assertEquals(driver.switchTo().alert().getText(), ALERT_TEXT, "Text in alert isn't equal.");
    }


    @Test(enabled = false)
    public void testScrollToBottomOfPage(){
        runJs.executeScript(
                "const element = document.getElementById('rec98080583');" +
                "element.scrollIntoView();");

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(footerLogo)));
        Assert.assertTrue(driver.findElement(By.xpath(footerLogo)).isDisplayed(), "Footer logo isn't display.");
    }

    @Test(enabled = true)
    public void testClickOnElement(){
        driver.manage().window().setSize(new Dimension(900, 600));

        runJs.executeScript(
                "$('.t280__burger').click();");

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='t280__menu__wrapper']")).isDisplayed(), "Menu isn't shown.");
    }

    @Test(enabled = false)
    public void testGetBrowserConsoleLog(){
        runJs.executeScript(format("console.log('%s')", CONSOLE_TEXT));

        Assert.assertTrue(driver.manage().logs().get(LogType.BROWSER).toJson()
                        .stream().anyMatch(item -> item.getMessage().contains(CONSOLE_TEXT)), "Log not found.");
    }

    @DataProvider(name = "mentorNames")
    public Object[][] mentorNames(){
        return new Object [][]{
                {0, "Олег Куришко"},
                {1, "Андрій Баглай"},
                {2, "Юрій Семеген"},
                {3, "Андрій Сеник"}
        };
    }

    @Test(enabled = false, dataProvider = "mentorNames")
    public void testMouseOverElement(int mentorIndex, String name){
        WebElement mentor = driver.findElements(By.xpath(mentors)).get(mentorIndex);

        Actions action = new Actions(driver);
        action.moveToElement(mentor).perform();

        Assert.assertEquals(mentor.findElement(By.xpath(mentorName)).getText(), name, "Mentor name isn't shown.");
    }


    @AfterClass(alwaysRun = true)
    public void afterJUnitTestNGHomeWork() {
        driver.quit();
    }

}
