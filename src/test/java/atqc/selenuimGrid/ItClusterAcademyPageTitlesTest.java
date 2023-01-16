package atqc.selenuimGrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ItClusterAcademyPageTitlesTest {
    public WebDriver driver;
    public String baseUrl = "https://itca.if.ua/";
    public String nodeUrl = "http://192.168.0.101:5566/wd/hub";

    @DataProvider(name = "pageTitles")
    public Object[][] pageTitles(){
        return new Object [][]{
            {baseUrl, "IT Cluster Academy"},
            {baseUrl + "mentors/", "Викладачі - IT Cluster Academy"},
            {baseUrl + "news/", "Новини - IT Cluster Academy"},
            {baseUrl + "courses/quality-control/", "Quality Control"},
            {baseUrl + "courses/devops-basics/", "DevOps Basics"},
            {baseUrl + "courses/java-basics/", "Java Basics"},
            {baseUrl + "courses/python/", "Python"},
            {baseUrl + "courses/frontend/", "Frontend"},
            {baseUrl + "courses/project-management/", "Project Management"},
            {baseUrl + "courses/automation-testing/", "Automation Testing"},
            {baseUrl + "courses/think-as-ba/", "Think as a Business Analyst"},
            {baseUrl + "courses/hr-in-it/", "HR in IT"},
            {baseUrl + "courses/ruby-on-rails/", "Ruby on Rails"}
        };
    }

    @Parameters({"browserName"})
    @BeforeClass(enabled = false)
    public void beforeGoogleSearchResultsTest(String browserName) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browserName);
        driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "pageTitles", enabled = false)
    public void testHomePageTitle(String url, String title){
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), title, "Titles aren't equal.");
    }

    @AfterClass(enabled = false)
    public void afterTest() {
        driver.quit();
    }

}
