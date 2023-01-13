package olena_lapa;


import com.codeborne.selenide.Condition;

import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class SampleTest {
     @Test

     public void verifyThatGoogleSearchWorks(){
          Selenide
                  .open("http://www.google.com");
          $x("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
          .setValue("test automation")
                  .sendKeys(Keys.ENTER);
          $x("//h3[contains(text(),'Test automation - Wikipedia')]")
                  .shouldHave(Condition.text("test automation"));
          System.out.println();

     }
}
