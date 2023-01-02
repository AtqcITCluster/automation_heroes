
package homeWorks.olapa;


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

    public String baseUrl = "https://try.test.io/test-io-platform/";
    public String driverPath = "/opt/homebrew/bin/chromedriver";
    public WebDriver driver;
    private static final String User_First_Name = "Ivan";
    private static final String User_Last_Name = "Vasyliv";
    private static final String User_Company = "Etol";
    private static final String User_EMail = "firstname.lastname.example.com";

    public String test_Form_User_First_Name = "//input[@id='first_name']";
    public String test_Form_User_Last_Name = "//input[@id='last_name']";
    public String test_Form_User_Company = "//input[@id='company']";
    public String test_Form_User_EMail = "//input[@id='email']";
    //    public String try_test_IO_Button = " //strong[contains(text(),'TRY TEST IO')]";
    public String try_test_IO_Button = "//button[@id='lp-pom-button-10']";
    public String pop_Up_Button = "//body/div[2]/div[1]/div[1]/iframe[1]";
    public String cross_Button = "//button[contains(text(),'Close')]";


    @BeforeClass

    public void beforeJUnitTestNGHomeWork() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);

    }

    private static final String STEP_1 = "Fill all inputs";

    @Test
    public void fillingInTestForm() {
        driver.findElement(By.xpath(test_Form_User_First_Name)).sendKeys(User_First_Name);
        driver.findElement(By.xpath(test_Form_User_Last_Name)).sendKeys(User_Last_Name);
        driver.findElement(By.xpath(test_Form_User_Company)).sendKeys(User_Company);
        driver.findElement(By.xpath(test_Form_User_EMail)).sendKeys(User_EMail);
        driver.findElement(By.xpath(try_test_IO_Button)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.findElement(By.id("lp-pom-button-10")).click();

    }

    private static final String Step_2 = "Check pop up text";

    @Test
    public void checkingPopUpText() {
        Assert.assertTrue(driver.findElement(By.xpath(pop_Up_Button)).getText().equals("Thank You! We'll get back to you soon."));
    }

    @AfterClass

    public void afterJUnitTestNGHomeWork() {
        driver.findElement(By.xpath(cross_Button)).click();
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
