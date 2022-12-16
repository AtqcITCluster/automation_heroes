package atqc.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AppPhoneLocators {

    @FindBy(xpath = "//img[@data-name='gray']//ancestor::div[@class='section']")
    private WebElement phone1Parent;

    @FindBy(xpath = "//div[@class='section']")
    private List<WebElement> phoneItemList;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//i[contains(@class,'twitter')]//parent::span")
    private WebElement twitterLink;

    @FindBy(xpath = "//i[contains(@class,'facebook')]//parent::span")
    private WebElement facebookLink;

    @FindBy(xpath = "//div[@class=\"login__pagination\"]//div[contains(@class,'active')]")
    private WebElement activeItem;

    private final WebElement phone1 = phoneItemList.get(0);

    public void testMethod(){
        phone1Parent.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
    }



}
