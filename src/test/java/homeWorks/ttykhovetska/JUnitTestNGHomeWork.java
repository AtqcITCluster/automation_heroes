package homeWorks.ttykhovetska;

import atqc.junit_testng.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class JUnitTestNGHomeWork {

    public String baseUrl="https://try.test.io/test-io-platform/";
    public String driverPath = "/opt/homebrew/bin/chromedriver";
    public WebDriver driver;
    private static final String USER_FIRST_NAME = "David";
    private static final String USER_LAST_NAME = "Dakhovny";
    private static final String USER_COMPANY = "Marsik";
    private static final String USER_EMAIL = "David.Dakhovny@example.com";

    public String test_Form_User_First_Name = "//input[@id='first_name']";
    public String test_Form_User_Last_Name = "//input[@id='last_name']";
    public String test_Form_User_Company = "//input[@id='company']";
    public String test_Form_User_EMail = "//input[@type='email']";
    public String try_test_IO_Button = " //button[@id='lp-pom-button-10']";
    public String pop_Up_Button = "//html[1]/body[1]/div[1]/div[3]/div[2]";
    public String cross_Button = "//button[contains(text(),'Close')]";



    @BeforeClass

    public void beforeJUnitTestNGHomeWork(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver=new ChromeDriver();
        driver.get(baseUrl);

    }
    private static final String STEP_1 = "fillingInTestForm";

    @Test
    public void fillingInTestForm(){
     driver.findElement(By.xpath(test_Form_User_First_Name)).sendKeys(USER_FIRST_NAME);
        driver.findElement(By.xpath(test_Form_User_Last_Name)).sendKeys(USER_LAST_NAME);
        driver.findElement(By.xpath(test_Form_User_Company)).sendKeys(USER_COMPANY);
        driver.findElement(By.xpath(test_Form_User_EMail)).sendKeys(USER_EMAIL);
        driver.findElement(By.xpath(try_test_IO_Button)).click();
        Assert.assertTrue(driver.findElement(By.xpath(pop_Up_Button)).isDisplayed());

    }
    private static final String Step_2 = "checkingPopUpText";

    @Test(dependsOnMethods = STEP_1)
    public void checkingPopUpText(){
        Assert.assertEquals(driver.findElement(By.xpath(pop_Up_Button)).getText(),"Thank You! We'll get back to you soon.");
    }

    @AfterClass

    public void afterJUnitTestNGHomeWork(){
        if(driver.findElement(By.xpath(cross_Button)).isDisplayed()) {
            driver.findElement(By.xpath(cross_Button)).click();
        }
        driver.close();

    }



//    ######## Develop UI test according the test case:
//
//    Precondition:
//    * run Driver and open url - https://try.test.io/test-io-platform/
//
//    Step:
//    fill all inputs and click on 'TRY TEST IO' button.
//
//    Result:
//    Check pop up text: "Thank You! We'll get back to you soon."
//
//    Post condition:
//    * click on 'x' button.
//    * close Driver.


//    Add precondition in beforeClass.
//    Add put condition in afterClass.


//    Good luck!!! ☺

}
