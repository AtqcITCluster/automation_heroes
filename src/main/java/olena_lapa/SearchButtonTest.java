package olena_lapa;

import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertTrue;

public class SearchButtonTest {
    @Test
    public void verifySearch() {
        Selenide.open("http://google.com");

        String searchTerm = "test automation";
        String inputFieldPath = "//input[@class=' gLFyf gsfi ']";

        $x(inputFieldPath).sendKeys(searchTerm);
        $x("//button").click();

        String firstLinkText = $x("//a[1]").text();
        assertTrue(firstLinkText.contains(searchTerm));
    }
    @Test
        public void verifyThatResultPageContainsFiveLinks;
        {
            ChromeDriver chromeDriver = new ChromeDriver();
            chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            chromeDriver.get("http://www.google.com/en");
            chromeDriver.findElement(By.xpath("//h3[contains(text(),'Test automation - Wikipedia')]"))
                    .sendKeys("test automation");
            chromeDriver.findElement(By.xpath("//h3[contains(text(),'What is Automation Testing? Test Tutorial - Guru99')]"))
                    .sendKeys("test automation");
            chromeDriver.findElement(By.xpath("//h3[contains(text(),'DevOps Test Automation | Atlassian')]"))
                    .sendKeys("test automation");
            chromeDriver.findElement(By.xpath("//h3[contains(text(),'What is automation testing? - Global App Testing')]"))
                    .sendKeys("test automation");
            chromeDriver.findElement(By.xpath("//h3[contains(text(),'What Is Test Automation? A Simple, Clear Introduct')]"))
                    .sendKeys("test automation");

        }
        @Test


        public void verifySearchToHomePage; {
            GoogleResultPage googleHomePage  = new GoogleResultPage();
            googleHomePage.open();
            Selenide.open("http://google.com");

            String searchTerm = "test automation";
            String inputFieldPath = "//input[@class=' gLFyf gsfi ']";

            $x(inputFieldPath).sendKeys(searchTerm);
            $x("//button").click();
        ChromeDriver chromeDriver;
        chromeDriver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/*[1]:" +
                ))
                .sendKeys(Keys.ENTER);
        boolean isButtonDisplayed = chromeDriver
                .findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/*[1]"))
                .isDisplayed();
        Assert.assertTrue("Search button should be displayed", isButtonDisplayed);
        chromeDriver.quit();
        }

        }
