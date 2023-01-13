package olena_lapa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;
public class GoogleSearchButtonTest {

    public class googleSearchButtonTest {
        @Test

        public boolean verifyThatGoogleSearchWorks() {
            Selenide
                    .open("http://www.google.com");
            $x("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
                    .setValue("test automation")
                    .sendKeys(Keys.ENTER);
            $x("//h3[contains(text(),'Test automation - Wikipedia')]");

            boolean verifyThatGoogleSearchWorks;
            {
                Selenide
                        .open("http://www.google.com");
                $x("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
                        .setValue("test automation");

                boolean isSearchButtonVisible;
                {
                    try {
                        $x("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]").shouldBe(Condition.visible);
                        return true;

                    } catch (AssertionError ex) {
                        return false;
                    }

                }
            }


        }
    }