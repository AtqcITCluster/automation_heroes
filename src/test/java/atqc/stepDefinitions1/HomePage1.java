package atqc.stepDefinitions1;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage1 {
    WebDriver driver;

    public HomePage1(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }
    public static final String PAGE_TITLE = "Вхід";
    public static final String LOGIN = "([^"]*)";
    public static final String PASSWORD = "([^"]*)";
    public static final String LOGIN_MESSAGE="Ви успішно залогувалися!"


    @FindBy(xpath="input[@ id=\"basic_email\"]")
    public static WebElement loginField;

    @FindBy(xpath="//input[@ id=\"basic_password\"]")
    public static WebElement passwordField;

    @FindBy(xpath="//div[@ class=\"login-footer\"]//button[@type=\"submit\"]")
    public static WebElement submitButtonButton;

    @FindBy(xpath = "//div[@ class=\"login-header\"]")
    public static WebElement homePageTitleField;

    @FindBy(xpath = "//div[@class=\"ant-message\"]")
    public static WebElement loggingInMessageWindow;

    public static String getHomePageTitleField() {
        return homePageTitleField.getText();
    }
    public static void  typeLogin1() {
        loginField.sendKeys(LOGIN);
    }
    public static void typePassword1() {
        passwordField.sendKeys(PASSWORD);
    }

    public static void clickSubmitButton() {
        submitButtonButton.click();
    }

    boolean isWindowDisplayed=
        loggingInMessageWindow.isDisplayed();


    //public static String getLoggingInMessage() {
    //    return loggingInMessageWindow.getText();
    //}

}
