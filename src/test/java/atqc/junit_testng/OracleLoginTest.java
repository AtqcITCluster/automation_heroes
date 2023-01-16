package atqc.junit_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;

public class OracleLoginTest {
    private static final String USER_MAIL = "tigspefu@sharklasers.com";
    private static final String USER_NAME = "dwadw dwadwa";
    private static final String PW = "Testing123";
    private static final String HOME_PAGE_TITLE_TEXT = "Oracle | Cloud Applications and Cloud Platform";
    private static final String LOGIN_PAGE_TITLE_TEXT = "Oracle account sign in";

    public String driverPath = new File("src/test/resources/drivers/chromedriver.exe").getAbsolutePath();
    public WebDriver driver;
    public String baseUrl = "https://www.oracle.com/";
    public String homePageGroup= "homePage";

    // WebElements Home Page
    public String onLoaded = "//body[contains(@class,'u24show')]";
    public String loginForm = "//div[contains(@id,'profilew1')and (contains(@class,'active'))]";
    public String openLoginForm = "//button[@data-lbl='sign-in-account']";
    private String homePageSignUpButton = "//a[text()='Sign-In']";

    // WebElements Login Page
    public String loginPageTitle = "//h2";
    public String loginInputName = "//input[@name='ssousername']";
    public String loginInputPassword = "//input[@name='password']";
    public String signInButton = "//input[@class='sign-in-button']";
    private String userName = "//li//a[@data-lbl='profile:user-account']";
    public String signOutButton = "//a[@data-lbl='signout']";

    TestBase testBase = new TestBase();

    @BeforeClass
    public void beforeOracleLoginTest(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @BeforeMethod(onlyForGroups = {"homePage"})
    public void homePageLoaded(){
        testBase.waitUntilLoaded(driver, onLoaded);
    }

    private static final String STEP_1 = "testOpenHonePge";
    @Test(groups = {"homePage"})
    public void testOpenHonePge(){
        Assert.assertEquals(driver.getTitle(), HOME_PAGE_TITLE_TEXT, "Home page isn't loaded.");
    }

    private static final String STEP_2 = "testOpenLoginPage";
    @Test(dependsOnMethods = STEP_1)
    public void testOpenLoginPage(){
        driver.findElement(By.xpath(openLoginForm)).click();

        testBase.waitUntilLoaded(driver, loginForm);
        driver.findElement(By.xpath(homePageSignUpButton)).click();

        testBase.waitUntilLoaded(driver, loginInputName);

        Assert.assertEquals(driver.findElement(By.xpath(loginPageTitle)).getText(), LOGIN_PAGE_TITLE_TEXT, "Login page isn't loaded.");
    }

    private static final String STEP_3 = "testLoginOnOracle";
    @Test(dependsOnMethods = STEP_2)
    public void testLoginOnOracle(){
        driver.findElement(By.xpath(loginInputName)).sendKeys(USER_MAIL);
        driver.findElement(By.xpath(loginInputPassword)).sendKeys(PW);

        driver.findElement(By.xpath(signInButton)).click();

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl, "Home page isn't loaded after login.");
    }

    @Test(dependsOnMethods = STEP_3, groups = {"logOut"})
    public void testUserNameIsShown(){
        driver.findElement(By.xpath(openLoginForm)).click();

        testBase.waitUntilLoaded(driver, loginForm);

        Assert.assertTrue(driver.findElement(By.xpath(userName)).getText().equals(USER_NAME), "User login incorrectly.");
    }

    @AfterMethod(onlyForGroups = {"logOut"})
    public void logOutOnOracle(){
        driver.findElement(By.xpath(signOutButton)).click();
        testBase.waitUntilLoaded(driver, onLoaded);
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.quit();
    }

}
