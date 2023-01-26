package atqc.stepDefinitions;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }
    public static final String PAGE_TITLE = "([^"]*)";
    public static final String LOGIN = "([^"]*)";
    public static final String PASSWORD = "([^"]*)";

    public static final String pageName = "http:";
    public static final String homePageTitle = "//"; //TODO:
    public static final String inputLogin="//";
    public static final String inputPassword="//";
    public static final String submitButton="//";
    public static final String onLoaded="//";
    public static final String onLoaded2="//";

    @FindBy(xpath=inputLogin)
    private WebElement loginField;

    @FindBy(xpath=inputPassword)
    private WebElement passwordField;

    @FindBy(xpath=submitButton)
    private WebElement submitButtonButton;

    @FindBy(xpath = homePageTitle)
    private WebElement homePageTitleField;

    public WebElement getHomePageTitleField() {
        return homePageTitleField;
    }

    public void setHomePageTitleField(WebElement homePageTitleField) {
        this.homePageTitleField = homePageTitleField;
    }

    public WebElement getLoginField() {
        return loginField;
    }

    public void setLoginField(WebElement loginField) {
        this.loginField = loginField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(WebElement passwordField) {
        this.passwordField = passwordField;
    }

    public WebElement getSubmitButtonButton() {
        return submitButtonButton;
    }

    public void setSubmitButtonButton(WebElement submitButtonButton) {
        this.submitButtonButton = submitButtonButton;
    }

    public void typeLogin(){
        loginField.sendKeys(LOGIN);
    }
    public void typePassword(){
        passwordField.sendKeys(PASSWORD);
    }
    public void clickSubmitButton(){
        submitButtonButton.click();
    }




}
